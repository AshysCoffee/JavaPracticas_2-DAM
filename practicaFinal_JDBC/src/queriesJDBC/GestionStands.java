package queriesJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelosBases.Stand;

public class GestionStands {
	
	private Connection conn;

	public GestionStands(Connection conn) {
		this.conn = conn;
	}

	
	public boolean insertarStand(Stand s) {
		String sql = "INSERT INTO stand (id_stand, nombre, descripcion, zona_id"+
				"VALUES (?, ?, ?, ?)";

		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, s.getId_stand());
			ps.setString(2, s.getNombre());
			ps.setString(3, s.getDescripcion());
			ps.setInt(4, s.getId_zona());
	
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
	
//////////sqlS BUSQUEDAA/////////
	
	public List<Stand> listarStands() {
		List<Stand> lista = new ArrayList<>();
		String sql = "SELECT * FROM stand";
		try (PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				lista.add(new Stand(rs.getInt("id_stand"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("zona_id")));
			}

		} catch (Exception e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return lista;
	}
	
	public List<Stand> StandsporZona() {
		List<Stand> lista = new ArrayList<>();
		String sql = "SELECT * FROM stand ORDER BY zona_id";
		try (PreparedStatement ps = conn.prepareStatement(sql);
				var rs = ps.executeQuery()) {

			while (rs.next()) {
				lista.add(new Stand(rs.getInt("id_stand"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("zona_id")));
			}

		} catch (Exception e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return lista;
		
	}

	
	public Stand StandporId(int id) {
		Stand stand = null;
		String sql = "SELECT * FROM stand WHERE id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id); 

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					stand = new Stand(rs.getInt("id_stand"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("zona_id"));
				}
			}

		} catch (Exception e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return stand;
	}

	
}
