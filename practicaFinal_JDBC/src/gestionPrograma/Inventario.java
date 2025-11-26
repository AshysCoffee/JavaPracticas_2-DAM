package gestionPrograma;

import modelosBases.ConexionBD;
import modelosBases.ControlErrores;
import modelosBases.Juguete;
import queriesJDBC.GestionJuguetes;

public class Inventario {

	ConexionBD conexionBD = new ConexionBD();
	
	GestionJuguetes gestionJuguetes = new GestionJuguetes(conexionBD.conectarBBDD());
	
	public void crearJuguete(String nombre, String descripcion,double precio, int stock) {
		
		
		if(nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
		
		if(descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacío");
        }
		
        if(precio <= 0.0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0");
        }
		
        if(stock <= 0) {
            throw new IllegalArgumentException("El stock debe ser mayor que 0");
        }
        
        
		Juguete nuevoJuguete = new Juguete(nombre, descripcion, precio, stock);
		
		gestionJuguetes.insertarJuguete(nuevoJuguete);
        
	}

//	buscarJuguete();
//
//listarJuguetes();
//
//modificarJuguete();
//
//eliminarJuguete();
//	
	
}
