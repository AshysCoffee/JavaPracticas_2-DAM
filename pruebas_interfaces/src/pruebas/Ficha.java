package pruebas;

public class Ficha implements Comparable<Ficha> {
	
		private String dni;
		private String nombre;
		private String apellidos;
		private double salario;
		
		
		public Ficha(String dni, String nombre, String apellidos, double salario) {
			super();
			this.dni = dni;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.salario = salario;
		}


		public String getDni() {
			return dni;
		}


		public void setDni(String dni) {
			this.dni = dni;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getApellidos() {
			return apellidos;
		}


		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}


		public double getSalario() {
			return salario;
		}


		public void setSalario(double salario) {
			this.salario = salario;
		}


		@Override
		public String toString() {
			return "Nombre = " + nombre + "\nApellidos = " + apellidos + "\nDNI = "  + dni + "\nSalario = " + salario;
		}


		@Override
		/*public int compareTo(Ficha f) {
			
			if (salario>f.getSalario()) {
				return 1;
			}else if (salario<f.getSalario()) {
				return -1;
			}
			
			return 0;
		}*/

		public int compareTo(Ficha f) {

			if (salario<f.getSalario()) {
				return 1;
			}else if (salario>f.getSalario()) {
				return -1;
			}

			return 0;
		}
		

}
