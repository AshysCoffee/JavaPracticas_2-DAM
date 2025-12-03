package prototipo_Final;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class Prototipo_v1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prototipo_v1 window = new Prototipo_v1();
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
	public Prototipo_v1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/raccoon_lg.png"));
		frame.setTitle("Noticiero Mapache");
		frame.setBounds(100, 100, 600, 600);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
        
		
		JPanel iniciar = new JPanel();
		frame.getContentPane().add(iniciar, "name_435875652272400");
		
		JPanel config = new JPanel();
		frame.getContentPane().add(config, "name_435880024319600");
		
		JPanel preferencais = new JPanel();
		frame.getContentPane().add(preferencais, "name_435943516059300");
		
		JPanel admin = new JPanel();
		frame.getContentPane().add(admin, "name_435954206221800");
		
		JPanel configadmin = new JPanel();
		frame.getContentPane().add(configadmin, "name_435957990256500");
	}

}
