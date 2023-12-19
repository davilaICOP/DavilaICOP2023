package Modelo;

public enum PartidoPolitico {
    LLA("La Libertad Avanza"),
    UXP("Union por la Patria"),
    JXC("Juntos por el Cambio"),
    FIT("Hacemos Pais");

    private final String nombreCompleto;
    
    // Constructor del enumerado
    PartidoPolitico(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        
    }

    // Getter para el nombre completo del partido
    public String getNombreCompleto() {
        return nombreCompleto;
    }

}
