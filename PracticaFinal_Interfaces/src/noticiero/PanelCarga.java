package noticiero;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import gestiones.ControlErrores;

@SuppressWarnings("serial")
public class PanelCarga extends JPanel{

	Timer tiempo, carga;
	int j = 0;

	private Component buscarImagen() {
		BufferedImage fondo = null;

		try {
			fondo = ImageIO.read(new File ("ui/mapache_carga.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image foto = fondo;
		JPanel panelconFondo = new JPanel () {
			@Override
			protected void paintComponent (Graphics g) {
				super.paintComponent(g);
				g.drawImage(foto,0,0,900,560,null);
				
			}
		};
		panelconFondo.setLayout(null);
		
		return panelconFondo;
	}

	
	public PanelCarga(PanelLogin login) {
		setLayout(null);
		
		add(buscarImagen());
		//setIconImage(Toolkit.getDefaultToolkit().getImage("iu/raccoon_lg.png"));
		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setOpaque(true);
		progressBar.setBounds(10, 265, 430, 24);
		add(progressBar);

		
		carga = new Timer(500, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				j += 20;
				progressBar.setValue(j);
				
				if (j == 80) {
					if (!ControlErrores.verificarArchivosObligatorios()) {
						JOptionPane.showMessageDialog(null, null, "ERROR", 1);
					}

					if (j >= 100) {
						carga.stop();
						login.setVisible(true);
				
					}

				}

			}
		});

		carga.start();

	}
}
