package Modelo;

import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

public abstract class Ciudadano {
    protected String apellido;
    protected String nombre;
    protected int edad;
    protected Genero genero;
    protected String domicilio;
    protected int DU;
    
    // Constructor por defecto
    public Ciudadano() {}

    // Constructor con parámetros
    public Ciudadano(String apellido, String nombre, int edad, Genero genero, String domicilio, int DU) {
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

    public int getDU() {
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

    public void setDU(int numeroIdentificacion) {
        this.DU = numeroIdentificacion;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Ciudadano ciudadano = (Ciudadano) obj;
        
        return DU == ciudadano.DU;  // Comparar enteros con ==
    }

    @Override
    public int hashCode() {
        return Objects.hash(DU);
    }
    
    private static Set<Integer> documentosRegistrados = new HashSet<>();
    
    // Método estático para verificar y registrar un documento    
    public static boolean verificarYRegistrarDocumento(int du, boolean esConsola) {
        if (documentosRegistrados.contains(du)) {
            if (esConsola) {
                System.out.println("Error: Ya hay un ciudadano registrado con ese número de documento.");
            }
            return false;
        } else {
            documentosRegistrados.add(du);
            return true;
        }
    }
}