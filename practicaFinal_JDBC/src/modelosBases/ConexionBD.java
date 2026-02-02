package modelosBases;

import java.sql.*;

public class ConexionBD {

	String url = "jdbc:mysql://localhost:3306/jugueteria";
	String usuario = "root";
	String password = "cfgs";

	
	
	public ConexionBD() {
	}
	
	
	public Connection conectarBBDD() throws SQLException, ClassNotFoundException {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, usuario, password);
		
	}
	
	
	
}
