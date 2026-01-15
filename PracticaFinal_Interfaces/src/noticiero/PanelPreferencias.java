package noticiero;

import javax.swing.JPanel;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import gestiones.GestionEmail;
import gestiones.GestionNoticias;
import gestiones.GestionPreferencias;
import gestiones.GestionUsuarios;
import modelos.Usuario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PanelPreferencias extends JPanel {

	JCheckBox[] listaPreferencias = new JCheckBox[18];
	private VentanaPrincipal v;
	private GestionUsuarios gu;
	private GestionNoticias gn;
	private GestionEmail ge;
	private GestionPreferencias gp;

	public PanelPreferencias(VentanaPrincipal ventanaPrincipal, GestionUsuarios gu, GestionNoticias gn,
			GestionPreferencias gp) {

		this.gp = gp;
		this.gn = gn;
		this.gu = gu;
		this.v = ventanaPrincipal;

		setLayout(null);
		setSize(650, 500);

		JCheckBox economia1 = new JCheckBox("El País");
		economia1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		economia1.setBounds(57, 109, 97, 23);
		add(economia1);
		listaPreferencias[0] = economia1;

		JCheckBox economia2 = new JCheckBox("El Mundo");
		economia2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		economia2.setBounds(57, 134, 97, 23);
		add(economia2);
		listaPreferencias[1] = economia2;

		JCheckBox economia3 = new JCheckBox("El Español");
		economia3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		economia3.setBounds(57, 159, 97, 23);
		add(economia3);
		listaPreferencias[2] = economia3;

		JCheckBox deporte1 = new JCheckBox("El País");
		deporte1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		deporte1.setBounds(57, 314, 97, 23);
		add(deporte1);
		listaPreferencias[3] = deporte1;

		JCheckBox deporte2 = new JCheckBox("El Mundo");
		deporte2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		deporte2.setBounds(57, 341, 97, 23);
		add(deporte2);
		listaPreferencias[4] = deporte2;

		JCheckBox deporte3 = new JCheckBox("El Español");
		deporte3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		deporte3.setBounds(57, 368, 97, 23);
		add(deporte3);
		listaPreferencias[5] = deporte3;

		JCheckBox nacional1 = new JCheckBox("El País");
		nacional1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		nacional1.setBounds(258, 109, 97, 23);
		add(nacional1);
		listaPreferencias[6] = nacional1;

		JCheckBox nacional2 = new JCheckBox("El Mundo");
		nacional2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		nacional2.setBounds(258, 134, 97, 23);
		add(nacional2);
		listaPreferencias[7] = nacional2;

		JCheckBox nacional3 = new JCheckBox("RTVE España");
		nacional3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		nacional3.setBounds(258, 159, 117, 23);
		add(nacional3);
		listaPreferencias[8] = nacional3;

		JCheckBox internacional1 = new JCheckBox("BBC Mundo");
		internacional1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		internacional1.setBounds(258, 314, 117, 23);
		add(internacional1);
		listaPreferencias[9] = internacional1;

		JCheckBox internacional2 = new JCheckBox("EuropaPress");
		internacional2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		internacional2.setBounds(258, 341, 117, 23);
		add(internacional2);
		listaPreferencias[10] = internacional2;

		JCheckBox internacional3 = new JCheckBox("El País");
		internacional3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		internacional3.setBounds(258, 368, 97, 23);
		add(internacional3);
		listaPreferencias[11] = internacional3;

		JCheckBox ciencias1 = new JCheckBox("Xataka Ciencia");
		ciencias1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		ciencias1.setBounds(455, 314, 123, 23);
		add(ciencias1);
		listaPreferencias[12] = ciencias1;

		JCheckBox ciencias2 = new JCheckBox("El Mundo");
		ciencias2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		ciencias2.setBounds(455, 341, 97, 23);
		add(ciencias2);
		listaPreferencias[13] = ciencias2;

		JCheckBox ciencias3 = new JCheckBox("La Razón");
		ciencias3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		ciencias3.setBounds(455, 368, 97, 23);
		add(ciencias3);
		listaPreferencias[14] = ciencias3;

		JCheckBox fauna1 = new JCheckBox("El País");
		fauna1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		fauna1.setBounds(455, 109, 97, 23);
		add(fauna1);
		listaPreferencias[15] = fauna1;

		JCheckBox fauna2 = new JCheckBox("El Diario");
		fauna2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		fauna2.setBounds(455, 134, 97, 23);
		add(fauna2);
		listaPreferencias[16] = fauna2;

		JCheckBox fauna3 = new JCheckBox("AnimaNaturalis");
		fauna3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		fauna3.setBounds(455, 159, 145, 23);
		add(fauna3);
		listaPreferencias[17] = fauna3;

//-----------------------------

		JLabel lblEconomia = new JLabel("Economia");
		lblEconomia.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblEconomia.setBounds(71, 78, 68, 22);
		add(lblEconomia);

		JLabel lblDeportes = new JLabel("Deportes");
		lblDeportes.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblDeportes.setBounds(57, 285, 68, 22);
		add(lblDeportes);

		JLabel lblNacional = new JLabel("Nacional");
		lblNacional.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNacional.setBounds(258, 78, 68, 22);
		add(lblNacional);

		JLabel lblInteracional = new JLabel("Internacional");
		lblInteracional.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblInteracional.setBounds(258, 285, 117, 22);
		add(lblInteracional);

		JLabel lblCiencias = new JLabel("Ciencias");
		lblCiencias.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblCiencias.setBounds(455, 285, 68, 22);
		add(lblCiencias);

		JLabel lblFauna = new JLabel("Fauna");
		lblFauna.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblFauna.setBounds(455, 79, 68, 22);
		add(lblFauna);

		JLabel titulo = new JLabel("Configura tus preferencias");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(113, 28, 420, 43);
		add(titulo);

		JButton btnNewButton = new JButton("Guardar preferencias");
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validarSeleccion()) {

					Usuario u = v.getUsuarioLogueado();

					if (u != null) {
						boolean guardado = gp.guardarPreferencias(listaPreferencias, u);

						if (guardado) {
							JOptionPane.showMessageDialog(null, "¡Preferencias guardadas con éxito!");
							v.cambiarPantalla("MENU_USUARIO");
						} else {
							JOptionPane.showMessageDialog(null, "Error al guardar en el fichero.");
						}
					}
				}
			}
		});
	
		btnNewButton.setBounds(229, 432, 226, 27);
		add(btnNewButton);

		JButton atras = new JButton("Atrás");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarPantalla("LOGIN");
			}
		});
		atras.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		atras.setBounds(23, 430, 131, 31);
		add(atras);

		JButton salir = new JButton("Salir");
		salir.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		salir.setBounds(508, 433, 116, 25);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(salir);

	}

	public boolean validarSeleccion() {
		for (int i = 0; i < listaPreferencias.length; i += 3) {
			
			boolean hayAlgunoMarcadoEnEstaSeccion = false;

			if (listaPreferencias[i].isSelected() || listaPreferencias[i + 1].isSelected()
					|| listaPreferencias[i + 2].isSelected()) {
				hayAlgunoMarcadoEnEstaSeccion = true;
			}

			if (!hayAlgunoMarcadoEnEstaSeccion) {
				String nombreSeccion = "";
				if (i == 0)
					nombreSeccion = "Economía";
				else if (i == 3)
					nombreSeccion = "Deportes";
				else if (i == 6)
					nombreSeccion = "Nacional";
				else if (i == 9)
					nombreSeccion = "Internacional";
				else if (i == 12)
					nombreSeccion = "Ciencias";
				else if (i == 15)
					nombreSeccion = "Fauna";

				JOptionPane.showMessageDialog(this,
						"Debes seleccionar al menos un periódico de " + nombreSeccion, "Faltan preferencias",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		return true;
	}
}
