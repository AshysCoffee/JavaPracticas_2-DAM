package ejercicios_acc_directo_bin;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * 2.	Se quiere crear un programa que gestione productos con las siguientes características y que se almacene en un fichero binario (hazlo sin clases). 
Cada producto tiene:ID (int), Cantidad en stock (int), Precio (double) 
a.	Almacenar productos 
b.	Visualizar productos (la lista entera) 
c.	Visualizar los datos de un producto concreto basado en su ID 
d.	Borrar productos dado un ID 
e.	Modificar los campos de un producto (Cantidad y precio) 
Los ID son contiguos para ayudar a la gestión.  

 * */

public class Producto_bin {

	public static void main(String[] args) {


		File f = new File ("stock.bin");

		if (!f.exists()){
			try {
				f.createNewFile();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}	


		try (RandomAccessFile raf = new RandomAccessFile (f,"rw")) {

			Scanner sc= new Scanner (System.in);

			int opcion = 0;

			do {
				System.out.println("1. Añadir producto");
				System.out.println("2. Ver todos");
				System.out.println("3. Buscar por ID");
				System.out.println("4. Borrar producto");
				System.out.println("5. Modificar producto");
				System.out.println("0. Salir");
				opcion = sc.nextInt();



				switch (opcion) {

				case 1:

					System.out.print("Introduzca el ID: ");
					int id=sc.nextInt();
					System.out.print("Introduzca el stock:");
					int stock=sc.nextInt();
					System.out.print("Introduzca el precio:");
					double precio=sc.nextDouble();

					
					raf.seek(raf.length()); //para añadirlo al final
					raf.write(id);
					raf.write(stock);
					raf.writeDouble(precio);
					
					System.out.println("Producto guardado correctamente");
							
					
					break;

				case 2:
					raf.seek(0);
					while (raf.getFilePointer()<raf.length()) { 
						int id_leido = raf.readInt();
					    int stock_leido = raf.readInt();
					    double precio_leido = raf.readDouble();
						System.out.printf("ID: %d | Stock: %d | Precio %f  \n"+id_leido,stock_leido,precio_leido);
					}
					break;

				case 3:

					String producto_id = sc.nextLine();
					
					boolean encontrado = false;
					
					int id_p = raf.readInt();
					int stock_p = raf.readInt();
					double precio_p = raf.readDouble();

					String idComp = String.valueOf(id_p) + String.valueOf(stock_p) + String.valueOf((precio_p*100));
					
					raf.seek(0);
					while (raf.getFilePointer()<raf.length()) { 
						if (idComp.equals(producto_id)) {
					        System.out.printf("ID: %d | Stock: %d | Precio: %.2f%n", id_p, stock_p, precio_p);
					        encontrado = true;
					        break;
					    }
						
					}
					
					if (encontrado) {
						System.out.println("Producto encontrado");
					} else {
						System.out.println("Producto no encontrado");
					}
					break;
					
				case 4:

					sc.nextLine();
					String producto_rm = sc.nextLine();
					
					encontrado = false;
					
					raf.seek(0);
					while (raf.getFilePointer()<raf.length()) { 
						long pos = raf.getFilePointer();
						int id_rm = raf.readInt();
						int stock_rm = raf.readInt();
						double precio_rm = raf.readDouble();

						String idComp_rm = String.valueOf(id_rm) + String.valueOf(stock_rm) + String.valueOf((precio_rm*100));
						
						 if (idComp_rm.equals(producto_rm)) {
                             raf.seek(pos);
                             raf.writeInt(0);
                             raf.writeInt(0);
                             raf.writeDouble(0);
                             System.out.println("Producto borrado correctamente.");
                             encontrado = true;
                             break;
                         }
						
					}
					
					if (encontrado) {
						System.out.println("Producto encontrado");
					} else {
						System.out.println("Producto no encontrado");
					}
					break;	

				case 5:

					System.out.print("Introduzca el ID: ");
					int id_md=sc.nextInt();
					System.out.print("Introduzca el nuevo stock:");
					int stock_nuevo=sc.nextInt();
					System.out.print("Introduzca el nuevo precio:");
					double precio_nuevo=sc.nextDouble();

						raf.seek(0);
						
						while (raf.getFilePointer()<raf.length()) {
							raf.writeInt(id_md);
							raf.writeInt(stock_nuevo);
							raf.writeDouble(precio_nuevo);
	
						}
					
					
					
				default:
					System.out.println("No es una opción");
					break;
				}

			} while (opcion != 0);

			sc.close();
			
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
