package modelosBases;

import java.time.LocalDate;

public class Venta {

	private int id_venta;
	private int id_empleado;
	private int id_juguete;
	private int id_stand;
	private int id_zona;
	private TipoPago tipoPago;
	private LocalDate fecha;
	private double importe;


	public Venta(int id_venta,LocalDate fecha, TipoPago tipoPago,double importe, int id_empleado, int id_juguete, int id_stand, int id_zona
			 ) {

		this.id_venta = id_venta;
		this.id_empleado = id_empleado;
		this.id_juguete = id_juguete;
		this.id_stand = id_stand;
		this.id_zona = id_zona;
		this.tipoPago = tipoPago;
		this.fecha = LocalDate.now();
		this.importe = importe;
	}

	public Venta(TipoPago tipoPago,double importe, int id_empleado, int id_juguete, int id_stand, int id_zona) {
		super();
		this.id_empleado = id_empleado;
		this.id_juguete = id_juguete;
		this.id_stand = id_stand;
		this.id_zona = id_zona;
		this.tipoPago = tipoPago;
		this.fecha = LocalDate.now();
		this.importe = importe;
	}
	
	
	public Venta() {

	}



	public int getId_venta() {
		return id_venta;
	}


	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}


	public int getId_empleado() {
		return id_empleado;
	}


	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}


	public int getId_juguete() {
		return id_juguete;
	}


	public void setId_juguete(int id_juguete) {
		this.id_juguete = id_juguete;
	}


	public int getId_stand() {
		return id_stand;
	}


	public void setId_stand(int id_stand) {
		this.id_stand = id_stand;
	}


	public int getId_zona() {
		return id_zona;
	}


	public void setId_zona(int id_zona) {
		this.id_zona = id_zona;
	}


	public TipoPago getTipoPago() {
		return tipoPago;
	}


	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public double getImporte() {
		return importe;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}


	@Override
	public String toString() {
		return "Venta " + id_venta + ", ID Empleado: " + id_empleado + ", ID Juguete: " + id_juguete
				+ ", ID Stand:" + id_stand + ", ID_Zona:" + id_zona + ", Pago: " + tipoPago + ", Fecha:" + fecha
				+ ", Importe:" + importe;
	}


	
	
	
}
