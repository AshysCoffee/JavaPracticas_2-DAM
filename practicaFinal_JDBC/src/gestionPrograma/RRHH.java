package gestionPrograma;

import modelosBases.Cargo;
import modelosBases.Empleado;
import queriesJDBC.GestionEmpleados;

import java.sql.*;
import java.time.*;
import java.util.List;

public class RRHH {

	private Connection conexion;
	private GestionEmpleados ge;

	public RRHH(Connection conexion) {
		this.conexion = conexion;
		this.ge = new GestionEmpleados(conexion);
		System.out.println("Conexión recibida en RRHH.");
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	// Opcion 1 - Crear empleado
	public boolean crearEmpleado(String nombre, String cargo) {

		if (nombre == null || nombre.isEmpty()) {
			System.err.println("Error: el nombre es obligatorio");
			return false;
		}

		if (cargo == null || cargo.isEmpty()) {
			System.err.println("Error: el cargo es obligatorio");
			return false;
		}

		if (!cargo.equalsIgnoreCase("JEFE") && !cargo.equalsIgnoreCase("CAJERO")) {
			System.err.println("Error: el cargo no existe, debe ser Jefe o Cajero");
			return false;
		}

		Empleado emp = new Empleado(nombre, Cargo.valueOf(cargo.toUpperCase()), LocalDate.now());

		boolean exito = ge.insertarEmpleado(emp);

		return exito;

	}

	// Opcion 2 - Eliminar empleado
	public boolean eliminarEmpleado(int id_empleado) {

		if (id_empleado <= 0) {
			System.out.println("El ID no puede ser inferior a 0");
			return false;
		}

		if (ge.obtenerEmpleadoPorId(id_empleado) == null) {
			System.out.println("El empleado deseado no existe");
		}

		boolean eliminado = ge.eliminarEmpleado(id_empleado);

		return eliminado;

	}

	// Opcion 3 - Listar empleados
	public void listarEmpleados() {

		List<Empleado> empleados = ge.listarEmpleados();

		if (empleados == null || empleados.isEmpty()) {
			System.out.println("No hay juguetes en el inventario.");
			return;
		}

		for (Empleado e : empleados) {
			System.out.println(e);
		}

	}

	// Opcion 4 - Buscar empleado por ID
	public Empleado buscarEmpleado(int id) {

		if (id <= 0) {
			System.err.println("El ID del juguete no es válido.");
			return null;
		}

		Empleado e = ge.obtenerEmpleadoPorId(id);

		if (e == null) {
			System.err.println("El empleado con ID " + id + " no existe.");
			return null;
		} else {
			System.out.println("Empleado encontrado: " + e);
			return e;
		}

	}

	// Opcion 5 - Actualizar empleado
	public boolean actualizarEmpleado(int id, String nuevoNombre, String nuevoCargo) {

		if (id <= 0) {
			System.err.println("El ID del empleado no es válido.");
			return false;
		}

		Empleado empleadoExistente = ge.obtenerEmpleadoPorId(id);

		if (empleadoExistente == null) {
			System.err.println("El empleado con ID " + id + " no existe.");
			return false;
		}

		if (nuevoNombre == null || nuevoNombre.isEmpty()) {
			System.err.println("El nombre no puede estar vacío.");
			return false;
		}

		if (nuevoCargo == null || nuevoCargo.isEmpty()) {
			System.err.println("El cargo no puede estar vacío.");
			return false;
		}

		if (!nuevoCargo.equalsIgnoreCase("Jefe") && !nuevoCargo.equalsIgnoreCase("Cajero")) {
			System.err.println("Error: el cargo no existe, debe ser Jefe o Cajero");
			return false;
		}

		Empleado empleadoActualizado = new Empleado(id, nuevoNombre, Cargo.valueOf(nuevoCargo.toUpperCase()),
				empleadoExistente.getFechaIngreso());

		boolean exito = ge.actualizarEmpleado(empleadoActualizado);

		return exito;
	}

}
