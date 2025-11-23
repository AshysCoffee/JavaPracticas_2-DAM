package queriesJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelosBases.Stock;


public class GestionStocks {

	    private Connection conn;

	    public GestionStocks(Connection conn) {
	        this.conn = conn;
	    }

	    // Obtener stock de un stand
	    public List<Stock> obtenerStockStand(int stand, int zona) {
	        List<Stock> lista = new ArrayList<>();
	        String querie = "SELECT * FROM stock WHERE stand_id=? AND zona_id=?";
	        try (PreparedStatement read = conn.prepareStatement(querie)) {

	            read.setInt(1, stand);
	            read.setInt(2, zona);

	            try (ResultSet rs = read.executeQuery()) {
	                while (rs.next()) {
	                    lista.add(new Stock(
	                            rs.getInt("stand_id"),
	                            rs.getInt("zona_id"),
	                            rs.getInt("juguete_id"),
	                            rs.getInt("cantidad")
	                    ));
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return lista;
	    }
	}


