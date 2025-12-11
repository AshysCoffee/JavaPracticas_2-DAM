package noticiero;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
			fondo = ImageIO.read(new File("ui/mapache_carga.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image foto = fondo;
		JPanel panelconFondo = new JPanel () {
			
			@Override
			protected void paintComponent (Graphics g) {
				super.paintComponent(g);
				g.drawImage(foto,0,0,650,500,null);
				
			}
		};
		panelconFondo.setBounds(0, 0, 650, 500);
		panelconFondo.setLayout(null);
		
		return panelconFondo;
	}

	
	public PanelCarga(VentanaPrincipal v) {
		setLayout(null);
		add(buscarImagen());
		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 24, 617, 36);
		add(progressBar);

		
		carga = new Timer(500, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				j += 10;
				progressBar.setValue(j);
				
				if (j > 80) {
					if (!ControlErrores.verificarArchivosObligatorios()) {
						JOptionPane.showMessageDialog(null, "No estan todos los archivos requeridos", "ERROR", 1);
						System.exit(0);
					}

					if (j >= 100) {
						carga.stop();
						v.cambiarPantalla("LOGIN");;
				
					}

				}

			}
		});

		carga.start();

	}
}
