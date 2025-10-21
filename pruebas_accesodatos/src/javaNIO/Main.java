package javaNIO;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	//Paths.get y Path.of es lo mismo al parecer ??
	
		//Lectura con la clase Files de JavaNIO
		
		public static void LeerFiles () {
			Path ruta = Paths.get("bye.txt"); //el parametro es la ruta o URL
			
			try {
				
				String contenido = Files.readString(ruta); //esto es para leer todo el contenido en una solo variable
				System.out.println(contenido+"\n"); 
				
				List <String> listaContenido = Files.readAllLines(ruta);//este metodo es para guardar linea a linea y en caso que querramos tratarlas 
				
				for (String linea : listaContenido) {
					System.out.println("Linea = "+linea); //aqui ponemos algo que haga identificar la diferencia
				}
				
				
			}catch (Exception e){
				e.getMessage();
			}
		}
		
		public static void EscrituraFiles() {
			
			Path ruta = Paths.get("escritura_first.txt");

			try {

				String contenido = "Holi es mi primer archivo escrito con Java NIO";
				Files.write(ruta, contenido.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND); 
				
				//Documentar las openoption :') 

			}catch (Exception e){
				e.getMessage();
			}
		}


		public static void Copiar() {

			Path rutaOrigen = Paths.get("escritura_first.txt"); 
			Path rutaDestino = Paths.get("escritura_copia.txt"); 
			
			try {

				Files.copy(rutaOrigen, rutaDestino, StandardCopyOption.REPLACE_EXISTING);

			}catch (Exception e){
				e.getMessage();
			}
		}

		public static void listarContenido() {

			Path directorio = Path.of(".");
			
			try {

				Stream<Path> flujo = Files.list(directorio);
				flujo.forEach(archivo -> System.out.println(archivo.getFileName()));
				
				flujo.close();
				
			}catch (Exception e){
				e.getMessage();
			}
		}
		
		
		public static void PropiedadesContenido() {

			Path ruta = Path.of("primos.txt");
			
			System.out.println("Fichero existe: " + Files.exists(ruta));
			System.out.println("Ficheo es directorio: "+Files.isDirectory(ruta));

		}
		
		
		public static void BorrarContenido() {

			Path ruta = Path.of("escritura_copia.txt");
			
			try {
				Files.deleteIfExists(ruta);
			}catch (Exception e){
				e.getMessage();
			}
		}
			public static void main(String[] args) {

			LeerFiles();
			
			//EscrituraFiles();
			
			Copiar();
			
			listarContenido();
				
			PropiedadesContenido();
			
			BorrarContenido();
	}

}
