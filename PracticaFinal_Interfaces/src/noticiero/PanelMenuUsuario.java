package noticiero;

import javax.swing.JPanel;

import gestiones.GestionEmail;
import gestiones.GestionNoticias;
import gestiones.GestionUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelMenuUsuario  extends JPanel{
	
	private VentanaPrincipal v;
	private GestionUsuarios gu;
	private GestionNoticias gn;
	private GestionEmail ge;
	
	public PanelMenuUsuario(VentanaPrincipal ventanaPrincipal, GestionNoticias gn) {
		
		this.gn = gn;
		this.v = ventanaPrincipal;
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Economia");
		lblNewLabel.setBounds(25, 26, 54, 13);
		add(lblNewLabel);
		
		JLabel Deporte = new JLabel("Deportes");
		Deporte.setBounds(25, 100, 54, 13);
		add(Deporte);
		
		JLabel lblNacional = new JLabel("Nacional");
		lblNacional.setBounds(25, 174, 54, 13);
		add(lblNacional);
		
		JLabel lblInternacional = new JLabel("Internacional");
		lblInternacional.setBounds(25, 248, 79, 13);
		add(lblInternacional);
		
		JLabel lblCiencia = new JLabel("Ciencia");
		lblCiencia.setBounds(25, 322, 54, 13);
		add(lblCiencia);
		
		JLabel lblFauna = new JLabel("Fauna");
		lblFauna.setBounds(25, 396, 54, 13);
		add(lblFauna);
		
	
		
		JLabel noticiasEcon = new JLabel("New label");
		noticiasEcon.setBounds(35, 40, 542, 50);
		add(noticiasEcon);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(35, 114, 542, 50);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setBounds(35, 188, 542, 50);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setBounds(35, 262, 542, 50);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setBounds(35, 336, 542, 50);
		add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("New label");
		lblNewLabel_1_5.setBounds(35, 413, 542, 50);
		add(lblNewLabel_1_5);
		
		
		JButton salir = new JButton("Salir");
		salir.setBounds(536, 473, 113, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(salir);
	}
	
}
