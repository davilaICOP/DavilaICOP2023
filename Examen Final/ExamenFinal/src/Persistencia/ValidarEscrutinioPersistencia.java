package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ValidarEscrutinioPersistencia {

    // Método para validar el total de votos
    public boolean validarTotalVotos() {
        int totalVotosCandidatos = new CandidatoPersistencia().sumarTotalVotos();
        int totalVotosEspeciales = new VotosEspecialesPersistencia().obtenerTotalVotosEspeciales();
        int totalSufragantesQueVotaron = new SufragantePersistencia().contarSufragantesQueVotaron();

        int totalVotos = totalVotosCandidatos + totalVotosEspeciales;
        return totalVotos == totalSufragantesQueVotaron;
    }
    
    // Método para actualizar la cantidad de sufragantes que votaron
    public void actualizarSufragantesQueVotaron() {
        String sql = "UPDATE Validar_Escrutinio SET cantidad = (SELECT COUNT(*) FROM Sufragante WHERE emitio_voto = TRUE) WHERE descripcion = 'Sufragantes que votaron'";
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar la cantidad total de votos escrutados
    public void actualizarVotosEscrutados() {
        String sql = "UPDATE Validar_Escrutinio SET cantidad = (SELECT SUM(cantidad_votos) FROM Candidato) + (SELECT SUM(cantidad) FROM Votos_Especiales) WHERE descripcion = 'Votos escrutados'";
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}