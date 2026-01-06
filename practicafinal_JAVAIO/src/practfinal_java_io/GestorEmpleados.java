package practfinal_java_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("serial")
public class GestorEmpleados implements Serializable {

	private ArrayList <Empleado> empleadosAltas;
	private ArrayList <Empleado> empleadosBajas;


	public GestorEmpleados(  ) {
		super();
		this.empleadosAltas = new ArrayList <>();
		this.empleadosBajas = new ArrayList <>();
	}


	public ArrayList<Empleado> getEmpleadosAltas() {
		return empleadosAltas;
	}
	
	public void setEmpleadosAltas(ArrayList<Empleado> empleadosAltas) {
		this.empleadosAltas = empleadosAltas;
	}

	
	public ArrayList<Empleado> getEmpleadosBajas() {
		return empleadosBajas;
	}

	
	public void setEmpleadosBajas(ArrayList<Empleado> empleadosBajas) {
		this.empleadosBajas = empleadosBajas;
	}

	public void inicializar() {
		escribirArchivoAlta();
		leerEmpleadosAlta();
		leerEmpleadosBaja();
	}


//////////ESCRITURA Y LECTURA DE EMPLEADOS

	public void escribirArchivoAlta(){

		try {

			File f = new File("EMPLEADOS/empleado.dat");
			if (!f.exists()) {
				f.getParentFile().mkdirs(); // crear carpeta si no existe
				f.createNewFile(); // crear archivo vacío
				System.out.println("Archivo creado porque no existía");
			}

			ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(f));

			Empleado empleado1 = new Empleado(57, "Gabriela", "p2s5mXw", Cargo.VENDEDOR);
			Empleado empleado2 = new Empleado(8331, "Federico", "0fM123", Cargo.VENDEDOR);
			Empleado empleado3 = new Empleado(504, "Maria Jose", "JkS67", Cargo.ENCARGADO);
			Empleado empleado4 = new Empleado(1500, "Pablo", "02IndOO", Cargo.ENCARGADO);

			empleadosAltas.add(empleado1);
			empleadosAltas.add(empleado2);
			empleadosAltas.add(empleado3);
			empleadosAltas.add(empleado4);

			escritura.writeObject(empleadosAltas);

			System.out.println("Objetos escritos correctamente en empleado.dat\n");

		} catch (IOException | DatosInvalidosException i) {
			System.out.println ("No se ha podido escribir los objectos en el archivo empleado.dat");
		}
	}

	public void leerArchivo(ArrayList<Empleado> lista, String ruta) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
			
			lista.clear();
			lista.addAll((ArrayList<Empleado>) ois.readObject());
			System.out.println("Objetos leídos correctamente desde " + ruta+"");

		}catch (IOException | ClassNotFoundException e) {
			
			System.out.println("Error al leer archivo: " + e.getMessage());

		}
	}

	public void leerEmpleadosAlta() {
		leerArchivo(empleadosAltas, "EMPLEADOS/empleado.dat");
	} 
	
	public void leerEmpleadosBaja() {
		
		try {

			File f_baja = new File("EMPLEADOS/BAJAS/empleadoBaja.dat");

			if (!f_baja.exists()) {
				f_baja.getParentFile().mkdirs(); // crear carpeta si no existe
				f_baja.createNewFile();          // crear archivo vacío
				System.out.println("Archivo creado porque no existía");
			}

			if(empleadosBajas.isEmpty() || !f_baja.exists() || f_baja.length()==0) {
				System.out.println("No existen empleados de baja en EMPLEADOS/BAJAS/empleadoBaja.dat\n");
			}else{
				leerArchivo(empleadosBajas, "EMPLEADOS/BAJAS/empleadoBaja.dat");
			}
			
		}catch (Exception e){
			System.out.println("Error al leer archivo de empleados de baja: " + e.getMessage());
		}
	} 



	public Empleado buscarEmpleadoPorId(ArrayList <Empleado> arraylist ,int id) {
		for (Empleado e : arraylist) {
			if (e.getId_empleado() == id) {
				return e;
			}
		}
		return null;
	}


	public Empleado buscarEmpleadoPorIdAlta(int id) {
		return buscarEmpleadoPorId(empleadosAltas, id);
	}
	
	
	public Empleado buscarEmpleadoPorIdBaja(int id) {
		return buscarEmpleadoPorId(empleadosBajas, id);
	}
	

	
