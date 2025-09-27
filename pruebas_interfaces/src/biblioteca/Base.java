 package biblioteca;

public abstract class Base{

	private String titulo, ISBN, fecha_edicion;
	
	public Base(String titulo, String iSBN, String fecha_edicion) {
		super();
		this.titulo = titulo;
		ISBN = iSBN;
		this.fecha_edicion = fecha_edicion;
	}

	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setFechaEdicion(String fecha_edicion) {
		this.fecha_edicion=fecha_edicion;
	}
	
	public String getFechaEdicion(){
		return fecha_edicion;
	}
	
	
	public void setISBN(String ISBN) {
		this.ISBN=ISBN;
	}
	
	public String getISBN(){
		return ISBN;
	}
	
	
	public String toString() {
		String s;
		s=("Titulo: "+titulo+"\n");
		s+=("ISBN: "+ISBN+"\n");
		s+=("Fecha: "+fecha_edicion+"\n");
		
		return s;
		
	}	

}
