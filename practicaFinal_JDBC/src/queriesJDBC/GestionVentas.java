package queriesJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelosBases.Venta;

public class GestionVentas {

	public class VentaDAO {

	    private Connection conn;

	    public VentaDAO(Connection conn) {
	        this.conn = conn;
	    }

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
	}

	
}