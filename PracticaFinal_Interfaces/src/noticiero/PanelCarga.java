package noticiero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gestiones.ControlErrores;

@SuppressWarnings("serial")
public class PanelCarga extends JPanel{

	private JFrame frame;
	Timer tiempo, carga;
	int i = 10, j = 0;


	public PanelCarga() {
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setOpaque(true);
		progressBar.setBounds(46, 438, 519, 35);
		add(progressBar);

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
			            } catch (Exception ex) {
			            	String msg =  "No se han encontrado todos los archivos";
			            	JOptionPane.showMessageDialog(null, msg, "Cierra aqui lol", 1);
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
