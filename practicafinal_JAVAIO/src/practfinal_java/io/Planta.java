package practfinal_java.io;

public class Planta {
	
	private String nombre, foto, descripcion;
	private int codigo, stock;
	private float precio;


	public Planta(int codigo, String nombre, String foto, String descripcion) throws DatosInvalidosException {
		
		if (codigo <=20) throw new DatosInvalidosException("Ese ID no es disponible.");
	    if (nombre == null || nombre.trim().isEmpty()) throw new DatosInvalidosException("Nombre obligatorio.");
	    if (foto == null || foto.isEmpty()) throw new DatosInvalidosException("Foto obligatoria.");
	    if (descripcion == null || descripcion.isEmpty()) throw new DatosInvalidosException("Descripción obligatoria.");
	    
		this.nombre = nombre;
		this.foto = foto;
		this.descripcion = descripcion;
		this.codigo = codigo;

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


	public void setStock(int stock) throws DatosInvalidosException {
		 if (stock < 0) throw new DatosInvalidosException ("Stock no puede ser negativo.");
		 this.stock = stock;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) throws DatosInvalidosException {
		if (precio < 0) throw new DatosInvalidosException ("El precio no puede ser negativo.");
			this.precio = precio;
        
	}


	public boolean hayStock() {
	    return this.stock > 0;
	}

	
	public boolean estaActiva() {
	    return this.stock > 0 || this.precio > 0;
	}

	public boolean estaDadaDeBaja() {
	    return this.precio == 0 && this.stock == 0;
	}
	

	public String toString() {
		return "Planta " + nombre + "\nFoto = " + foto + "\nDescripcion = " + descripcion;
	}
	

}
