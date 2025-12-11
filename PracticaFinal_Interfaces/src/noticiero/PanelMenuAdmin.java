package noticiero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import gestiones.GestionEmail;
import gestiones.GestionNoticias;

public class PanelMenuAdmin extends JPanel{


	public PanelMenuAdmin() {

		setLayout(null);

		JButton btnTestNoticias = new JButton("Test de noticias");
		btnTestNoticias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionEmail ge = new GestionEmail ();

			}
		});
		btnTestNoticias.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		btnTestNoticias.setBounds(121, 141, 191, 36);
		add(btnTestNoticias);

		JButton btnGestionUsuarios = new JButton("Gestión de usuarios");
		btnGestionUsuarios.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		btnGestionUsuarios.setBounds(121, 94, 191, 36);
		add(btnGestionUsuarios);

		JLabel lblNewLabel = new JLabel("Menu Administrador");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(141, 60, 151, 23);
		add(lblNewLabel);
	}
}
