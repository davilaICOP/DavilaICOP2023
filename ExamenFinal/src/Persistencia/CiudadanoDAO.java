package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.Candidato;
import Modelo.Ciudadano;
import Modelo.Genero;
import Modelo.Sufragante;

public class CiudadanoDAO {

    // Consultas SQL para operaciones CRUD
    private static final String INSERT_CIUDADANO = "INSERT INTO ciudadano (apellido, nombre, edad, genero, domicilio, DU) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String INSERT_SUFRAGANTE = "INSERT INTO Sufragante (apellido, nombre, edad, genero, domicilio, DU) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String INSERT_CANDIDATO = "INSERT INTO Candidato (apellido, nombre, edad, genero, domicilio, DU, partidoPolitico, lema) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_CIUDADANO_POR_DNI = "SELECT * FROM ciudadano WHERE DU = ?";
    
    // Otros SQL para operaciones de actualización, eliminación, etc.

    // Conexión a la base de datos
    private Conexion conexion;

    public CiudadanoDAO() {
        this.conexion = new Conexion();
    }

    public void agregarCiudadano(Ciudadano ciudadano) {
        try (Connection connection = conexion.conectar();
             PreparedStatement statement = connection.prepareStatement(INSERT_CIUDADANO)) {

            // Establecer los parámetros en la consulta
            statement.setString(1, ciudadano.getApellido());
            statement.setString(2, ciudadano.getNombre());
            statement.setInt(3, ciudadano.getEdad());
            statement.setString(4, ciudadano.getGenero().name()); // Almacena el nombre del enum
            statement.setString(5, ciudadano.getDomicilio());
            statement.setString(6, ciudadano.getDU());

            // Ejecutar la consulta
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones en un entorno de producción
        }
    }
    
    /*public boolean agregarSufragante(Sufragante sufragante) {
        try (Connection connection = conexion.conectar();
             PreparedStatement preparedStatement = conexion.prepareStatement(INSERT_SUFRAGANTE)) {
            preparedStatement.setString(1, sufragante.getApellido());
            preparedStatement.setString(2, sufragante.getNombre());
            preparedStatement.setInt(3, sufragante.getEdad());
            preparedStatement.setString(4, sufragante.getGenero().toString());
            preparedStatement.setString(5, sufragante.getDomicilio());
            preparedStatement.setString(6, sufragante.getDU());

            int filasAfectadas = preparedStatement.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }*/

    /*public boolean agregarCandidato(Candidato candidato) {
        try (Connection connection = conexion.conectar();
             PreparedStatement preparedStatement = conexion.prepareStatement(INSERT_CANDIDATO)) {
            preparedStatement.setString(1, candidato.getApellido());
            preparedStatement.setString(2, candidato.getNombre());
            preparedStatement.setInt(3, candidato.getEdad());
            preparedStatement.setString(4, candidato.getGenero().toString());
            preparedStatement.setString(5, candidato.getDomicilio());
            preparedStatement.setString(6, candidato.getDU());
            preparedStatement.setString(7, candidato.getPartidoPolitico().toString());
            preparedStatement.setString(8, candidato.getLema());

            int filasAfectadas = preparedStatement.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }*/


    public Ciudadano obtenerCiudadanoPorDNI(String dni) {
        try (Connection connection = conexion.conectar();
             PreparedStatement statement = connection.prepareStatement(SELECT_CIUDADANO_POR_DNI)) {

            // Establecer el parámetro en la consulta
            statement.setString(1, dni);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Procesar los resultados
            if (resultSet.next()) {
                String apellido = resultSet.getString("apellido");
                String nombre = resultSet.getString("nombre");
                int edad = resultSet.getInt("edad");
                String generoString = resultSet.getString("genero");
                Genero genero = Genero.valueOf(generoString); // Convertir el nombre del enum a la instancia de enum
                String domicilio = resultSet.getString("domicilio");
                String DU = resultSet.getString("DU");

                // Puedes crear un objeto Ciudadano con los datos obtenidos de la base de datos
                return new Ciudadano(apellido, nombre, edad, genero, domicilio, DU);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return null; 
    }

    
}
