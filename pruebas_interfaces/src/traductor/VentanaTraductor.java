package traductor;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class VentanaTraductor extends JFrame{

	//Al ser la clase padre necesita constructores, y si quieres ponerle metodos sobreescritos
	//O poner this.algo y asi podemos modificarlos, pero si lo hacemos simplemente es que lo vamos
	//Vamos hacer de nuestra manera. :-)
	
	public VentanaTraductor() {
		setTitle("TRADUCTOR INGLES-ESPAÑOL");
		setSize(800,800);
		setResizable(true);
		setLocationRelativeTo(null);
		
		Panel miPanel = new Panel();
		
		add(miPanel);
		
	}
	
}
