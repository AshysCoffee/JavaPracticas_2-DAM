package noticiero;

import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PanelLogin  extends JPanel{
	
	private JTextField entradaUsuario;
	private JLabel titulo;
	private JLabel enun1;
	private JLabel enun2; 
	private JButton login;
	private JPasswordField passwordField;
	private JButton verPwd;

	
	public PanelLogin() {
		setLayout(null);
		
		titulo = new JLabel("Bienvenido a Noticias Mapaches");
		titulo.setBounds(174, 52, 284, 18);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Ubuntu Mono", Font.BOLD, 16));
		titulo.setAlignmentX(0.5f);
		add(titulo);
		
		enun1 = new JLabel("Usuario");
		enun1.setAlignmentX(Component.CENTER_ALIGNMENT);
		enun1.setBounds(294, 122, 45, 17);
		enun1.setHorizontalTextPosition(SwingConstants.CENTER);
		enun1.setHorizontalAlignment(SwingConstants.CENTER);
		enun1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(enun1);
		
		enun2 = new JLabel("Contraseña");
		enun2.setAlignmentX(Component.CENTER_ALIGNMENT);
		enun2.setBounds(279, 227, 70, 17);
		enun2.setHorizontalTextPosition(SwingConstants.CENTER);
		enun2.setHorizontalAlignment(SwingConstants.CENTER);
		enun2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(enun2);
		
		login = new JButton("Iniciar sesión");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		login.setBounds(269, 324, 95, 23);
		add(login);
		
		entradaUsuario = new JTextField();
		entradaUsuario.setBounds(223, 150, 187, 20);
		entradaUsuario.setColumns(10);
		add(entradaUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(223, 249, 187, 20);
		add(passwordField);
		
		verPwd = new JButton("Ver contraseña");
		verPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///PONER EL METODO AQUI IJIJIJI TODO
			}
		});
		verPwd.setBounds(257, 280, 121, 23);
		add(verPwd);
		

	}
}
