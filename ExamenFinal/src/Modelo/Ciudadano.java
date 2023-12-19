package Modelo;

import java.util.Comparator;

public class Ciudadano {
    private String apellido;
    private String nombre;
    private int edad;
    private Genero genero;
    private String domicilio;
    private String DU;

    // Constructor por defecto
    public Ciudadano() {}

    // Constructor con parámetros
    public Ciudadano(String apellido, String nombre, int edad, Genero genero, String domicilio, String DU) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.domicilio = domicilio;
        this.DU = DU;
    }

    // Getters
    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getDU() {
        return DU;
    }

    // Setters
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setDU(String numeroIdentificacion) {
        this.DU = numeroIdentificacion;
    }
    
 // Nuevo método para comparar ciudadanos por apellido, nombre y edad
    public static Comparator<Ciudadano> comparadorPorApellidoNombreEdad = Comparator
            .comparing(Ciudadano::getApellido)
            .thenComparing(Ciudadano::getNombre)
            .thenComparingInt(Ciudadano::getEdad);
}