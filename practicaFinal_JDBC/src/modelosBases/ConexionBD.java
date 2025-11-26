package modelosBases;

import java.sql.*;

public class ConexionBD {

	String url = "jdbc:mysql://localhost:3306/jugueteria";
	String usuario = "root";
	String password = "cfgs";

	///AÑADIR UN CONTROL DE QUE SI LA BASE DE DATOS ESTA VACIA
	/// Y YA DE AHI CARGAR CON UN INSERT
	
	
	public Connection conectarBBDD() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, usuario, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void desconectarConexion(Connection conexion) {
	    try {
	        if (conexion != null && !conexion.isClosed()) {
	        	conexion.close();
	            System.out.println("Conexión cerrada correctamente");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	

}
