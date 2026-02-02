package queriesJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelosBases.TipoPago;
import modelosBases.Venta;

public class GestionVentas {

	private Connection conn;

	public GestionVentas(Connection conn) {
		this.conn = conn;
	}

	
	////////CRUD//////////	
	
	public boolean registrarVenta(Venta v) {
		String sql = "INSERT INTO venta (fecha ,monto, tipo_pago, empleado_id, stand_id, zona_id, juguete_id, cantidad, cliente)"+
	"VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setDate(1, Date.valueOf(v.getFecha()));
			ps.setDouble(2, v.getImporte());
			ps.setString(3, v.getTipoPago().name());
			ps.setInt(4, v.getId_empleado());
			ps.setInt(5, v.getId_stand());
			ps.setInt(6, v.getId_zona());
			ps.setInt(7, v.getId_juguete());
			ps.setInt(8, v.getCantidad());
			ps.setString(9, v.getCliente());

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
	
	public boolean eliminarVenta(int ventaId) {
		String sql = "DELETE FROM venta WHERE id_venta = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, ventaId);
			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
			return false;
		}
	}
		
	public boolean eliminarVentasDeJuguete(int jugueteId) {
		
		String sql = "DELETE FROM venta WHERE juguete_id= ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, jugueteId);
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
		
	public boolean eliminarVentasDeEmpleado(int empleadoId) {
		String sql = "DELETE FROM venta WHERE empleado_id = ?";

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
	
	public boolean actualizarVenta(Venta v) {
		String sql = "UPDATE venta SET fecha = ?, monto = ?, tipo_pago = ?, empleado_id = ?, stand_id = ?, zona_id = ?, juguete_id = ?, cantidad = ?, cliente = ? WHERE id_venta = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setDate(1, Date.valueOf(v.getFecha()));
			ps.setDouble(2, v.getImporte());
			ps.setString(3, v.getTipoPago().name());
			ps.setInt(4, v.getId_empleado());
			ps.setInt(5, v.getId_stand());
			ps.setInt(6, v.getId_zona());
			ps.setInt(7, v.getId_juguete());
			ps.setInt(8, v.getCantidad());
			ps.setString(9, v.getCliente());
			

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
			return false;
		}
	}
	
	public Venta obtenerVentaPorId(int ventaId) {
		String sql = "SELECT * FROM venta WHERE id_venta = ?";
		Venta v = null;

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, ventaId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				v = new Venta();
				v.setId_venta(rs.getInt("id_venta"));
				v.setFecha(rs.getDate("fecha").toLocalDate());
				v.setImporte(rs.getDouble("monto"));
				v.setTipoPago(TipoPago.valueOf(rs.getString("tipo_pago")));
				v.setId_empleado(rs.getInt("empleado_id"));
				v.setId_stand(rs.getInt("stand_id"));
				v.setId_zona(rs.getInt("zona_id"));
				v.setId_juguete(rs.getInt("juguete_id"));
				v.setCantidad(rs.getInt("cantidad"));
				v.setCliente(rs.getString("cliente"));
			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}

		return v;
	}
	
	public Venta buscarVentaPorId(int ventaId) {
		String sql = "SELECT * FROM venta WHERE id_venta = ?";
		Venta v = null;

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, ventaId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				v = new Venta();
				v.setId_venta(rs.getInt("id_venta"));
				v.setFecha(rs.getDate("fecha").toLocalDate());
				v.setImporte(rs.getDouble("monto"));
				v.setTipoPago(TipoPago.valueOf(rs.getString("tipo_pago")));
				v.setId_empleado(rs.getInt("empleado_id"));
				v.setId_stand(rs.getInt("stand_id"));
				v.setId_zona(rs.getInt("zona_id"));
				v.setId_juguete(rs.getInt("juguete_id"));
				v.setCantidad(rs.getInt("cantidad"));
				v.setCliente(rs.getString("cliente"));
			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}

