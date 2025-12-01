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
            ge.insertarEmpleado(new Empleado("Ana", Cargo.Cajero, LocalDate.of(2023, 1, 10)));
            ge.insertarEmpleado(new Empleado("Luis", Cargo.Jefe , LocalDate.of(2022, 5, 20)));
            ge.insertarEmpleado(new Empleado("María", Cargo.Cajero, LocalDate.of(2024, 3, 14)));
            ge.insertarEmpleado(new Empleado("Carlos", Cargo.Jefe, LocalDate.of(2023, 8, 5)));
            ge.insertarEmpleado(new Empleado("Elena", Cargo.Cajero, LocalDate.of(2022, 11, 2)));
            ge.insertarEmpleado(new Empleado("Raúl", Cargo.Jefe, LocalDate.of(2021, 6, 30)));


            // ------------------ Zonas ------------------
            gz.agregarZona(new Zona("Zona Infantil", "Juguetes de 0 a 5 años"));
            gz.agregarZona(new Zona("Zona Escolar", "Juguetes educativos y escolares"));
            gz.agregarZona(new Zona("Zona Deportiva", "Juguetes deportivos"));
            gz.agregarZona(new Zona("Zona Electrónica", "Juguetes interactivos"));
            gz.agregarZona(new Zona("Zona Bebés", "Artículos para bebés"));


            // ------------------ Stands ------------------
            gs.insertarStand(new Stand(1,"Stand 1", "Stand principal", 1));
            gs.insertarStand(new Stand(2, "Stand 2", "Stand lateral", 2));
            gs.insertarStand(new Stand(3, "Stand 3", "Stand central", 3));
            gs.insertarStand(new Stand(4, "Stand 4", "Stand deportivo", 4));
            gs.insertarStand(new Stand(5, "Stand 5", "Stand electrónico", 5));


            // ------------------ Juguetes ------------------
            gj.insertarJuguete(new Juguete(1,"Muñeca", "Muñeca de trapo", 15.5, 10));
            gj.insertarJuguete(new Juguete(2,"Puzzle", "Puzzle de 100 piezas", 12.0, 5));
            gj.insertarJuguete(new Juguete(3,"Pelota", "Pelota de fútbol", 8.0, 7));
            gj.insertarJuguete(new Juguete(4,"Camión", "Camión de juguete metálico", 18.0, 12));
            gj.insertarJuguete(new Juguete(5,"Robot", "Robot interactivo con luces", 35.0, 8));
            gj.insertarJuguete(new Juguete(6,"Bloques", "Caja de bloques de construcción", 22.0, 6));
            gj.insertarJuguete(new Juguete(7,"Coche RC", "Coche teledirigido", 45.0, 4));
            gj.insertarJuguete(new Juguete(8,"Peluche Oso", "Oso de peluche grande", 25.0, 7));


            // ------------------ Stock ------------------
            gstock.insertarStock(new Stock(1, 1, 1, 5)); // Muñeca en Stand 1, Zona 1
            gstock.insertarStock(new Stock(2, 2, 2, 3)); // Puzzle en Stand 2, Zona 2
            gstock.insertarStock(new Stock(1, 1, 3, 7)); // Pelota en Stand 1, Zona 1
            gstock.insertarStock(new Stock(11, 1, 4, 4)); // Camión en Stand 11, Zona 1
            gstock.insertarStock(new Stock(12, 2, 5, 3)); // Robot en Stand 12, Zona 2
            gstock.insertarStock(new Stock(13, 3, 6, 6)); // Bloques en Stand 13, Zona 3
            gstock.insertarStock(new Stock(14, 4, 7, 2)); // Coche RC en Stand 14, Zona 4
            gstock.insertarStock(new Stock(15, 5, 8, 5)); // Peluche en Stand 15, Zona 5

            gstock.insertarStock(new Stock(11, 1, 2, 2)); // Puzzle también en Stand 11
            gstock.insertarStock(new Stock(12, 2, 3, 4)); // Pelota también en Stand 12

            // ------------------ Ventas ------------------
            gv.registrarVenta(new Venta(TipoPago.Paypal, 15.5, 1, 1, 1, 1));
            gv.registrarVenta(new Venta(TipoPago.Tarjeta, 12.0, 2, 2, 2, 2));
            gv.registrarVenta(new Venta(TipoPago.Efectivo, 18.0, 3, 4, 11, 3)); // Camión
            gv.registrarVenta(new Venta(TipoPago.Tarjeta, 35.0, 4, 5, 12, 4)); // Robot
            gv.registrarVenta(new Venta(TipoPago.Paypal, 22.0, 5, 6, 13, 1)); // Bloques
            gv.registrarVenta(new Venta(TipoPago.Efectivo, 45.0, 6, 7, 14, 2)); // Coche RC
            gv.registrarVenta(new Venta(TipoPago.Paypal, 25.0, 7, 8, 15, 3)); // Peluche
            gv.registrarVenta(new Venta(TipoPago.Efectivo, 15.5, 1, 1, 11, 2)); // Muñeca
            gv.registrarVenta(new Venta(TipoPago.Tarjeta, 12.0, 2, 2, 12, 1)); // Puzzle

            // Reducir stock automáticamente al registrar ventas
            actualizarStockDespuesDeVentas();

            // ------------------ Cambios ------------------
            // Ejemplo: cambiar Puzzle del Stand 2, Zona 2 al Stand 1, Zona 1
            gc.insertarCambio(new Cambio(1,"Intercambio por defecto", 2, 2, 2, 1, 1, 2, 2 ));
            gc.insertarCambio(new Cambio(2,"Cambio por defecto", 11, 1, 7, 14, 4, 4, 2));
            gc.insertarCambio(new Cambio(3,"Cliente prefiere otro modelo", 12, 2, 3, 11, 1, 4, 3));
            gc.insertarCambio(new Cambio(4,"Cambio por color diferente", 13, 3, 6, 15, 5, 8, 1));


            System.out.println("Todos los datos de ejemplo cargados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	private void actualizarStockDespuesDeVentas() {
		try {
			List<Venta> ventas = gv.todasVentas();
			for (Venta v : ventas) {
				Stock s = gstock.obtenerStockdelStand(v.getId_stand(), v.getId_zona(), v.getId_juguete());
				gstock.actualizarStock(v.getId_stand(), v.getId_zona(), v.getId_juguete(), s.getCantidad_disponible() - 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
