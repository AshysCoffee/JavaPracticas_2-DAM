package practfinal_java_io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;

public class Devolucion implements Serializable{

	private int codDevolucion;
	private static int ultimoCodigo = 0;
	private ArrayList<LineaDevolucion> lineas;
	private double total;
	private LocalDate fecha;
	private GestorPlantas gestor_p;

	public Devolucion(GestorPlantas gestor_p) {
		this.codDevolucion = ++ultimoCodigo;
		this.lineas = new ArrayList<>();
		this.fecha = LocalDate.now();
		this.gestor_p = gestor_p;
	}



	public int getCodDevolucion() {
		return codDevolucion;
	}

	public void setCodDevolucion(int codDevolucion) {
		this.codDevolucion = codDevolucion;
	}


	public static int getUltimoCodigo() {
		return ultimoCodigo;
	}


	public static void setUltimoCodigo(int ultimoCodigo) {
		Devolucion.ultimoCodigo = ultimoCodigo;
	}



	public ArrayList<LineaDevolucion> getLineas() {
		return lineas;
	}

	public void setLineas(ArrayList<LineaDevolucion> lineas) {
		this.lineas = lineas;
	}


	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}



	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public void agregarLineaDev(Planta p, int cantidad) {
	
		try {

			LineaDevolucion linea = new LineaDevolucion(p, cantidad);
			lineas.add(linea);
			total += linea.getSubtotal();

			p.setStock(p.getStock() + cantidad);
		
		} catch (DatosInvalidosException e) {
			System.out.println("Error al actualizar el stock de la planta durante la devolución: " + e.getMessage());
		}
	}

	public void generarTicketDevolucion() {
		try {
			
			File carpeta = new File("DEVOLUCIONES");
			if (!carpeta.exists()) carpeta.mkdirs();

			File f = new File("DEVOLUCIONES/" + codDevolucion + ".txt");
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
				bw.write("===== TICKET DE DEVOLUCIÓN Nº " + codDevolucion + " =====\n");
				bw.write("Fecha: " + fecha + "\n\n");

				for (LineaDevolucion l : lineas)
					bw.write(l.toString() + "\n");

				bw.write("\n------------------------------------\n");
				bw.write("TOTAL DEVUELTO: -" + total + " €\n");
				bw.write("====================================\n");
			}

			System.out.println("Devolución Nº " + codDevolucion + " registrada correctamente");

			
		} catch (IOException e) {
			System.out.println("Error al guardar ticket de devolución: " + e.getMessage());
		}
	}
	
	

}
