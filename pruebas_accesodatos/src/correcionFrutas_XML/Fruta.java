package correcionFrutas_XML;

import java.util.ArrayList;

public class Fruta {

	String nombre, tiempo,color,origen,temporada;
	double precio;
	ArrayList <String> nutrientes;
	
	
	public Fruta(String nombre, String tiempo, String color, String origen, String temporada,
			double precio) {
		super();
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.color = color;
		this.origen = origen;
		this.temporada = temporada;
		this.precio = precio;
		this.nutrientes = null;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String gettiempo() {
		return tiempo;
	}


	public void settiempo(String tiempo) {
		this.tiempo = tiempo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String getTemporada() {
		return temporada;
	}


	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public ArrayList<String> getNutrientes() {
		return nutrientes;
	}


	public void setNutrientes(ArrayList<String> nutrientes) {
		this.nutrientes = nutrientes;
	}


	@Override
	public String toString() {
		return "Fruta\nNombre=" + nombre + "\nTiempo=" + tiempo + "\nColor=" + color + "\nOrigen="
				+ origen + "\nTemporada=" + temporada + "\nPrecio=" + precio + "\nNutrientes=" + nutrientes.toString();
	}
	
	

	
	
}
