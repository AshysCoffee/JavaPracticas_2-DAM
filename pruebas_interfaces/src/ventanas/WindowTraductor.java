package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.SwingConstants;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class WindowTraductor {

	
	//HACER CONTROL DE ERRORES!!!!!!!!!!!!!!!
	//OSEA QUE NO DEJE ENTRAR SOLO ESPACIOS, NUMEROS, SOLO LETRAS Y QUE SI NO LO ENCUENTRA PUES ERROR XD	
	
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowTraductor window = new WindowTraductor();
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
	public WindowTraductor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel enunciado = new JLabel("Introduzca la palabra a traducir:");
		enunciado.setHorizontalTextPosition(SwingConstants.CENTER);
		enunciado.setHorizontalAlignment(SwingConstants.CENTER);
		enunciado.setFont(new Font("Ubuntu Mono", Font.BOLD, 15));
		enunciado.setBounds(32, 32, 360, 41);
		frame.getContentPane().add(enunciado);
		
		textField = new JTextField();
		textField.setBounds(42, 72, 210, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel textoTrudccion = new JLabel("Traducción:");
		textoTrudccion.setHorizontalTextPosition(SwingConstants.CENTER);
		textoTrudccion.setHorizontalAlignment(SwingConstants.CENTER);
		textoTrudccion.setFont(new Font("Ubuntu Mono", Font.BOLD, 15));
		textoTrudccion.setBounds(86, 128, 129, 30);
		frame.getContentPane().add(textoTrudccion);
		
		JLabel resultado = new JLabel("");
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setBounds(42, 164, 210, 30);
		frame.getContentPane().add(resultado);
		
		JLabel errores = new JLabel("");
		errores.setForeground(new Color(255, 0, 0));
		errores.setBounds(245, 128, 161, 80);
		frame.getContentPane().add(errores);
		
		JButton traducir = new JButton("Traducir");
		traducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					
					String palabra_pedida = textField.getText();

						String web_traductor = ("https://www.spanishdict.com/translate/");
						String web = web_traductor + palabra_pedida;
						Document doc = Jsoup.connect(web).get();
						Element palabra = doc.select("div#quickdef1-es a.tCur1iYh").get(0);
						String resul = palabra.html().toUpperCase();
						resultado.setText("Your word is "+resul+" :3");

					

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		traducir.setBounds(283, 75, 89, 23);
		frame.getContentPane().add(traducir);

		JButton salida = new JButton("Saquenme de aqui");
		salida.setBounds(305, 220, 119, 30);
		frame.getContentPane().add(salida);
		salida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); //liberar memoria :3
				System.exit(0);
			}
		});
		
	}
}
