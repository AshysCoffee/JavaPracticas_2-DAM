package traductor;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelJ extends JPanel {
    static JTextField palabraATrad;
    static JTextField palabraYaTrad;
    JLabel texto1;
    JLabel texto2;
    JButton botoncito;
    static JButton salida;

    public PanelJ() {
        setPreferredSize(new Dimension(500, 500));
        setLayout(null);

        texto1 = new JLabel("Palabra a traducir:");
        texto1.setFont(new Font("Ubuntu Mono", Font.BOLD, 16));
        texto1.setHorizontalAlignment(SwingConstants.CENTER);
        texto1.setBounds(56, 107, 183, 54);
        add(texto1);

        texto2 = new JLabel("Palabra traducida:");
        texto2.setHorizontalAlignment(SwingConstants.CENTER);
        texto2.setFont(new Font("Ubuntu Mono", Font.BOLD, 16));
        texto2.setBounds(68, 290, 171, 54);
        add(texto2);

        palabraATrad = new JTextField();
        palabraATrad.setBounds(249, 117, 183, 39);
        add(palabraATrad);
        palabraATrad.setColumns(10);

        palabraYaTrad = new JTextField();
        palabraYaTrad.setEditable(false);
        palabraYaTrad.setBounds(249, 300, 183, 39);
        add(palabraYaTrad);
        palabraYaTrad.setColumns(10);

        botoncito = new JButton("Traducir");
        botoncito.setFont(new Font("Ubuntu Mono", Font.ITALIC, 18));
        botoncito.setBounds(182, 209, 132, 39);
        botoncito.addActionListener(new EventoTraducir(palabraATrad, palabraYaTrad));
        add(botoncito);

        salida = new JButton("Salida :3");
        salida.setFont(new Font("Ubuntu Mono", Font.ITALIC, 13));
        salida.setBounds(340, 387, 125, 32);
        salida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(salida);
    }
}
