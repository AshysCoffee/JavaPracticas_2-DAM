package noticiero;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	
	public VentanaPrincipal() {
		setTitle("NOTICIERO MAPACHE");
		setSize(800,800);
		setResizable(true);
		setLocationRelativeTo(null);
		
		PanelLogin login = new PanelLogin();
		PanelMenuAdmin menuAdmin = new PanelMenuAdmin();
		PanelCarga carga = new PanelCarga();
		PanelMenuUsuario menuUser = new PanelMenuUsuario();
		
		add(login);
		
	}
	
}