////////////VALIDACIONES DE CREDENCIALES	
	
	
	public Empleado validarLogin(int id, String contraseña) {
		
		if (empleadosAltas.isEmpty() || buscarEmpleadoPorIdAlta(id)==null) {
			System.out.println("No existen empleados para acceder al login");
			return null;
		}
		
		for (Empleado e : empleadosAltas) {
			if (e.getId_empleado() == id && contraseña.equals(e.getContraseña())) {
				return e;
			}
		}
		return null;
	}

	public Empleado autenticarInteractivo(GestorPlantas gp, int intentosMaximos) throws DatosInvalidosException {
		
		Scanner sc = new Scanner(System.in);
		
		int intentos = 0;
		while (intentos < intentosMaximos) {
			intentos++;
			
			System.out.print("ID: ");

			String input = sc.nextLine().trim();

			int id = ControlErrores.leerEntero(input);

			System.out.print("Contraseña: ");
			String pwd = sc.nextLine().trim();

			Empleado e = validarLogin(id, pwd);

			if (e != null) {
				System.out.println("\nHe iniciado sesión correctamente");

				switch (e.getCargo()) {
				case VENDEDOR:

					try {
						new MenuVendedor(gp,e).mostrarMenu();
					} catch (Exception ex) {
						System.err.println("Error al mostrar menú vendedor: " + ex.getMessage());
					}
					break;

				case ENCARGADO:
					try {
						new MenuGestor(e, this, gp).mostrarMenu();
					} catch (Exception ex) {
						System.err.println("Error al mostrar menú gestor: " + ex.getMessage());
						
					}
					break;

				default:
					System.out.println("Cargo no reconocido. No se puede mostrar el menú correspondiente.");
				}
				return e;

			}else{
				
				int restantes = intentosMaximos - intentos;
				
				if (restantes > 0) {
					System.out.println("Credenciales incorrectas. Te quedan " + restantes + " intentos.");
				} else {
					System.out.println("Has agotado el número máximo de intentos. Usuario bloqueado temporalmente.");
				}
			}
		}
		// No cerramos scanner porque podría cerrar System.in para el resto de la app
		return null;
	}


/////////////OPCIONES PARA EL GESTOR	

	public void darAltaEmpleado(int id, String nombre, String contraseña, Cargo cargo){

		Empleado e_buscado = buscarEmpleadoPorId(empleadosAltas, id);

		if (e_buscado == null) {
			System.out.println("No se encontró el empleado en activos.");

		}else if (e_buscado != null){

			empleadosAltas.add(e_buscado);

			guardarEmpleadoEnAlta(); //Lo escribimos en empleadosAltas.dat

			System.out.println("Empleado con ID " + e_buscado.getId_empleado() + " se ha dado de alta correctamente.");

			return;
		}

		System.out.println("No se encontró el empleado en activos.");
	}

	public void guardarEmpleadoEnAlta() {

		if (empleadosAltas.isEmpty()) {
	        System.out.println("No hay empleados en alta para guardar.");
	        return;
	    }
		
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empleado.dat"))) {

			for (Empleado e : empleadosAltas) {
				oos.writeObject(e);
			}

			System.out.println("Empleado guardado correctamente.");

		} catch (IOException e) {
			
			System.out.println("Error al guardar empleado: " + e.getMessage());
		}

	}

	public void darBajaEmpleado(int id){

		Empleado e_buscado = buscarEmpleadoPorId(empleadosAltas,id);

		if (empleadosBajas.contains(e_buscado)) {
		    System.out.println("El empleado ya está dado de baja.");
		    return;
		}
		
		if (e_buscado == null) {
			System.out.println("No se encontró el empleado en activos.");

		}else if (e_buscado != null){

			empleadosAltas.removeIf(e -> e.getId_empleado() == e_buscado.getId_empleado());
			empleadosBajas.add(e_buscado);

			// Guardar registro del empleado dado de baja
			guardarEmpleadoEnBaja(); //Lo escribimos en empleadosBajas.dat

			System.out.println("Empleado con ID " + e_buscado.getId_empleado() + " dado de baja correctamente.");

			return;
		}

	}

	public void guardarEmpleadoEnBaja() {

		if (empleadosBajas.isEmpty()) {
	        System.out.println("No hay empleados en baja para guardar.");
	        return;
	    }
		
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BAJA/empleadosBaja.dat"))) {
			
			for (Empleado e : empleadosBajas) {
				oos.writeObject(e);
			}
			System.out.println("Empleado guardado correctamente.");

			
		} catch (IOException e) {
			System.out.println("Error al guardar empleado: " + e.getMessage());
		}

	}

	public void recuperarEmpleado(int id) {

		Empleado e_recupera = buscarEmpleadoPorId(empleadosBajas,id);

		if (e_recupera == null) {
			System.out.println("Empleado no encontrada en bajas");
			return;
		}

		if (e_recupera != null) {
			
			empleadosBajas.removeIf(e -> e.getId_empleado() == e_recupera.getId_empleado());
			empleadosAltas.add(e_recupera);

			guardarEmpleadoEnBaja();
			guardarEmpleadoEnAlta();

			System.out.println("El empleado con "+e_recupera.getId_empleado()+" fue reactivado correctamente");

		}

	}

	
}
