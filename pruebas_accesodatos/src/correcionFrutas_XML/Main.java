package correcionFrutas_XML;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
	
	public static int posicion (double precio, ArrayList<Fruta> Frutas) {
		int posicion =-1;
		double valorAnterior=0;

		
		for(int i=0;i<Frutas.size();i++) {
			if(Frutas.get(i).getPrecio()==precio){
				
				posicion=i ;
			}else {
				if(valorAnterior>Frutas.get(i).getPrecio()) {
					posicion = i-1;
				}
			}
			valorAnterior=Frutas.get(i).getPrecio();
		}
		return posicion;
	}

	public static void main(String[] args) {
		
		ArrayList <Fruta> Frutas = new ArrayList <>();
		
		try {
			File ficheroXML = new File ("frutas.xml");
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder docB = dbf.newDocumentBuilder();
			
			Document doc = docB.parse(ficheroXML);
			
			doc.getDocumentElement().normalize();
			
			NodeList lista = doc.getElementsByTagName("fruta"); 

			int longitud_lista = lista.getLength();
			

			for (int i=0 ; i<longitud_lista; i++) {
				Node nodo = lista.item(i);
			
				if (nodo.getNodeType()==Node.ELEMENT_NODE) {
					Element fruta =  (Element) nodo;
					
					ArrayList <String> nutrientes = new ArrayList <>(); //creamos el arraylist donde guardaremos los nutrientes

					Fruta piezaFruta =new Fruta ( //creamos la fruta y lo guardamos en el constructor
							fruta.getElementsByTagName("nombre").item(0).getTextContent(),
							fruta.getElementsByTagName("tipo").item(0).getTextContent(),
							fruta.getElementsByTagName("color").item(0).getTextContent(),
							fruta.getElementsByTagName("origen").item(0).getTextContent(),
							fruta.getElementsByTagName("temporada").item(0).getTextContent(),
							Double.valueOf(fruta.getElementsByTagName("precio").item(0).getTextContent())
							);

					NodeList listaNutrientes = fruta.getElementsByTagName("nutriente"); //creamos la lista del nodo nutriente

					for (int j=0; j<listaNutrientes.getLength(); j++) { //hacemos un for para ir añadiendo
						nutrientes.add(listaNutrientes.item(i).getTextContent()); //añadimos cada objeto de la lista nodo al arraylist
						
					}
					
					piezaFruta.setNutrientes(nutrientes); //ponemos el arraylist en el constructor
					Frutas.add(piezaFruta);//ahora si metemos la fruta entera con la info al array externo de frutas
					
				}
				
				Frutas.sort(Comparator.comparing(Fruta::getPrecio));
				
			}
			
			for (Fruta f : Frutas) {
				
				System.out.println(f.toString());
				
				ArrayList <String> nutrientes = f.getNutrientes();
				
				for (String n : nutrientes) {
					System.out.println(n);
				}
				
			}
			
			
		}catch (Exception e){
			
			e.getMessage();

		}

	}

}
