package noticiero;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gestiones.GestionEmail;
import gestiones.GestionNoticias;
import gestiones.GestionPreferencias;
import gestiones.GestionUsuarios;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelMenuUsuario extends JPanel {

	private VentanaPrincipal v;
	private GestionNoticias gn;
	private GestionPreferencias gp;

	public PanelMenuUsuario(VentanaPrincipal ventanaPrincipal, GestionNoticias gn, GestionPreferencias gp) {

		this.gp = gp;
		this.gn = gn;
		this.v = ventanaPrincipal;

		JLabel lblNewLabel = new JLabel("Economia");
		lblNewLabel.setBounds(25, 26, 54, 13);
		add(lblNewLabel);

		JLabel lblDeporte = new JLabel("Deportes");
		lblDeporte.setBounds(25, 100, 54, 13);
		add(lblDeporte);

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

		setLayout(null);

		// 1. Título
		JLabel lblTitulo = new JLabel("Mis Noticias");
		lblTitulo.setBounds(30, 20, 200, 30);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblTitulo);

		JTextArea txtNoticias = new JTextArea();
		txtNoticias.setEditable(false);
		txtNoticias.setLineWrap(true);
		txtNoticias.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(txtNoticias);
		scroll.setBounds(30, 60, 500, 300); // Ajusta tamaño a tu ventana
		add(scroll);

		JButton btnCargar = new JButton("Actualizar Noticias");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 1. Intentamos poner un mensaje de espera
				txtNoticias.setText("Cargando noticias... (La pantalla se congelará un momento)");

				// Forzamos a que el "Cargando" se pinte antes de bloquear (truco rápido)
				txtNoticias.paintImmediately(txtNoticias.getVisibleRect());

				// 2. LLAMADA DIRECTA (Sin hilos)
				// Esto bloqueará la ventana hasta que termine de descargar o leer el fichero
				List<String> listaTitulares = gn.cargarTitulares(gn.cargarFuentes());

				// 3. Mostramos los resultados
				txtNoticias.setText(""); // Borramos el mensaje de carga

				if (listaTitulares != null && !listaTitulares.isEmpty()) {
					for (String titular : listaTitulares) {
						txtNoticias.append("• " + titular + "\n\n");
					}
				} else {
					txtNoticias.setText("No hay noticias disponibles o no hay conexión.");
				}

			}
		});
		btnCargar.setBounds(30, 380, 150, 30);
		add(btnCargar);

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
