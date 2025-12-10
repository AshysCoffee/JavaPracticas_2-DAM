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
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class PanelLogin  extends JPanel{
	private JTextField textField;
	private JTextField textField_1;

	
	public PanelLogin() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_9842354588700");
		panel.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(112, 99, 180, 19);
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(112, 161, 180, 19);
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		JLabel titulo_1 = new JLabel("Bienvenido a Noticias Mapaches");
		titulo_1.setBounds(63, 25, 278, 18);
		titulo_1.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo_1.setHorizontalAlignment(SwingConstants.CENTER);
		titulo_1.setFont(new Font("Ubuntu Mono", Font.BOLD, 16));
		titulo_1.setAlignmentX(0.5f);
		panel.add(titulo_1);
		
		JLabel fieldUsuario_1 = new JLabel("Usuario");
		fieldUsuario_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		fieldUsuario_1.setBounds(154, 56, 96, 30);
		fieldUsuario_1.setHorizontalTextPosition(SwingConstants.CENTER);
		fieldUsuario_1.setHorizontalAlignment(SwingConstants.CENTER);
		fieldUsuario_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(fieldUsuario_1);
		
		JLabel fieldPwd_1 = new JLabel("Contraseña");
		fieldPwd_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		fieldPwd_1.setBounds(150, 131, 105, 17);
		fieldPwd_1.setHorizontalTextPosition(SwingConstants.CENTER);
		fieldPwd_1.setHorizontalAlignment(SwingConstants.CENTER);
		fieldPwd_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(fieldPwd_1);
		
		JButton btnLogin_1 = new JButton("Iniciar sesión");
		btnLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin_1.setBounds(156, 193, 93, 21);
		panel.add(btnLogin_1);
		
		textField = new JTextField();
		textField.setBounds(106, 86, 198, 18);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 158, 198, 18);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "name_9842416105400");
		panel_1.setLayout(null);
		
		JButton btnTestNoticias = new JButton("Test de noticias");
		btnTestNoticias.setBounds(5, 5, 135, 25);
		btnTestNoticias.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		panel_1.add(btnTestNoticias);
		
		JButton btnGestionUsuarios = new JButton("Gestión de usuarios");
		btnGestionUsuarios.setBounds(145, 5, 161, 25);
		btnGestionUsuarios.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		panel_1.add(btnGestionUsuarios);
		
		JButton btnModificarEnvoDel = new JButton("Modificar envío del email");
		btnModificarEnvoDel.setBounds(311, 5, 195, 25);
		btnModificarEnvoDel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		panel_1.add(btnModificarEnvoDel);
		
		JLabel lblNewLabel = new JLabel("Menu Administrador");
		lblNewLabel.setBounds(511, 7, 149, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 17));
		panel_1.add(lblNewLabel);
	}
}
