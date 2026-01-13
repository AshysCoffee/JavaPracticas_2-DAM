package noticiero;

import javax.swing.JPanel;

import gestiones.GestionUsuarios;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelGestionAdmin extends JPanel {
	
	private VentanaPrincipal v;
	private GestionUsuarios gu;
	
	public PanelGestionAdmin(VentanaPrincipal ventanaPrincipal, GestionUsuarios gu) {
		
		this.gu=gu;
		this.v = ventanaPrincipal;
		
		setLayout(null);
		
		JButton btnNewButton = new JButton("Crear usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(47, 83, 118, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar usuario");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(47, 188, 118, 23);
		add(btnNewButton_1);
		
		JButton salir = new JButton("Salir");
		salir.setBounds(510, 438, 113, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(salir);
		
	}

}
