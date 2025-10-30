package pruebas_bbdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*1. Funcion que permite obtener los datos de los jugadores que empiecen por una letra -> Select * from jugadores where nombre like '?'
 *parametro -> 'A'+'%'
 * 2. EL peso medio de los jugadores AVG :^P
 * 3. Listando los equipos que nos permita seleccionar el número del equipo y podamos ver todos los integrantes del equipo seleccionado
 * 4. Inserta un jugador xd
 * 
 * el execute boolean da un false o un resultset*/

//tengo que hacer un programa osea wtf xD


public class EjercicioNBA {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/nba";
		String usuario = "root";
		String password = "cfgs";
		
		
		Scanner sc = new Scanner (System.in);
		
		int opcion = 0;
	
		do {
		
			System.out.println("Bienvenido al sistema de consulta de la NBA\nPuede consultar los siguientes datos:\n"
			+ "1. Jugadores por inicial de nombre.\n2. Peso medio de toda la distribución.\n3. Ver los integrantes del equipo que desee.\n"
			+ "4. Insertar un jugador nuevo.");
			
			opcion = sc.nextInt();
			
			switch (opcion) {
			
			case 1:
			
				System.out.println("Introduzca la letra por la que quiere filtrar");
				String letra = sc.next();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection conexion = DriverManager.getConnection(url,usuario,password);

					String condicion = "'"+letra+"%'";
					
					String consulta = "SELECT * FROM jugadores WHERE Nombre LIKE ? ";
					PreparedStatement sentencia_preparada = conexion.prepareStatement(consulta);	
					sentencia_preparada.setString(1, condicion);

					ResultSet resultado = sentencia_preparada.executeQuery();		
					
					while (resultado.next()){
						int codigo = resultado.getInt("codigo");
						String nombre = resultado.getNString("Nombre");
						String procedencia = resultado.getNString("Procedencia");
						int peso = resultado.getInt("Peso");
						String posicion = resultado.getNString("Posicion");
						String nombre_equipo = resultado.getNString("Nombre_equipo");
						
						System.out.println("Codigo:"+codigo+" | Nombre: "+nombre+" | Procedencia: "+procedencia+
								"| Peso: "+peso+" | Posición:"+posicion+" | Nombre del equipo:"+nombre_equipo+"|");
						
				
					}	
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
				
			case 2:
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection conexion = DriverManager.getConnection(url,usuario,password);
					
					Statement sentencia = conexion.createStatement();	
					String consulta = "SELECT AVG(Peso) AS peso_promedio FROM jugadores;";

					ResultSet resultado = sentencia.executeQuery(consulta);		
					
					while (resultado.next()){
						int peso_medio = resultado.getInt("peso_promedio");
			
						System.out.println("Peso medio de toda la selección: "+peso_medio+" kg. \n");
						
					}	
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			case 3:
				
			case 4:
				
				
				
			}
			
			
		}while (opcion<5);

	}

}
