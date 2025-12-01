package gestionPrograma;

import java.sql.Connection;
import java.util.List;

import modelosBases.Juguete;
import queriesJDBC.GestionJuguetes;

public class Inventario {

	private Connection conexion;
	private GestionJuguetes gj;

	public Inventario(Connection conexion) {
		this.conexion = conexion;
		this.gj = new GestionJuguetes(conexion);
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
	public boolean crearJuguete(int id, String nombre, String descripcion, double precio, int cantidad) {

		if (id <= 0) {
			System.err.println("Error: el precio no puede ser negativo.");
			return false;
		}
		
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

		Juguete juguete = new Juguete(id, nombre, descripcion, precio, cantidad);

		boolean creado = gj.insertarJuguete(juguete);

		return creado;

	}

	// Buscar Juguete - Opcion 2
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

	// Listar Juguetes - Opcion 3
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

	// Modificar Precio - Opcion 4
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

	// Modificar Stock - Opcion 5
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

	// Eliminar Juguete - Opcion 6
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

}
