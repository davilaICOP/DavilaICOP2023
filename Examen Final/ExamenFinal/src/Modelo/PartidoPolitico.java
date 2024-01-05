package Modelo;

public enum PartidoPolitico {
    LLA("La Libertad Avanza"),
    UXP("Union por la Patria"),
    JXC("Juntos por el Cambio"),
    FIT("Frente de Izquierda");

    private final String nombreCompleto;
    
    PartidoPolitico(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;       
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

}