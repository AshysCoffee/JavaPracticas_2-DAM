package modelosBases;

public class Stock {
	
	private int id_stand;
	private int id_zona;
	private int id_juguete;
	private int cantidad_disponible;
	
	public Stock(int id_stand, int id_zona, int id_juguete, int cantidad_disponible) {
		this.id_stand = id_stand;
		this.id_zona = id_zona;
		this.id_juguete = id_juguete;
		this.cantidad_disponible = cantidad_disponible;
	}

	public Stock(int id_stand, int id_zona) {
		this.id_stand = id_stand;
		this.id_zona = id_zona;
	}

	public int getId_stand() {
		return id_stand;
	}

	public void setId_stand(int id_stand) {
		this.id_stand = id_stand;
	}

	public int getId_zona() {
		return id_zona;
	}

	public void setId_zona(int id_zona) {
		this.id_zona = id_zona;
	}

	public int getId_juguete() {
		return id_juguete;
	}

	public void setId_juguete(int id_juguete) {
		this.id_juguete = id_juguete;
	}

	public int getCantidad_disponible() {
		return cantidad_disponible;
	}

	public void setCantidad_disponible(int cantidad_disponible) {
		this.cantidad_disponible = cantidad_disponible;
	}

	@Override
	public String toString() {
		return "Stock " + id_stand + ", ID Zona: " + id_zona + ", ID Juguete: " + id_juguete
				+ ", Stock: " + cantidad_disponible + "]";
	}

	
	
	
	
	
}
