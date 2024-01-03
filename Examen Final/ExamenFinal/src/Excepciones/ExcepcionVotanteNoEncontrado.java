package Excepciones;

public class ExcepcionVotanteNoEncontrado extends RuntimeException {
	
	private static final String VotanteNoRegistrado = "Error: El votante no está registrado.";
	private static final String VotanteEsCandidato = "Error: El votante ya es candidato y no puede votarse a sí mismo.";

    public ExcepcionVotanteNoEncontrado(String mensajeError) {
        super(mensajeError);
    }

    // Métodos estáticos para crear instancias de la excepción con mensajes de error específicos
    public static ExcepcionVotanteNoEncontrado votanteNoRegistrado() {
        return new ExcepcionVotanteNoEncontrado(VotanteNoRegistrado);
    }

    public static ExcepcionVotanteNoEncontrado votanteEsCandidato() {
        return new ExcepcionVotanteNoEncontrado(VotanteEsCandidato);
    }
}