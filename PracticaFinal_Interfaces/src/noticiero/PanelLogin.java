package noticiero;

import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import gestiones.GestionUsuarios;
import modelos.Usuario;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

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
		
		this.v = v;
		this.gu = gu;
		
		setBackground(SystemColor.menu);
		setFont(new Font("Tahoma", Font.PLAIN, 18));

		this.gu = gu;
		this.v = v;

		setLayout(null);
		setSize(650, 500);

		titulo = new JLabel("Bienvenido a Noticias Mapaches");
		titulo.setBounds(-59, 60, 768, 54);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Ubuntu Mono", Font.BOLD, 30));
		titulo.setAlignmentX(0.5f);
		add(titulo);

		enun1 = new JLabel("Usuario");
		enun1.setAlignmentX(Component.CENTER_ALIGNMENT);
		enun1.setBounds(280, 148, 89, 17);
		enun1.setHorizontalTextPosition(SwingConstants.CENTER);
		enun1.setHorizontalAlignment(SwingConstants.CENTER);
		enun1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		add(enun1);

		enun2 = new JLabel("Contraseña");
		enun2.setAlignmentX(Component.CENTER_ALIGNMENT);
		enun2.setBounds(264, 236, 121, 17);
		enun2.setHorizontalTextPosition(SwingConstants.CENTER);
		enun2.setHorizontalAlignment(SwingConstants.CENTER);
		enun2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		add(enun2);

		login = new JButton("Iniciar sesión");
		login.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String usr = entradaUsuario.getText();
				String pwd = new String(passwordField.getPassword());

				Usuario usuarioValidado = gu.validarLogin(usr, pwd);

				if (usuarioValidado != null) {
					VentanaPrincipal ventana = (VentanaPrincipal) SwingUtilities.getWindowAncestor(PanelLogin.this);
					    ventana.setUsuarioLogueado(usuarioValidado);
					if (usuarioValidado.isEsAdmin()) {
						entradaUsuario.setText("");
						passwordField.setText("");
						v.cambiarPantalla("MENU_ADMIN");
					} else {
						if (!usuarioValidado.isEsAdmin() && usuarioValidado.getVisitas() == 0) {
							entradaUsuario.setText("");
							passwordField.setText("");
							v.cambiarPantalla("CONFIG_USUARIO");
						} else {
							entradaUsuario.setText("");
							passwordField.setText("");
							v.cambiarPantalla("MENU_USUARIO");
						}
					}
				
				} else {
					JOptionPane.showMessageDialog(null, "Error de acceso");
				}

			}
		});

	login.setBounds(238,343,173,32);

	add(login);

		entradaUsuario = new JTextField();
		entradaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		entradaUsuario.setToolTipText("Introduzca el usuario");
		entradaUsuario.setBounds(190, 175, 269, 32);
		entradaUsuario.setColumns(10);
		add(entradaUsuario);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Introduzco su contraseña");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(190, 263, 269, 32);
		add(passwordField);

		salir = new JButton("Salir");
		salir.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		salir.setBounds(489, 417, 135, 32);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(salir);

	}
}
