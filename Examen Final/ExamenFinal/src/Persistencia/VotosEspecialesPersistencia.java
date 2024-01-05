package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VotosEspecialesPersistencia {

    // Método para incrementar los votos en blanco
    public boolean incrementarVotosEnBlanco() {
        String sql = "UPDATE Votos_Especiales SET cantidad = cantidad + 1 WHERE tipo = 'Blanco'";
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Método para obtener la cantidad de votos en blanco
    public int obtenerCantidadVotosEnBlanco() {
        String sql = "SELECT cantidad FROM Votos_Especiales WHERE tipo = 'Blanco'";
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("cantidad");
            } else {
                return 0; // No se encontraron votos en blanco
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // Indica que hubo un error
        }
    }

    // Método para incrementar los votos impugnados
    public boolean incrementarVotosImpugnados() {
        String sql = "UPDATE Votos_Especiales SET cantidad = cantidad + 1 WHERE tipo = 'Impugnado'";
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Método para obtener la cantidad de votos impugnados
    public int obtenerCantidadVotosImpugnados() {
        String sql = "SELECT cantidad FROM Votos_Especiales WHERE tipo = 'Impugnado'";
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("cantidad");
            } else {
                return 0; // No se encontraron votos impugnados
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // Indica que hubo un error
        }
    }
    
    // Método para obtener la suma total de votos especiales
    public int obtenerTotalVotosEspeciales() {
        String sql = "SELECT SUM(cantidad) AS total_votos_especiales FROM Votos_Especiales";
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("total_votos_especiales");
            } else {
                return 0; // No se encontraron votos especiales
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // Indica que hubo un error
        }
    }
}