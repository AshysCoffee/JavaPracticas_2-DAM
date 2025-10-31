package pruebas_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

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

					String condicion = letra+"%";
					
					String consulta = "SELECT * FROM jugadores WHERE Nombre LIKE ? ";
					PreparedStatement sentencia_preparada = conexion.prepareStatement(consulta);	
					sentencia_preparada.setString(1, condicion);

					ResultSet resultado = sentencia_preparada.executeQuery();		
					
					System.out.println("Jugadores que empiezan por "+letra+" :-------");
					
					while (resultado.next()){
						int codigo = resultado.getInt("codigo");
						String nombre = resultado.getString("Nombre");
						String procedencia = resultado.getString("Procedencia");
						String altura = resultado.getString("Altura");
						int peso = resultado.getInt("Peso");
						String posicion = resultado.getString("Posicion");
						String nombre_equipo = resultado.getString("Nombre_equipo");
						
						
						System.out.println("---\nCodigo:"+codigo+"\nNombre: "+nombre+"\nProcedencia: "+procedencia+
								"\nAltura: "+altura+"\nPeso: "+peso+"\nPosición:"+posicion+"\nNombre del equipo:"+nombre_equipo+"\n-----\n");
						
				
					}	
					
					System.out.println("--------------");
					
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
			
						System.out.println("Peso medio de toda la selección: "+peso_medio+" lbs. \n");
						
					}	
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
				
			case 3:
				
				ArrayList <String> opciones = new ArrayList<>();
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conexion = DriverManager.getConnection(url,usuario,password);
			
					Statement sentencia = conexion.createStatement();	
					String consulta = "SELECT DISTINCT nombre_equipo FROM jugadores";
					ResultSet resultado = sentencia.executeQuery(consulta);		
					
					int contador = 0;
					
					
					System.out.println("\nEquipos existentes:---------------");
					
					while (resultado.next()){
						String nombre_equipo = resultado.getString("nombre_equipo");
						contador++;
						System.out.println(contador +". "+ nombre_equipo+"");
						
						opciones.add(nombre_equipo);
						
					}	
					
					System.out.println("\n");
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				
				int seleccion=0;
				
				System.out.print("Escriba el número del equipo que desea consultar: ");
				seleccion=sc.nextInt();
				
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection conexion = DriverManager.getConnection(url,usuario,password);
					String consulta = "SELECT * FROM jugadores WHERE nombre_equipo = ?";
					PreparedStatement sentencia_preparada = conexion.prepareStatement(consulta);	
					
					String condicion = opciones.get(seleccion-1);
					
					sentencia_preparada.setString(1, condicion);
					
					
					ResultSet resultado = sentencia_preparada.executeQuery();
					
					System.out.println("Equipo "+opciones.get(seleccion-1).toString()+":");
					
					while (resultado.next()){
						int codigo = resultado.getInt("codigo");
						String nombre = resultado.getString("Nombre");
						String procedencia = resultado.getString("Procedencia");
						int peso = resultado.getInt("Peso");
						String posicion = resultado.getString("Posicion");
						
						
						System.out.println("---\nCodigo:"+codigo+"\nNombre: "+nombre+"\nProcedencia: "+procedencia+
								"\nPeso: "+peso+"\nPosición:"+posicion+"\n-----\n");
						
				
					}	
					
				}catch(Exception e) {
					e.printStackTrace();
				}

				break;

			case 4:

				System.out.println("Por favor, introduzca los siguientes datos:");
				
				System.out.println("Codigo: ");
				int codigo = sc.nextInt();
				
				sc.nextLine();
				
				System.out.println("Nombre: ");
				String nombre = sc.nextLine();

				System.out.println("Procedencia: ");
				String procedencia = sc.nextLine();

				System.out.println("Altura: ");
				String altura = sc.nextLine();
				
				System.out.println("Peso: ");
				int peso = sc.nextInt();

				sc.nextLine();
				
				System.out.println("Posicion: ");
				String posicion = sc.nextLine();

				System.out.println("Nombre de su equipo: ");
				String nombre_equipo = sc.nextLine();
		
				

				try {

					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection conexion = DriverManager.getConnection(url,usuario,password);
					String consulta = "INSERT INTO jugadores VALUES (?,?,?,?,?,?,?)";
					PreparedStatement sentencia_preparada = conexion.prepareStatement(consulta);	

					sentencia_preparada.setInt(1, codigo);
					sentencia_preparada.setString(2, nombre);
					sentencia_preparada.setString(3, procedencia);
					sentencia_preparada.setString(4, altura);
					sentencia_preparada.setInt(5, peso);
					sentencia_preparada.setString(6, posicion);
					sentencia_preparada.setString(7, nombre_equipo);
					
					int resultado = sentencia_preparada.executeUpdate();
								
					if (resultado > 0) {
				        
						System.out.println("---\nCodigo:"+codigo+"\nNombre: "+nombre+"\nProcedencia: "+procedencia+
								"\nAltura: "+altura+"\nPeso: "+peso+"\nPosición:"+posicion+"\nNombre del equipo:"+nombre_equipo+"\n-----\n");
						
				    } else {
				    	
				        System.out.println("No se pudo insertar el jugador");
				    }
					

				}catch(Exception e) {
					e.printStackTrace();
				}

				
			default:
				System.out.println("No es una opcion");
			
					
					
			}		
			
			
		}while (opcion<5);

		sc.close();
		
	}

}
