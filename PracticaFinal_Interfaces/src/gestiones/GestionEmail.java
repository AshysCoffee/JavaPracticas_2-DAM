package gestiones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import modelos.Fuentes;
import modelos.Usuario;

public class GestionEmail {

	private Usuario usuario;
	private GestionNoticias gn;
	private GestionUsuarios gu;
	private GestionPreferencias gp;
	private String fromEmail, password, horaEnvioAutomatico;

	public GestionEmail(GestionNoticias gn, GestionUsuarios gu, GestionPreferencias gp) {
		super();
		this.gu = gu;
		this.gn = gn;
		this.gp = gp;
	}

	///////////////////////
	

	public void cargarCredenciales() {
		File f = new File("data/config.txt");
		if (!f.exists())
			return;

		try (BufferedReader bf = new BufferedReader(new FileReader(f))) {
			String linea = bf.readLine();
			while (linea != null) {
				linea = linea.trim();
				if (linea.startsWith("--")) {
					String datos = linea.substring(2);
					String[] partes = datos.split(";;;");

					if (partes.length >= 3) {
						fromEmail = partes[0].trim();
						password = partes[1].trim();
						horaEnvioAutomatico = partes[2].trim();
						return;
					}
				}
				linea = bf.readLine();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos.", "Error de Sistema",
					JOptionPane.ERROR_MESSAGE);
		}
	}

/////////////////////// 

	public boolean sendEmail(Session session, String toEmail, String subject, String body) {

		try {
			MimeMessage msg = new MimeMessage(session);
			// Configurar Cabeceras
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("no_reply@example.com", "TEST DE NOTICIAS MAPACHE"));// Datos de ejemplo
			msg.setReplyTo(InternetAddress.parse("no_reply_DOSA@DAM.com", false));
			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "UTF-8");
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			Transport.send(msg);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos.", "Error de Sistema",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

	}

	public boolean testCorreoAdmin() {

		String usuarioMail = fromEmail;

		String texto = "";

		for (String s : gn.cargarTitulares(gn.getListaNoticias(), "admin")) {
			texto += "• " + s + "\n";
		}

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP de GMAIL en este caso
		props.put("mail.smtp.socketFactory.port", "465"); // PUERTO SSL
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL Factory Class
		props.put("mail.smtp.auth", "true"); // ACTIVAR SMTP AUTENTIFICACI�N
		props.put("mail.smtp.port", "465"); // SMTP Port
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getDefaultInstance(props, auth);// CREA UNA SESIÓN CON TODAS LAS PROPIEDADES Y EL

		return sendEmail(session, usuarioMail, "TEST NOTICIAS", texto);

	}

	public boolean enviarNoticiasUsuario(Usuario u) {

		if (u == null || gn == null) {
			return false;
		}

		String usuarioMail = u.getCorreo();
		String texto = "Hola " + u.getUsuario() + ",\n\nAquí tienes tus noticias de hoy:\n\n";

		if (gn.getTitulares() != null && !gn.getTitulares().isEmpty()) {

			List<Fuentes> misFuentes = gn.obtenerPreferencias(u.getUsuario());
			List<String> titularesUsuario = gn.cargarTitulares(misFuentes, u.getUsuario());

			for (String s : titularesUsuario) {
				texto += "• " + s + "\n";
			}
			
		} else {
			texto += "No hay noticias cargadas actualmente.";
		}

		texto += "\n\nSaludos,\nEl Equipo Mapache";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP de GMAIL en este caso
		props.put("mail.smtp.socketFactory.port", "465"); // PUERTO SSL
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL Factory Class
		props.put("mail.smtp.auth", "true"); // ACTIVAR SMTP AUTENTIFICACI�N
		props.put("mail.smtp.port", "465"); // SMTP Port
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getDefaultInstance(props, auth);// CREA UNA SESIÓN CON TODAS LAS PROPIEDADES Y EL

		return sendEmail(session, usuarioMail, "Tus Noticias - Noticiero Mapache", texto);

	}

	public void iniciarRelojAutomatico() {

		String[] partes = horaEnvioAutomatico.split(":");
		int hora = Integer.parseInt(partes[0]);
		int minuto = Integer.parseInt(partes[1]);

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						LocalTime ahora = LocalTime.now();

						if (ahora.getHour() == hora && ahora.getMinute() == minuto) {

							enviarBoletinMasivo();

							Thread.sleep(61000);
						}

						Thread.sleep(30000);

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Error en el reloj automático", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}).start();
	}

	private boolean enviarBoletinMasivo() {
		
		List<Usuario> todos = gu.getListaUsuario();

		if (todos == null || todos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay usuarios registrados para enviar el boletín.", "Aviso",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		for (Usuario u : todos) {

			try {

				List<Fuentes> misFuentes = gn.obtenerPreferencias(u.getUsuario());
	            
				gn.cargarTitulares(misFuentes, u.getUsuario());
				
				enviarNoticiasUsuario(u);

				Thread.sleep(1000);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al enviar el correo a " + u.getUsuario(), "Error",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}


}
