package noticiero;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

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
					GestionNoticias gn = new GestionNoticias();
					GestionEmail ge = new GestionEmail();
					GestionPreferencias gp = new GestionPreferencias();
					
					gu.cargarUsuarios();

					VentanaPrincipal frame = new VentanaPrincipal(gu,gn, ge, gp);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("ui/raccoon_icons.jpg"));
	}

}
