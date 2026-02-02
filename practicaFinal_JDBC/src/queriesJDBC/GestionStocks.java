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

	public boolean insertarStock(Stock s) {
		String sql = "INSERT INTO stock (stand_id, zona_id, juguete_id, cantidad)"+
				"VALUES (?, ?, ?, ?)";

		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, s.getId_stand());
			ps.setInt(2, s.getId_zona());
			ps.setInt(3, s.getId_juguete());
			ps.setInt(4, s.getCantidad_disponible());
	
			if (ps.executeUpdate() == 0) {
				return false;
			}else{
				return true;
			}
			
			

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
			return false;
		}
	}
	
	public List<Stock> stockJuguete(int id) {

		List<Stock> lista = new ArrayList<>();
		String sql = "SELECT * FROM stock WHERE juguete_id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					lista.add(new Stock(rs.getInt("stand_id"), rs.getInt("zona_id"), rs.getInt("juguete_id"),
							rs.getInt("cantidad")));
				}
			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return lista;
	}
	
	public boolean actualizarStock(int standId, int zonaId, int jugueteId, int nuevaCantidad) {
		String sql = "UPDATE stock SET cantidad = ? WHERE stand_id = ? AND zona_id = ? AND juguete_id = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, nuevaCantidad);
			ps.setInt(2, standId);
			ps.setInt(3, zonaId);
			ps.setInt(4, jugueteId);

			if (ps.executeUpdate()==0) {
				return false;
			}else {
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		
		return false;
	}

	public List<String> obtenerJuguetesEnStand(int id) {
		   
		List<String> inventario = new ArrayList<>();
	    
	    String sql = "SELECT j.nombre, s.cantidad FROM stock s " +
	                 "JOIN juguete j ON s.juguete_id = j.id_juguete " + 
	                 "WHERE s.stand_id = ?"; 
	    
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, id);
	        
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                String nombre = rs.getString("nombre");
	                int cantidad = rs.getInt("cantidad");
	                inventario.add(nombre + " - Stock: " + cantidad);
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al buscar en stand: " + e.getMessage());
	    }
	    return inventario;
	}

	public Stock obtenerStockdelStand(int stand, int zona, int juguete) {
		String sql = "SELECT * FROM stock WHERE stand_id=? AND zona_id=? AND juguete_id =?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, stand);
			ps.setInt(2, zona);
			ps.setInt(3, juguete);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					return new Stock(rs.getInt("stand_id"), rs.getInt("zona_id"), rs.getInt("juguete_id"), rs.getInt("cantidad"));
				}
			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return null;

	}
	
	
}
