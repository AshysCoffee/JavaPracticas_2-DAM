package PF;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class main {
	
	public static float numeroAleatorioPrecio() {
		  
		        float numero = ThreadLocalRandom.current().nextFloat(1, 500);
		        return Math.round(numero * 100f) / 100f; // redondea a 2 decimales
		    
	}
	
	
	public static int numeroAleatorioStock() {
		  return ThreadLocalRandom.current().nextInt(1, 501); 
	}
	
	
	public static void EscribirFichero () {
	    
	        try (RandomAccessFile raf = new RandomAccessFile("plantas.dat", "rw")) {
	            for(int i=1;i<21;i++) {
	            	raf.writeInt(i);
	            	float numero= numeroAleatorioPrecio();
	            	System.out.println(numero);
	      	        raf.writeFloat(numero);
	      	        int numero1= numeroAleatorioStock();
	            	System.out.println(numero1);
	            	raf.writeInt(numero1);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    
	}
	
	
	
	public static void EscribirEmpleado(){
		ArrayList <Empleado> ListaEmpleados = new ArrayList <>();
		
		try (FileOutputStream FicheroEscritura = new FileOutputStream("empleado.dat");
	             ObjectOutputStream escritura = new ObjectOutputStream(FicheroEscritura)) {

	            	            
	            Empleado empleado1 = new Empleado(1452,"Teresa","asb123","vendedor");
	            Empleado empleado2 = new Empleado(0234,"Miguel Angel","123qwe","vendedor");
	            Empleado empleado3 = new Empleado(7532,"Natalia","xs21qw4","gestor");
	            
	            ListaEmpleados.add(empleado1);
	            ListaEmpleados.add(empleado2);
	            ListaEmpleados.add(empleado3);
	            
	            escritura.writeObject(ListaEmpleados);
	            

	            System.out.println("Objetos escritos correctamente en empleado.dat");

	        } catch (IOException i) {
	            i.printStackTrace();
	        }
	}
	
	
	
	public static void leerPlantaAccesoDirecto() {
		int posicion=0;
		try (RandomAccessFile raf = new RandomAccessFile("plantas.dat", "r")) {
			long size = raf.length();
			while (posicion < size) {
			  
			        int codigo = raf.readInt();
			        float precio = raf.readFloat();
			        int stock = raf.readInt();

			        System.out.println(codigo + "," + precio + "," + stock);

			        // Avanzar la posición según los bytes leídos (4 + 4 + 4 = 12 bytes)
			        posicion += 12;
			    } 
		}catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	
	
	public static void leerCadaEmpleado() {
		ArrayList<Empleado> listaEmpleados = leerEmpleados();

        // Imprimir los empleados leídos
        if (listaEmpleados != null) {
            for (Empleado empleado : listaEmpleados) {
                System.out.println(empleado);
            }
        }
	}
	
	
	
	public static ArrayList<Empleado> leerEmpleados() {
        ArrayList<Empleado> listaEmpleados = null;

        try (FileInputStream ficherolectura = new FileInputStream("empleado.dat");
             ObjectInputStream lectura = new ObjectInputStream(ficherolectura)) {

            // Leer el ArrayList de Empleado desde el archivo
            listaEmpleados = (ArrayList<Empleado>) lectura.readObject();

            System.out.println("Objetos leídos correctamente desde empleado.dat");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listaEmpleados;
    }
	
	public static void main(String[] args) {
		
		EscribirEmpleado();
		EscribirFichero();
		leerCadaEmpleado();
		leerPlantaAccesoDirecto();
	}

}
