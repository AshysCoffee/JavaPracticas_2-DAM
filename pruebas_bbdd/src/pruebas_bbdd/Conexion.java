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
			//consulta = "Select * from usuario where idUsuario = ?;";
			consulta = "UPDATE usuario set nombre = ? where idUsuario = ?";
			PreparedStatement sentencia_preparada = conexion.prepareStatement(consulta);// al estar preparado, el execute es sin nada	
			int numero = 1;
			sentencia_preparada.setInt(2, numero);
			sentencia_preparada.setString(1, "Leo"); //da igual el orden pero cada interrogante tiene su numero ref :P
		
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