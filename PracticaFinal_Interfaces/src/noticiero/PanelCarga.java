package noticiero;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gestiones.ControlErrores;

public class PanelCarga {

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
					PanelCarga window = new PanelCarga();
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
	public PanelCarga() {
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
		frame.getContentPane().setLayout(null);
		
		JButton start = new JButton("START");
		start.setFont(new Font("Tahoma", Font.PLAIN, 20));
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tiempo.start();
				carga.start();

			}
		});
		start.setBounds(239, 358, 98, 59);
		frame.getContentPane().add(start);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(46, 438, 519, 35);
		frame.getContentPane().add(progressBar);

		carga = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (frame.isVisible()) {
					j += 20;
					progressBar.setValue(j);
					;
					if (j == 80) {
						try {
			                ControlErrores.verificarArchivosObligatorios();
			                System.out.println("Archivos verificados correctamente.");
			            } catch (Exception ex) {
			                System.err.println("Error verificando archivos: " + ex.getMessage());
			            }
					}
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
