package Constructor;

public class Ciudadano extends Persona {
    private String domicilio;
    private String patente;
    private String condición;

    public Ciudadano() {
        condición = "APTO";
    }

    public Ciudadano(String apellido, String nombre, String dni, int edad, String localidad,
                     String domicilio, String patente) {
        super(apellido, nombre, dni, edad, localidad);
        this.domicilio = domicilio;
        this.patente = patente;
        condición = "APTO";
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getCondición() {
        return condición;
    }

    public void setCondición(String condición) {
        this.condición = condición;
    }

    public void mostrar() {
        super.mostrar();
        System.out.println("Domicilio: " + domicilio);
        System.out.println("Patente: " + patente);
        System.out.println("Condición: " + condición);
    }

    public void agregarDiagnóstico(Diagnóstico diagnóstico) {
        diagnóstico.setCiudadano(this);
    }
}