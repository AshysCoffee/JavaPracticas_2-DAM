package pruebas_bbdd;

import java.sql.*;

public class Conexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/mydb";
		String usuario = "root";
		String password = "cfgs";
		
		try {
			//1. Cargar el drive de la bd
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Crear un conexion
			Connection conexion = DriverManager.getConnection(url,usuario,password);
			System.out.println("Se ha conectado a la base de datos.");
			
			//3.1 Crear un Statement
			Statement sentencia = conexion.createStatement();
			String consulta = "Select * from Usuario where idUsuario = 1 OR 1=1";//Este formato de sql permite las inyecciones de SQL
			ResultSet resultado = sentencia.executeQuery(consulta);
			
			//3.2 Crear un PreparedStatement
			consulta = "Select * from usuario where idUsuario = ?";
			PreparedStatement sentencia_preparada = conexion.prepareStatement(consulta);
			int numero = 1;
			sentencia_preparada.setInt(1, numero);
			sentencia_preparada.setString(2, "Leo");
			
			sentencia_preparada.executeQuery();
			
			//4. Mostrar los resultados
			
			while (resultado.next()){
				int idUsuario = resultado.getInt("idUsuario");
				String nombre = resultado.getNString("nombre");
				Date fecha = resultado.getDate("Fecha de nacimiento");
				String genero = resultado.getString("Genero");
				System.out.println("Usuario : "+idUsuario+", Nombre: " +nombre+ ", Fecha de nacimiento: "+fecha+", Genero: "+genero);
				
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}