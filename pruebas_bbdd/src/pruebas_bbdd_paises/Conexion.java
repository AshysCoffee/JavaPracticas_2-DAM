package pruebas_bbdd_paises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
	
	public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String password = "Soyunestegosaurio27."; 

        try (@SuppressWarnings("unused")	
		Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión establecida con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
