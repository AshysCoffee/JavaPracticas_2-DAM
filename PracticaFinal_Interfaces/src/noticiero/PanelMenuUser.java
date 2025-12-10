package noticiero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class PanelMenuUser {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelMenuUser window = new PanelMenuUser();
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
	public PanelMenuUser() {
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
		frame.getContentPane().add(panel, "name_20271549412400");
		panel.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(29, 37, 92, 20);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1.setBounds(29, 59, 92, 20);
		panel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
		chckbxNewCheckBox_2.setBounds(29, 81, 92, 20);
		panel.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("New check box");
		chckbxNewCheckBox_3.setBounds(29, 120, 92, 20);
		panel.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1_1.setBounds(29, 142, 92, 20);
		panel.add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_2_1.setBounds(29, 164, 92, 20);
		panel.add(chckbxNewCheckBox_2_1);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("New check box");
		chckbxNewCheckBox_4.setBounds(151, 37, 92, 20);
		panel.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("New check box");
		chckbxNewCheckBox_1_2.setBounds(151, 59, 92, 20);
		panel.add(chckbxNewCheckBox_1_2);
		
		JCheckBox chckbxNewCheckBox_2_2 = new JCheckBox("New check box");
		chckbxNewCheckBox_2_2.setBounds(151, 81, 92, 20);
		panel.add(chckbxNewCheckBox_2_2);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("New check box");
		chckbxNewCheckBox_5.setBounds(151, 120, 92, 20);
		panel.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_1_3 = new JCheckBox("New check box");
		chckbxNewCheckBox_1_3.setBounds(151, 142, 92, 20);
		panel.add(chckbxNewCheckBox_1_3);
		
		JCheckBox chckbxNewCheckBox_2_3 = new JCheckBox("New check box");
		chckbxNewCheckBox_2_3.setBounds(151, 164, 92, 20);
		panel.add(chckbxNewCheckBox_2_3);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("New check box");
		chckbxNewCheckBox_6.setBounds(277, 37, 92, 20);
		panel.add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_1_4 = new JCheckBox("New check box");
		chckbxNewCheckBox_1_4.setBounds(277, 59, 92, 20);
		panel.add(chckbxNewCheckBox_1_4);
		
		JCheckBox chckbxNewCheckBox_2_4 = new JCheckBox("New check box");
		chckbxNewCheckBox_2_4.setBounds(277, 81, 92, 20);
		panel.add(chckbxNewCheckBox_2_4);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("New check box");
		chckbxNewCheckBox_7.setBounds(277, 120, 92, 20);
		panel.add(chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_1_5 = new JCheckBox("New check box");
		chckbxNewCheckBox_1_5.setBounds(277, 142, 92, 20);
		panel.add(chckbxNewCheckBox_1_5);
		
		JCheckBox chckbxNewCheckBox_2_5 = new JCheckBox("New check box");
		chckbxNewCheckBox_2_5.setBounds(277, 164, 92, 20);
		panel.add(chckbxNewCheckBox_2_5);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "name_20275617027200");
	}
}
