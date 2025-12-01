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
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		Menu menu = new Menu();
		menu.mostrarMenuPrincipal();

	}

}
