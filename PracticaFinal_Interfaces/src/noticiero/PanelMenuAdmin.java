package noticiero;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import gestiones.GestionEmail;
import gestiones.GestionNoticias;
import gestiones.GestionUsuarios;

public class PanelMenuAdmin extends JPanel{

	private VentanaPrincipal v;
	private GestionUsuarios gu;
	private GestionNoticias gn;
	private GestionEmail ge;
	
	public PanelMenuAdmin(VentanaPrincipal ventanaPrincipal,GestionUsuarios gu, GestionNoticias gn, GestionEmail ge) {

		this.gn=gn;
		this.gu=gu;
		this.ge=ge;
		this.v = ventanaPrincipal;
		
		setLayout(null);
		setSize(650, 500);

		JButton btnTestNoticias = new JButton("Gestión de usuarios");
		btnTestNoticias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				v.cambiarPantalla("GESTION_ADMIN");
				
			}
		});
		btnTestNoticias.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		btnTestNoticias.setBounds(229, 141, 191, 36);
		add(btnTestNoticias);

		JButton btnGestionUsuarios = new JButton("Test de noticias");
		btnGestionUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ge.testCorreoAdmin();
				
			}
		});
		btnGestionUsuarios.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		btnGestionUsuarios.setBounds(229, 94, 191, 36);
		add(btnGestionUsuarios);

		JLabel lblNewLabel = new JLabel("Menu Administrador");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(249, 60, 151, 23);
		add(lblNewLabel);
		
		JButton atras = new JButton("Atrás");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarPantalla("LOGIN");
			}
		});
		atras.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		atras.setBounds(144, 236, 141, 31);
		add(atras);
		
		JButton salir = new JButton("Salir");
		salir.setBounds(358, 237, 151, 30);
		salir.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(salir);
	}

	
}
