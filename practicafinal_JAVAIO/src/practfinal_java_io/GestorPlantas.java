package practfinal_java_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class GestorPlantas {

	private ArrayList<Planta> plantasAlta;
	private ArrayList<Planta> plantasBaja;

	// CONSTRUCTOR
	public GestorPlantas() {
		this.plantasAlta = new ArrayList<>();
		this.plantasBaja = new ArrayList<>();
	}

	public void setPlantasAlta(ArrayList<Planta> plantasAlta) {
		this.plantasAlta = plantasAlta;
	}

	public ArrayList<Planta> getPlantasAlta() {
		return plantasAlta;
	}

	public void setPlantasBaja(ArrayList<Planta> plantasBaja) {
		this.plantasBaja = plantasBaja;
	}

	public ArrayList<Planta> getPlantasBaja() {
		return plantasBaja;
	}

	public void inicializar() {

		try {
			this.plantasAlta = cargarPlantasAlta(); // Cargar plantas activas desde XML
			if (!plantasAlta.isEmpty()) {
				System.out.println("Plantas activas cargadas: " + plantasAlta.size());
			}

			this.plantasBaja = cargarPlantasBaja();
			if (!plantasBaja.isEmpty()) {
				System.out.println("Plantas bajas cargadas: " + plantasBaja.size());
			}

			cargarPlantaDat();

		} catch (Exception e) {
			System.out.println("Hubo un error en los archivos");
		}
	}

	///////////// METODOS DEL .XML

	public ArrayList<Planta> cargarPlantasAlta() {

		ArrayList<Planta> listaTemporal = new ArrayList<>();

		try {

			File ficheroXML = new File("PLANTAS/plantas.xml");

			if (!ficheroXML.exists() || ficheroXML.getParent() == null) {
				System.out.println("El archivo no existe");
				return listaTemporal; // Devolver lista vacía si no existe

			}

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

					listaTemporal.add(planta_p);

				}

			}

		} catch (Exception e) {

			System.err.println("Error al cargar las plantas activas desde XML: " + e.getMessage());

		}
		this.plantasAlta = listaTemporal; // actualiza el atributo
		return this.plantasAlta;

	}

	public ArrayList<Planta> cargarPlantasBaja() {

		plantasBaja.clear();

		try {
			File ficheroXML = new File("PLANTAS/plantasBajas.xml");

			if (!ficheroXML.exists()) {
				System.out.println("El archivo plantasBajas.xml no existe");
				return plantasBaja; // Devolver lista vacía si no existe

			}

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

					plantasBaja.add(planta_p);

				}

			}

		} catch (Exception e) {

			System.err.println("Error al cargar las plantas dadas de baja desde XML: " + e.getMessage());
		}
		return plantasBaja;

	}

	public boolean reescribirPlantas(ArrayList<Planta> p, String rutaFile) {

		try {

			// Crear archivo si no existe

			File f = new File(rutaFile);

			if (!f.exists()) {
				f.createNewFile();
				System.out.println("Archivo no existía, se creó uno nuevo.");
			}

			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.newDocument();
			Element rootElement = doc.createElement("plantas");
			doc.appendChild(rootElement);

			for (Planta pl : p) {

				Element planta = doc.createElement("planta");
				rootElement.appendChild(planta);

				Element codigo = doc.createElement("codigo");
				Text codigo_planta = doc.createTextNode(String.valueOf(pl.getCodigo()).toString());
				codigo.appendChild(codigo_planta);
				planta.appendChild(codigo);

				Element nombre = doc.createElement("nombre");
				Text nombre_planta = doc.createTextNode(pl.getNombre());
				nombre.appendChild(nombre_planta);
				planta.appendChild(nombre);

				Element foto = doc.createElement("foto");
				Text foto_planta = doc.createTextNode(pl.getFoto());
				foto.appendChild(foto_planta);
				planta.appendChild(foto);

				Element descripcion = doc.createElement("descripcion");
				Text descripcion_planta = doc.createTextNode(pl.getDescripcion());
				descripcion.appendChild(descripcion_planta);
				planta.appendChild(descripcion);

			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(f);
			transformer.transform(source, result);

			System.out.println("Archivo reescrito con éxito: " + rutaFile);
			return true;
		} catch (Exception e) {

			System.err.println("Error al reescribir el archivo: " + e.getMessage());
			return false;
		}

	}

	public void reescribirPlantas() {
		if (reescribirPlantas(plantasAlta, "PLANTAS/plantas.xml")) {
			System.out.println("Guardado correcto");
		} else {
			System.out.println("Error al guardar");
		}

	} 

	public void reescribirplantasBorradas() {
		if (reescribirPlantas(plantasBaja, "PLANTAS/plantasBajas.xml")) {
			System.out.println("Guardado correcto");
		} else {
			System.out.println("Error al guardar");
		}

	} 

	///////////////// METODOS .DAT

	public void crearPlantasDat() {

		try {

			File f = new File("PLANTAS/plantas.dat");

			if (!f.exists()) {
				f.getParentFile().mkdirs(); // crear carpeta si no existe
				f.createNewFile(); // crear archivo vacío
				System.out.println("Archivo creado porque no existía");
			}

			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			final int TAM_REGISTRO = 12;

			for (Planta p : plantasAlta) {

				long posicion = (p.getCodigo() - 1) * TAM_REGISTRO;
				raf.seek(posicion);

				raf.writeInt(p.getCodigo());

				raf.writeFloat(10.0f);
				raf.writeInt(50);
			}

			raf.close();

		} catch (IOException e) {
			System.err.println("Error al crear el archivo plantas.dat: " + e.getMessage());
		}
	}

	public void cargarPlantaDat() {

		File f = new File("PLANTAS/plantas.dat");
		
		if (!f.exists()) {
			crearPlantasDat();
		}
		
		try {

			int posicion = 0;

			RandomAccessFile raf = new RandomAccessFile("PLANTAS/plantas.dat", "r");
			long size = raf.length();

			for (Planta p : plantasAlta) {

				if (raf.getFilePointer() < raf.length()) {

					int codigo = raf.readInt();
					float precio = raf.readFloat();
					int stock = raf.readInt();

					p.setPrecio(precio);
					p.setStock(stock);

					posicion += 12;

				}
			}

			System.out.println("Se ha podido cargar el archivo plantas.dat correctamente");
			
		} catch (IOException | DatosInvalidosException e) {

			System.err.println("Error al cargar el archivo plantas.dat: " + e.getMessage());
		}

	} 

	public String leerPlantaDatPorCodigo(int codigo) {

		try {


			RandomAccessFile raf = new RandomAccessFile("PLANTAS/plantas.dat", "r");
			final int TAM_REGISTRO = 12;
			long size = raf.length();
			long posicion = 0;

			while (posicion < size) {
				raf.seek(posicion);

				int codigoLeido = raf.readInt();
				float precio = raf.readFloat();
				int stock = raf.readInt();

				if (codigoLeido == codigo) {
					return "Código: " + codigoLeido + " | Precio: " + precio + " | Stock: " + stock;
				}

				posicion += TAM_REGISTRO;

			}

			throw new DatosInvalidosException("Código inválido: " + codigo);
		} catch (IOException | DatosInvalidosException e) {

			return "Error leyendo el archivo";
		}

	}

	public void actualizarStockDat(int codigo, int nuevoStock) {

		try {
			RandomAccessFile raf = new RandomAccessFile("PLANTAS/plantas.dat", "rw");

			final int TAM_REGISTRO = 12;
			long posicion = (codigo - 1) * TAM_REGISTRO;

			raf.seek(posicion);

			raf.readInt(); // Saltar código de código
			float precio = raf.readFloat(); // Leer precio actual

			// Volver a la posición del código para reescribir todo
			raf.seek(posicion);
			raf.writeInt(codigo);
			raf.writeFloat(precio); // Mantener mismo precio
			raf.writeInt(nuevoStock); // NUEVO stock

			raf.close();
		} catch (IOException e) {

			System.err.println("Error al actualizar el stock en plantas.dat: " + e.getMessage());
		}

	} 

	public void actualizarPrecioDat(int codigo, float nuevoPrecio) {

		try {

			RandomAccessFile raf = new RandomAccessFile("PLANTAS/plantas.dat", "rw");

			final int TAM_REGISTRO = 12;
			long posicion = (codigo - 1) * TAM_REGISTRO;

			raf.seek(posicion);

			raf.readInt(); // Saltar código
			int stock = raf.readInt(); // Leer precio actual

			// Volver a la posición del código para reescribir todo
			raf.seek(posicion);
			raf.writeInt(codigo);
			raf.writeFloat(nuevoPrecio); // Mantener mismo precio
			raf.writeInt(stock); // NUEVO stock

			raf.close();

		} catch (IOException e) {

			System.err.println("Error al actualizar el stock en plantas.dat: " + e.getMessage());
		}
	} 

	public void darDeBajaEnDat(int codigo) {

		try {

			RandomAccessFile raf = new RandomAccessFile("PLANTAS/plantas.dat", "rw");

			final int TAM_REGISTRO = 12;
			long posicion = (codigo - 1) * TAM_REGISTRO;

			raf.seek(posicion);

			raf.writeInt(codigo);
			raf.writeFloat(0.0f); // Precio = 0
			raf.writeInt(0); // Stock = 0

			raf.close();

			System.out.println("Planta " + codigo + " dada de baja en .dat");

		} catch (IOException e) {

			System.err.println("Error al actualizar el stock en plantas.dat: " + e.getMessage());
		}
	} 

	/////////////// METODOS GENERALES

	public void dardeAltaPlanta(String nombre, String foto, String descripcion, int stock, float precio) {

		try {
			
			int id = plantasAlta.size() + plantasBaja.size() + 1; // Nuevo ID secuencial
			
			Planta p = new Planta(id, nombre, foto, descripcion);

			plantasAlta.add(p);
			reescribirPlantas();

			RandomAccessFile raf = new RandomAccessFile("PLANTAS/plantas.dat", "rw");
			final int TAM_REGISTRO = 12; // Usamos una constante dado que siempre es el mismo tamaño

			// Para cada planta del XML
			// Calcular posición según su código
			long posicion = (p.getCodigo() - 1) * TAM_REGISTRO;
			raf.seek(posicion);

			// Escribir el MISMO código del XML
			raf.writeInt(p.getCodigo());

			// Precio y stock: valores por defecto para facilitar la interacción
			raf.writeFloat(precio);
			raf.writeInt(stock);

			raf.close();

		} catch (IOException | DatosInvalidosException e) {
			System.out.println("Error al escribir la planta sobre el fichero.");
			;
		}

	} 

	public void darDeBajaPlanta(int codigo) {

		try {

			Planta plantaBaja = buscarPlanta(plantasAlta, codigo);// 1. Buscar la planta en plantasActivas

			if (plantaBaja == null) { // Error por si no encuenta la planta
				System.out.println("Planta no encontrada con código: " + codigo);
				return;
			}

			plantasBaja = cargarPlantasBaja(); // 2. Cargar plantas de baja existentes (si las hay)

			if (!plantasBaja.contains(plantaBaja)) {// Se comprueba que no este duplicado
				plantasBaja.add(plantaBaja);//Añadir la nueva planta a la lista de borradas
			} else {
				System.out.println("La planta ya está dada de baja.");
				return;
			}

			reescribirplantasBorradas();// 4. Guardar en plantasBaja.xml

			darDeBajaEnDat(codigo); // 5. Poner precio y stock a 0 en plantas.dat

			plantasAlta.removeIf(p -> p.getCodigo() == plantaBaja.getCodigo()); // elimina la planta con ese código de
																				// la lista plantasBaja

			reescribirPlantas();// 7. Reescribir plantas.xml (sin la planta borrada)

			System.out.println("Planta '" + plantaBaja.getNombre() + "' se ha dado de baja correctamente");

		} catch (Exception e) {

			System.out.println("Error al dar de baja planta");
		}

	} 

	public void recuperarPlanta(int codigo, float precio, int stock) {

		try {

			plantasAlta = cargarPlantasAlta();
			plantasBaja = cargarPlantasBaja();

			// 1. Buscar en plantasBaja.xml
			Planta plantaRescatar = buscarPlanta(plantasBaja, codigo);

			if (plantaRescatar == null) {
				System.out.println("Planta no encontrada en bajas");
				return;
			}

			// 2. Actualizar en plantas.dat con nuevo precio/stock
			RandomAccessFile raf = new RandomAccessFile("PLANTAS/plantas.dat", "rw");
			long posicion = (codigo - 1) * 12;
			raf.seek(posicion);
			raf.writeInt(codigo);
			raf.writeFloat(precio);
			raf.writeInt(stock);
			raf.close();

			// 3. Añadir a plantasActivas
			plantasAlta.add(plantaRescatar);

			// 4. Eliminar de plantasBaja
			plantasBaja.removeIf(p -> p.getCodigo() == plantaRescatar.getCodigo());

			reescribirplantasBorradas();
			reescribirPlantas();

			System.out.println("Planta fue reactivada correctamente");

		} catch (IOException e) {

			System.out.println("Error al cargar las plantas");
		}

	}

	public Planta buscarPlanta(ArrayList<Planta> a, int codigo) {
		for (Planta p : a) {
			if (p.getCodigo() == codigo) {
				return p;
			}
		}
		return null;
	} 

	public String mostrarPlantas() {
		StringBuilder sb = new StringBuilder();

		for (Planta p : plantasAlta) {
			sb.append("Nombre: ").append(p.getNombre()).append("\n");
			sb.append("Foto: ").append(p.getFoto()).append("\n");
			sb.append("Descripción: ").append(p.getDescripcion()).append("\n");

			sb.append(leerPlantaDatPorCodigo(p.getCodigo())).append("\n");

			sb.append("-----------------------------\n");
		}

		return sb.toString();
	}
	
	public String mostrarPlantasBaja() {
		StringBuilder sb = new StringBuilder();

		for (Planta p : plantasBaja) {
			sb.append("Nombre: ").append(p.getNombre()).append("\n");
			sb.append("Foto: ").append(p.getFoto()).append("\n");
			sb.append("Descripción: ").append(p.getDescripcion()).append("\n");

			sb.append(leerPlantaDatPorCodigo(p.getCodigo())).append("\n");

			sb.append("-----------------------------\n");
		}

		return sb.toString();
	}

	public void mostrarEstadisticas() {

		int totalPlantas = plantasAlta.size() + plantasBaja.size();
		System.out.println("Total de plantas (activas + bajas): " + totalPlantas);
		System.out.println("Plantas activas: " + plantasAlta.size());
		System.out.println("Plantas dadas de baja: " + plantasBaja.size());

	}
	
	public void calcularEstadisticasAvanzadas() {
	    double recaudacionTotal = 0;
	    ArrayList<AuxEstadistica> ranking = new ArrayList<>();

	    try {
	        File carpeta = new File("TICKETS");
	        File[] archivos = carpeta.listFiles();

	        if (archivos != null) {
	            for (int i = 0; i < archivos.length; i++) {
	                File f = archivos[i];
	                
	                if (f.isFile() && f.getName().endsWith(".txt")) {
	                    BufferedReader br = new BufferedReader(new FileReader(f));
	                    String linea;
	                    boolean esSeccionProductos = false;

	                    while ((linea = br.readLine()) != null) {
	                        
	                        if (linea.contains("TOTAL:")) {
	                            String limpia = linea.replace("TOTAL:", "").replace("€", "").trim();
	                            recaudacionTotal += Double.parseDouble(limpia);
	                        }

	                        if (linea.contains("CódigoProducto")) {
	                            esSeccionProductos = true;
	                            continue; 
	                        }
	                        if (linea.contains("---")) {
	                            esSeccionProductos = false;
	                        }

	                        if (esSeccionProductos && !linea.trim().isEmpty()) {
	                            String[] partes = linea.split("\t+");
	                            if (partes.length >= 2) {
	                                int id = Integer.parseInt(partes[0].trim());
	                                int cant = Integer.parseInt(partes[1].trim());

	                                boolean encontrada = false;
	                                for (int j = 0; j < ranking.size(); j++) {
	                                    if (ranking.get(j).getId() == id) {
	                                        ranking.get(j).cantidadTotal += cant;
	                                        encontrada = true;
	                                        break;
	                                    }
	                                }
	                                // Si no estaba, la añadimos a la lista
	                                if (!encontrada) {
	                                    ranking.add(new AuxEstadistica(id, cant));
	                                }
	                            }
	                        }
	                    }
	                    br.close();
	                }
	            }
	        }

	        for (int i = 0; i < ranking.size() - 1; i++) {
	            for (int j = 0; j < ranking.size() - i - 1; j++) {
	                if (ranking.get(j).getCantidadTotal() < ranking.get(j + 1).getCantidadTotal()) {
	                    // Intercambiamos
	                    AuxEstadistica temp = ranking.get(j);
	                    ranking.set(j, ranking.get(j + 1));
	                    ranking.set(j + 1, temp);
	                }
	            }
	        }

	 
	        System.out.println("\n===== ESTADÍSTICAS FINALES =====");
	        System.out.println("Recaudación Total de todos los tickets: " + recaudacionTotal + " €");
	        System.out.println("Ranking de productos más vendidos:");
	        for (int i = 0; i < ranking.size(); i++) {
	            AuxEstadistica aux = ranking.get(i);
	            Planta p = buscarPlanta(plantasAlta, aux.id);
	            String nombre = (p != null) ? p.getNombre() : "Desconocido";
	            System.out.println((i + 1) + ". " + nombre + " (ID: " + aux.id + ") - " + aux.cantidadTotal + " unidades");
	        }

	    } catch (Exception e) {
	        System.out.println("Error al calcular estadísticas: " + e.getMessage());
	    }
	}
	
	

}
