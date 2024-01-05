package Persistencia;

import Modelo.Sufragante;
import Modelo.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SufragantePersistencia {

    public boolean agregarSufragante(Sufragante sufragante) {
        String sql = "INSERT INTO Sufragante (apellido, nombre, edad, genero, domicilio, du, emitio_voto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, sufragante.getApellido());
            pstmt.setString(2, sufragante.getNombre());
            pstmt.setInt(3, sufragante.getEdad());
            pstmt.setString(4, sufragante.getGenero().toString());
            pstmt.setString(5, sufragante.getDomicilio());
            pstmt.setInt(6, sufragante.getDU());
            pstmt.setBoolean(7, sufragante.haEmitidoVoto());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Sufragante> obtenerTodosLosSufragantesOrdenados() {
        List<Sufragante> sufragantes = new ArrayList<>();
        String sql = "SELECT * FROM Sufragante ORDER BY apellido, nombre, edad";
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Sufragante sufragante = new Sufragante(
                    rs.getString("apellido"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    Genero.valueOf(rs.getString("genero")),
                    rs.getString("domicilio"),
                    rs.getInt("du")
                );
                sufragante.setEmitioVoto(rs.getBoolean("emitio_voto"));
                sufragantes.add(sufragante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sufragantes;
    }
    
    public Sufragante buscarSufragantePorDni(int du) {
        Sufragante sufragante = null;
        String sql = "SELECT * FROM Sufragante WHERE du = ?";

        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, du);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    sufragante = new Sufragante(
                        resultSet.getString("apellido"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("edad"),
                        Genero.valueOf(resultSet.getString("genero")),
                        resultSet.getString("domicilio"),
                        resultSet.getInt("du")
                    );
                    sufragante.setEmitioVoto(resultSet.getBoolean("emitio_voto"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();         
        }

        return sufragante;
    }
    
    public boolean actualizarVotoEmitido(int du, boolean haVotado) {
        String sql = "UPDATE Sufragante SET emitio_voto = ? WHERE du = ?";
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setBoolean(1, haVotado);
            pstmt.setInt(2, du);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int contarSufragantesQueVotaron() {
        int contador = 0;
        String sql = "SELECT COUNT(*) FROM Sufragante WHERE emitio_voto = TRUE";

        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                contador = rs.getInt(1); // Obtener el resultado de la consulta COUNT
            }
        } catch (SQLException e) {
            e.printStackTrace();           
        }
        return contador;
    }    
}