package noticiero;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gestiones.GestionNoticias;
import gestiones.GestionPreferencias;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelMenuUsuario  extends JPanel{
	
	private VentanaPrincipal v;
	private GestionNoticias gn;
	private GestionPreferencias gp;
	
	private JTextArea areaNoticias;
	
	public PanelMenuUsuario(VentanaPrincipal ventanaPrincipal, GestionNoticias gn, GestionPreferencias gp) {
		
		this.gp = gp;
		this.gn = gn;
		this.v = ventanaPrincipal;
		
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
		
		JTextArea txtNoticias = new JTextArea();
		txtNoticias.setEditable(false);
		txtNoticias.setLineWrap(true);
		txtNoticias.setWrapStyleWord(true);
		txtNoticias.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton btnRefrescar = new JButton("Ver mis Noticias");
		btnRefrescar.setBounds(50, 50, 200, 30);
		add(btnRefrescar);

		// 2. Área de texto para mostrar los titulares
		areaNoticias = new JTextArea();
		areaNoticias.setBounds(50, 100, 500, 300);
		areaNoticias.setEditable(false);
		areaNoticias.setLineWrap(true);
		areaNoticias.setWrapStyleWord(true);

		// Ponemos Scroll por si hay muchas noticias
		JScrollPane scroll = new JScrollPane(areaNoticias);
		scroll.setBounds(50, 100, 500, 300);
		add(scroll);

		// 3. El Evento del Botón
		btnRefrescar.addActionListener(e -> {
			cargarNoticiasEnPantalla();
		});
	}

	private void cargarNoticiasEnPantalla() {
		areaNoticias.setText("Cargando titulares... espere un momento.");

		List<String> titulares = gn.getTitulares(); // O el método que uses

		areaNoticias.setText(""); // Limpiar
		if (titulares.isEmpty()) {
			areaNoticias.setText("No hay noticias o no hay internet.");
		} else {
			for (String t : titulares) {
				areaNoticias.append("• " + t + "\n\n");
			}
		}

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
