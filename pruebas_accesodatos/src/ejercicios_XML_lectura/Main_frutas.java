package ejercicios_XML_lectura;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main_frutas {
	
	public static void main(String[] args) {
	
		try { 
			
			//esto es la estructura?¿¿?¿?¿? 

			//Dado el siguiente fichero: visualiza los datos, filtra por precio (mayor, igual, menor)
			//filtra las frutas que tienen algunos nutrientes
			
			File ficheroXML =  new File ("frutas.xml");
	
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docB = dbf.newDocumentBuilder();

			Document doc = docB.parse(ficheroXML);

			//Normaliza el documento elimando saltos de linea y espacios
			doc.getDocumentElement().normalize();

			NodeList lista = doc.getElementsByTagName("fruta"); 

			int cantidad = lista.getLength();
			

			for (int i=0 ; i<cantidad; i++) {
				Node nodo = lista.item(i);
			
				if (nodo.getNodeType()==Node.ELEMENT_NODE) {
					Element fruta =  (Element) nodo;
					String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
					String tipo = fruta.getElementsByTagName("tipo").item(0).getTextContent();
					String color = fruta.getElementsByTagName("color").item(0).getTextContent();
					String origen = fruta.getElementsByTagName("origen").item(0).getTextContent();
					String precio = fruta.getElementsByTagName("precio").item(0).getTextContent();
					String temporada = fruta.getElementsByTagName("temporada").item(0).getTextContent();
					String nutrientes = fruta.getElementsByTagName("nutrientes").item(0).getTextContent();

					System.out.printf("La fruta %s, es de tipo %s de color %s.\nSu origen es de %s, y un precio de %s.\nSu principal temporada es %s, "
							+ "nutrientes más valiosos son los %s\n\n", nombre, tipo, color, origen, precio, temporada, nutrientes);

	
				}
				
			}
			
			
			Scanner sc = new Scanner (System.in);
			
			int opcion = 0;
		
			do {
	
				System.out.println("----------¿Que desea hacer?----------\n1. Ver productos por mayor precio\n"
						+ "2. Ver productos por un precio equivalente\n3. Ver productos por menor precio\n4. Cerrar filtros");
				
				opcion = sc.nextInt();
				
				switch (opcion) {
				
				case 1:
					
				double precioFiltrado_mas = 0;
					
				System.out.println("Deseo ver los productos mayores a : ");
				precioFiltrado_mas = sc.nextDouble();
				
				System.out.println("Frutas con precio mayor a "+precioFiltrado_mas);

				for (int i = 0; i < cantidad; i++) {
				    Node nodo = lista.item(i);

				    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				        Element fruta = (Element) nodo;
				        double precio = Double.parseDouble(fruta.getElementsByTagName("precio").item(0).getTextContent());
				        String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
				        
				        if (precio > precioFiltrado_mas) {
	                        System.out.println(nombre + " - " + precio + " €/kg\n");
	                    }
				        
				    }
				}
					break;
					
				case 2:
					
					System.out.println("Deseo ver los productos iguales a :");
				double precioFiltrado_igual = sc.nextDouble();
				
				System.out.println("Frutas con precio iguales a " +precioFiltrado_igual);

				for (int i = 0; i < cantidad; i++) {
				    Node nodo = lista.item(i);

				    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				        Element fruta = (Element) nodo;
				        double precio = Double.parseDouble(fruta.getElementsByTagName("precio").item(0).getTextContent());
				        String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
				        
				        if (precio == precioFiltrado_igual) {
	                        System.out.println(nombre + " - " + precio + " €/kg");
	                    }
				        
				    }
				}
					break;
					
				case 3:
					
					System.out.println("Deseo ver los productos inferiores a : ");
				double precioFiltrado_menos = sc.nextDouble();
				
				System.out.println("Frutas con precio inferior a ");

				for (int i = 0; i < cantidad; i++) {
				    Node nodo = lista.item(i);

				    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				        Element fruta = (Element) nodo;
				        double precio = Double.parseDouble(fruta.getElementsByTagName("precio").item(0).getTextContent());
				        String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
				        
				        if (precio < precioFiltrado_menos) {
	                        System.out.println(nombre + " - " + precio + " €/kg");
	                    }
				        
				    }
				}
				
					break;

				default:
					System.out.println("Se cerro el filtro de precios.\nEl siguiente es el filtro por nutriente\n");
					break;
				}
				
			} while (opcion < 4);
			

			
			opcion = 0;
		
			do {
	
				System.out.println("----------¿Que desea hacer?----------\n1. Ver productos que tienen vitamina C\n"
						+ "2. Ver productos que tienen fibra\n3. Ver productos que tienen melatonina\n4. Cerrar filtros");
				
				opcion = sc.nextInt();
				
				switch (opcion) {
				
				case 1:
									
				System.out.println("-------Frutas con Vitamina C");

				for (int i = 0; i < cantidad; i++) {
				    Node nodo = lista.item(i);

				    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				        Element fruta = (Element) nodo;
				        String nutrientes = fruta.getElementsByTagName("nutrientes").item(0).getTextContent();
				        String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
				        
				        if (nutrientes.contains("Vitamina C")) {
	                        System.out.println(nombre);
	                    }
				        
				    }
				}
					break;
					
				case 2:

					
					System.out.println("-------Frutas con Fibra");

					for (int i = 0; i < cantidad; i++) {
					    Node nodo = lista.item(i);

					    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					        Element fruta = (Element) nodo;
					        String nutrientes = fruta.getElementsByTagName("nutrientes").item(0).getTextContent();
					        String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
					        
					        if (nutrientes.contains("Fibra")) {
		                        System.out.println(nombre);
		                    }
					        
					    }
					}
						break;
					
				case 3:	
					
					System.out.println("-------Frutas con Melatonina");

					for (int i = 0; i < cantidad; i++) {
					    Node nodo = lista.item(i);

					    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					        Element fruta = (Element) nodo;
					        String nutrientes = fruta.getElementsByTagName("nutrientes").item(0).getTextContent();
					        String nombre = fruta.getElementsByTagName("nombre").item(0).getTextContent();
					        
					        if (nutrientes.contains("Melatonina")) {
		                        System.out.println(nombre);
		                    }
					        
					    }
					}
						break;

				default:
					System.out.println("Se cerro el filtro\n");
					break;
				}
				
			} while (opcion < 4);	
			
			sc.close();

		}catch (Exception e) {
			e.printStackTrace(); //con esto tengo que poder leer todo, filtrar por precio y nutrientes
		}
		
	}

}
