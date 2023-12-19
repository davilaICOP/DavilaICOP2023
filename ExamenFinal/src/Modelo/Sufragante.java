package Modelo;

public class Sufragante extends Ciudadano {
    private boolean emitioVoto;
    private Candidato candidatoElegido;
    private boolean votoImpugnado;

    // Constructor por defecto
    public Sufragante() {
        this.emitioVoto = false;
        this.candidatoElegido = null;
        this.votoImpugnado = false;
    }

    // Constructor con parámetros
    public Sufragante(String apellido, String nombre, int edad, Genero genero,
                      String domicilio, String DU) {
        super(apellido, nombre, edad, genero, domicilio, DU);
        this.emitioVoto = false;
        this.candidatoElegido = null;
        this.votoImpugnado = false;
    }

    // Getter y setter específicos para Sufragante
    public boolean haEmitidoVoto() {
        return emitioVoto;
    }

    public Candidato getCandidatoElegido() {
        return candidatoElegido;
    }
    
    public boolean isVotoImpugnado() {
        return votoImpugnado;
    }

    public void setEmitioVoto(boolean emitioVoto) {
        this.emitioVoto = emitioVoto;
    }

    public void setCandidatoElegido(Candidato candidatoElegido) {
        this.candidatoElegido = candidatoElegido;
    }
    

    public void setVotoImpugnado(boolean votoImpugnado) {
        this.votoImpugnado = votoImpugnado;
    }
}


