package noticiero;

import javax.swing.JPanel;

import gestiones.GestionEmail;
import gestiones.GestionNoticias;
import gestiones.GestionPreferencias;
import gestiones.GestionUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelMenuUsuario  extends JPanel{
	
	private VentanaPrincipal v;
	private GestionNoticias gn;
	private GestionPreferencias gp;
	
	public PanelMenuUsuario(VentanaPrincipal ventanaPrincipal, GestionNoticias gn, GestionPreferencias gp) {
		
		this.gp = gp;
		this.gn = gn;
		this.v = ventanaPrincipal;
		
		List<Fuentes>titulares = gp.
		
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
		
		JLabel noticiasDeportes = new JLabel("New label");
		noticiasDeportes.setBounds(35, 114, 542, 50);
		add(noticiasDeportes);
		
		JLabel noticiasNacio = new JLabel("New label");
		noticiasNacio.setBounds(35, 188, 542, 50);
		add(noticiasNacio);
		
		JLabel noticiasInter = new JLabel("New label");
		noticiasInter.setBounds(35, 262, 542, 50);
		add(noticiasInter);
		
		JLabel noticiasCiencias = new JLabel("New label");
		noticiasCiencias.setBounds(35, 336, 542, 50);
		add(noticiasCiencias);
		
		JLabel noticiasFauna = new JLabel("New label");
		noticiasFauna.setBounds(35, 413, 542, 50);
		add(noticiasFauna);
		
		
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
