package queriesJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelosBases.Juguete;

public class GestionJuguetes {

	private Connection conn;

	public GestionJuguetes(Connection conn) {
		this.conn = conn;
	}

	public boolean insertarJuguete(Juguete j) {
		String querie = "INSERT INTO juguete VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement create = conn.prepareStatement(querie)) {
			create.setInt(1, j.getId_juguete());
			create.setString(2, j.getNombre());
			create.setString(3, j.getDescripcion());
			create.setDouble(4, j.getPrecio());
			create.setInt(5, j.getCantidad_stock());
			return create.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Juguete> listarJuguetes() {
		List<Juguete> lista = new ArrayList<>();
		String querie = "SELECT * FROM juguete";

		try (PreparedStatement read = conn.prepareStatement(querie); ResultSet rs = read.executeQuery()) {

			while (rs.next()) {
				lista.add(new Juguete(rs.getInt("id_juguete"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getDouble("precio"), rs.getInt("cantidad_stock")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public boolean actualizarJuguete(Juguete j) {
		String querie = "UPDATE juguete SET nombre=?, descripcion=?, precio=?, cantidad_stock=? WHERE id_juguete=?";
		try (PreparedStatement update = conn.prepareStatement(querie)) {
			update.setString(1, j.getNombre());
			update.setString(2, j.getDescripcion());
			update.setDouble(3, j.getPrecio());
			update.setInt(4, j.getCantidad_stock());
			update.setInt(5, j.getId_juguete());
			return update.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean eliminarJuguete(int id) {
		String querie = "DELETE FROM juguete WHERE id_juguete=?";
		try (PreparedStatement delete = conn.prepareStatement(querie)) {
			delete.setInt(1, id);
			return delete.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
