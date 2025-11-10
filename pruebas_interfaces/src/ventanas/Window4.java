package ventanas;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.CardLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.swing.JLayeredPane;
import java.awt.Toolkit;

public class Window4 {

	private JFrame frame;
	private JPanel panel_1; //siempre declara aqui arriba para que no rompa xd
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window4 window = new Window4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private Component buscarImagen() {
		BufferedImage fondo = null;

		try {
			fondo = ImageIO.read(new File ("src/Cute_Raccoon_Wallpaper.jpg"));
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

	/**
	 * Create the application.
	 */
	public Window4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/raccoon_lg.png"));
		frame.setTitle("Pruebas iniciales");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(new Color(255, 182, 193));
		frame.setBounds(100, 100, 900, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		frame.getContentPane().add(buscarImagen());
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, "name_1701738081100");
		
		JPanel panel = new JPanel();
		layeredPane.setLayer(panel, 1);
		panel.setBackground(new Color(255, 255, 0));
		panel.setBounds(0, 0, 434, 261);
		layeredPane.add(panel);  
		panel.setLayout(null);
		
		JButton btnNaranja = new JButton("Cambiar al naranja");
		btnNaranja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNaranja.setBounds(240, 227, 184, 23);
		panel.add(btnNaranja);
		
		JButton btnRojo = new JButton("Cambia al rojo");
		btnRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnRojo.setBounds(10, 227, 184, 23);
		panel.add(btnRojo);
		
		panel_1 = new JPanel();
		layeredPane.setLayer(panel_1, 2);
		panel_1.setVisible(false);
		panel_1.setBackground(new Color(255, 153, 0));
		panel_1.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_3_1 = new JButton("Cambia al rojo");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnNewButton_3_1.setBounds(240, 227, 184, 23);
		panel_1.add(btnNewButton_3_1);
		
		JButton btnAmarillo = new JButton("Cambia al amarillo");
		btnAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
			}
		});
		btnAmarillo.setBounds(10, 227, 184, 23);
		panel_1.add(btnAmarillo);
		
		panel_2 = new JPanel();
		layeredPane.setLayer(panel_2, 3);
		panel_2.setBackground(new Color(255, 51, 0));
		panel_2.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_3_2 = new JButton("Cambia al amarillo");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			panel.setVisible(true);
			panel_1.setVisible(false);
			panel_2.setVisible(false);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Cambiar al naranja");
		btnNewButton_1.setBounds(10, 227, 184, 23);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.setVisible(false);
				panel_1.setVisible(true);
				panel_2.setVisible(false);
			}
		});
		btnNewButton_3_2.setBounds(240, 227, 184, 23);
		panel_2.add(btnNewButton_3_2);
	}
	
	
}
