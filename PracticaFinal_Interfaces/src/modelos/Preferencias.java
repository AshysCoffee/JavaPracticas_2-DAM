package modelos;

import javax.swing.JCheckBox;

public class Preferencias {

	private JCheckBox [] listaPreferencias;
	private Usuario u;
	private String preferenciasString;
	
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
	
	
	public String getPreferenciasString() {
		return preferenciasString;
	}


	public void setPreferenciasString(String preferenciasString) {
		this.preferenciasString = preferenciasString;
	}


	public String checkTOString() {

		String s = "";
		
		for (JCheckBox checkBox : listaPreferencias) {
			if (checkBox.isSelected()) {
				s += ('1');
			} else {
				s +=('0');
			}
		}
		preferenciasString = s;
		
		return s;
	}
	
	public void stringTOcheck() {
		if (preferenciasString != null && preferenciasString.length() == listaPreferencias.length) {
			for (int i = 0; i < preferenciasString.length(); i++) {
				char c = preferenciasString.charAt(i);
				if (c == '1') {
					listaPreferencias[i].setSelected(true);
				} else {
					listaPreferencias[i].setSelected(false);
				}
			}
		}
	}
	
	public String toString() {
		
		return "=="+u.getUsuario()+"=="+checkTOString();
		
	}

	
	
}
