package noticiero;

import java.awt.EventQueue;

import javax.swing.JFrame;

import gestiones.GestionNoticias;
import gestiones.GestionUsuarios;

public class Main {

	private JFrame frame;
	private GestionUsuarios gu;
	private GestionNoticias gn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal main = new VentanaPrincipal();
					main.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		gu.cargarUsuarios();
		gn.cargarTitulares();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
