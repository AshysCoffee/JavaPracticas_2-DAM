package ejercicio_UML;

import java.time.LocalDate;

public class Coche_Autonomo extends Veh_Inteligente{

	private int nivelAutonomia;
	private double vel_maxima;
	private int num_Pasajeros;
	private String software_version;
	
	
	public Coche_Autonomo(int id, String modela, double bateriasNivel, boolean sensoresActivos,
			LocalDate fechaActivacion, int nivelAutonomia, double vel_maxima, int num_Pasajeros,
			String software_version) {
		super(id, modela, bateriasNivel, sensoresActivos, fechaActivacion);
		this.nivelAutonomia = nivelAutonomia;
		this.vel_maxima = vel_maxima;
		this.num_Pasajeros = num_Pasajeros;
		this.software_version = software_version;
	}


	public int getNivelAutonomia() {
		return nivelAutonomia;
	}


	public void setNivelAutonomia(int nivelAutonomia) {
		this.nivelAutonomia = nivelAutonomia;
	}


	public double getVel_maxima() {
		return vel_maxima;
	}


	public void setVel_maxima(double vel_maxima) {
		this.vel_maxima = vel_maxima;
	}


	public int getNum_Pasajeros() {
		return num_Pasajeros;
	}


	public void setNum_Pasajeros(int num_Pasajeros) {
		this.num_Pasajeros = num_Pasajeros;
	}


	public String getSoftware_version() {
		return software_version;
	}


	public void setSoftware_version(String software_version) {
		this.software_version = software_version;
	}
	
	
	public void activarModoAutonomo (){
		
	}


	@Override
	public String toString() {
		return super.toString()+"Coche_Autonomo [nivelAutonomia=" + nivelAutonomia + ", vel_maxima=" + vel_maxima + ", num_Pasajeros="
				+ num_Pasajeros + ", software_version=" + software_version + "]";
	}
	
	
	
	
	
}
