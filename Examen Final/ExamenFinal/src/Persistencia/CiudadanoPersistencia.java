package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CiudadanoPersistencia {

    // Método para verificar si un DU ya está registrado en la base de datos
    public static boolean verificarDocumento(int du) {
        String verificarSql = "SELECT COUNT(1) FROM Ciudadano WHERE du = ?;";                         

        try (Connection conn = new Conexion().conectar();
             PreparedStatement verificarStmt = conn.prepareStatement(verificarSql)) {

            verificarStmt.setInt(1, du); // Establecer el parámetro DU en la consulta

            ResultSet rs = verificarStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // DU ya está registrado
                return false;
            } else {
                // DU no está registrado
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


/*package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CiudadanoPersistencia {

    // Método para verificar si un DU ya está registrado en ambas tablas
    public static boolean verificarDocumento(int du) {
        String verificarSql = "SELECT COUNT(1) FROM Ciudadano WHERE du = ?;";                         

        try (Connection conn = new Conexion().conectar();
             PreparedStatement verificarStmt = conn.prepareStatement(verificarSql)) {

            verificarStmt.setInt(1, du);
            verificarStmt.setInt(2, du);

            ResultSet rs = verificarStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // DU ya está registrado
                return false;
            } else {
                // DU no está registrado
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}*/