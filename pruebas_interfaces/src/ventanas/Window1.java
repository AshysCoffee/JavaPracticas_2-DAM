package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Dimension;

public class Window1 {

	private JFrame frame;
	private JTextField textField_2;
	private JPasswordField pwdContrasea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window1 window = new Window1();
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
	public Window1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel saludito = new JLabel("Hola muchachos esta es mi primera ventana! :D");
		saludito.setBounds(76, 116, 277, 14);
		frame.getContentPane().add(saludito);
		
		JLabel agradecimiento = new JLabel("Espero que os guste!! :3 <3");
		agradecimiento.setBounds(131, 141, 145, 14);
		frame.getContentPane().add(agradecimiento);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Escribeme algo bonito :-)");
		textField_2.setBounds(164, 166, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Furros");
		rdbtnNewRadioButton.setBounds(98, 52, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Femboys");
		rdbtnNewRadioButton_1.setBounds(98, 78, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setRolloverEnabled(false);
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setVerifyInputWhenFocusTarget(false);
		btnNewButton.setMinimumSize(new Dimension(1, 1));
		btnNewButton.setFocusable(false);
		btnNewButton.setToolTipText("");
		btnNewButton.setBounds(309, 213, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		pwdContrasea = new JPasswordField();
		pwdContrasea.setName("");
		pwdContrasea.setBounds(78, 214, 129, 20);
		frame.getContentPane().add(pwdContrasea);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Botoncito tipo\\n interrumptor");
		tglbtnNewToggleButton.setBounds(279, 52, 145, 23);
		frame.getContentPane().add(tglbtnNewToggleButton);
		


	}
}