package queriesJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelosBases.Cambio;

public class GestionCambios {
	
	private Connection conn;

	public GestionCambios(Connection conn) {
		this.conn = conn;
	}

	
	////////CRUD///////////	
	
	public boolean insertarCambio(Cambio c) {
		String sql = "INSERT INTO cambio (id_cambio, motivo, fecha, stand_id_original, zona_id_original, juguete_id_original,"+
				"stand_id_nuevo, zona_id_nuevo, juguete_id_nuevo, empleado_id)"+
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, c.getId_cambio());
			ps.setString(2, c.getMotivo());
			ps.setDate(3, Date.valueOf(c.getFecha()));
			ps.setInt(4, c.getStandOrigen());
			ps.setInt(5, c.getZonaOrigen());
			ps.setInt(6, c.getJugueteOriginal());
			ps.setInt(7, c.getStandDestino());
			ps.setInt(8, c.getZonaDestino());
			ps.setInt(9, c.getJugueteNuevo());
			ps.setInt(10, c.getId_empleado());

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
	
	public boolean eliminarCambio(int idCambio) {
		String sql = "DELETE FROM cambio WHERE id_cambio = ?";
		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, idCambio);
			
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

	public void actualizarCambio(Cambio c) {
		String sql = """
				UPDATE cambio SET motivo = ?, fecha = ?, stand_id_original = ?, zona_id_original = ?,
				juguete_id_original = ?, stand_id_nuevo = ?, zona_id_nuevo = ?, juguete_id_nuevo = ?,
				empleado_id = ? WHERE id_cambio = ?
				""";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, c.getMotivo());
			ps.setDate(2, Date.valueOf(c.getFecha()));
			ps.setInt(3, c.getStandOrigen());
			ps.setInt(4, c.getZonaOrigen());
			ps.setInt(5, c.getJugueteOriginal());
			ps.setInt(6, c.getStandDestino());
			ps.setInt(7, c.getZonaDestino());
			ps.setInt(8, c.getJugueteNuevo());
			ps.setInt(9, c.getId_empleado());
			ps.setInt(10, c.getId_cambio());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
	}

	public Cambio obtenerCambioPorId(int idCambio) {
		String sql = "SELECT * FROM cambio WHERE id_cambio = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, idCambio);

			var rs = ps.executeQuery();
			if (rs.next()) {
				return new Cambio(rs.getInt("id_cambio"), rs.getInt("juguete_id_original"), rs.getDate("fecha").toLocalDate(),
						rs.getInt("stand_id_original"), rs.getInt("zona_id_original"), rs.getString("motivo"),
						rs.getInt("stand_id_nuevo"), rs.getInt("zona_id_nuevo"), rs.getInt("juguete_id_nuevo"),
						rs.getInt("empleado_id"));
			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return null;
	}


	//////////OTRAS CONSULTAS////////	
	
	public List<Cambio> obtenerTodosLosCambios() {
		List<Cambio> cambios = new ArrayList<>();
		String sql = "SELECT * FROM cambio";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			var rs = ps.executeQuery();
			while (rs.next()) {
				Cambio c = new Cambio(rs.getInt("id_cambio"), rs.getInt("juguete_id_original"), rs.getDate("fecha").toLocalDate(),
						rs.getInt("stand_id_original"), rs.getInt("zona_id_original"), rs.getString("motivo"),
						rs.getInt("stand_id_nuevo"), rs.getInt("zona_id_nuevo"), rs.getInt("juguete_id_nuevo"),
						rs.getInt("empleado_id"));
				cambios.add(c);
			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return cambios;
	}
	
	
	public List<Cambio> obtenerCambiosPorEmpleado(int empleadoId) {
		List<Cambio> cambios = new ArrayList<>();
		String sql = "SELECT * FROM cambio WHERE empleado_id = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, empleadoId);

			var rs = ps.executeQuery();
			while (rs.next()) {
				Cambio c = new Cambio(rs.getInt("id_cambio"), rs.getInt("juguete_id_original"), rs.getDate("fecha").toLocalDate(),
						rs.getInt("stand_id_original"), rs.getInt("zona_id_original"), rs.getString("motivo"),
						rs.getInt("stand_id_nuevo"), rs.getInt("zona_id_nuevo"), rs.getInt("juguete_id_nuevo"),
						rs.getInt("empleado_id"));
				cambios.add(c);
			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return cambios;
	}


	public boolean eliminarCambiosDeJuguete(int id) {
		
		String sql = "DELETE FROM cambio WHERE juguete_id_nuevo = ? OR juguete_id_original = ?";
		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.setInt(2, id);
			
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
	
	
	public boolean eliminarCambiosDeEmpleado(int empleadoId) {
		String sql = "DELETE FROM cambio WHERE empleado_id = ?";
		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, empleadoId);
			
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
	
}
