package noticiero;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gestiones.GestionEmail;
import gestiones.GestionNoticias;
import gestiones.GestionPreferencias;
import gestiones.GestionUsuarios;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	private static JPanel panelContenedor;
	private static CardLayout cardLayout;
	private GestionUsuarios gu;
	private GestionNoticias gn;
	private GestionEmail ge;
	private GestionPreferencias gp;

	public VentanaPrincipal(GestionUsuarios gu, GestionNoticias gn, GestionEmail ge, GestionPreferencias gp) {
		
		this.gu = gu;
		this.gn = gn;
		this.ge = ge;
		this.gn = gn;
		
		gu.cargarUsuarios();
		gn.cargarFuentes();
		
		setTitle("NOTICIERO MAPACHE");
		setSize(650, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(cardLayout);
		setIconImage(Toolkit.getDefaultToolkit().getImage("ui/raccoon_icons.jpg"));
		
		cardLayout = new CardLayout();
		panelContenedor = new JPanel(cardLayout);
		setContentPane(panelContenedor);

		PanelCarga carga = new PanelCarga(this);
		PanelGestionAdmin gestionAdmin = new PanelGestionAdmin(this, gu);
		PanelLogin login = new PanelLogin(this, gu);
		PanelMenuAdmin menuAdmin = new PanelMenuAdmin(this, gu, gn, ge);
		PanelMenuUsuario menuUser = new PanelMenuUsuario(this, gn, gp);
		PanelPreferencias preferencias = new PanelPreferencias(this, gu, gn, gp);
		

		panelContenedor.add(carga, "CARGA");
		panelContenedor.add(login, "LOGIN");
		panelContenedor.add(menuAdmin, "MENU_ADMIN");
		panelContenedor.add(preferencias, "CONFIG_USUARIO");
		panelContenedor.add(gestionAdmin, "GESTION_ADMIN");
		panelContenedor.add(menuUser, "MENU_USUARIO");

		cardLayout.show(panelContenedor, "CARGA");
		
	}

	public void cambiarPantalla(String nombrePantalla) {
		cardLayout.show(panelContenedor, nombrePantalla);
	}

}