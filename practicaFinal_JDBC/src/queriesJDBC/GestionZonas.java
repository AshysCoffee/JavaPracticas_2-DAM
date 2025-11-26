package queriesJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import modelosBases.Zona;

public class GestionZonas {

	private Connection conn;

	public GestionZonas(Connection conn) {
		this.conn = conn;
	}

	
////////////CRUD////////	
	
	public ArrayList<Zona> listarZonas() {
		ArrayList<Zona> lista = new ArrayList<>();
		String sql = "SELECT * FROM zona";
		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				lista.add(new Zona(rs.getInt("id_zona"), rs.getString("nombre"), rs.getString("descripcion")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Zona obtenerZonaPorId(int idZona) {
		Zona zona = null;
		String sql = "SELECT * FROM zona WHERE id_zona = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, idZona);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					zona = new Zona(rs.getInt("id_zona"), rs.getString("nombre"), rs.getString("descripcion"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zona;
	}
	
	
	public boolean agregarZona(Zona zona) {
		String sql = "INSERT INTO zona (nombre, descripcion) VALUES (?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, zona.getNombre());
			ps.setString(2, zona.getDescripcion());
			int filasAfectadas = ps.executeUpdate();
			return filasAfectadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean eliminarZona(int idZona) {
		String sql = "DELETE FROM zona WHERE id_zona = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, idZona);
			int filasAfectadas = ps.executeUpdate();
			return filasAfectadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	
}
