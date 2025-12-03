package prototipo_Final;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;

public class Prototipo_test {

	private JFrame frame;
	private JTextField contenido_correo;
	private JTextField contenido_asunto;
	private JTextField contenido_texto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prototipo_test window = new Prototipo_test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prototipo_test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel iniciarsesion = new JPanel();
		iniciarsesion.setBackground(new Color(255, 255, 204));
		frame.getContentPane().add(iniciarsesion, "name_8151841658300");
		iniciarsesion.setLayout(null);
		
		JLabel Asunto = new JLabel("Asunto");
		Asunto.setBounds(52, 84, 51, 14);
		iniciarsesion.add(Asunto);
		
		JLabel Correo = new JLabel("Correo");
		Correo.setBounds(69, 38, 46, 14);
		iniciarsesion.add(Correo);
		
		JLabel Contenido = new JLabel("Contenido");
		Contenido.setBounds(33, 123, 72, 14);
		iniciarsesion.add(Contenido);
		
		contenido_correo = new JTextField();
		contenido_correo.setBounds(112, 35, 235, 20);
		iniciarsesion.add(contenido_correo);
		contenido_correo.setColumns(10);
		
		contenido_asunto = new JTextField();
		contenido_asunto.setColumns(10);
		contenido_asunto.setBounds(112, 81, 235, 20);
		iniciarsesion.add(contenido_asunto);
		
		contenido_texto = new JTextField();
		contenido_texto.setBounds(112, 122, 235, 65);
		iniciarsesion.add(contenido_texto);
		contenido_texto.setColumns(10);
		
		JButton EnviarCorreo = new JButton("Enviar");
		EnviarCorreo.setBounds(183, 198, 89, 23);
		
		EnviarCorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				final String fromEmail = "albaelena1970.ale@gmail.com"; //EMAIL DE SALIDA
				final String password = "owlh yyir waqd kphp"; //CONTRASEÑA DEL EMAIL DE SALIDA (aplicaciones de 3ros) Contraseñas de aplicación -- Verificación en 2 pasos
				final String toEmail = contenido_correo.getText(); // EMAIL DESTINATARIO
				
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
					
				sendEmail(session, toEmail, contenido_asunto.getText(), contenido_texto.getText());
				
			}});
		iniciarsesion.add(EnviarCorreo);
		
		
		
		JButton salir = new JButton("Salir");
		salir.setBounds(335, 227, 89, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); //liberar memoria :3
				System.exit(0);
			}
		});
		iniciarsesion.add(salir);
		
		JPanel config_admin = new JPanel();
		frame.getContentPane().add(config_admin, "name_8181815336400");
		
		JPanel config_usuario = new JPanel();
		frame.getContentPane().add(config_usuario, "name_8184843070700");
		
		JPanel login = new JPanel();
		frame.getContentPane().add(login, "name_8186793532900");
	}
	
	public static void sendEmail(Session session, String toEmail, String subject, String body){
		try{
	      MimeMessage msg = new MimeMessage(session);
	      //Configurar Cabeceras
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");
	      msg.setFrom("albaelena1970.ale@gmail.com");//Datos de ejemplo	      	            
	      msg.setSubject(subject, "UTF-8");
	      msg.setText(body, "UTF-8");
	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));	   
	      Transport.send(msg);
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}
