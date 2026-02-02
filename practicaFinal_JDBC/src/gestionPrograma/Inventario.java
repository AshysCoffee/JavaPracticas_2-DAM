package gestionPrograma;

import java.sql.Connection;
import java.util.List;

import modelosBases.Juguete;
import modelosBases.Stand;
import modelosBases.Stock;
import queriesJDBC.GestionJuguetes;
import queriesJDBC.GestionStands;
import queriesJDBC.GestionStocks;

public class Inventario {

	private Connection conexion;
	private GestionJuguetes gj;
	private GestionStocks gs;
	private GestionStands gstands;

	public Inventario(Connection conexion) {
		this.conexion = conexion;
		this.gj = new GestionJuguetes(conexion);
		this.gs = new GestionStocks(conexion);
		this.gstands = new GestionStands(conexion);
		System.out.println("Conexión recibida en Inventario.");
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	//////////// MENU DE JUGUETES

	// Crear Juguete - Opcion 1
	public boolean crearJuguete(String nombre, String descripcion, double precio, int cantidad, String categoria,
			int zona_id, int stand_id) {

		if (nombre == null || nombre.isEmpty()) {
			System.err.println("Error: el nombre es obligatorio");
			return false;
		}

		if (descripcion == null || descripcion.isEmpty()) {
			System.err.println("Error: la descripción es obligatoria");
			return false;
		}

		if (precio <= 0) {
			System.err.println("Error: el precio no puede ser negativo.");
			return false;
		}

		if (cantidad < 0) {
			System.err.println("Error: el stock no puede ser negativo.");
			return false;
		}

		if (stand_id <= 0) {
			System.err.println("Error: El ID del Stand no es valido.");
			return false;
		}

		if (zona_id <= 0) {
			System.err.println("Error: El ID de la Zona no es valido.");
			return false;
		}

		Juguete juguete = new Juguete(nombre, descripcion, precio, cantidad, categoria);

		boolean creado = gj.insertarJuguete(juguete);

		if (creado) {

			int idGenerado = gj.obtenerUltimoId();

			if (idGenerado != 0) {

				Stock nuevoStock = new Stock(stand_id, zona_id, idGenerado, cantidad);

				boolean stockCreado = gs.insertarStock(nuevoStock);

				if (stockCreado) {
					System.out.println(
							"Juguete creado con éxito (ID: " + idGenerado + ") y ubicado en Stand " + stand_id + ".");
					return true;
				} else {
					System.err.println("El juguete se creó, pero hubo un error al asignarlo al Stand (Stock).");
					return true;
				}
			} else {
				System.err.println("Error crítico: No se pudo recuperar el ID del juguete recién creado.");
				return false;
			}
		} else {
			System.err.println("Error al insertar el juguete en la base de datos.");
			return false;
		}

	}

	public Juguete buscarJuguete(int id) {

		if (id <= 0) {
			System.err.println("El ID del juguete no es válido.");
			return null;
		}

		Juguete juguete = gj.obtenerJuguetePorId(id);

		if (juguete == null) {
			System.err.println("El juguete con ID " + id + " no existe.");
			return null;
		} else {
			System.out.println("Juguete encontrado: " + juguete);
			return juguete;

		}
	}

	public void listarJuguetes() {
		List<Juguete> listado = gj.listarJuguetes();

		if (listado == null || listado.isEmpty()) {
			System.out.println("No hay juguetes en el inventario.");
			return;
		}

		for (Juguete juguete : listado) {
			System.out.println(juguete);
		}

	}

	public boolean modificarPrecio(int id, double precio) {

		if (precio < 0) {
			System.out.println("El stock no puede ser negativo.");
			return false;
		}

		if (id <= 0) {
			System.out.println("El ID del juguete no es válido.");
			return false;
		}

		if (gj.obtenerJuguetePorId(id) == null) {
			System.out.println("El juguete no existe.");
			return false;
		}

		boolean actualizar = gj.actualizarPrecio(id, precio);

		return actualizar;

	}

	public boolean modificarStock(int id, int stock) {

		if (stock < 0) {
			System.out.println("El stock no puede ser negativo.");
			return false;
		}

		if (id <= 0) {
			System.out.println("El ID del juguete no es válido.");
			return false;
		}

		if (gj.obtenerJuguetePorId(id) == null) {
			System.out.println("El juguete no existe.");
			return false;
		}

		boolean actualizar = gj.actualizarStock(id, stock);

		return actualizar;
	}

	public boolean eliminarJuguete(int id) {

		if (id <= 0) {
			System.out.println("El ID del juguete no es válido.");
			return false;
		}

		if (gj.obtenerJuguetePorId(id) == null) {
			System.out.println("El juguete no existe.");
			return false;
		}

		boolean eliminar = gj.eliminarJuguete(id);

		return eliminar;
	}

	public void buscarPorCategoria(String categoria) {
		List<Juguete> lista = gj.buscarJuguetesPorCategoria(categoria);

		if (lista == null || lista.isEmpty()) {
			System.out.println("No se encontraron juguetes de la categoría: " + categoria);
		} else {
			for (Juguete j : lista) {
				System.out.println(j);
			}
		}

	}

	public boolean moverMercancia(int idJuguete, int cant, int stOrigen, int zOrigen, int stDestino, int zDestino) {

		Stock origen = gs.obtenerStockdelStand(stOrigen, zOrigen, idJuguete);

		if (origen == null) {
			System.out.println("Error: Ese juguete no existe en el Stand de origen.");
			return false;
		}

		if (origen.getCantidad_disponible() < cant) {
			System.out.println(
					"Error: No hay suficiente cantidad en el origen (Hay: " + origen.getCantidad_disponible() + ")");
			return false;
		}

		Stock destino = gs.obtenerStockdelStand(stDestino, zDestino, idJuguete);

		boolean exitoDestino;

		if (destino == null) {
			
			System.out.println("No existe el stand al que se quiere transferir, se procedera a crear");
			Stock s = new Stock(zDestino, stDestino, idJuguete, cant);

			gs.insertarStock(s);
			
			destino = gs.obtenerStockdelStand(stDestino, zDestino, idJuguete);

			int nuevaCant = destino.getCantidad_disponible() + cant;
			exitoDestino = gs.actualizarStock(stDestino, zDestino, idJuguete, nuevaCant);

		}else{
		
			int nuevaCant = destino.getCantidad_disponible() + cant;
			exitoDestino = gs.actualizarStock(stDestino, zDestino, idJuguete, nuevaCant);

			if (exitoDestino) {
				int resta = origen.getCantidad_disponible() - cant;
				gs.actualizarStock(stOrigen, zOrigen, idJuguete, resta);
				System.out.println("¡Transferencia realizada con éxito!");
				return true;
			} else {
				System.out.println("Error al actualizar el stand de destino.");
				return false;
			}
			
		}
	}

	public void listaStands() {

		List<Stand> lista = gstands.listarStands();

		for (Stand s : lista) {
			System.out.println(s);
		}

	}

}
