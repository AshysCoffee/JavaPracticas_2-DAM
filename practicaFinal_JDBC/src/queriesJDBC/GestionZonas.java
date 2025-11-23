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
}
