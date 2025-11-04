package practfinal_java.io;

public class Planta {
	
	private String nombre, foto, descripcion;
	private int codigo,cod_planta, stock;
	private float precio;


	Planta(int codigo, String nombre, String foto, String descripcion) throws DatosInvalidosException {
		
		if (codigo < 1) throw new DatosInvalidosException("ID no puede estar vacío.");
	    if (nombre == null || nombre.isEmpty()) throw new DatosInvalidosException("Nombre obligatorio.");
	    if (foto == null || foto.isEmpty()) throw new DatosInvalidosException("Foto obligatoria.");
	    if (descripcion == null || descripcion.isEmpty()) throw new DatosInvalidosException("Descripción obligatoria.");

		this.nombre = nombre;
		this.foto = foto;
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.stock = 0;
		this.precio = 0;
	}
	
	Planta(int codigo, String nombre, String foto, String descripcion, int stock, float precio) throws DatosInvalidosException {

		if (codigo < 1) throw new DatosInvalidosException("ID no puede estar vacío.");
		if (nombre == null || nombre.isEmpty()) throw new DatosInvalidosException("Nombre obligatorio.");
		if (foto == null || foto.isEmpty()) throw new DatosInvalidosException("Foto obligatoria.");
		if (descripcion == null || descripcion.isEmpty()) throw new DatosInvalidosException("Descripción obligatoria.");
		if (stock < 1) throw new DatosInvalidosException("El stock no puede ser nulo");
		if (precio < 0) throw new DatosInvalidosException("El precio debe ser mayor a 0");

		this.nombre = nombre;
		this.foto = foto;
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.stock = stock;
		this.precio = precio;
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
		 if (stock <= 0) throw new DatosInvalidosException ("Stock no puede ser negativo.");
	        
		 this.stock = stock;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) throws DatosInvalidosException {
		if (precio < 0) throw new DatosInvalidosException ("El precio no puede ser negativo.");
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
	
	public void darDeBaja(int id) throws DatosInvalidosException {
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
