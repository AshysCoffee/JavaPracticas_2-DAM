package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;

public class Window5 {

	private JFrame frame;
	Timer tiempo;
	int i = 5;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window5 window = new Window5();
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
	public Window5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel mensajito = new JLabel("FELIZ AÑO NUEVO :D!");
		mensajito.setVisible(false);
		mensajito.setHorizontalTextPosition(SwingConstants.CENTER);
		mensajito.setHorizontalAlignment(SwingConstants.CENTER);
		mensajito.setOpaque(true);
		mensajito.setBackground(new Color(102, 153, 255));
		mensajito.setFont(new Font("Ubuntu Mono", Font.BOLD, 16));
		mensajito.setBounds(125, 30, 257, 43);
		frame.getContentPane().add(mensajito);
		
		JLabel contador_texto = new JLabel("");
		contador_texto.setFont(new Font("Ubuntu Mono", Font.BOLD, 36));
		contador_texto.setBounds(223, 96, 112, 64);
		frame.getContentPane().add(contador_texto);
		
		JButton contador = new JButton("START");
		contador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		contador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tiempo.start();
			}
		});
		contador.setBounds(44, 96, 95, 64);
		frame.getContentPane().add(contador);
		
		JButton salida = new JButton("SAQUENME DE AQUI XFAVOR");
		salida.setBackground(new Color(255, 51, 51));
		salida.setBorder(UIManager.getBorder("Button.border"));
		salida.setActionCommand("salida");
		salida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); //liberar memoria :3
				System.exit(0);
			}
		});
		
		salida.setFont(new Font("Ubuntu Mono", Font.BOLD | Font.ITALIC, 15));
		salida.setBounds(173, 207, 251, 43);
		frame.getContentPane().add(salida);
		
		
		//METODO DE LA CUENTA ATRAS - RECUERDA ESTO ES UN METODO LUEGO EN EL BOTON HAY QUE PONERLO EN EL ACTION PERFORMED;
		tiempo = new Timer (1000, new ActionListener() {
		
		public void actionPerformed (ActionEvent e) {
			i--;
			contador_texto.setText(String.valueOf(i));
			if (i==0) {
				tiempo.stop();
				mensajito.setVisible(true);
				contador.setEnabled(false);
			}
		}
		});
	}
}
