package noticiero;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import gestiones.GestionEmail;
import gestiones.GestionNoticias;
import gestiones.GestionUsuarios;
import modelos.Fuentes;
import modelos.Usuario;

public class PanelMenuAdmin extends JPanel{

	private VentanaPrincipal v;
	private GestionUsuarios gu;
	private GestionNoticias gn;
	private GestionEmail ge;
	JPanel panelNoticias;
	JScrollPane scroll;
	
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
		btnTestNoticias.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		btnTestNoticias.setBounds(193, 171, 270, 36);
		add(btnTestNoticias);

		JButton btnGestionUsuarios = new JButton("Test de noticias - Email");
		btnGestionUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ge.testCorreoAdmin();
				
			}
		});
		btnGestionUsuarios.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		btnGestionUsuarios.setBounds(193, 127, 270, 36);
		add(btnGestionUsuarios);

		JLabel lblNewLabel = new JLabel("Menu Administrador");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(166, 27, 316, 42);
		add(lblNewLabel);
		
		JButton atras = new JButton("Atrás");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarPantalla("LOGIN");
			}
		});
		atras.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		atras.setBounds(24, 231, 141, 31);
		add(atras);
		
		JButton salir = new JButton("Salir");
		salir.setBounds(475, 231, 151, 30);
		salir.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(salir);
		
		JButton btnNoticiasPantalla = new JButton("Test de noticias - Pantalla");
		btnNoticiasPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scroll.setVisible(true);
				
			}
		});
		btnNoticiasPantalla.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		btnNoticiasPantalla.setBounds(193, 80, 270, 36);
		add(btnNoticiasPantalla);
		

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cargarNoticias();
			}
		});
		
		panelNoticias = new JPanel();
		panelNoticias.setBounds(52, 283, 546, 206);
		add(btnNoticiasPantalla);
		
		panelNoticias = new JPanel();
		panelNoticias.setLayout(new BoxLayout(panelNoticias, BoxLayout.Y_AXIS));
		panelNoticias.setBackground(Color.WHITE);

		scroll = new JScrollPane(panelNoticias);
		scroll.setVisible(false);
		scroll.setBounds(25, 273, 600, 173); // Espacio central grande
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scroll);

		
		JButton moreInfo = new JButton("Acerca de");
		moreInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Noticias Mapaches v1.0\nDesarrollado por el equipo Mapache\n2025\nTodos los derechos reservados.\nVersion 1.5\n¡Gracias por usar nuestra aplicación de noticias!",
						"Acerca de Noticias Mapaches", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		moreInfo.setBounds(24, 11, 84, 20);
		add(moreInfo);
		
	}
		public void cargarNoticias() {
			panelNoticias.removeAll();
			panelNoticias.add(new JLabel("Cargando noticias, por favor espere..."));
			panelNoticias.revalidate();
			panelNoticias.repaint();

			new Thread(() -> {
				try {
					
					panelNoticias.removeAll();
					panelNoticias.add(new JLabel("Cargando noticias, por favor espere..."));
					panelNoticias.revalidate();
					panelNoticias.repaint();
					
					List<Fuentes> misFuentes = gn.getListaNoticias();
					List<String> titulares = gn.cargarTitulares(misFuentes, "admin");
					if (misFuentes == null)
						misFuentes = new ArrayList<>();

					SwingUtilities.invokeLater(() -> {
						panelNoticias.removeAll();

						if (titulares == null || titulares.isEmpty()) {
							JTextArea txt = new JTextArea(
									"No hay noticias.\nPosibles causas:\n1. No tienes periódicos asignados.\n2. Fallo de conexión.\n3. Revisa config.txt");
							txt.setEditable(false);
							panelNoticias.add(txt);
						} else {
							for (String t : titulares) {
								JTextArea txt = new JTextArea(t);
								txt.setLineWrap(true);
								txt.setWrapStyleWord(true);
								txt.setEditable(false);
								txt.setOpaque(false);
								txt.setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));
								panelNoticias.add(txt);
								panelNoticias.add(new JSeparator());
							}
						}
						panelNoticias.revalidate();
						panelNoticias.repaint();
					});

				} catch (Exception ex) {
					SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage()));
				}
			}).start();
		}
		
		
		
}
