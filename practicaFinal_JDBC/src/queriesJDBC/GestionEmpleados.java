package queriesJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import modelosBases.Cargo;
import modelosBases.Empleado;
import modelosBases.Venta;

public class GestionEmpleados {

	private Connection conn;

	public GestionEmpleados(Connection conn) {
		this.conn = conn;
	}


///////CRUD///////	
	
	public boolean insertarEmpleado(Empleado emp) {
		String sql = "INSERT INTO empleado (nombre, cargo, fecha_ingreso) VALUES (?, ?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, emp.getNombre());
			ps.setString(2, emp.getCargo().name());
			ps.setDate(3, Date.valueOf(emp.getFechaIngreso()));

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

	public List<Empleado> listarEmpleados() {
		List<Empleado> lista = new ArrayList<>();
		String sql = "SELECT * FROM empleado";

		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				Cargo cargo = Cargo.valueOf(rs.getString("cargo"));

				Empleado emp = new Empleado(rs.getInt("id_empleado"), rs.getString("nombre"), cargo, rs.getDate("fecha_ingreso").toLocalDate());
				lista.add(emp);
			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return lista;
	}

	public boolean actualizarEmpleado(Empleado emp) {
		String sql = "UPDATE empleado SET nombre=?, cargo=?, fecha_ingreso=? WHERE id_empleado=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, emp.getNombre());
			ps.setString(2, emp.getCargo().name());
			ps.setDate(3, Date.valueOf(emp.getFechaIngreso()));
			ps.setInt(4, emp.getIdEmpleado());

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

	public boolean eliminarEmpleado(int id) {

		if (obtenerEmpleadoPorId(id) == null) {
			System.out.println("El empleado no existe.");
			return false;
		}

		GestionVentas gv = new GestionVentas(conn);
		GestionCambios gc = new GestionCambios(conn);

		try {

			gv.eliminarVentasDeEmpleado(id);
			gc.eliminarCambiosDeEmpleado(id);

			String sql = "DELETE FROM empleado WHERE id_empleado = ?";
			try (PreparedStatement ps = conn.prepareStatement(sql)) {

				ps.setInt(1, id);

				if (ps.executeUpdate() == 0) {
					return false;
				} else {
					return true;
				}

			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
			return false;
		}
	}
	
////////////OTRAS CONSULTAS////////	
	
	public Empleado obtenerEmpleadoPorId(int id) {
		String sql = "SELECT * FROM empleado WHERE id_empleado = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Cargo cargo = Cargo.valueOf(rs.getString("cargo"));
					return new Empleado(rs.getInt("id_empleado"), rs.getString("nombre"), cargo, rs.getDate("fecha_ingreso").toLocalDate());
				}
			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return null;
	}	
  
	public List<Empleado> obtenerEmpleadosPorCargo(Cargo cargo) {
		List<Empleado> lista = new ArrayList<>();
		String sql = "SELECT * FROM empleado WHERE cargo = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, cargo.name());
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Empleado emp = new Empleado(rs.getInt("id_empleado"), rs.getString("nombre"),
							cargo, rs.getDate("fecha_ingreso").toLocalDate());
					lista.add(emp);
				}
			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return lista;
	}


	
}
