package gestionPrograma;

import java.sql.Connection;
import java.util.List;

import modelosBases.Juguete;
import queriesJDBC.GestionJuguetes;

public class Consultas {

	private Connection conexion;
	private GestionJuguetes gj;

	public Consultas(Connection conexion) {
		this.conexion = conexion;
		this.gj = new GestionJuguetes(conexion);
		System.out.println("Conexión recibida en Consultas.");
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public void JuguetesDeMasAMenos() {

		List<Juguete> listaJuguetes = gj.JuguetesPorPrecioDes();

		if (listaJuguetes==null||listaJuguetes.isEmpty()) {
			System.out.println("No hay juguetes en ese rango.");
		} else {

			for (Juguete juguete : listaJuguetes) {
				System.out.println(juguete);
			}

		}

	}

	public void JuguetesDeMenosAMas() {

		List<Juguete> listaJuguetes = gj.JuguetesPorPrecioAsc();

		if (listaJuguetes==null||listaJuguetes.isEmpty()) {
			System.out.println("No hay juguetes en ese rango.");
		} else {

			for (Juguete juguete : listaJuguetes) {
				System.out.println(juguete);
			}

		}

	}

	public void JuguetesRango(int min, int max) {

		if (min < 0 || max < 0 || min > max) {
			System.out.println("Rango de precios inválido.");
			return;
		}

		List<Juguete> listaJuguetes = gj.JuguetesRangoPrecio(min, max);

		if (listaJuguetes==null||listaJuguetes.isEmpty()) {
			System.out.println("No hay juguetes en ese rango.");
		} else {

			for (Juguete juguete : listaJuguetes) {
				System.out.println(juguete);
			}

		}

	}
	
	public List<String> posicionJuguete(int id) {

		if (id < 0) {
			System.out.println("ID inválido.");
			return null;
		}
		
		List<String> infoJuguete = gj.obtenerInfoJuguete(id);

		if (infoJuguete==null||infoJuguete.isEmpty()) {
			System.out.println("No existe un juguete con ese ID.");
		} else {

			for (String info : infoJuguete) {
				System.out.println(info);
			}

		}
		
		return infoJuguete;

	}

}
