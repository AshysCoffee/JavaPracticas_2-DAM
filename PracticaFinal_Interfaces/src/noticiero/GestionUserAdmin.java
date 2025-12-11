package noticiero;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionUserAdmin extends JPanel {
	
	public GestionUserAdmin() {
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
		
	}

}
