package noticiero;

import javax.swing.JPanel;

import gestiones.GestionUsuarios;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PanelGestionAdmin extends JPanel {
	
	private VentanaPrincipal v;
	private GestionUsuarios gu;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public PanelGestionAdmin(VentanaPrincipal ventanaPrincipal, GestionUsuarios gu) {
		
		this.gu=gu;
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
				
				
				
			}
		});
		btnCrearUsuarios.setBounds(353, 142, 183, 31);
		add(btnCrearUsuarios);
		
		JButton infoApp = new JButton("Información adicional");
		infoApp.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		infoApp.setBounds(353, 255, 215, 31);
		add(infoApp);
		
		JButton btnBorrarUsuario = new JButton("Borrar usuario");
		btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrarUsuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		btnBorrarUsuario.setBounds(353, 197, 183, 31);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 20, 306, 392);
		add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(32, 63, 242, 19);
		textField.setColumns(10);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(57, 135, 183, 19);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(32, 204, 242, 19);
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Nombre del usuario");
		lblNewLabel.setBounds(104, 41, 97, 12);
		panel.add(lblNewLabel);
		
		JLabel lblContrasenna = new JLabel("Contraseña");
		lblContrasenna.setBounds(118, 113, 52, 12);
		panel.add(lblContrasenna);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(132, 182, 30, 12);
		panel.add(lblEmail);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 9, 9);
		add(panel_1);
		
	}
}
