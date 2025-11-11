package practfinal_java.io;

import java.io.Serializable;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.time.*;

@SuppressWarnings("serial")
public class Venta implements Serializable{

	private static int ultimoTicket=0;
	private int cod_ticket, cod_empleado;
	private String nombre_empleado;
	private double total;
	private LocalDate fecha;
	private GestorPlantas gestor;
	ArrayList <LineaTicket> lista_prod;
	ArrayList <Planta> cesta;
	
	public Venta(int cod_empleado, String nombre_empleado, GestorPlantas gestor) {
		super();
		this.gestor = gestor;
		this.cod_ticket = 0;
		this.cod_empleado = cod_empleado;
		this.nombre_empleado = nombre_empleado;
		this.fecha = LocalDate.now();
		this.total = 0;
		lista_prod = new ArrayList <>();
		cesta = new ArrayList <>();
	}

	public int getCod_ticket() {
		return cod_ticket;
	}

	public int getCod_empleado() {
		return cod_empleado;
	}

	public void setCod_empleado(int cod_empleado) {
		this.cod_empleado = cod_empleado;
	}

	public String getNombre_empleado() {
		return nombre_empleado;
	}

	public void setNombre_empleado(String nombre_empleado) {
		this.nombre_empleado = nombre_empleado;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ArrayList<LineaTicket> getLista_prod() {
		return lista_prod;
	}

	public void setLista_prod(ArrayList<LineaTicket> lista_prod) {
		this.lista_prod = lista_prod;
	}
	

	public ArrayList<Planta> getCesta() {
		return cesta;
	}

	public void setCesta(ArrayList<Planta> cesta) {
		this.cesta = cesta;
	}


	public GestorPlantas getGestor() {
		return gestor;
	}

	public void setGestor(GestorPlantas gestor) {
		this.gestor = gestor;
	}



/////////////////// METODOS	DE VENTA 
	

/////METODOS DE INICIALIZACION
	
	public void inicializarUltimoTicket() {
	    
		File carpetaTickets = new File("TICKETS");
	    
	    if (!carpetaTickets.exists()) { //lo creamos si no existe
	        carpetaTickets.mkdirs();
	        cod_ticket = 0;
	        return;
	    }

	    File[] tickets = carpetaTickets.listFiles(); //listamos todos los archivos
	    int max = 0; 
	    if (tickets != null) {
	        for (File t : tickets) { //recorremos el array y los volvemos todos string
	            String nombre = t.getName().replace(".txt", "");
	            try {
	                int num = Integer.parseInt(nombre); //Los volvemos numeros normales
	                if (num > max) max = num; //si el num es mayor que max, max se asigna ese valor
	            } catch (NumberFormatException e) {
	                // Ignorar archivos que no sean tickets
	            }
	        }
	        
//	        Este se ejecuta normalmente al inicio del programa,
//	        y su trabajo es leer el último número de ticket generado desde un archivo
	    }
	    ultimoTicket = max;
	} //PROBARLO++ ---- LEE EL ULTIMO NUMERO GUARDADO
	
	
	public int generarNuevoTicket() {
		
		//Este es el que usas cuando se hace una nueva venta.
		
	    ultimoTicket++; // siguiente número
	    
	    this.cod_ticket = ultimoTicket; // asignarlo a la venta
	    
	    generarTicket(); // guarda en carpeta TICKETS
	    
	    return ultimoTicket;
	} //PROBARLO++ --- INCREMENTA EL NUMERO, SE PONE AL GENERAR UNA NUEVA VENTA
	

	
/////METODOS DE ESPECIFICOS

	public String leerLineas() {
		String s = "";
		for (LineaTicket l : lista_prod) {
			s += (l.toString());
		}
		return s;
	} //SOLO SIRVE PARA EL TOSTRING NATURAL
	
	
	public double calcularTotal() {

		for (Planta p: cesta) {
			total += p.getPrecio();
		}
		return total;
	} //PROBARLO++

	public LineaTicket buscarLinea(int id) {
		
		LineaTicket linea = null;
		
		for (LineaTicket l : lista_prod) {
	        if (l.getPlanta().getCodigo() == id) {
	            linea = l;
	        }
	    }
		
		return linea;
	} //PROBARLO

	
/////METODOS DE LINEAS	
	
	public void agregarLinea(LineaTicket linea) {
		lista_prod.add(linea);
		this.total += linea.calcularSubtotal();
	} //PROBARLO++

	
	public void eliminarLinea(LineaTicket linea) {
		lista_prod.remove(linea);
		this.total -= linea.calcularSubtotal();
	} //PROBARLO++

	
	public LineaTicket devolucionLinea (int id) {
		
		LineaTicket linea = buscarLinea(id);
		
		if (lista_prod.contains(linea)) {
		
		String s = "-"+String.valueOf(linea.getCantidad());
		int devolucion = Integer.parseInt(s);
		linea.setCantidad(devolucion);
		return linea;
		
		}
		
		System.out.println("No se pudo encontrar la linea deseada para realizar la devolución");
		return null;
		
	} //Pone negativa la cantidad + PROBARLO
	
/////METODOS DE ARRAYLISTS	
	
	
	public void agregarProducto (int id, int cantidad) {

		Planta p = gestor.buscarPlantaEnAlta(id);
		try {
			if (p == null || cantidad <= 0 || p.getStock()<1) {
				System.out.println("Error: planta nula o cantidad inválida");
				return;
			}

			if (p.getStock()<cantidad) {
				System.out.println("Error: no hay stock suficiente");
				return;
			}

			cesta.add(p);
			agregarLinea(new LineaTicket (cantidad,p));


			p.setStock(p.getStock()-cantidad);
			gestor.actualizarStockDat(id, p.getStock());

		} catch (DatosInvalidosException | IOException e) {
			e.printStackTrace();
		}
	} //PROBARLO++
	
		
	public void eliminarProducto(int id) {
	   
		LineaTicket lineaAEliminar = null;

	    for (LineaTicket l : lista_prod) {
	        if (l.getPlanta().getCodigo() == id) {
	            lineaAEliminar = l;
	            break;
	        }
	    }

	    if (lineaAEliminar != null) {
	    	
	    	cesta.removeIf(p -> p.getCodigo() == id);  //Eliminamos todas las unidades que encontremos
	    	
	    	eliminarLinea(lineaAEliminar);// Quita la línea y resta el subtotal del total
	    	
	    	System.out.println("Producto con codigo " + id + " eliminado del ticket.");
	    } else {
	    	System.out.println("No se encontro el producto con codigo " + id + " en el ticket.");
	    }
	} //PROBARLO++

	
	
/////METODOS DE LECTURA Y ESCRITURA	
	
	public void generarTicket () {

		try {

			File carpeta = new File("TICKETS");
	        if (!carpeta.exists()) {
	            carpeta.mkdirs();
	        }

			File f = new File ("TICKETS/"+cod_ticket+".txt");

			try (BufferedWriter buffer_w = new BufferedWriter(new FileWriter(f))) {

	            buffer_w.write("===== TICKET DE VENTA Nº " + cod_ticket + " =====\n");
	            buffer_w.write("Fecha: " + java.time.LocalDate.now() + "\n\n");

	            // Escribimos cada línea de producto
	            for (LineaTicket l : lista_prod) {
	                buffer_w.write(l.toString() + "\n");
	            }

	            buffer_w.write("\n------------------------------------\n");
	            buffer_w.write("TOTAL: " + total + " €\n");
	            buffer_w.write("====================================\n");

	            System.out.println("Ticket " + cod_ticket + " guardado correctamente en /TICKETS");

			}
		} catch (IOException e) {
			System.out.println("Error al guardar ticket: " + e.getMessage());
		}



	} //PROBARLO++


	public void leerTicket () {

		try {

			File carpeta = new File("TICKETS");
			if (!carpeta.exists()) {
				carpeta.mkdirs();
			}

			File f = new File ("TICKETS/"+cod_ticket+".txt");

			BufferedReader buffer_r = new BufferedReader(new FileReader (f));
			String linea;

			while ((linea=buffer_r.readLine())!=null){
				System.out.println(linea);
			}
			buffer_r.close();

		} catch (IOException e) {
			e.getMessage();
		}

	}	

//	public void buscarTicket (int venta) { //USAR JAVA NIO XD NO SE TOY CANSADA :(
//		
//		File directorio = new File("TICKETS");
//		String[] nombresArchivos = directorio.list();
//		
//		for (String archivo : nombresArchivos) {
//	        if (nombreAb)
//	}
	
	public void generarTicketDevolucion (int ticket,int id) {

		try {

			File carpeta = new File("DEVOLUCIONES");
			if (!carpeta.exists()) {
				carpeta.mkdirs();
			}

			File f = new File ("DEVOLUCIONES/"+ticket+".txt");

			try (BufferedWriter buffer_w = new BufferedWriter(new FileWriter(f))) {

				buffer_w.write("===== TICKET DE VENTA Nº " + cod_ticket + " =====\n");
				buffer_w.write("Fecha: " + java.time.LocalDate.now() + "\n\n");

				// Escribimos cada línea de producto
				for (LineaTicket l : lista_prod) {
					buffer_w.write(l.toString() + "\n");
				}

				buffer_w.write("\n------------------------------------\n");
				buffer_w.write("TOTAL: " + total + " €\n");
				buffer_w.write("====================================\n");

				System.out.println("Ticket " + cod_ticket + " guardado correctamente en /TICKETS");

				System.out.println("------------DEVOLUCION------------");

				System.out.println(devolucionLinea(id));

			}
		} catch (IOException e) {
			System.out.println("Error al guardar ticket: " + e.getMessage());
		}

	}
	
	
	public String toString() {

		return "Número Ticket:" + cod_ticket + "\n——————————————//———————————------------------------\n"
				+"\nEmpleado que ha atendido: "+cod_empleado+"\nNombre del empleado: "+nombre_empleado+"\n"
				+ "Fecha: "+fecha+"\nCodigoProducto\tProducto\tCantidad\tPrecioUnitario\n"+leerLineas()+"\nTotal: "+total;
	}



}
