package queriesJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelosBases.TipoPago;
import modelosBases.Venta;

public class GestionVentas {

	private Connection conn;

	public GestionVentas(Connection conn) {
		this.conn = conn;
	}

	
	////////CRUD//////////	
	
	public boolean registrarVenta(Venta v) {
		String sql = "INSERT INTO venta (fecha, monto, tipo_pago, empleado_id, stand_id, zona_id, juguete_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setDate(1, Date.valueOf(v.getFecha()));
			ps.setDouble(2, v.getImporte());
			ps.setString(3, v.getTipoPago().name());
			ps.setInt(4, v.getId_empleado());
			ps.setInt(5, v.getId_stand());
			ps.setInt(6, v.getId_zona());
			ps.setInt(7, v.getId_juguete());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean eliminarVenta(int ventaId) {
		String sql = "DELETE FROM venta WHERE id = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, ventaId);
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean actualizarVenta(Venta v) {
		String sql = "UPDATE venta SET fecha = ?, monto = ?, tipo_pago = ?, empleado_id = ?, stand_id = ?, zona_id = ?, juguete_id = ? WHERE id = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setDate(1, Date.valueOf(v.getFecha()));
			ps.setDouble(2, v.getImporte());
			ps.setString(3, v.getTipoPago().name());
			ps.setInt(4, v.getId_empleado());
			ps.setInt(5, v.getId_stand());
			ps.setInt(6, v.getId_zona());
			ps.setInt(7, v.getId_juguete());
			ps.setInt(8, v.getId_venta());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Venta obtenerVentaPorId(int ventaId) {
		String sql = "SELECT * FROM venta WHERE id = ?";
		Venta v = null;

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, ventaId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				v = new Venta();
				v.setId_venta(rs.getInt("id"));
				v.setFecha(rs.getDate("fecha").toLocalDate());
				v.setImporte(rs.getDouble("monto"));
				v.setTipoPago(TipoPago.valueOf(rs.getString("tipo_pago")));
				v.setId_empleado(rs.getInt("empleado_id"));
				v.setId_stand(rs.getInt("stand_id"));
				v.setId_zona(rs.getInt("zona_id"));
				v.setId_juguete(rs.getInt("juguete_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return v;
	}
	
	
	/////////CONSULTAS//////////
	
	public ArrayList<Venta> VentasPorEmpleado(int empleadoId) {
		ArrayList<Venta> ventas = new ArrayList<>();
		String sql = "SELECT * FROM venta WHERE empleado_id = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, empleadoId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Venta v = new Venta();
				v.setId_venta(rs.getInt("id"));
				v.setFecha(rs.getDate("fecha").toLocalDate());
				v.setImporte(rs.getDouble("monto"));
				v.setTipoPago(TipoPago.valueOf(rs.getString("tipo_pago")));
				v.setId_empleado(rs.getInt("empleado_id"));
				v.setId_stand(rs.getInt("stand_id"));
				v.setId_zona(rs.getInt("zona_id"));
				v.setId_juguete(rs.getInt("juguete_id"));

				ventas.add(v);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ventas;
	}

	public ArrayList<Venta> VentasPorFecha(Date fecha) {
		ArrayList<Venta> ventas = new ArrayList<>();
		String sql = "SELECT * FROM venta WHERE fecha = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setDate(1, fecha);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Venta v = new Venta();
				v.setId_venta(rs.getInt("id"));
				v.setFecha(rs.getDate("fecha").toLocalDate());
				v.setImporte(rs.getDouble("monto"));
				v.setTipoPago(TipoPago.valueOf(rs.getString("tipo_pago")));
				v.setId_empleado(rs.getInt("empleado_id"));
				v.setId_stand(rs.getInt("stand_id"));
				v.setId_zona(rs.getInt("zona_id"));
				v.setId_juguete(rs.getInt("juguete_id"));

				ventas.add(v);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ventas;
	}

	public ArrayList<Venta> VentasPorMes(int mes) {
		ArrayList<Venta> ventas = new ArrayList<>();
		String sql = "SELECT * FROM venta WHERE MONTH(fecha) = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, mes);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Venta v = new Venta();
				v.setId_venta(rs.getInt("id"));
				v.setFecha(rs.getDate("fecha").toLocalDate());
				v.setImporte(rs.getDouble("monto"));
				v.setTipoPago(TipoPago.valueOf(rs.getString("tipo_pago")));
				v.setId_empleado(rs.getInt("empleado_id"));
				v.setId_stand(rs.getInt("stand_id"));
				v.setId_zona(rs.getInt("zona_id"));
				v.setId_juguete(rs.getInt("juguete_id"));
				ventas.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ventas;
	}

	public ArrayList<Venta> Top5JuguetesMasVendidos() {
		ArrayList<Venta> ventas = new ArrayList<>();
		String sql = "SELECT juguete_id, COUNT(*) AS total_ventas FROM venta GROUP BY juguete_id ORDER BY total_ventas DESC LIMIT 5";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Venta v = new Venta();
				v.setId_juguete(rs.getInt("juguete_id"));
				// Aquí podrías agregar un campo adicional en la clase Venta para almacenar
				// total_ventas si lo deseas
				ventas.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ventas;
	}

	public ArrayList<Venta> EmpleadosQueMasVenden() {
		ArrayList<Venta> ventas = new ArrayList<>();
		String sql = "SELECT empleado_id, SUM(monto) AS total_ventas FROM venta GROUP BY empleado_id ORDER BY total_ventas DESC";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Venta v = new Venta();
				v.setId_empleado(rs.getInt("empleado_id"));
				// Aquí podrías agregar un campo adicional en la clase Venta para almacenar
				// total_ventas si lo deseas
				ventas.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ventas;
	}

}