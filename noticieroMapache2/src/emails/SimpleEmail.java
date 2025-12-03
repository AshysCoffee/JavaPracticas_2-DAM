package emails;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SimpleEmail {	////// NO DEBE SACARLO DE AQUÍ, ES UN EJEMPLO PARA PROBAR EL ENVÍO DE EMAILS CON JAVA Y GMAIL
	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (SSL)
	   Use Authentication: Yes
	   Port for SSL: 465
	 */
	public static void main(String[] args) {
		
		///////////YO TENGO QUE LLAMAR A ESTO COMO UN METODO DE LA CLASE EMAILUTIL, PORQUE NO PEUDO TENR DOS MAINS
		//// CONFIGURACIÓN DE DATOS DE ENVÍO DE EMAILS CON GMAIL
		//// Datos de ejemplo, no usar en producción
		/// aparte HAY QUE PENSAR QUE TODO ESTO FUNCIONA COMO SI FUERA LA CLASE TRADUCCION
		
		final String fromEmail = "albaelena1970.ale@gmail.com"; //EMAIL DE SALIDA
		final String password = "owlh yyir waqd kphp"; //CONTRASEÑA DEL EMAIL DE SALIDA (aplicaciones de 3ros) Contraseñas de aplicación -- Verificación en 2 pasos
		final String toEmail = "albaelena1970.ale@gmail.com"; // EMAIL DESTINATARIO
		
		System.out.println("Configurando datos conexión SSL");
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP de GMAIL en este caso
		props.put("mail.smtp.socketFactory.port", "465"); //PUERTO SSL 
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //ACTIVAR SMTP AUTENTIFICACI�N
		props.put("mail.smtp.port", "465"); //SMTP Port		
		Authenticator auth = new Authenticator() {		
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};		
		Session session = Session.getDefaultInstance(props, auth);//CREA UNA SESIÓN CON TODAS LAS PROPIEDADES Y EL "LOGIN"
		System.out.println("Sesión Creada");
		
		/**
		 * Llamada al método sendEmail con todos los datos configurados
		 * session 
		 * toEmail 
		 * subject
		 * body 
		 */		
	    EmailUtil.sendEmail(session, toEmail,"ASUNTO", "MENSAJE/CUERPO");
	}
}


