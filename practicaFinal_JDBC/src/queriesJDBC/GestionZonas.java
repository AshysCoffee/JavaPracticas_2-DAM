package queriesJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelosBases.Zona;

public class GestionZonas {

	private Connection conn;

	public GestionZonas(Connection conn) {
		this.conn = conn;
	}

	
////////////CRUD////////	
	
	public List<Zona> listarZonas() {
		List<Zona> lista = new ArrayList<>();
		String sql = "SELECT * FROM zona";
		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				lista.add(new Zona(rs.getInt("id_zona"), rs.getString("nombre"), rs.getString("descripcion")));
			}
		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return lista;
	}
	
	
	public boolean agregarZona(Zona zona) {
		String sql = "INSERT INTO zona (nombre, descripcion) VALUES (?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, zona.getNombre());
			ps.setString(2, zona.getDescripcion());

			if (ps.executeUpdate() == 0) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
			return false;
		}
	}
	
	public boolean actualizarZona(Zona zona) {
		String sql = "UPDATE zona SET nombre = ?, descripcion = ? WHERE id_zona = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, zona.getNombre());
			ps.setString(2, zona.getDescripcion());
			ps.setInt(3, zona.getId_zona());
			
			if (ps.executeUpdate()==0) {
				return false;
			}else {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
			return false;
		}
	}
	
	
	public boolean eliminarZona(int idZona) {
		String sql = "DELETE FROM zona WHERE id_zona = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, idZona);
			
			if (ps.executeUpdate()==0) {
				return false;
			}else {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
			return false;
		}
	}
	

/////////OTRAS CONSULTAS////////	
	
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
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return zona;
	}
	
	
}
