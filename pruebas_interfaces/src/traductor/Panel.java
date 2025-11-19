package traductor;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Panel extends JFrame{
	private JTextField palabraATrad;
	private JTextField palabraYaTrad;
	private JLabel texto1;
	private JLabel texto2;
	private JButton botoncito;
	
	public Panel() {
		
		setSize(new Dimension(500,500));
		getContentPane().setLayout(null);
		
		texto1 = new JLabel("Palabra a traducir:");
		texto1.setFont(new Font("Ubuntu Mono", Font.BOLD, 16));
		texto1.setHorizontalAlignment(SwingConstants.CENTER);
		texto1.setBounds(56, 107, 183, 54);
		getContentPane().add(texto1);
		
		texto2 = new JLabel("Palabra traducida:");
		texto2.setHorizontalAlignment(SwingConstants.CENTER);
		texto2.setFont(new Font("Ubuntu Mono", Font.BOLD, 16));
		texto2.setBounds(68, 290, 171, 54);
		getContentPane().add(texto2);
		
		palabraATrad = new JTextField();
		palabraATrad.setBounds(249, 117, 183, 39);
		getContentPane().add(palabraATrad);
		palabraATrad.setColumns(10);
		
		palabraYaTrad = new JTextField();
		palabraYaTrad.setBounds(249, 300, 183, 39);
		getContentPane().add(palabraYaTrad);
		palabraYaTrad.setColumns(10);
		
		botoncito = new JButton("Traducir");
		botoncito.setFont(new Font("Ubuntu Mono", Font.ITALIC, 18));
		botoncito.setBounds(182, 209, 132, 39);
		getContentPane().add(botoncito);
		
	}
}
