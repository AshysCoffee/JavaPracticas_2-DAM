package modelos;

import java.util.ArrayList;
import java.util.List;

public class Preferencias {

	private List<Fuentes> categoriasElegidas;

	public Preferencias() {
		
		this.categoriasElegidas = new ArrayList<>();
		
	}

	public List<Fuentes> getCategoriasElegidas() {
		return categoriasElegidas;
	}

	public void setCategoriasElegidas(List<Fuentes> categoriasElegidas) {
		this.categoriasElegidas = categoriasElegidas;
	}
	
	
	public boolean guardarPreferencias(List<Fuentes>pref, Usuario u) {
		
		
		return false;
	}
	
}
