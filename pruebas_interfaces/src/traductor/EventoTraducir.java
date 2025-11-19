package traductor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EventoTraducir implements ActionListener {

	JTextField entrada_p, salida_p;
	

	public EventoTraducir(JTextField entrada, JTextField salida) {
		super();
		this.entrada_p = entrada;
		this.salida_p = salida;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		//1. Control errores -- Es solo esto para ponerlo hipermegaultrasimple xd lol
		if (entrada_p.getText().isBlank()!=true) {
			salida_p.setText(Operaciones.traducir(entrada_p.getText()));
			
			PanelJ.palabraYaTrad.setVisible(true);
			PanelJ.palabraATrad.setVisible(true);
			PanelJ.salida.setVisible(true);
			
		}else {
			JOptionPane.showMessageDialog(null,"No se ha introducido los datos pedidos");		}
		
		}

}
