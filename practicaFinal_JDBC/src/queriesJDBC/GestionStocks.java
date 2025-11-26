package queriesJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelosBases.Stock;

public class GestionStocks {

	private Connection conn;

	public GestionStocks(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<Stock> obtenerStockStand(int stand, int zona) {
		ArrayList<Stock> lista = new ArrayList<>();
		String querie = "SELECT * FROM stock WHERE stand_id=? AND zona_id=?";
		try (PreparedStatement read = conn.prepareStatement(querie)) {

			read.setInt(1, stand);
			read.setInt(2, zona);

			try (ResultSet rs = read.executeQuery()) {
				while (rs.next()) {
					lista.add(new Stock(rs.getInt("stand_id"), rs.getInt("zona_id"), rs.getInt("juguete_id"),
							rs.getInt("cantidad")));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public ArrayList<Stock> StockJuguete(int id) {

		ArrayList<Stock> lista = new ArrayList<>();
		String querie = "SELECT * FROM stock WHERE juguete_id=?";
		try (PreparedStatement read = conn.prepareStatement(querie)) {

			read.setInt(1, id);

			try (ResultSet rs = read.executeQuery()) {
				while (rs.next()) {
					lista.add(new Stock(rs.getInt("stand_id"), rs.getInt("zona_id"), rs.getInt("juguete_id"),
							rs.getInt("cantidad")));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void actualizarStock(int standId, int zonaId, int jugueteId, int nuevaCantidad) {
		String querie = "UPDATE stock SET cantidad = ? WHERE stand_id = ? AND zona_id = ? AND juguete_id = ?";
		try (PreparedStatement update = conn.prepareStatement(querie)) {

			update.setInt(1, nuevaCantidad);
			update.setInt(2, standId);
			update.setInt(3, zonaId);
			update.setInt(4, jugueteId);

			update.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
