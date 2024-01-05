package Persistencia;

import Modelo.Candidato;
import Modelo.Genero;
import Modelo.PartidoPolitico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatoPersistencia {

    public boolean agregarCandidato(Candidato candidato) {
        String sql = "INSERT INTO Candidato (apellido, nombre, edad, genero, domicilio, du, partido_politico, lema, cantidad_votos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, candidato.getApellido());
            pstmt.setString(2, candidato.getNombre());
            pstmt.setInt(3, candidato.getEdad());
            pstmt.setString(4, candidato.getGenero().toString());
            pstmt.setString(5, candidato.getDomicilio());
            pstmt.setInt(6, candidato.getDU());
            pstmt.setString(7, candidato.getPartidoPolitico().name());
            pstmt.setString(8, candidato.getLema());
            pstmt.setInt(9, candidato.getCantidadVotos());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Candidato> obtenerTodosLosCandidatosOrdenados() {
        List<Candidato> candidatos = new ArrayList<>();
        String sql = "SELECT * FROM Candidato ORDER BY partido_politico, apellido, nombre";
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Candidato candidato = new Candidato(
                    rs.getString("apellido"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    Genero.valueOf(rs.getString("genero")),
                    rs.getString("domicilio"),
                    rs.getInt("du"),
                    PartidoPolitico.valueOf(rs.getString("partido_politico")),
                    rs.getString("lema")
                );
                candidato.setCantidadVotos(rs.getInt("cantidad_votos"));
                candidatos.add(candidato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidatos;
    }
    
    public Candidato buscarPorDni(int du) {
        Candidato candidato = null;
        String sql = "SELECT * FROM Candidato WHERE du = ?";

        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	 pstmt.setInt(1, du);

             try (ResultSet resultSet = pstmt.executeQuery()) {
                 if (resultSet.next()) {
                     candidato = new Candidato();
                     candidato.setDU(resultSet.getInt("du"));
                 }
             }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return candidato;
    }
    
    public boolean actualizarCantidadVotos(int du) {
        String sql = "UPDATE Candidato SET cantidad_votos = cantidad_votos + 1 WHERE du = ?";
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, du);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int sumarTotalVotos() {
        int totalVotos = 0;
        String sql = "SELECT SUM(cantidad_votos) AS total FROM Candidato";
        
        try (Connection conn = new Conexion().conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                totalVotos = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return totalVotos;
    }  
}