package usuario;

import java.sql.Connection;
import java.sql.SQLException;

import modelosBases.ConexionBD;
import modelosBases.DatosIniciales;

public class Main {

	public static void main(String[] args) {

		try {
			ConexionBD conexionBD = new ConexionBD();
			Connection conn = conexionBD.conectarBBDD();

			DatosIniciales dt = new DatosIniciales(conn);

			if (dt.baseDeDatosVacia()) {
				System.out.println("La base de datos está vacía. Cargando datos iniciales...");
				dt.cargarTodo();
			} else {
				System.out.println("La base de datos ya tiene datos. No se cargarán los datos iniciales.");
			}

		} catch (ClassNotFoundException e) {
			System.err.println("Error al cargar el controlador JDBC: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Error al conectar con la base de datos: " + e.getMessage());
		}

		Menu menu = new Menu();
		menu.mostrarMenuPrincipal();

	}

}
