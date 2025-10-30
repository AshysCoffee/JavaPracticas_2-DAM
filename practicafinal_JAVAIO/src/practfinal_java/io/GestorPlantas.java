package practfinal_java.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GestorPlantas {

	public static void main(String[] args) {

		ArrayList<Planta> Plantas = new ArrayList<>();

		try {

			File ficheroXML = new File("plantas.xml");

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			DocumentBuilder docB = dbf.newDocumentBuilder();

			Document doc = docB.parse(ficheroXML);

			doc.getDocumentElement().normalize();

			NodeList lista = doc.getElementsByTagName("planta");

			int longitud_lista = lista.getLength();

			for (int i = 0; i < longitud_lista; i++) {
				Node nodo = lista.item(i);

				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element planta = (Element) nodo;

					Planta planta_p = new Planta( // creamos la fruta y lo guardamos en el constructor
							Integer.valueOf((planta.getElementsByTagName("codigo").item(0).getTextContent())),
							planta.getElementsByTagName("nombre").item(0).getTextContent(),
							planta.getElementsByTagName("foto").item(0).getTextContent(),
							planta.getElementsByTagName("descripcion").item(0).getTextContent());

					try {

						File f = new File ("plantas.dat");

						if (!f.exists()){
							try {
								f.createNewFile();
							}catch (IOException e) {
								e.printStackTrace();
							}
						}	
						
						
						
						
					}catch (Exception e){

					}

					Plantas.add(planta_p);



				}

			}

			for (Planta p : Plantas) {
				System.out.println(p);
			}

		} catch (Exception e) {

			e.getMessage();

		}


	}

}
