package noticiero;

import javax.swing.JPanel;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import gestiones.GestionEmail;
import gestiones.GestionNoticias;
import gestiones.GestionUsuarios;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PanelPreferencias extends JPanel{

	JCheckBox [] listaPreferencias = new JCheckBox[18];
	private VentanaPrincipal v;
	private GestionUsuarios gu;
	private GestionNoticias gn;
	private GestionEmail ge;
	
	public PanelPreferencias(VentanaPrincipal ventanaPrincipal, GestionUsuarios gu, GestionNoticias gn) {
		
		this.gn=gn;
		this.gu=gu;
		this.v = ventanaPrincipal;
		
		setLayout(null);
		
		JCheckBox economia1 = new JCheckBox("El País");
		economia1.setBounds(91, 121, 97, 23);
		add(economia1);
		listaPreferencias[0] = economia1;
		
		JCheckBox economia2 = new JCheckBox("El Mundo");
		economia2.setBounds(91, 147, 97, 23);
		add(economia2);
		listaPreferencias[1] = economia2;
		
		JCheckBox economia3 = new JCheckBox("El Español");
		economia3.setBounds(91, 173, 97, 23);
		add(economia3);
		listaPreferencias[2] = economia3;
		
		JCheckBox deporte1 = new JCheckBox("El País");
		deporte1.setBounds(91, 329, 97, 23);
		add(deporte1);
		listaPreferencias[3] = deporte1;
		
		JCheckBox deporte2 = new JCheckBox("El Mundo");
		deporte2.setBounds(91, 356, 97, 23);
		add(deporte2);
		listaPreferencias[4] = deporte2;
		
		JCheckBox deporte3 = new JCheckBox("El Español");
		deporte3.setBounds(91, 383, 97, 23);
		add(deporte3);
		listaPreferencias[5] = deporte3;
		
		JCheckBox nacional1 = new JCheckBox("El País");
		nacional1.setBounds(291, 121, 97, 23);
		add(nacional1);
		listaPreferencias[6] = nacional1;
		
		JCheckBox nacional2 = new JCheckBox("El Mundo");
		nacional2.setBounds(291, 147, 97, 23);
		add(nacional2);
		listaPreferencias[7] = nacional2;
		
		JCheckBox nacional3 = new JCheckBox("RTVE España");
		nacional3.setBounds(291, 173, 97, 23);
		add(nacional3);
		listaPreferencias[8] = nacional3;
		
		JCheckBox internacional1 = new JCheckBox("BBC Mundo");
		internacional1.setBounds(291, 329, 97, 23);
		add(internacional1);
		listaPreferencias[9] = internacional1;
		
		JCheckBox internacional2 = new JCheckBox("EuropaPress");
		internacional2.setBounds(291, 356, 97, 23);
		add(internacional2);
		listaPreferencias[10] = internacional2;
		
		JCheckBox internacional3 = new JCheckBox("El País");
		internacional3.setBounds(291, 383, 97, 23);
		add(internacional3);
		listaPreferencias[11] = internacional3;
		
		JCheckBox ciencias1 = new JCheckBox("Xataka Ciencia");
		ciencias1.setBounds(495, 329, 97, 23);
		add(ciencias1);
		listaPreferencias[12] = ciencias1;
		
		JCheckBox ciencias2 = new JCheckBox("El Mundo");
		ciencias2.setBounds(495, 356, 97, 23);
		add(ciencias2);
		listaPreferencias[13] = ciencias2;
		
		JCheckBox ciencias3 = new JCheckBox("La Razón");
		ciencias3.setBounds(495, 383, 97, 23);
		add(ciencias3);
		listaPreferencias[14] = ciencias3;
		
		JCheckBox fauna1 = new JCheckBox("El País");
		fauna1.setBounds(495, 121, 97, 23);
		add(fauna1);
		listaPreferencias[15] = fauna1;
		
		JCheckBox fauna2 = new JCheckBox("El Diario");
		fauna2.setBounds(495, 147, 97, 23);
		add(fauna2);
		listaPreferencias[16] = fauna2;
		
		JCheckBox fauna3 = new JCheckBox("AnimaNaturalis");
		fauna3.setBounds(495, 173, 97, 23);
		add(fauna3);
		listaPreferencias[17] = fauna3;
		
//-----------------------------
		
		JLabel lblEconomia = new JLabel("Economia");
		lblEconomia.setBounds(48, 92, 68, 22);
		add(lblEconomia);
		
		JLabel lblDeportes = new JLabel("Deportes");
		lblDeportes.setBounds(48, 300, 68, 22);
		add(lblDeportes);
		
		JLabel lblNacional = new JLabel("Nacional");
		lblNacional.setBounds(271, 92, 68, 22);
		add(lblNacional);
		
		JLabel lblInteracional = new JLabel("Internacional");
		lblInteracional.setBounds(271, 300, 68, 22);
		add(lblInteracional);
		
		JLabel lblCiencias = new JLabel("Ciencias");
		lblCiencias.setBounds(478, 300, 68, 22);
		add(lblCiencias);
		
		JLabel lblFauna = new JLabel("Fauna");
		lblFauna.setBounds(478, 92, 68, 22);
		add(lblFauna);
		
		JLabel titulo = new JLabel("Configura tus preferencias");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(113, 28, 420, 43);
		add(titulo);
		
		JButton btnNewButton = new JButton("Guardar preferencias");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnNewButton.setBounds(243, 452, 164, 23);
		add(btnNewButton);
		
		JButton salir = new JButton("Salir");
		salir.setBounds(527, 452, 113, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(salir);
		
	}
}
