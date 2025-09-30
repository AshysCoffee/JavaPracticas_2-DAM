package serializar;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Atleta implements Serializable {

		private String nombre;
		private double tiempo;
		private int edad;
		
		public Atleta(String nombre, double tiempo, int edad) {
			super();
			this.nombre = nombre;
			this.tiempo = tiempo;
			this.edad = edad;
		}
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public double getTiempo() {
			return tiempo;
		}
		public void setTiempo(double tiempo) {
			this.tiempo = tiempo;
		}
		
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		
		
		public int compareTo(Atleta a) {
			if(this.tiempo>a.tiempo) {
				return 1;
				
			}else if(this.tiempo<a.tiempo) {
				return -1;
			}
			return 0;
		}

			
		public String toString() {
			String s=" ";
			s+=("Nombre: "+nombre+" | Tiempo: "+tiempo+" s | Edad: "+edad+"\n");
					
			return s;
			
		}

}
