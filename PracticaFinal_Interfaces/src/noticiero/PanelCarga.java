package noticiero;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gestiones.ControlErrores;

public class PanelCarga extends JFrame{

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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("ui/raccoon_lg.png"));
		frame.setTitle("Noticiero Mapache");
		frame.setBounds(100, 100, 600, 600);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				tiempo.start();
				carga.start();
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setOpaque(true);
		progressBar.setBounds(46, 438, 519, 35);
		frame.getContentPane().add(progressBar);

		tiempo = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				i--;
				if (i == 0) {
					tiempo.stop();
				}
			}
		});
		
		carga = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (frame.isVisible() && frame.isActive()) {
					j += 1;
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
				if (progressBar.getValue() == 100) {
					String msg = "Me funcionaaaa, por fis sal de aqui y veras mi maravilloso programa B)";

					JOptionPane.showMessageDialog(null, msg, "Cierra aqui lol", 1);
				}

			}
		});
	}
}
