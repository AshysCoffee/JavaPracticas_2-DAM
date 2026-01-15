package noticiero;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

import gestiones.GestionUsuarios;
import modelos.Fuentes;
import modelos.Usuario;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import java.awt.CardLayout;
import javax.swing.JTextArea;

public class PanelGestionAdmin extends JPanel {

	private VentanaPrincipal v;
	private GestionUsuarios gu;
	private JTextField newNombre;
	private JTextField newPwd;
	private JTextField newEmail;
	JPanel panelCreacion;
	JLabel resultadoCreacion;
	JButton aceptarCreate;
	JPanel panelBorrado;
	private JTextField textField;

	public PanelGestionAdmin(VentanaPrincipal ventanaPrincipal, GestionUsuarios gu) {

		this.gu = gu;
		this.v = ventanaPrincipal;

		setLayout(null);
		setSize(650, 500);

		JButton salir = new JButton("Salir");
		salir.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		salir.setBounds(481, 419, 141, 31);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(salir);

		JButton btnCrearUsuarios = new JButton("Crear usuario");
		btnCrearUsuarios.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		btnCrearUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCreacion.setVisible(true);
				newNombre.setText("");
				newPwd.setText("");
				newEmail.setText("");
				resultadoCreacion.setVisible(false);
			}
		});
		btnCrearUsuarios.setBounds(353, 142, 215, 31);
		add(btnCrearUsuarios);

		JButton infoApp = new JButton("Información adicional");
		infoApp.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		infoApp.setBounds(353, 254, 215, 31);
		add(infoApp);

		JButton btnBorrarUsuario = new JButton("Borrar usuario");
		btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBorrado.setVisible(true);
				cargarUsuarios();
				
			}
		});
		btnBorrarUsuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		btnBorrarUsuario.setBounds(353, 198, 215, 31);
		add(btnBorrarUsuario);

		JButton atras = new JButton("Atrás");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarPantalla("MENU_ADMIN");
			}
		});
		atras.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		atras.setBounds(26, 419, 141, 31);
		add(atras);

		JPanel panelTotal = new JPanel();
		panelTotal
				.setBorder(new TitledBorder(null, "Gestión de usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTotal.setBounds(20, 5, 318, 413);
		add(panelTotal);
		panelTotal.setLayout(new CardLayout(0, 0));

		panelCreacion = new JPanel();
		panelTotal.add(panelCreacion, "name_1318434496380600");
		panelCreacion.setLayout(null);
		panelCreacion.setVisible(false);

		newNombre = new JTextField();
		newNombre.setToolTipText("Usuario");
		newNombre.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		newNombre.setBounds(61, 110, 183, 27);
		newNombre.setColumns(10);
		panelCreacion.add(newNombre);

		newPwd = new JPasswordField();
		newPwd.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		newPwd.setBounds(61, 178, 183, 27);
		newPwd.setColumns(10);
		panelCreacion.add(newPwd);

		newEmail = new JTextField();
		newEmail.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		newEmail.setBounds(61, 252, 183, 27);
		newEmail.setColumns(10);
		panelCreacion.add(newEmail);

		JLabel lblNewLabel = new JLabel("Nombre del usuario");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel.setBounds(80, 76, 146, 27);
		panelCreacion.add(lblNewLabel);

		JLabel lblContrasenna = new JLabel("Contraseña");
		lblContrasenna.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblContrasenna.setBounds(112, 148, 81, 19);
		panelCreacion.add(lblContrasenna);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblEmail.setBounds(132, 217, 42, 24);
		panelCreacion.add(lblEmail);

		aceptarCreate = new JButton("Aceptar");
		aceptarCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (gu.crearUsuario(newNombre.getText(), newPwd.getText(), newEmail.getText())) {
					resultadoCreacion.setText("¡Se ha registrado con exito!");
					resultadoCreacion.setVisible(true);

				} else {
					resultadoCreacion.setText("Hubo problemas con la creación");
					resultadoCreacion.setVisible(true);
				}

			}
		});
		aceptarCreate.setBounds(104, 312, 97, 23);
		panelCreacion.add(aceptarCreate);

		JLabel lblNewLabel_1 = new JLabel("Creación de un usuario nuevo");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel_1.setBounds(16, 28, 274, 27);
		panelCreacion.add(lblNewLabel_1);

		resultadoCreacion = new JLabel("En espera");
		resultadoCreacion.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoCreacion.setVisible(false);
		resultadoCreacion.setBounds(31, 346, 243, 14);
		panelCreacion.add(resultadoCreacion);
		
		panelBorrado = new JPanel();
		panelTotal.add(panelBorrado, "name_1318519325036300");
		panelBorrado.setLayout(null);
		panelBorrado.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Borrar un usuario");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(14, 71, 277, 27);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		panelBorrado.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(14, 108, 277, 118);
		panelBorrado.add(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		textField.setBounds(26, 289, 253, 27);
		panelBorrado.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombreDelUsuario = new JLabel("Nombre del usuario a eliminar");
		lblNombreDelUsuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNombreDelUsuario.setBounds(46, 257, 214, 26);
		panelBorrado.add(lblNombreDelUsuario);
		
		
		JButton moreInfo = new JButton("Acerca de");
		moreInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Noticias Mapaches v1.0\nDesarrollado por el equipo Mapache\n2025\nTodos los derechos reservados.\nVersion 1.5\n¡Gracias por usar nuestra aplicación de noticias!",
						"Acerca de Noticias Mapaches", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		moreInfo.setBounds(538, 10, 84, 20);
		add(moreInfo);
		

	}
	
	public void cargarUsuarios() {

		new Thread(() -> {
			try {
				
			List<Usuario> todosUsuarios = gu.getListaUsuario();
			List<String> usuarios = new ArrayList<>();
			
			for (Usuario u : todosUsuarios) {
				usuarios.add("Usuario: " + u.getUsuario() + " | Email: " + u.getCorreo() + " | Visitas: " + u.getVisitas());
			}
			
				SwingUtilities.invokeLater(() -> {

					if (todosUsuarios == null || todosUsuarios.isEmpty()) {
						JTextArea txt = new JTextArea(
								"No existen usuarios registrados.");
						txt.setEditable(false);
						panelBorrado.add(txt);
					} else {
						for (String t : usuarios) {
							JTextArea txt = new JTextArea(t);
							txt.setLineWrap(true);
							txt.setWrapStyleWord(true);
							txt.setEditable(false);
							txt.setOpaque(false);
							txt.setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));
							panelBorrado.add(txt);
							panelBorrado.add(new JSeparator());
						}
					}
					panelBorrado.revalidate();
					panelBorrado.repaint();
				});

			} catch (Exception ex) {
				SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage()));
			}
		}).start();
	}
}
