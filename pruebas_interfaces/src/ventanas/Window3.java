package ventanas;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JToggleButton;

public class Window3 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window3 window = new Window3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize();
		int height= (int) monitor.getHeight() /2;
		int width= (int) monitor.getWidth() /2;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		
		/*frame.setLocationRelativeTo(null);
		//osea si se escribe en null, el programa entiendo que no existe otro elemento, entonces lo alinea en el centro
		//haciendo que lo ponga en el centro del frame, en caso de null en la mitad de la pantalla en la que se ejecute*/
		
		frame.setLocation((width - frame.getWidth()/2), (height- frame.getHeight()/2));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 255));
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Interruptor");
		tglbtnNewToggleButton.setActionCommand("Encender_apagar");
		
		tglbtnNewToggleButton.setBounds(164, 110, 121, 23);
		panel.add(tglbtnNewToggleButton);
	}
}
