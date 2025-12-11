package noticiero;

import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gestiones.GestionUsuarios;
import modelos.Usuario;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PanelLogin extends JPanel {

	static JTextField entradaUsuario;
	JLabel titulo;
	JLabel enun1;
	JLabel enun2;
	JButton login;
	static JPasswordField passwordField;
	JButton verPwd;
	JButton salir;
	private GestionUsuarios gu;
	private VentanaPrincipal v;
	

	public PanelLogin(VentanaPrincipal v, GestionUsuarios gu) {

		this.gu = gu;
		this.v = v;

		setLayout(null);
		

		titulo = new JLabel("Bienvenido a Noticias Mapaches");
		titulo.setBounds(-58, 46, 768, 54);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Ubuntu Mono", Font.BOLD, 25));
		titulo.setAlignmentX(0.5f);
		add(titulo);

		enun1 = new JLabel("Usuario");
		enun1.setAlignmentX(Component.CENTER_ALIGNMENT);
		enun1.setBounds(297, 123, 57, 17);
		enun1.setHorizontalTextPosition(SwingConstants.CENTER);
		enun1.setHorizontalAlignment(SwingConstants.CENTER);
		enun1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(enun1);

		enun2 = new JLabel("Contraseña");
		enun2.setAlignmentX(Component.CENTER_ALIGNMENT);
		enun2.setBounds(290, 227, 70, 17);
		enun2.setHorizontalTextPosition(SwingConstants.CENTER);
		enun2.setHorizontalAlignment(SwingConstants.CENTER);
		enun2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(enun2);

		login = new JButton("Iniciar sesión");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String usr = entradaUsuario.getText();
				String pwd = new String(passwordField.getPassword());

				Usuario usuarioValidado = gu.validarLogin(usr, pwd);

				if (usuarioValidado != null) {
					if (usuarioValidado.isEsAdmin()) {
						v.cambiarPantalla("MENU_ADMIN");
					} else {
						if (!usuarioValidado.isEsAdmin() && usuarioValidado.getVisitas() == 0) {
							v.cambiarPantalla("CONFIG_USUARIO");
						} else {
							v.cambiarPantalla("MENU_USUARIO");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Error de acceso");
				}

			}
		});
		
		login.setBounds(265, 347, 121, 23);
		add(login);

		entradaUsuario = new JTextField();
		entradaUsuario.setToolTipText("");
		entradaUsuario.setBounds(208, 150, 234, 32);
		entradaUsuario.setColumns(10);
		add(entradaUsuario);

		passwordField = new JPasswordField();
		passwordField.setBounds(208, 255, 234, 32);
		add(passwordField);

	
		salir = new JButton("Salir");
		salir.setBounds(510, 438, 113, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(salir);

	}
}
