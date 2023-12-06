package Constructor;

public class Médico extends Persona {
    private String númeroMatrícula;
    private String especialidad;

    public Médico() {
    }

    public Médico(String apellido, String nombre, String dni, int edad, String localidad,
                  String númeroMatrícula, String especialidad) {
        super(apellido, nombre, dni, edad, localidad);
        this.númeroMatrícula = númeroMatrícula;
        this.especialidad = especialidad;
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

    public String getNúmeroMatrícula() {
        return númeroMatrícula;
    }

    public void setNúmeroMatrícula(String númeroMatrícula) {
        this.númeroMatrícula = númeroMatrícula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void mostrar() {
        super.mostrar();
        
        
        System.out.println("Número de Matrícula: " + númeroMatrícula);
        System.out.println("Especialidad: " + especialidad);
    }

    public void prescribir(Ciudadano ciudadano, Diagnóstico diagnóstico) {
        diagnóstico.setMédico(this);
        ciudadano.agregarDiagnóstico(diagnóstico);
    }
}
