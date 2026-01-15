package gestiones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import modelos.Usuario;

public class GestionEmail {

	private Usuario usuario;
	private GestionNoticias gn;
	private GestionUsuarios gu;
	private String fromEmail, password;

	public GestionEmail(Usuario usuario, GestionNoticias gn, GestionUsuarios gu) {
		super();
		this.gu = gu;
		this.gn = gn;
		this.usuario = usuario;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

    public void cargarCredenciales() {
        File f = new File("data/config.txt");
        if (!f.exists()) return;

        try (BufferedReader bf = new BufferedReader(new FileReader(f))) {
            String linea = bf.readLine();
            while (linea != null) {
                linea = linea.trim();
                if (linea.startsWith("--")) {
                    String datos = linea.substring(2);
                    String[] partes = datos.split(";;;");
                    
                    if (partes.length >= 2) {
                        fromEmail = partes[0].trim();
                        password = partes[1].trim();
                        return; 
                    }
                }
                linea = bf.readLine();
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos.", "Error de Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

	
/////////////////////// -- TEST DE NOTICIAS HECHO, AHORA FALTA INTERFAZ

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
			JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos.", "Error de Sistema", JOptionPane.ERROR_MESSAGE);
			return false;
		}

	}

	public boolean testCorreoAdmin() {

		String usuarioMail = fromEmail;

		String texto = "";
		
		for (String s : gn.cargarTitulares(gn.getListaNoticias(),"admin")) {
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
        if (u == null || gn == null) return false;

        String usuarioMail = u.getCorreo();
        String texto = "Hola " + u.getUsuario() + ",\n\nAquí tienes tus noticias de hoy:\n\n";

        if (gn.getTitulares() != null && !gn.getTitulares().isEmpty()) {
            for (String s : gn.getTitulares()) {
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
        
        return sendEmail (session, usuarioMail, "Tus Noticias - Noticiero Mapache", texto);

	}
	
}
