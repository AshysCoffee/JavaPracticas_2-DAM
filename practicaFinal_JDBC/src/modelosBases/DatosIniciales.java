package modelosBases;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import queriesJDBC.GestionCambios;
import queriesJDBC.GestionEmpleados;
import queriesJDBC.GestionJuguetes;
import queriesJDBC.GestionStands;
import queriesJDBC.GestionStocks;
import queriesJDBC.GestionVentas;
import queriesJDBC.GestionZonas;

public class DatosIniciales {

	private Connection conn;
	private GestionEmpleados ge;
	private GestionZonas gz;
	private GestionStands gs;
	private GestionJuguetes gj;
	private GestionStocks gstock;
	private GestionVentas gv;
	private GestionCambios gc;

	public DatosIniciales(Connection conn) {
		this.conn = conn;
		ge = new GestionEmpleados(conn);
		gz = new GestionZonas(conn);
		gs = new GestionStands(conn);
		gj = new GestionJuguetes(conn);
		gstock = new GestionStocks(conn);
		gv = new GestionVentas(conn);
		gc = new GestionCambios(conn);
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public boolean baseDeDatosVacia() {

		boolean empleadosVacio = ge.listarEmpleados().isEmpty();
		boolean juguetesVacio = gj.listarJuguetes().isEmpty();
		boolean zonasVacio = gz.listarZonas().isEmpty();
		boolean standsVacio = gs.listarStands().isEmpty();

		// Si todas las tablas base están vacías → BBDD vacía
		return empleadosVacio && juguetesVacio && zonasVacio && standsVacio;
	}

	public void cargarTodo() {
		if (baseDeDatosVacia()) {
			System.out.println("La base de datos está vacía. Cargando datos de ejemplo...");
			cargarDatosEjemplo();
		} else {
			System.out.println("La base de datos ya contiene datos.");
		}
	}

	public void cargarDatosEjemplo() {

		try {

			// ------------------ Empleados ------------------
			ge.insertarEmpleado(new Empleado("Ana", Cargo.CAJERO, LocalDate.of(2023, 1, 10)));
			ge.insertarEmpleado(new Empleado("Luis", Cargo.JEFE, LocalDate.of(2022, 5, 20)));
			ge.insertarEmpleado(new Empleado("María", Cargo.CAJERO, LocalDate.of(2024, 3, 14)));
			ge.insertarEmpleado(new Empleado("Carlos", Cargo.JEFE, LocalDate.of(2023, 8, 5)));
			ge.insertarEmpleado(new Empleado("Elena", Cargo.CAJERO, LocalDate.of(2022, 11, 2)));
			ge.insertarEmpleado(new Empleado("Raúl", Cargo.JEFE, LocalDate.of(2021, 6, 30)));

			// ------------------ Zonas ------------------
			gz.agregarZona(new Zona("Zona Infantil", "Juguetes de 0 a 5 años"));
			gz.agregarZona(new Zona("Zona Escolar", "Juguetes educativos y escolares"));
			gz.agregarZona(new Zona("Zona Deportiva", "Juguetes deportivos"));
			gz.agregarZona(new Zona("Zona Electrónica", "Juguetes interactivos"));
			gz.agregarZona(new Zona("Zona Bebés", "Artículos para bebés"));

			// ------------------ Stands ------------------
			gs.insertarStand(new Stand("Stand 1", "Stand principal", 1));
			gs.insertarStand(new Stand("Stand 2", "Stand lateral", 2));
			gs.insertarStand(new Stand("Stand 3", "Stand central", 3));
			gs.insertarStand(new Stand("Stand 4", "Stand deportivo", 4));
			gs.insertarStand(new Stand("Stand 5", "Stand electrónico", 5));

			// ------------------ Juguetes ------------------
			gj.insertarJuguete(new Juguete("Muñeca", "Muñeca de trapo", 15.5, 10, "Muñecas")); // ID 1
			gj.insertarJuguete(new Juguete("Puzzle", "Puzzle de 100 piezas", 12.0, 5, "Puzzles")); // ID 2
			gj.insertarJuguete(new Juguete("Pelota", "Pelota de fútbol", 8.0, 7, "Deportes")); // ID 3
			gj.insertarJuguete(new Juguete("Camión", "Camión de juguete metálico", 18.0, 12, "Vehículos")); // ID 4
			gj.insertarJuguete(new Juguete("Robot", "Robot interactivo con luces", 35.0, 8, "Electrónicos")); // ID 5
			gj.insertarJuguete(new Juguete("Bloques", "Caja de bloques de construcción", 22.0, 6, "Construcción")); // ID
																													// 6
			gj.insertarJuguete(new Juguete("Coche RC", "Coche teledirigido", 45.0, 4, "Vehículos")); // ID 7
			gj.insertarJuguete(new Juguete("Peluche Oso", "Oso de peluche grande", 25.0, 7, "Peluches")); // ID 8

			// ------------------ Stock ------------------
			gstock.insertarStock(new Stock(1, 1, 1, 5)); // Muñeca en Stand 1
			gstock.insertarStock(new Stock(2, 2, 2, 3)); // Puzzle en Stand 2
			gstock.insertarStock(new Stock(1, 1, 3, 7)); // Pelota en Stand 1
			gstock.insertarStock(new Stock(3, 3, 4, 4)); // Camión en Stand 3
			gstock.insertarStock(new Stock(4, 4, 5, 3)); // Robot en Stand 4
			gstock.insertarStock(new Stock(5, 5, 6, 6)); // Bloques en Stand 5
			gstock.insertarStock(new Stock(1, 1, 7, 2)); // Coche RC en Stand 1
			gstock.insertarStock(new Stock(2, 2, 8, 5)); // Peluche en Stand 2

			// ------------------ Ventas ------------------
			// Ahora los Stands y Zonas coinciden con donde pusimos el Stock arriba

			gv.registrarVenta(new Venta(TipoPago.PAYPAL, 15.5, 1, 1, 1, 1, 1, "Cliente Casual"));
			gv.registrarVenta(new Venta(TipoPago.TARJETA, 12.0, 2, 2, 2, 2, 1, null));
			gv.registrarVenta(new Venta(TipoPago.EFECTIVO, 18.0, 3, 4, 3, 3, 2, "Juan Perez"));
			gv.registrarVenta(new Venta(TipoPago.TARJETA, 35.0, 4, 5, 4, 4, 1, "Maria Lopez"));
			gv.registrarVenta(new Venta(TipoPago.PAYPAL, 22.0, 5, 6, 5, 5, 3, "Construcciones SA"));
			gv.registrarVenta(new Venta(TipoPago.EFECTIVO, 45.0, 6, 7, 1, 1, 1, null));
			gv.registrarVenta(new Venta(TipoPago.PAYPAL, 25.0, 1, 8, 2, 2, 2, "Lucia Garcia"));
			gv.registrarVenta(new Venta(TipoPago.EFECTIVO, 15.5, 2, 1, 1, 1, 1, "Cliente Casual"));
			gv.registrarVenta(new Venta(TipoPago.TARJETA, 12.0, 3, 2, 2, 2, 4, "Pedro Rodriguez"));

			actualizarStockDespuesDeVentas();

			// ------------------ Cambios ------------------

			gc.insertarCambio(new Cambio("Intercambio por defecto", 2, 2, 1, 2, 2, 1, 1));
			gc.insertarCambio(new Cambio("Cambio por defecto", 2, 7, 4, 1, 1, 3, 3));
			gc.insertarCambio(new Cambio("Cliente prefiere otro modelo", 3, 3, 4, 1, 1, 3, 3));
			gc.insertarCambio(new Cambio("Cambio por color diferente", 1, 6, 8, 5, 5, 2, 2));

			System.out.println("Todos los datos de ejemplo cargados correctamente.");
		} catch (Exception e) {
			System.out.println("Hubo un error " + e.getMessage());
			;
		}
	}

	private void actualizarStockDespuesDeVentas() {
		try {
			List<Venta> ventas = gv.todasVentas();
			for (Venta v : ventas) {
				Stock s = gstock.obtenerStockdelStand(v.getId_stand(), v.getId_zona(), v.getId_juguete());
				gstock.actualizarStock(v.getId_stand(), v.getId_zona(), v.getId_juguete(),
						s.getCantidad_disponible() - 1);
			}
		} catch (Exception e) {
			System.out.println("Hubo un error " + e.getMessage());
			;
		}
	}

}
