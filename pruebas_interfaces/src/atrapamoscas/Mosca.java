package atrapamoscas;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Mosca {

	private JFrame frame;
	JLabel mosca_img;
	int xM, yM;
	Random r = new Random();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mosca window = new Mosca();
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
	public Mosca() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setBackground(new Color(255, 182, 193));
		frame.setBounds(100, 100, 900, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel mosca = new JLabel("New label");
		mosca.setIcon(new ImageIcon("src/mosca.png"));
		mosca.setBounds(279, 227, 50, 50);
		
		frame.addMouseMotionListener( new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
						xM  = e.getX();
						yM = e.getY();
						
					int lblX = mosca.getX();
					int lblY = mosca.getY();
					int lblW = mosca.getWidth();
					int lblH = mosca.getHeight();
					
					int distanX = Math.abs(xM - lblX);
					int distanY = Math.abs(yM - lblY);
						
					int limite = 75;
					
					
					if (distanX < limite ||distanY < limite ) {
						
						int moverX = r.nextInt(101)-50;
						int moverY = r.nextInt(101)-50;
						
						
						int nuevoX = Math.max(0, Math.min(lblX+moverX, frame.getWidth()-2*lblW));
						int nuevoY = Math.max(0, Math.min(lblY+moverY, frame.getHeight()-2*lblH));
					
					mosca.setLocation(nuevoX, nuevoY);
					}
					
					
				}});
		
		frame.getContentPane().add(mosca);
		
		
	}
}
