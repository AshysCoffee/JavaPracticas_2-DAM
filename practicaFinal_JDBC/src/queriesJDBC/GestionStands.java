package queriesJDBC;

import java.sql.Connection;
import java.util.ArrayList;

import modelosBases.Stand;

public class GestionStands {
	
	private Connection conn;

	public GestionStands(Connection conn) {
		this.conn = conn;
	}

	
//////////QUERIES BUSQUEDAA/////////
	
	public ArrayList<Stand> listarStands() {
		ArrayList<Stand> lista = new ArrayList<>();
		String querie = "SELECT * FROM stands";
		try (var read = conn.prepareStatement(querie);
				var rs = read.executeQuery()) {

			while (rs.next()) {
				lista.add(new Stand(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("zona_id")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public ArrayList<Stand> StandsporZona() {
		ArrayList<Stand> lista = new ArrayList<>();
		String querie = "SELECT * FROM stands ORDER BY zona_id";
		try (var read = conn.prepareStatement(querie);
				var rs = read.executeQuery()) {

			while (rs.next()) {
				lista.add(new Stand(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("zona_id")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
		
	}

	
	public Stand StandporId() {
		Stand stand = null;
		String querie = "SELECT * FROM stands WHERE id=?";
		try (var read = conn.prepareStatement(querie)) {

			read.setInt(1, 1); // Ejemplo con id=1

			try (var rs = read.executeQuery()) {
				if (rs.next()) {
					stand = new Stand(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("zona_id"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stand;
	}

	
}
