package ejercicios_XML_lectura;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main_persona {
	
	public static void main(String[] args) {
	
		try { 
			
			//esto es la estructura?¿¿?¿?¿? 
			
			File ficheroXML =  new File ("personas.xml");
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docB = dbf.newDocumentBuilder();
			
			Document doc = docB.parse(ficheroXML);
			
			//Normaliza el documento elimando saltos de linea y espacios
			doc.getDocumentElement().normalize();
			
			NodeList lista = doc.getElementsByTagName("persona"); 
			
			int cantidad = lista.getLength();
			
			for (int i=0 ; i<cantidad; i++) {
				Node nodo = lista.item(i);
				
				if (nodo.getNodeType()==Node.ELEMENT_NODE) {
					Element persona =  (Element) nodo;
					String nombre = persona.getElementsByTagName("nombre").item(0).getTextContent();
					String edad = persona.getElementsByTagName("edad").item(0).getTextContent();
					String ciudad = persona.getElementsByTagName("ciudad").item(0).getTextContent();
					
					System.out.printf("La persona es %s, su edad es %s y nacio en %s\n", nombre,edad,ciudad);
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace(); //con esto tengo que poder leer todo, filtrar por precio y nutrientes
		}
		
	}

}
