package practfinal_java_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class GestorTickets {

	
	public String buscarTicketPorNumero(int numTicket) {
		File archivo = new File("TICKETS/"+ numTicket + ".txt");
		if (!archivo.exists()) {
			System.out.println("No se encontró el ticket Nº " + numTicket);
			return null;
		}

		StringBuilder contenido = new StringBuilder();
		try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = lector.readLine()) != null) {
				contenido.append(linea).append("\n");
			}
		} catch (IOException e) {
			System.out.println("Error al leer el ticket: " + e.getMessage());
		}

		return contenido.toString();
	}

	
	public void agregarDevolucionATicket(int numTicket, ArrayList<String> lineasDevolucion) {
		
		File archivo = new File("TICKETS/" + numTicket + ".txt");
		
		if (!archivo.exists()) {
			System.out.println("No se encontró el ticket Nº " + numTicket);
			return;
		}

		try (FileWriter fw = new FileWriter(archivo, true)) { // true → añadir al final
			
			fw.write("\n=== DEVOLUCIONES ===\n");
			for (String linea : lineasDevolucion) {
				fw.write(linea + "\n");
			}
			
			System.out.println("Devoluciones añadidas al ticket Nº " + numTicket);
			
			
		} catch (IOException e) {
			
			System.out.println("Error al escribir devoluciones: " + e.getMessage());
		}
	
	
		try {
			
			Path origen = Paths.get("TICKETS/" + numTicket + ".txt");
			Path destino = Paths.get("DEVOLUCIONES/" + numTicket + ".txt");
			
			Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			System.out.println("Error al mover el ticket a DEVOLUCIONES: " + e.getMessage());
		}
		

	}
}
