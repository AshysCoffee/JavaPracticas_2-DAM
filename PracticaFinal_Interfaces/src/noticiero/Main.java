package noticiero;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gestiones.GestionEmail;
import gestiones.GestionNoticias;
import gestiones.GestionPreferencias;
import gestiones.GestionUsuarios;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionUsuarios gu = new GestionUsuarios();
					GestionNoticias gn = new GestionNoticias(gu);
					GestionEmail ge = new GestionEmail(null, gn, gu);
					GestionPreferencias gp = new GestionPreferencias(gn, gu);

					gu.cargarUsuarios();
					gn.iniciarNoticias();
					ge.cargarCredenciales();

					VentanaPrincipal frame = new VentanaPrincipal(gu, gn, ge, gp);
					frame.setVisible(true);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"No se pudo ejecutar el proyecto, por favor contacte soporte.", "Error en la app",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
