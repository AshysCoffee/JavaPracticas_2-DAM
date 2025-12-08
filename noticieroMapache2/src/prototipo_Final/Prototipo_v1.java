package prototipo_Final;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;

public class Prototipo_v1 {

	private JFrame frame;
	Timer tiempo, carga;
	int i = 10, j = 0;

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
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
        
		
		JPanel iniciar = new JPanel();
		frame.getContentPane().add(iniciar, "name_435875652272400");
		iniciar.setLayout(null);
		
		JPanel config = new JPanel();
		frame.getContentPane().add(config, "name_435880024319600");
		
		JPanel preferencais = new JPanel();
		frame.getContentPane().add(preferencais, "name_435943516059300");

		JPanel admin = new JPanel();
		frame.getContentPane().add(admin, "name_435954206221800");

		JPanel configadmin = new JPanel();
		frame.getContentPane().add(configadmin, "name_435957990256500");

		JButton salir = new JButton("Salir");
		salir.setBounds(471, 548, 89, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // liberar memoria :3
				System.exit(0);
			}
		});
		iniciar.add(salir);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setStringPainted(true);
		progressBar_1.setBounds(58, 290, 476, 28);
		iniciar.add(progressBar_1);

		JLabel contador_texto = new JLabel("");
		contador_texto.setHorizontalTextPosition(SwingConstants.CENTER);
		contador_texto.setHorizontalAlignment(SwingConstants.CENTER);
		contador_texto.setOpaque(true);
		contador_texto.setBackground(new Color(51, 204, 102));
		contador_texto.setFont(new Font("Ubuntu Mono", Font.BOLD, 36));
		contador_texto.setBounds(243, 55, 112, 64);
		frame.getContentPane().add(contador_texto);

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

		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(67, 169, 312, 19);
		frame.getContentPane().add(progressBar);

		JLabel cargando = new JLabel("Cargando :0");
		cargando.setBounds(55, 199, 46, 14);
		frame.getContentPane().add(cargando);

		tiempo = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				i--;
				contador_texto.setText(String.valueOf(i));
				if (i == 0) {
					tiempo.stop();
					start.setEnabled(false);
				}
			}
		});

		carga = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				j += 10;
				progressBar.setValue(j);
				cargando.setLocation((cargando.getLocation().x + 10), cargando.getLocation().y);
				;
				if (j == 100) {
					carga.stop();
					cargando.setVisible(false);
				}
			}
		});

		progressBar.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (progressBar.getValue() != 100) {
					String msg = "Me funcionaaaa, por fis sal de aqui y veras mi maravilloso programa B)";

					JOptionPane.showMessageDialog(null, msg, "Cierra aqui lol", 1);
				}

			}
		});

	}
}
