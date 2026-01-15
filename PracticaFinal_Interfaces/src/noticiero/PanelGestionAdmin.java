package noticiero;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import gestiones.GestionUsuarios;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PanelGestionAdmin extends JPanel {

	private VentanaPrincipal v;
	private GestionUsuarios gu;
	private JTextField newNombre;
	private JTextField newPwd;
	private JTextField newEmail;
	JPanel panelCreacion;
	JLabel resultadoCreacion;
	JButton aceptarCreate;

	public PanelGestionAdmin(VentanaPrincipal ventanaPrincipal, GestionUsuarios gu) {

		this.gu = gu;
		this.v = ventanaPrincipal;

		setLayout(null);
		setSize(650, 500);

		JButton salir = new JButton("Salir");
		salir.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		salir.setBounds(482, 430, 141, 31);
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
		atras.setBounds(26, 430, 141, 31);
		add(atras);

		panelCreacion = new JPanel();
		panelCreacion.setBounds(26, 20, 306, 392);
		add(panelCreacion);
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
		lblNewLabel.setBounds(87, 76, 132, 27);
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
					
				}else {
					resultadoCreacion.setText("Hubo problemas con la creación");
					resultadoCreacion.setVisible(true);
				}

			}
		});
		aceptarCreate.setBounds(104, 312, 97, 23);
		panelCreacion.add(aceptarCreate);

		JLabel lblNewLabel_1 = new JLabel("Creación de un usuario nuevo");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel_1.setBounds(16, 28, 273, 27);
		panelCreacion.add(lblNewLabel_1);

		resultadoCreacion = new JLabel("En espera");
		resultadoCreacion.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoCreacion.setVisible(false);
		resultadoCreacion.setBounds(31, 346, 243, 14);
		panelCreacion.add(resultadoCreacion);

	}
}
