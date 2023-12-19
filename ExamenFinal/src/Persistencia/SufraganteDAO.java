package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.Sufragante;

public class SufraganteDAO {
    private Conexion conexion;

    public SufraganteDAO() {
        this.conexion = new Conexion();
    }

    public void guardarSufragante(Sufragante sufragante) {
        try (Connection conn = conexion.conectar()) {
            String query = "INSERT INTO sufragantes (apellido, nombre, edad, genero, domicilio, du, emitio_voto, candidato_id, voto_impugnado) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, sufragante.getApellido());
                stmt.setString(2, sufragante.getNombre());
                stmt.setInt(3, sufragante.getEdad());
                stmt.setString(4, sufragante.getGenero().toString());
                stmt.setString(5, sufragante.getDomicilio());
                stmt.setString(6, sufragante.getDU());
                stmt.setBoolean(7, sufragante.haEmitidoVoto());
                
                if (sufragante.getCandidatoElegido() != null) {
                    stmt.setString(8, sufragante.getCandidatoElegido().getDU());  // Suponiendo que Candidato tenga un campo "id"
                } else {
                    stmt.setNull(8, java.sql.Types.BIGINT);
                }

                stmt.setBoolean(9, sufragante.isVotoImpugnado());

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
