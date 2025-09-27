package ejercicio_UML;

import java.time.LocalDate;

public class Robot_Repartidor extends Veh_Inteligente{
	
	private String tipoCarga;
	private	double capacidad_Litros;
	private	String zona_Operacion; 
	private	boolean resistenteAgua; 
	private	int numeroRuedas;
	
	
	public Robot_Repartidor(int id, String modela, double bateriasNivel, boolean sensoresActivos,
			LocalDate fechaActivacion, String tipoCarga, double capacidad_Litros, String zona_Operacion,
			boolean resistenteAgua, int numeroRuedas) {
		super(id, modela, bateriasNivel, sensoresActivos, fechaActivacion);
		this.tipoCarga = tipoCarga;
		this.capacidad_Litros = capacidad_Litros;
		this.zona_Operacion = zona_Operacion;
		this.resistenteAgua = resistenteAgua;
		this.numeroRuedas = numeroRuedas;
	}


	public String getTipoCarga() {
		return tipoCarga;
	}


	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}


	public double getCapacidad_Litros() {
		return capacidad_Litros;
	}


	public void setCapacidad_Litros(double capacidad_Litros) {
		this.capacidad_Litros = capacidad_Litros;
	}


	public String getZona_Operacion() {
		return zona_Operacion;
	}


	public void setZona_Operacion(String zona_Operacion) {
		this.zona_Operacion = zona_Operacion;
	}


	public boolean isResistenteAgua() {
		return resistenteAgua;
	}


	public void setResistenteAgua(boolean resistenteAgua) {
		this.resistenteAgua = resistenteAgua;
	}


	public int getNumeroRuedas() {
		return numeroRuedas;
	}


	public void setNumeroRuedas(int numeroRuedas) {
		this.numeroRuedas = numeroRuedas;
	}

	
	public void iniciar_Reparto () {
		
	}

	@Override
	public String toString() {
		return super.toString()+"Robot_Repartidor [tipoCarga=" + tipoCarga + ", capacidad_Litros=" + capacidad_Litros
				+ ", zona_Operacion=" + zona_Operacion + ", resistenteAgua=" + resistenteAgua + ", numeroRuedas="
				+ numeroRuedas + "]";
	}

	
	
	

}
