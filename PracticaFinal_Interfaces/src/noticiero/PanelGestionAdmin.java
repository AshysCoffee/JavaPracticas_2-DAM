package noticiero;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import gestiones.GestionPreferencias;
import gestiones.GestionUsuarios;
import modelos.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.CardLayout;
import javax.swing.JTextArea;

public class PanelGestionAdmin extends JPanel {

	private VentanaPrincipal v;
	private GestionUsuarios gu;
	private GestionPreferencias gp;
	private JTextField newNombre;
	private JTextField newPwd;
	private JTextField newEmail;
	private JPanel panelCreacion;
	private JLabel resultadoCreacion;
	private JButton aceptarCreate;
	private JPanel panelBorrado;
	private JTextField usuarioBorrar;
	private JLabel resultado;
	private JTextArea textArea;

	public PanelGestionAdmin(VentanaPrincipal ventanaPrincipal, GestionUsuarios gu, GestionPreferencias gp) {

		this.gu = gu;
		this.v = ventanaPrincipal;

		setLayout(null);
		setSize(650, 500);

		JButton salir = new JButton("Salir");
		salir.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		salir.setBounds(484, 452, 141, 31);
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
		btnCrearUsuarios.setBounds(373, 206, 215, 31);
		add(btnCrearUsuarios);

		JButton btnBorrarUsuario = new JButton("Borrar usuario");
		btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCreacion.setVisible(false);
				panelBorrado.setVisible(true);
				usuarioBorrar.setText("");
				resultado.setVisible(false);

			}
		});
		btnBorrarUsuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		btnBorrarUsuario.setBounds(373, 262, 215, 31);
		add(btnBorrarUsuario);

		JButton atras = new JButton("Atrás");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarPantalla("MENU_ADMIN");
			}
		});
		atras.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		atras.setBounds(10, 452, 141, 31);
		add(atras);

		JPanel panelTotal = new JPanel();
		panelTotal.setBorder(
				new TitledBorder(null, "Gestión de usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTotal.setBounds(46, 23, 318, 413);
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

		JLabel titulo1 = new JLabel("Nombre del usuario");
		titulo1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		titulo1.setBounds(80, 76, 146, 27);
		panelCreacion.add(titulo1);

		JLabel titulo2 = new JLabel("Contraseña");
		titulo2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		titulo2.setBounds(112, 148, 81, 19);
		panelCreacion.add(titulo2);

		JLabel titulo3 = new JLabel("Email");
		titulo3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		titulo3.setBounds(132, 217, 42, 24);
		panelCreacion.add(titulo3);

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

		JLabel titulo4 = new JLabel("Creación de un usuario nuevo");
		titulo4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		titulo4.setBounds(16, 28, 274, 27);
		panelCreacion.add(titulo4);

		resultadoCreacion = new JLabel("En espera");
		resultadoCreacion.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoCreacion.setVisible(false);
		resultadoCreacion.setBounds(31, 346, 243, 14);
		panelCreacion.add(resultadoCreacion);

		panelBorrado = new JPanel();
		panelTotal.add(panelBorrado, "name_1318519325036300");
		panelBorrado.setLayout(null);
		panelBorrado.setVisible(false);

		JLabel titulo5 = new JLabel("Borrar un usuario");
		titulo5.setHorizontalAlignment(SwingConstants.CENTER);
		titulo5.setBounds(14, 46, 277, 27);
		titulo5.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		panelBorrado.add(titulo5);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(0, 0, 277, 118);

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(14, 84, 277, 118);
		panelBorrado.add(scroll);
		
		actualizarTablonUsuarios();

		usuarioBorrar = new JTextField();
		usuarioBorrar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		usuarioBorrar.setBounds(26, 264, 253, 27);
		panelBorrado.add(usuarioBorrar);
		usuarioBorrar.setColumns(10);

		JLabel lblNombreDelUsuario = new JLabel("Nombre del usuario a eliminar");
		lblNombreDelUsuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNombreDelUsuario.setBounds(46, 232, 214, 26);
		panelBorrado.add(lblNombreDelUsuario);

		JButton botonBorrar = new JButton("Borrar");
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (usuarioBorrar.getText().isEmpty()) {
					resultado.setVisible(true);
					resultado.setText("Por favor ingrese un nombre de usuario.");
					return;
				}

				Usuario u = gu.buscarUsuario(usuarioBorrar.getText());

				if (u != null && !u.isEsAdmin()) {
					if (gu.eliminarUsuario(u.getUsuario())) {
						if (gp.eliminarPreferencias(u.getUsuario())) {
							resultado.setVisible(true);
							resultado.setText("Se ha borrado con exito!");
							actualizarTablonUsuarios();
							usuarioBorrar.setText(""); // Limpiamos la cajita de escribir
							resultado.setText("Usuario eliminado correctamente.");
						} else {
							resultado.setVisible(true);
							resultado.setText("No se han encontrado preferencias de este usuarios");
						}

					} else {
						resultado.setVisible(true);
						resultado.setText("No se ha podido eliminar el usuario.");
					}

				} else {
					resultado.setVisible(true);
					resultado.setText("No se encontro el usuario deseado.");
				}

			}
		});
		botonBorrar.setBounds(108, 302, 89, 23);
		panelBorrado.add(botonBorrar);

		resultado = new JLabel("En espera");
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setBounds(46, 342, 214, 14);
		resultado.setVisible(false);
		panelBorrado.add(resultado);

		JButton moreInfo = new JButton("Acerca de");
		moreInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Noticias Mapaches v1.0\nDesarrollado por el equipo Mapache\n2025\nTodos los derechos reservados.\nVersion 1.5\n¡Gracias por usar nuestra aplicación de noticias!",
						"Acerca de Noticias Mapaches", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		moreInfo.setBounds(515, 16, 109, 20);
		add(moreInfo);

	}

	private void actualizarTablonUsuarios() {
		textArea.setText("");
		
		List<Usuario> lista = gu.getListaUsuario();

		StringBuilder texto = new StringBuilder();
		for (Usuario u : lista) {
			texto.append("• ").append(u.getUsuario());
			if (u.isEsAdmin()) {
				texto.append(" [ADMIN]");
			}
			texto.append("\n");

		}

		textArea.setText(texto.toString());
	}
}
