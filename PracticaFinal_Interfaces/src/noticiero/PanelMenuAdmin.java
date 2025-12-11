package noticiero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import gestiones.GestionNoticias;

public class PanelMenuAdmin extends JPanel{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelMenuAdmin window = new PanelMenuAdmin();
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
	public PanelMenuAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_17778785980100");
		panel.setLayout(null);
		
		JButton btnTestNoticias = new JButton("Test de noticias");
		btnTestNoticias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionNoticias gn = new GestionNoticias ();
				
				gn.iniciarNoticias();
				
				
			}
		});
		btnTestNoticias.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		btnTestNoticias.setBounds(114, 116, 191, 36);
		panel.add(btnTestNoticias);
		
		JButton btnGestionUsuarios = new JButton("Gestión de usuarios");
		btnGestionUsuarios.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		btnGestionUsuarios.setBounds(114, 69, 191, 36);
		panel.add(btnGestionUsuarios);
		
		JLabel lblNewLabel = new JLabel("Menu Administrador");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(136, 35, 151, 23);
		panel.add(lblNewLabel);
	}
}