		return v;
	}
	
	
	////////OTRAS CONSULTAS//////////

	public List<Venta> todasVentas() {
	    List<Venta> ventas = new ArrayList<>();
	    String sql = "SELECT * FROM venta";

	    try (PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            Venta v = new Venta();
	            v.setId_venta(rs.getInt("id_venta"));
	            
	            Date fechaSQL = rs.getDate("fecha");
	            if (fechaSQL != null) {
	                v.setFecha(fechaSQL.toLocalDate());
	            }

	            v.setImporte(rs.getDouble("monto"));

	            String pagoString = rs.getString("tipo_pago");
	            if (pagoString != null) {
	                try {
	                    v.setTipoPago(TipoPago.valueOf(pagoString));
	                } catch (IllegalArgumentException e) {
	                    System.err.println("Tipo de pago desconocido: " + pagoString);
	                }
	            }

	            v.setId_empleado(rs.getInt("empleado_id"));
	            v.setId_stand(rs.getInt("stand_id"));
	            v.setId_zona(rs.getInt("zona_id"));
	            v.setId_juguete(rs.getInt("juguete_id"));
	            v.setCantidad(rs.getInt("cantidad"));
				v.setCliente(rs.getString("cliente"));

	            ventas.add(v);
	        }

	    } catch (SQLException e) {
	        System.out.println("Hubo un error :"+e.getMessage());
	    }
	    return ventas;
	}
	
	
	public List<Venta> VentasPorEmpleado(int empleadoId) {
		List<Venta> ventas = new ArrayList<>();
		String sql = "SELECT * FROM venta WHERE empleado_id = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, empleadoId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Venta v = new Venta();
				v.setId_venta(rs.getInt("id_venta"));
				v.setFecha(rs.getDate("fecha").toLocalDate());
				v.setImporte(rs.getDouble("monto"));
				v.setTipoPago(TipoPago.valueOf(rs.getString("tipo_pago")));
				v.setId_empleado(rs.getInt("empleado_id"));
				v.setId_stand(rs.getInt("stand_id"));
				v.setId_zona(rs.getInt("zona_id"));
				v.setId_juguete(rs.getInt("juguete_id"));
				v.setCantidad(rs.getInt("cantidad"));
				v.setCliente(rs.getString("cliente"));

				ventas.add(v);
			}

		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}

		return ventas;
	}

	
	public List<Venta> VentasPorMes(int mes) {
		List<Venta> ventas = new ArrayList<>();
		String sql = "SELECT * FROM venta WHERE MONTH(fecha) = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, mes);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Venta v = new Venta();
				v.setId_venta(rs.getInt("id_venta"));
				v.setFecha(rs.getDate("fecha").toLocalDate());
				v.setImporte(rs.getDouble("monto"));
				v.setTipoPago(TipoPago.valueOf(rs.getString("tipo_pago")));
				v.setId_empleado(rs.getInt("empleado_id"));
				v.setId_stand(rs.getInt("stand_id"));
				v.setId_zona(rs.getInt("zona_id"));
				v.setId_juguete(rs.getInt("juguete_id"));
				v.setCantidad(rs.getInt("cantidad"));
				v.setCliente(rs.getString("cliente"));
				
				ventas.add(v);
			}
		} catch (SQLException e) {
			System.out.println("Hubo un error :"+e.getMessage());
		}
		return ventas;
	}

	
	public List<String> top5JuguetesMasVendidos() {
	    List<String> ranking = new ArrayList<>();
	    
	    String sql = "SELECT j.nombre, COUNT(*) AS total_ventas " +
	                 "FROM venta v " +
	                 "JOIN juguete j ON v.juguete_id = j.id_juguete " +
	                 "GROUP BY j.id_juguete, j.nombre " +
	                 "ORDER BY total_ventas DESC " +
	                 "LIMIT 5";

	    try (PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        int posicion = 1;
	        while (rs.next()) {
	            String nombre = rs.getString("nombre");
	            int cantidad = rs.getInt("total_ventas");
	            
	            String fila = posicion + ". " + nombre + " (Total: " + cantidad + ")";
	            ranking.add(fila);
	            posicion++;
	        }
	        
	    } catch (SQLException e) {
	        System.out.println("Hubo un error :"+e.getMessage());
	    }
	    
	    return ranking;
	}	
	
	
	public List<String> empleadosQueMasVenden() {
	    List<String> ranking = new ArrayList<>();
	    
	    String sql = "SELECT e.nombre, SUM(v.monto) AS total_dinero " +
	                 "FROM venta v " +
	                 "JOIN empleado e ON v.empleado_id = e.id_empleado " +
	                 "GROUP BY e.id_empleado, e.nombre " +
	                 "ORDER BY total_dinero DESC"; 

	    try (PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        int posicion = 1;
	        while (rs.next()) {
	            String nombre = rs.getString("nombre");
	            double total = rs.getDouble("total_dinero");
	            
	            String fila = posicion + ". " + nombre + " - Total vendido: " + total + " €";
	            ranking.add(fila);
	            posicion++;
	        }
	        
	    } catch (SQLException e) {
	        System.out.println("Hubo un error :"+e.getMessage());
	    }
	    
	    return ranking;
	}
	
	public List<Venta> ventasEmpleadoEnMes(int idEmpleado, int mes) {
	    List<Venta> lista = new ArrayList<>();
	    String sql = "SELECT * FROM venta WHERE empleado_id = ? AND MONTH(fecha) = ?";
	    
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, idEmpleado);
	        ps.setInt(2, mes);
	        ResultSet rs = ps.executeQuery();
	        
	        while(rs.next()){
	        	Venta v = new Venta();
				v.setId_venta(rs.getInt("id_venta"));
				v.setFecha(rs.getDate("fecha").toLocalDate());
				v.setImporte(rs.getDouble("monto"));
				v.setTipoPago(TipoPago.valueOf(rs.getString("tipo_pago")));
				v.setId_empleado(rs.getInt("empleado_id"));
				v.setId_stand(rs.getInt("stand_id"));
				v.setId_zona(rs.getInt("zona_id"));
				v.setId_juguete(rs.getInt("juguete_id"));
				v.setCantidad(rs.getInt("cantidad"));
				v.setCliente(rs.getString("cliente"));

				lista.add(v);
	        }
	    } catch (SQLException e) {
	    	System.out.println("Hubo un error :"+e.getMessage());
	    }
	    return lista;
	}

	
}	

