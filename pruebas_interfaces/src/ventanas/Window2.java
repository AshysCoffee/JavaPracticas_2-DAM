package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class Window2 {

	private JFrame frame;
	private JTextField textField;
	private int contador=0;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window2 window = new Window2();
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
	public Window2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(new Color(255, 182, 193));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		frame.getContentPane().add(panel, "name_12551002396200");
		panel.setLayout(null);//no hay setup
		
		JButton btnNewButton = new JButton("CLICK++");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador++;
				textField.setText(Integer.toString(contador));
			}
		});
		btnNewButton.setBounds(37, 112, 131, 34);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Campo de texto kawaii :3");
		lblNewLabel.setBounds(207, 96, 131, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(228, 126, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("NEXT :3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.setVisible(false);
				panel_1.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(335, 227, 89, 23);
		panel.add(btnNewButton_1);
		
		panel_1 = new JPanel(); //declararlo fuera porque ta abajo y sino no funciona
		panel_1.setBackground(new Color(255, 215, 0));
		frame.getContentPane().add(panel_1, "name_12551017437800");
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("BACK! :0");
		
		btnNewButton_2.setBounds(10, 227, 89, 23);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);

			}
		});
		
		JButton btnNewButton_3 = new JButton("FINISH!");
		btnNewButton_3.setBounds(335, 227, 89, 23);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_1.setVisible(false);
				panel.setVisible(false);
				panel_2.setVisible(true);
				
			}
		});
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 250));
		frame.getContentPane().add(panel_2, "name_12551031123900");
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("GRACIAS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_1.setBounds(132, 71, 141, 97);
		panel_2.add(lblNewLabel_1);
		
		JButton btnNewButton_4 = new JButton("Inicio <3");
		btnNewButton_4.setActionCommand("Inicio <3");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				
			}
		});
		btnNewButton_4.setBounds(164, 227, 89, 23);
		panel_2.add(btnNewButton_4);
	}
}
