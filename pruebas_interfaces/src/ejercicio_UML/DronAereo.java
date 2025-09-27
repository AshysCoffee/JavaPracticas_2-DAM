package ejercicio_UML;

import java.time.LocalDate;

public class DronAereo extends Veh_Inteligente{
	
	private double altitudMaxima;
	private	int numeroHelices;
	private	double pesoCargaMax;
	private	boolean gpsintegrado;
	private	String fabricante;
	
	
	public DronAereo(int id, String modela, double bateriasNivel, boolean sensoresActivos, LocalDate fechaActivacion,
			double altitudMaxima, int numeroHelices, double pesoCargaMax, boolean gpsintegrado, String fabricante) {
		super(id, modela, bateriasNivel, sensoresActivos, fechaActivacion);
		this.altitudMaxima = altitudMaxima;
		this.numeroHelices = numeroHelices;
		this.pesoCargaMax = pesoCargaMax;
		this.gpsintegrado = gpsintegrado;
		this.fabricante = fabricante;
	}


	public double getAltitudMaxima() {
		return altitudMaxima;
	}


	public void setAltitudMaxima(double altitudMaxima) {
		this.altitudMaxima = altitudMaxima;
	}


	public int getNumeroHelices() {
		return numeroHelices;
	}


	public void setNumeroHelices(int numeroHelices) {
		this.numeroHelices = numeroHelices;
	}


	public double getPesoCargaMax() {
		return pesoCargaMax;
	}


	public void setPesoCargaMax(double pesoCargaMax) {
		this.pesoCargaMax = pesoCargaMax;
	}


	public boolean isGpsintegrado() {
		return gpsintegrado;
	}


	public void setGpsintegrado(boolean gpsintegrado) {
		this.gpsintegrado = gpsintegrado;
	}


	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public void despegar() {
		
	}


	@Override
	public String toString() {
		return super.toString()+ "DronAereo [altitudMaxima=" + altitudMaxima + ", numeroHelices=" + numeroHelices + ", pesoCargaMax="
				+ pesoCargaMax + ", gpsintegrado=" + gpsintegrado + ", fabricante=" + fabricante + "]";
	}
	
	
	


}
