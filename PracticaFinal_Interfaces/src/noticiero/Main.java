package noticiero;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import gestiones.GestionEmail;
import gestiones.GestionNoticias;
import gestiones.GestionUsuarios;

public class Main {

	private JFrame frame;
	private GestionNoticias gn;

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
					
					gu.cargarUsuarios();

					VentanaPrincipal frame = new VentanaPrincipal(gu,gn, ge);
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("iu/raccoon_lg.png"));
	}

}
