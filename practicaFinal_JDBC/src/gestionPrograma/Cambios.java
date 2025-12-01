package gestionPrograma;

import java.sql.Connection;
import java.util.List;

import modelosBases.Cambio;
import modelosBases.Stock;
import queriesJDBC.GestionCambios;
import queriesJDBC.GestionStocks;

public class Cambios {

	private Connection conexion;
	private GestionCambios gc;
	private GestionStocks gs;

	public Cambios(Connection conexion) {
		this.conexion = conexion;
		this.gc = new GestionCambios(conexion);
		this.gs = new GestionStocks(conexion);
		System.out.println("Conexión recibida en Consultas.");
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	
	//EN LA BASE DE DATOS SI ME FUNCIONA LA QUERIE PERO AQUI POR MÁS QUE LO CAMBIO O INVESTIGO NO ME DEJA :(
		
		//ME DA EL SIGUIENTE ERROR ==>
	//Cannot add or update a child row: a foreign key constraint fails (`jugueteria`.`cambio`, CONSTRAINT `fk_cambio_stock_original` 
	//FOREIGN KEY (`stand_id_original`, `zona_id_original`, `juguete_id_original`) REFERENCES `stock` (`stand_id`, `zona_id`, `juguete_id)
	
	public boolean ingresarCambio(int id_cambio, String motivo, int stand_id_original, int zona_id_original,
			int juguete_id_original, int stand_id_nuevo, int zona_id_nuevo, int juguete_id_nuevo, int empleado_id) {

		if (id_cambio <= 0) {
			System.out.println("No puede ser negativo el ID");
			return false;
		}

		if (motivo == null || motivo.isEmpty()) {
			System.out.println("Tiene que rellenar este espacio");
			return false;
		}

		if (stand_id_original <= 0 || zona_id_original <= 0 || juguete_id_original <= 0 || stand_id_nuevo <= 0
				|| zona_id_nuevo <= 0 || juguete_id_nuevo <= 0) {
			System.out.println("Los IDs no pueden ser negativos ni cero");
			return false;
		}

		if (empleado_id <= 0) {
			System.out.println("El ID del empleado tiene que ser positivo");
			return false;
		}

		Stock stockOriginal = gs.obtenerStockdelStand(stand_id_original, zona_id_original, juguete_id_original);

		if (stockOriginal == null) {
			System.out.println("El Stock Original no existe. Intentando crearlo...");

			Stock nuevoStock = new Stock(stand_id_original, zona_id_original, juguete_id_original, 0);

			boolean stockCreado = gs.insertarStock(nuevoStock);

			if (!stockCreado) {
				System.err.println("ERROR FATAL: No se pudo crear el Stock Original.");
				System.err.println("CAUSA PROBABLE: El Juguete ID " + juguete_id_original + " o el Stand ID "
						+ stand_id_original + " NO existen en la base de datos.");
				return false;
			}

			System.out.println("Stock creado correctamente. Continuando con el cambio...");
			stockOriginal = nuevoStock;
		}

		Stock stockNuevo = gs.obtenerStockdelStand(stand_id_nuevo, zona_id_nuevo, juguete_id_nuevo);
		if (stockNuevo == null || stockNuevo.getCantidad_disponible() < 1) {
			System.err.println("Error: No hay stock disponible del producto nuevo para entregar.");
			return false;
		}

		gs.actualizarStock(stand_id_nuevo, zona_id_nuevo, juguete_id_nuevo, stockNuevo.getCantidad_disponible() - 1);
		gs.actualizarStock(stand_id_original, zona_id_original, juguete_id_original,
				stockOriginal.getCantidad_disponible() + 1);

		Cambio cambio = new Cambio(id_cambio, motivo, stand_id_original, zona_id_original, juguete_id_original,
				stand_id_nuevo, zona_id_nuevo, juguete_id_nuevo, empleado_id);

		boolean cambiado = gc.insertarCambio(cambio);

		return cambiado;
	}

	public void listasTodosCambios() {

		List<Cambio> cambiosAll = gc.obtenerTodosLosCambios();

		if (cambiosAll == null || cambiosAll.isEmpty()) {
			System.out.println("No hay juguetes en ese rango.");
		} else {

			for (Cambio c : cambiosAll) {
				System.out.println(c);
			}

		}

	}

	public Cambio buscarCambio(int id) {

		if (id <= 0) {
			System.out.println("EL ID no puede ser negativo");
			return null;
		}

		Cambio buscado = gc.obtenerCambioPorId(id);

		if (buscado == null) {
			System.err.println("El cambio con ID " + id + " no existe.");
			return null;
		} else {
			System.out.println("Cambio encontrado: " + buscado);
			return buscado;
		}

	}

	public void listasCambiosPerEmpleados(int empleado) {

		if (empleado <= 0) {
			System.out.println("EL ID no puede ser negativo");
			return;
		}

		List<Cambio> cambiosEmpleado = gc.obtenerCambiosPorEmpleado(empleado);

		if (cambiosEmpleado == null || cambiosEmpleado.isEmpty()) {
			System.out.println("Este empleado no tiene ventas con su ID");
		} else {

			for (Cambio c : cambiosEmpleado) {
				System.out.println(c);
			}

		}

	}

}
