package queriesJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelosBases.Cambio;

public class GestionCambios {
	    private Connection conn;

	    public GestionCambios(Connection conn) {
	        this.conn = conn;
	    }

	    public boolean registrarCambio(Cambio c) {
	        String sql = """
	            INSERT INTO cambio 
	            (id_cambio, motivo, fecha, stand_id_original, zona_id_original, juguete_id_original,
	             stand_id_nuevo, zona_id_nuevo, juguete_id_nuevo, empleado_id)
	            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
	            """;

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

	            return ps.executeUpdate() > 0;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	}

