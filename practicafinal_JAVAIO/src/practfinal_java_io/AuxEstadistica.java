package practfinal_java_io;

public class AuxEstadistica {

	int id;
	int cantidadTotal;

    AuxEstadistica(int id, int cantidad) {
        this.id = id;
        this.cantidadTotal = cantidad;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}
	
    
    
}
