package traductor;

import java.awt.EventQueue;

public class Principal {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					VentanaTraductor miVentana = new VentanaTraductor();
					miVentana.setVisible(true);
					miVentana.setSize(500,500);
					
					//Si pongo un set aqui, estoy modificando el constructor xD
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
