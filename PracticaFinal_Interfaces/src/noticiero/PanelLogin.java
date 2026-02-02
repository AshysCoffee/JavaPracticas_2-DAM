package noticiero;

import javax.swing.JTextField;
import javax.swing.JToggleButton;

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
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
						if (!usuarioValidado.isEsAdmin() && usuarioValidado.getVisitas() == 1) {
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
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Inténtelo de nuevo.",
							"Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	login.setBounds(238,365,173,32);

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
		salir.setBounds(478, 424, 135, 32);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, 
					    "¿Seguro que quieres cerrar la aplicación?", 
					    "Confirmar Salida", 
					    JOptionPane.YES_NO_OPTION, 
					    JOptionPane.WARNING_MESSAGE);

					if (respuesta == JOptionPane.YES_OPTION) {
					    System.exit(0); // Solo cerramos si dice SÍ
					}
			}
		});
		add(salir);
		

		char puntito = passwordField.getEchoChar();
		
		JToggleButton mostrarPwd = new JToggleButton("Ver contraseña");
		mostrarPwd.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		mostrarPwd.setBounds(238, 306, 173, 27);
		mostrarPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mostrarPwd.isSelected()) {
					passwordField.setEchoChar((char) 0); //Se pone 0 para que me de las letras correspondientes
					mostrarPwd.setText("Ocultar Contraseña");
				} else {
					passwordField.setEchoChar(puntito); //Ponemos de nuevo el puntito
					mostrarPwd.setText("Mostrar Contraseña");
				}
			}
		});
		add(mostrarPwd);
		
		JButton moreInfo = new JButton("Acerca de");
		moreInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Noticias Mapaches v1.0\nDesarrollado por el equipo Mapache\n2025\nTodos los derechos reservados.\nVersion 1.5\n¡Gracias por usar nuestra aplicación de noticias!",
						"Acerca de Noticias Mapaches", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		moreInfo.setBounds(10, 10, 121, 20);
		add(moreInfo);
	
		

	}
}
