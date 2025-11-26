package modelosBases;

import java.time.LocalDate;

public class Cambio {

	private int id_cambio;
    private int id_empleado;        
    private int jugueteOriginal;  
    private int jugueteNuevo;     
    private String motivo;
    private LocalDate fecha;
    
    private int standOrigen;        
    private int zonaOrigen;          
    private int standDestino;       
    private int zonaDestino;
	
    
    public Cambio(int id_cambio, String motivo, LocalDate fecha, int id_empleado, int jugueteOriginal, int jugueteNuevo,  
			int standOrigen, int zonaOrigen, int standDestino, int zonaDestino) {
		super();
		this.id_cambio = id_cambio;
		this.id_empleado = id_empleado;
		this.jugueteOriginal = jugueteOriginal;
		this.jugueteNuevo = jugueteNuevo;
		this.motivo = motivo;
		this.fecha = fecha;
		this.standOrigen = standOrigen;
		this.zonaOrigen = zonaOrigen;
		this.standDestino = standDestino;
		this.zonaDestino = zonaDestino;
	}


	public int getId_cambio() {
		return id_cambio;
	}


	public void setId_cambio(int id_cambio) {
		this.id_cambio = id_cambio;
	}


	public int getId_empleado() {
		return id_empleado;
	}


	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}


	public int getJugueteOriginal() {
		return jugueteOriginal;
	}


	public void setJugueteOriginal(int jugueteOriginal) {
		this.jugueteOriginal = jugueteOriginal;
	}


	public int getJugueteNuevo() {
		return jugueteNuevo;
	}


	public void setJugueteNuevo(int jugueteNuevo) {
		this.jugueteNuevo = jugueteNuevo;
	}


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public int getStandOrigen() {
		return standOrigen;
	}


	public void setStandOrigen(int standOrigen) {
		this.standOrigen = standOrigen;
	}


	public int getZonaOrigen() {
		return zonaOrigen;
	}


	public void setZonaOrigen(int zonaOrigen) {
		this.zonaOrigen = zonaOrigen;
	}


	public int getStandDestino() {
		return standDestino;
	}


	public void setStandDestino(int standDestino) {
		this.standDestino = standDestino;
	}


	public int getZonaDestino() {
		return zonaDestino;
	}


	public void setZonaDestino(int zonaDestino) {
		this.zonaDestino = zonaDestino;
	}


	@Override
	public String toString() {
		return "Cambio [id_cambio=" + id_cambio + ", id_empleado=" + id_empleado + ", jugueteOriginal="
				+ jugueteOriginal + ", jugueteNuevo=" + jugueteNuevo + ", motivo=" + motivo + ", fecha=" + fecha
				+ ", standOrigen=" + standOrigen + ", zonaOrigen=" + zonaOrigen + ", standDestino=" + standDestino
				+ ", zonaDestino=" + zonaDestino + "]";
	}     
    
   
    
	
}
