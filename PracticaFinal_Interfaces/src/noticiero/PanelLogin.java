package noticiero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class PanelLogin {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelLogin window = new PanelLogin();
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
	public PanelLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField.setAlignmentY(Component.TOP_ALIGNMENT);
		textField.setBounds(98, 89, 228, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setAlignmentY(0.0f);
		textField_1.setAlignmentX(0.0f);
		textField_1.setBounds(98, 159, 228, 30);
		frame.getContentPane().add(textField_1);
		
		JLabel titulo = new JLabel("Bienvenido a Noticias Mapaches");
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		titulo.setFont(new Font("Ubuntu Mono", Font.BOLD, 16));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBounds(52, 11, 321, 55);
		frame.getContentPane().add(titulo);
		
		JLabel fieldUsuario = new JLabel("Usuario");
		fieldUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fieldUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		fieldUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		fieldUsuario.setBounds(190, 65, 46, 14);
		frame.getContentPane().add(fieldUsuario);
		
		JLabel fieldPwd = new JLabel("Contraseña");
		fieldPwd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fieldPwd.setHorizontalTextPosition(SwingConstants.CENTER);
		fieldPwd.setHorizontalAlignment(SwingConstants.CENTER);
		fieldPwd.setBounds(175, 140, 74, 14);
		frame.getContentPane().add(fieldPwd);
		
		JButton btnLogin = new JButton("Iniciar sesión");
		btnLogin.setBounds(153, 202, 113, 23);
		frame.getContentPane().add(btnLogin);
	}
}
