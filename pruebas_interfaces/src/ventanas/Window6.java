package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Window6 {

	private JFrame frame;
	Timer tiempo, carga;
	int i = 10, j=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window6 window = new Window6();
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
	public Window6() {
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

		
		JLabel mensajito = new JLabel("Esto no se Odoo! xD");
		mensajito.setVisible(false);
		mensajito.setHorizontalTextPosition(SwingConstants.CENTER);
		mensajito.setHorizontalAlignment(SwingConstants.CENTER);
		mensajito.setBackground(new Color(255, 255, 255));
		mensajito.setFont(new Font("Ubuntu Mono", Font.BOLD, 10));
		mensajito.setBounds(256, 197, 156, 19);
		frame.getContentPane().add(mensajito);
		
		JButton start = new JButton("START");
		start.setFont(new Font("Tahoma", Font.PLAIN, 20));
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tiempo.start();
				carga.start();
				
			}
		});
		start.setBounds(55, 55, 98, 59);
		frame.getContentPane().add(start);

		JLabel contador_texto = new JLabel("");
		contador_texto.setHorizontalTextPosition(SwingConstants.CENTER);
		contador_texto.setHorizontalAlignment(SwingConstants.CENTER);
		contador_texto.setOpaque(true);
		contador_texto.setBackground(new Color(51, 204, 102));
		contador_texto.setFont(new Font("Ubuntu Mono", Font.BOLD, 36));
		contador_texto.setBounds(243, 55, 112, 64);
		frame.getContentPane().add(contador_texto);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(67, 169, 312, 19);
		frame.getContentPane().add(progressBar);
		
		JLabel cargando = new JLabel("Cargando :0");
		cargando.setBounds(55, 199, 46, 14);
		frame.getContentPane().add(cargando);


		tiempo = new Timer (1000, new ActionListener() {

			public void actionPerformed (ActionEvent e) {
				i--;
				contador_texto.setText(String.valueOf(i));
				if (i==0) {
					tiempo.stop();
					start.setEnabled(false);
				}
			}
		});

		carga = new Timer (1000, new ActionListener() {

			public void actionPerformed (ActionEvent e) {
				j+=10;
				progressBar.setValue(j);
			cargando.setLocation((cargando.getLocation().x+10), cargando.getLocation().y);;
				if (j==100) {
					carga.stop();
					mensajito.setVisible(true);
					cargando.setVisible(false);
				}
			}
		});
		
		progressBar.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if  (progressBar.getValue()==100) {
					String msg = "Me funcionaaaa, por fis sal de aqui y veras mi maravilloso programa B)";
				
					JOptionPane.showMessageDialog (null, msg,"Cierra aqui lol" ,1);
				} 
				
			}
		});


	}
}
