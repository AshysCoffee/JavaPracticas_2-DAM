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

	
	
	public boolean crearVenta(String tipoPago, double importe, int id_empleado, int id_juguete, int cantidad,
			String cliente) {

		int standId = -1;
		int zonaId = -1;

		if (!tipoPago.equalsIgnoreCase("TARJETA") && !tipoPago.equalsIgnoreCase("EFECTIVO")
				&& !tipoPago.equalsIgnoreCase("PAYPAL")) {
			System.out.println("NO existe ese método de pago (Use: EFECTIVO, TARJETA, PAYPAL).");
			return false;
		}

		if (importe < 0) {
			System.out.println("El precio tiene que ser positivo.");
			return false;
		}

		if (cantidad <= 0) {
			System.out.println("La cantidad debe ser mayor a 0.");
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

		List<Stock> standYzona = gs.stockJuguete(id_juguete);

		if (standYzona.isEmpty()) {
			System.out.println("Este juguete no tiene stock asignado a ningún stand.");
			return false;
		}

		Stock stockSeleccionado = null;

		for (Stock s : standYzona) {
			if (s.getCantidad_disponible() >= cantidad) {
				stockSeleccionado = s;
				break;
			}
		}

		if (stockSeleccionado == null) {
			System.out.println("No hay suficiente stock en ningún stand para cubrir la cantidad solicitada.");
			return false;
		}

		standId = stockSeleccionado.getId_stand();
		zonaId = stockSeleccionado.getId_zona();

		Venta v = new Venta(TipoPago.valueOf(tipoPago.toUpperCase()), importe, id_empleado, id_juguete, standId, zonaId,
				cantidad, cliente);

		if (!gv.registrarVenta(v)) {
			System.out.println("Error al registrar la venta en la BD.");
			return false;
		} else {
			int stock_global = gj.obtenerJuguetePorId(id_juguete).getCantidad_stock();
			gj.actualizarStock(id_juguete, stock_global - cantidad);

			gs.actualizarStock(standId, zonaId, id_juguete, stockSeleccionado.getCantidad_disponible() - cantidad);
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
			System.out.println("No hay ventas en ese rango.");
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

	public void ventasPorEmpleadoYMes(int idEmpleado, int m) {

		if (ge.obtenerEmpleadoPorId(idEmpleado) == null) {
			System.out.println("No existe el empleado que busca");
			return;
		}

		if (m < 1 || m > 12) {
			System.out.println("No es valido, tiene que ser entre 1 y 12");
			return;
		}

		List<Venta> ventaEmpleadoMes = gv.ventasEmpleadoEnMes(idEmpleado, m);
		if (ventaEmpleadoMes == null || ventaEmpleadoMes.isEmpty()) {
			System.out.println("No hay juguetes en ese rango.");
		} else {

			for (Venta v : ventaEmpleadoMes) {
				System.out.println(v);
			}

		}

	}
	
	public Venta buscarVentasPorId(int idVenta) {

		if (idVenta <= 0) {
			System.out.println("El ID no puede ser negativo o cero.");
			return null;
		}

		Venta venta = gv.obtenerVentaPorId(idVenta);

		if (venta == null) {
			System.out.println("No existe una venta con ese ID.");
			return null;
		} else {
			System.out.println(venta);
			return venta;
		}

	}

	public void listarVentas() {
		
		List<Venta> listado = gv.todasVentas();

		if (listado == null || listado.isEmpty()) {
			System.out.println("No hay ventas en el inventario.");
			return;
		}

		for (Venta venta : listado) {
			System.out.println(venta);
		}
		
	}

}
