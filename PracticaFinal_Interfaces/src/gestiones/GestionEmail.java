package gestiones;

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

	final static String fromEmail = "albaelena1970.ale@gmail.com"; // EMAIL DE SALIDA
	final static String password = "owlh yyir waqd kphp";

	private Usuario usuario;
	private GestionNoticias gn = new GestionNoticias();
	///EN TODO CASO, SI ES AL USUARIO SUSTITUIR EL ARRAY DE NOTICIAS POR
	///EL ARRAY DE PREFERENCIAS

	public GestionEmail(Usuario usuario) {
		super();
		this.usuario = usuario;
	}


	public GestionEmail() {
		// TODO Auto-generated constructor stub
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

		gn.iniciarNoticias(); 
		String texto = "";
		
		for (String s : gn.cargarTitulares(gn.cargarFuentes())) {
			texto += s + "\n";
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

	public boolean testCorreoAdmin(Usuario usuario) {

		String usuarioMail = usuario.getCorreo().trim();

		gn.iniciarNoticias(); 
		String texto = "";
		
		for (String s : gn.getTitulares()) {
			texto += s + "\n";
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
	
////////////////

}
