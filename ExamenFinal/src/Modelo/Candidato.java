package Modelo;

public class Candidato extends Ciudadano {
    private PartidoPolitico partidoPolitico;
    private String lema;
    private int cantidadVotos;

    // Constructor por defecto
    public Candidato() {}

    // Constructor con parámetros
    public Candidato(String apellido, String nombre, int edad, Genero genero,
                     String domicilio, String DU,
                     PartidoPolitico partidoPolitico, String lema) {
        super(apellido, nombre, edad, genero, domicilio, DU);
        this.partidoPolitico = partidoPolitico;
        this.lema = lema;
        this.cantidadVotos = 0;
    }

    // Getter y setter específicos para Candidato
    public PartidoPolitico getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }
    
    public void incrementarCantidadVotos() {
        this.cantidadVotos++;
    }
}
