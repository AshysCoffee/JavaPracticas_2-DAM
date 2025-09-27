 package ejercicio_UML;

import java.time.LocalDate;

public class Veh_Inteligente {
	
	private int id;
	private String modela;
	private	double bateriasNivel;
	private	boolean sensoresActivos;
	private	LocalDate fechaActivacion;
	
	
	public Veh_Inteligente(int id, String modela, double bateriasNivel, boolean sensoresActivos,
			LocalDate fechaActivacion) {
		super();
		this.id = id;
		this.modela = modela;
		this.bateriasNivel = bateriasNivel;
		this.sensoresActivos = sensoresActivos;
		this.fechaActivacion = fechaActivacion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModela() {
		return modela;
	}
	public void setModela(String modela) {
		this.modela = modela;
	}
	public double getBateriasNivel() {
		return bateriasNivel;
	}
	public void setBateriasNivel(double bateriasNivel) {
		this.bateriasNivel = bateriasNivel;
	}
	public boolean isSensoresActivos() {
		return sensoresActivos;
	}
	public void setSensoresActivos(boolean sensoresActivos) {
		this.sensoresActivos = sensoresActivos;
	}
	public LocalDate getFechaActivacion() {
		return fechaActivacion;
	}
	public void setFechaActivacion(LocalDate fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	@Override
	public String toString() {
		return "ID = " + id + "\nModelo =" + modela + "\nNivel de baterias=" + bateriasNivel
				+ "\nSensores activos=" + sensoresActivos + "\nFecha de activación=" + fechaActivacion + "]";
	}

	
	

}
