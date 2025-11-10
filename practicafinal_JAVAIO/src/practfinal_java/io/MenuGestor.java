package practfinal_java.io;

import java.util.Scanner;

public class MenuGestor {

	private Empleado empleado;
	private GestorEmpleados gestor_e;
	private GestorPlantas gestor_p;


	public MenuGestor(Empleado empleado, GestorEmpleados gestor_e,GestorPlantas gestor_p) {
		super();
		this.empleado = empleado;
		this.gestor_e = gestor_e;
		this.gestor_p = gestor_p;
	}


	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public GestorEmpleados getGestor_e() {
		return gestor_e;
	}
	public void setGestor_e(GestorEmpleados gestor_e) {
		this.gestor_e = gestor_e;
	}


	public GestorPlantas getGestor_p() {
		return gestor_p;
	}
	public void setGestor_p(GestorPlantas gestor_p) {
		this.gestor_p = gestor_p;
	}


	///////// METODOS DEL MENU <---- los hacemos aparte para hacer codigo más limpio

	//	public void altaPlanta(); //Opcion 1
	//	
	//	public void bajaPlanta(int codigo); //Opcion 2
	//	
	//	public void modificarPlanta(int codigo); //Opcion 3
	//	
	//	public void altaEmpleado(); //Opcion 4
	//	
	//	public void bajaEmpleado(int id); //Opcion 5
	//
	//	public void recontratarEmpleado(int id); //Opcion 6  
	//
	//	public void mostrarEstadisticas(); //Opcion 7



	//LO HACEMOS UN METODO PARA QUE CUANDO EL USUARIO PASE LA
	//VALIDACION LE LLEVE DIRECTAMENTE AL MENU Y LO PUEDA EJECUTAR DESDE AHI

	public void mostrarMenu() {

		Scanner sc = new Scanner(System.in);
		int opcion;

		do {

			System.out.println("Bienvenido " + empleado.getNombre()+"\n");
			System.out.println("=== MENÚ GESTOR ===\n"
					+ "1. Alta de plantas\n"
					+ "2. Baja de plantas\n"
					+ "3. Modificar planta\n"
					+ "4. Alta de empleados\n"
					+ "5. Baja de empleados\n"
					+ "6. Recontratar empleado\n"
					+ "7. Consultar estadísticas\n"
					+ "0. Cerrar sesión");

			System.out.println("Elige una opción: ");

			opcion = sc.nextInt();

			switch (opcion) {
			
			case 1:
				
				System.out.println("Por favor introduzca los siguientes datos:");

				
				break;
				
			case 2:

				break;
				
			case 3:

				break;
				
			case 4:

				break;


			case 5:

				break;


			case 6:

				break;

			case 7:

				break;


			default:

				break;

			} 
		}while (opcion != 0);

		sc.close();
	}

}
