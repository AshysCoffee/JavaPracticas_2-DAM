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

//////CRUD JUGUETES//////

	public boolean insertarJuguete(Juguete j) {
		String sql = "INSERT INTO juguete (nombre, descripcion, precio, cantidad_stock, categoria) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, j.getNombre());
			ps.setString(2, j.getDescripcion());
			ps.setDouble(3, j.getPrecio());
			ps.setInt(4, j.getCantidad_stock());
			ps.setString(5, j.getCategoria());

			if (ps.executeUpdate() == 0) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException e) {
			System.err.println("Hubo un error :" + e.getMessage());
			return false;
		}
	}

	public List<Juguete> listarJuguetes() {
		List<Juguete> lista = new ArrayList<>();
		String sql = "SELECT * FROM juguete";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					lista.add(new Juguete(rs.getInt("id_juguete"), rs.getString("nombre"), rs.getString("descripcion"),
							rs.getDouble("precio"), rs.getInt("cantidad_stock"), rs.getString("categoria")));

				}
			}

		} catch (SQLException e) {
			System.err.println("Hubo un error :" + e.getMessage());
		}
		return lista;
	}

	public boolean actualizarStock(int idJuguete, int nuevoStock) {
		String sql = "UPDATE juguete SET cantidad_stock = ? WHERE id_juguete = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, nuevoStock);
			ps.setInt(2, idJuguete);

			if (ps.executeUpdate() == 0) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException e) {
			System.err.println("Hubo un error :" + e.getMessage());
			return false;
		}
	}

	public boolean actualizarPrecio(int idJuguete, double nuevoPrecio) {
		String sql = "UPDATE juguete SET precio = ? WHERE id_juguete = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setDouble(1, nuevoPrecio);
			ps.setInt(2, idJuguete);

			if (ps.executeUpdate() == 0) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException e) {
			System.err.println("Hubo un error :" + e.getMessage());
			return false;
		}
	}

	public boolean eliminarJuguete(int id) {

		if (obtenerJuguetePorId(id) == null) {
			System.out.println("El juguete no existe.");
			return false;
		}

		GestionVentas gv = new GestionVentas(conn);
		GestionCambios gc = new GestionCambios(conn);

		try {

			gv.eliminarVentasDeJuguete(id);
			gc.eliminarCambiosDeJuguete(id);

			String sql = "DELETE FROM juguete WHERE id_juguete = ?";
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setInt(1, id);

				if (ps.executeUpdate() == 0) {
					return false;
				} else {
					return true;
				}

			}

		} catch (SQLException e) {
			System.err.println("Hubo un error :" + e.getMessage());
			return false;
		}
	}

	public int obtenerUltimoId() {
		String sql = "SELECT MAX(id_juguete) FROM juguete";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			System.err.println("Error al obtener ID: " + e.getMessage());
		}
		return -1;
	}
	
/////////OTRAS CONSULTAS////// --> SOLO UN JUGUETE POR STANDS

	public Juguete obtenerJuguetePorId(int id) {
		String sql = "SELECT * FROM juguete WHERE id_juguete=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Juguete(rs.getInt("id_juguete"), rs.getString("nombre"), rs.getString("descripcion"),
							rs.getDouble("precio"), rs.getInt("cantidad_stock"), rs.getString("categoria"));
				}
			}
		} catch (SQLException e) {
			System.err.println("Hubo un error :" + e.getMessage());
		}
		return null;
	}

	public List<Juguete> buscarJuguetesPorCategoria(String nombre) {
		List<Juguete> lista = new ArrayList<>();
		String sql = "SELECT * FROM juguete WHERE categoria LIKE ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + nombre + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					lista.add(new Juguete(rs.getInt("id_juguete"), rs.getString("nombre"), rs.getString("descripcion"),
							rs.getDouble("precio"), rs.getInt("cantidad_stock"), rs.getString("categoria")));
				}
			}
		} catch (SQLException e) {
			System.err.println("Hubo un error :" + e.getMessage());
		}
		return lista;
	}

	public List<Juguete> JuguetesRangoPrecio(double precioMin, double precioMax) {
		List<Juguete> lista = new ArrayList<>();
		String sql = "SELECT * FROM juguete WHERE precio BETWEEN ? AND ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setDouble(1, precioMin);
			ps.setDouble(2, precioMax);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					lista.add(new Juguete(rs.getInt("id_juguete"), rs.getString("nombre"), rs.getString("descripcion"),
							rs.getDouble("precio"), rs.getInt("cantidad_stock"), rs.getString("categoria")));
				}
			}
		} catch (SQLException e) {
			System.err.println("Hubo un error :" + e.getMessage());
		}
		return lista;

	}

	public List<Juguete> JuguetesPorPrecioAsc() {
		List<Juguete> lista = new ArrayList<>();
		String sql = "SELECT * FROM juguete ORDER BY precio ASC";
		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				lista.add(new Juguete(rs.getInt("id_juguete"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getDouble("precio"), rs.getInt("cantidad_stock"), rs.getString("categoria")));
			}

		} catch (SQLException e) {
			System.err.println("Hubo un error :" + e.getMessage());
		}
		return lista;
	}

	public List<Juguete> JuguetesPorPrecioDes() {
		List<Juguete> lista = new ArrayList<>();
		String sql = "SELECT * FROM juguete ORDER BY precio DESC";
		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				lista.add(new Juguete(rs.getInt("id_juguete"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getDouble("precio"), rs.getInt("cantidad_stock"), rs.getString("categoria")));
			}
		} catch (SQLException e) {
			System.err.println("Hubo un error :" + e.getMessage());
		}
		return lista;
	}

	public List<String> obtenerInfoJuguete(int id) {
		List<String> inventario = new ArrayList<>();

		String sql = "SELECT * FROM stock where juguete_id = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					rs.getInt("juguete_id");
					rs.getInt("stand_id");
					rs.getInt("zona_id");
					rs.getInt("cantidad");
					
					inventario.add("Juguete ID: " + rs.getInt("juguete_id") + ", Stand ID: " + rs.getInt("stand_id")
							+ ", Zona ID: " + rs.getInt("zona_id") + ", Cantidad: " + rs.getInt("cantidad") );
					
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar en stand: " + e.getMessage());
		}
		return inventario;
	}

	public List<String> obtenerCategorias() {
		List<String> categorias = new ArrayList<>();

		String sql = "SELECT DISTINCT categoria FROM juguete";

		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				categorias.add(rs.getString("categoria"));
			}
		} catch (SQLException e) {
			System.err.println("Hubo un error :" + e.getMessage());
		}
		return categorias;
	}

}
