package practfinal_java.io;

public class Planta {
	
	private String nombre, foto, descripcion;
	private int codigo,cod_planta, stock;
	private float precio;


	Planta(int codigo, String nombre, String foto, String descripcion) throws DatosInvalidosException {
		
		if (codigo < 1) throw new DatosInvalidosException("ID no puede estar vacío.");
	    if (nombre == null || nombre.isEmpty()) throw new DatosInvalidosException("Nombre obligatorio.");
	    if (foto == null || foto.isEmpty()) throw new DatosInvalidosException("Nombre obligatorio.");
	    if (descripcion == null || descripcion.isEmpty()) throw new DatosInvalidosException("Nombre obligatorio.");

		this.nombre = nombre;
		this.foto = foto;
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.stock = 0;
		this.precio = 0;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) throws Exception {
		 if (stock <= 0) throw new Exception ("Stock no puede ser negativo.");
	        this.stock = stock;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) throws Exception {
		if (precio <= 0) throw new Exception ("Stock no puede ser negativo.");
        this.precio = precio;
}
	


	public int getCod_planta() {
		return cod_planta;
	}


	public void setCod_planta(int cod_planta) {
		this.cod_planta = cod_planta;
	}

	
	public boolean hayStock(int id) {
		
		if (id==this.codigo&&this.stock==0) {
			return false;
		}
		
		return true;
	}
	
	public void dardeBaja(int id) throws Exception {
		if (id==this.codigo) {
			setPrecio(0);
			setStock(0);
		}
	}
	

	@Override
	public String toString() {
		return "Planta " + nombre + "\nFoto = " + foto + "\nDescripcion = " + descripcion + ",\nCodigo = " + codigo
				+ "\nStock = " + stock + "\nPrecio = " + precio +" euros\n\n";
	}
	
	

}
