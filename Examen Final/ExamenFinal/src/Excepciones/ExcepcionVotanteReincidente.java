package Excepciones;

public class ExcepcionVotanteReincidente extends RuntimeException {

    private static final String VotoEmitido = "Error: El votante ya ha emitido su voto.";

    public ExcepcionVotanteReincidente(String mensajeError) {
        super(mensajeError);
    }

    public static ExcepcionVotanteReincidente votoEmitido() {
        return new ExcepcionVotanteReincidente(VotoEmitido);
    }
}