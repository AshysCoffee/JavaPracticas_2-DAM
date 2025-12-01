package gestionPrograma;

import java.sql.Connection;
import java.util.List;

import modelosBases.Stock;
import modelosBases.TipoPago;
import modelosBases.Venta;
import queriesJDBC.GestionEmpleados;
import queriesJDBC.GestionJuguetes;
import queriesJDBC.GestionStocks;
import queriesJDBC.GestionVentas;

public class Ventas {

	private Connection conexion;
	private GestionVentas gv;
	private GestionJuguetes gj;
	private GestionEmpleados ge;
	private GestionStocks gs;

	public Ventas(Connection conexion) {
		this.conexion = conexion;
		this.gv = new GestionVentas(conexion);
		this.gj = new GestionJuguetes(conexion);
		this.ge = new GestionEmpleados(conexion);
		this.gs = new GestionStocks(conexion);

		System.out.println("Conexión recibida en Ventas.");
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public boolean crearVenta(String tipoPago, double importe, int id_empleado, int id_juguete) {

		int standId = -1;
		int zonaId = -1;


		if (!tipoPago.equalsIgnoreCase("Tarjeta") && !tipoPago.equalsIgnoreCase("Efectivo")
				&& !tipoPago.equalsIgnoreCase("Paypal")) {

			System.out.println("NO existe ese método de pago, revise su opción.");
			return false;
		}

		if (importe < 0) {
			System.out.println("El precio tiene que ser positivo.");
			return false;
		}

		if (ge.obtenerEmpleadoPorId(id_empleado) == null) {
			System.out.println("No existe el empleado.");
			return false;
		}

		if (gj.obtenerJuguetePorId(id_juguete) == null) {
			System.out.println("No existe el juguete deseado");
			return false;
		}
		
		List<Stock> standYzona = gs.StockJuguete(id_juguete);

		if (standYzona.isEmpty()) {
			System.out.println("Este juguete no tiene stock asignado a ningún stand.");
			return false;
		}

		Stock s = standYzona.get(0);
		standId = s.getId_stand();
		zonaId = s.getId_zona();

		Venta v = new Venta(TipoPago.valueOf(tipoPago), importe, id_empleado, id_juguete, standId, zonaId);

		if (!gv.registrarVenta(v)) {
			System.out.println("Error al registrar la venta.");
			return false;
		} else {
			int stock_actual = gj.obtenerJuguetePorId(id_juguete).getCantidad_stock();
			gj.actualizarStock(id_juguete, stock_actual - 1);
			return true;

		}
	}

	public void ventasPorMes(int mes) {

		if (mes < 1 || mes > 12) {
			System.out.println("No es valido, tiene que ser entre 1 y 12");
			return;
		}

		List<Venta> ventaMes = gv.VentasPorMes(mes);

		if (ventaMes == null || ventaMes.isEmpty()) {
			System.out.println("No hay ventas en ese mes.");
			return;
		} else {

			for (Venta v : ventaMes) {
				System.out.println(v);
			}

		}
	}

	public void ventasPorEmpleado(int id_empleado) {

		GestionEmpleados gj = new GestionEmpleados(conexion);

		if (gj.obtenerEmpleadoPorId(id_empleado) == null) {
			System.out.println("No existe el empleado que busca");
			return;
		}

		List<Venta> ventaEmpleado = gv.VentasPorEmpleado(id_empleado);
		if (ventaEmpleado == null || ventaEmpleado.isEmpty()) {
			System.out.println("No hay juguetes en ese rango.");
		} else {

			for (Venta v : ventaEmpleado) {
				System.out.println(v);
			}

		}

	}

	public void Top5Productos() {

		List<String> top5 = gv.top5JuguetesMasVendidos();

		if (top5 == null || top5.isEmpty()) {
			System.out.println("No hay juguetes en ese rango.");
		} else {

			for (String v : top5) {
				System.out.println(v);
			}

		}

	}

	public void EmpleadoMasProduc() {

		List<String> empleadoTop = gv.empleadosQueMasVenden();

		if (empleadoTop == null || empleadoTop.isEmpty()) {
			System.out.println("No hay juguetes en ese rango.");
		} else {

			for (String v : empleadoTop) {
				System.out.println(v);
			}

		}

	}

}
