package noticiero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import gestiones.GestionNoticias;
import gestiones.GestionPreferencias;
import modelos.Fuentes;
import modelos.Usuario;

public class PanelMenuUsuario extends JPanel {

	private VentanaPrincipal v;
	private GestionNoticias gn;
	private GestionPreferencias gp;
	private JPanel panelContenidos; // Panel interior para el scroll

	public PanelMenuUsuario(VentanaPrincipal ventanaPrincipal, GestionNoticias gn, GestionPreferencias gp) {
		this.gp = gp;
		this.gn = gn;
		this.v = ventanaPrincipal;

		setLayout(null);
		setSize(650, 500);

		// 1. TÍTULO
		JLabel lblTitulo = new JLabel("Mis Noticias");
		lblTitulo.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		lblTitulo.setBounds(25, 20, 200, 30);
		add(lblTitulo);

		// 2. ÁREA DE NOTICIAS (CON SCROLL - EL "BUCLE MÁGICO")
		panelContenidos = new JPanel();
		panelContenidos.setLayout(new BoxLayout(panelContenidos, BoxLayout.Y_AXIS));
		panelContenidos.setBackground(Color.WHITE);

		JScrollPane scroll = new JScrollPane(panelContenidos);
		scroll.setBounds(25, 60, 600, 350); // Espacio central grande
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scroll);

		// 3. BOTÓN ATRÁS
		JButton atras = new JButton("Cerrar Sesión");
		atras.addActionListener(e -> v.cambiarPantalla("LOGIN"));
		atras.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		atras.setBounds(25, 430, 150, 30);
		add(atras);

		// 4. BOTÓN RECARGAR (Por si falla internet)
		JButton recargar = new JButton("Recargar");
		recargar.addActionListener(e -> cargarNoticias());
		recargar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		recargar.setBounds(475, 430, 150, 30);
		add(recargar);

		// --- LA SOLUCIÓN AL "PETE" ---
		// Este "listener" detecta cuando la pantalla se hace visible.
		// Solo ENTONCES cargamos las noticias.
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cargarNoticias(); // <--- AQUÍ ES SEGURO LLAMARLO
			}
		});
	}

	// Método para cargar noticias sin bloquear la ventana
	private void cargarNoticias() {
		panelContenidos.removeAll();
		panelContenidos.add(new JLabel("Cargando noticias, por favor espere..."));
		panelContenidos.revalidate();
		panelContenidos.repaint();

		// Usamos un Hilo para no congelar la ventana
		new Thread(() -> {
			try {
				Usuario miUsuario = v.getUsuarioLogueado();
				if (miUsuario == null)
					return; // Seguridad

				List<Fuentes> misFuentes = gp.obtenerPreferencias(miUsuario.getUsuario());
				List<String> titulares = gn.cargarTitulares(misFuentes, miUsuario.getUsuario());
				if (misFuentes == null)
					misFuentes = new ArrayList<>();

				SwingUtilities.invokeLater(() -> {
					panelContenidos.removeAll();

					if (titulares == null || titulares.isEmpty()) {
						JTextArea txt = new JTextArea(
								"No hay noticias.\nPosibles causas:\n1. No tienes periódicos asignados.\n2. Fallo de conexión.\n3. Revisa config.txt");
						txt.setEditable(false);
						panelContenidos.add(txt);
					} else {
						for (String t : titulares) {
							JTextArea txt = new JTextArea("• " + t);
							txt.setLineWrap(true);
							txt.setWrapStyleWord(true);
							txt.setEditable(false);
							txt.setOpaque(false);
							txt.setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));
							panelContenidos.add(txt);
							panelContenidos.add(new JSeparator());
						}
					}
					panelContenidos.revalidate();
					panelContenidos.repaint();
				});

			} catch (Exception ex) {
				SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage()));
			}
		}).start();
	}
}