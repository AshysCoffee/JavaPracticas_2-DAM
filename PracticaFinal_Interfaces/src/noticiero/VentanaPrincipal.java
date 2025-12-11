package noticiero;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame{
	
	public VentanaPrincipal() {
		setTitle("NOTICIERO MAPACHE");
		setSize(800,800);
		setResizable(true);
		setLocationRelativeTo(null);
		
		PanelLogin login = new PanelLogin();
		PanelMenuAdmin menuAdmin = new PanelMenuAdmin();
		PanelCarga carga = new PanelCarga(login);
		
		PanelPreferencias menuUser = new PanelPreferencias();
		
		add(login);
		add(menuAdmin);
		add(carga);
		add(menuUser);
		
	}
	
}