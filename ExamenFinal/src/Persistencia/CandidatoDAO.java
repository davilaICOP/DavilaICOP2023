package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelo.Candidato;

public class CandidatoDAO {
    private Conexion conexion;

    public CandidatoDAO() {
        this.conexion = new Conexion();
    }

    public void guardarCandidato(Candidato candidato) {
        try (Connection conn = conexion.conectar()) {
            String query = "INSERT INTO candidatos (apellido, nombre, edad, genero, domicilio, du, partido_politico, lema, cantidad_votos) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, candidato.getApellido());
                stmt.setString(2, candidato.getNombre());
                stmt.setInt(3, candidato.getEdad());
                stmt.setString(4, candidato.getGenero().toString());
                stmt.setString(5, candidato.getDomicilio());
                stmt.setString(6, candidato.getDU());
                stmt.setString(7, candidato.getPartidoPolitico().toString());
                stmt.setString(8, candidato.getLema());
                stmt.setInt(9, candidato.getCantidadVotos());

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}

