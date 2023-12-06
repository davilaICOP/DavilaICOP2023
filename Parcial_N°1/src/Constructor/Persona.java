package Constructor;

public class Persona {
    protected String apellido;
    protected String nombre;
    private String dni;
    private int edad;
    private String localidad;

    public Persona() {
    }

    public Persona(String apellido, String nombre, String dni, int edad, String localidad) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.localidad = localidad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void mostrar() {
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Edad: " + edad);
        System.out.println("Localidad: " + localidad);
    }
}