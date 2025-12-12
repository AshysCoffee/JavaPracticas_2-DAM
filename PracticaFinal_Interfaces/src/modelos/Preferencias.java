package modelos;

import javax.swing.JCheckBox;

public class Preferencias {

	private JCheckBox [] listaPreferencias;
	private Usuario u;
	
	
	public Preferencias(JCheckBox[] listaPreferencias, Usuario u) {
		super();
		this.listaPreferencias = listaPreferencias;
		this.u = u;
	}
	
	
	public JCheckBox[] getListaPreferencias() {
		return listaPreferencias;
	}
	public void setListaPreferencias(JCheckBox[] listaPreferencias) {
		this.listaPreferencias = listaPreferencias;
	}
	public Usuario getU() {
		return u;
	}
	public void setU(Usuario u) {
		this.u = u;
	} 

	
	
}
