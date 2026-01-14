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

		JButton btnTestNoticias = new JButton("Gestión de usuarios");
		btnTestNoticias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnTestNoticias.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		btnTestNoticias.setBounds(121, 141, 191, 36);
		add(btnTestNoticias);

		JButton btnGestionUsuarios = new JButton("Test de noticias");
		btnGestionUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ge.testCorreoAdmin();
				
			}
		});
		btnGestionUsuarios.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		btnGestionUsuarios.setBounds(121, 94, 191, 36);
		add(btnGestionUsuarios);

		JLabel lblNewLabel = new JLabel("Menu Administrador");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(141, 60, 151, 23);
		add(lblNewLabel);
		
		JButton salir = new JButton("Salir");
		salir.setBounds(327, 266, 113, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(salir);
	}

	
}
