package Principal;
import Entidad.Puntos;
public class PuntosConstructor {

	// Ejemplo de uso
    public static void main(String[] args) {
        Puntos puntos = new Puntos();

        // Llamamos al método crearPuntos() para obtener las coordenadas
        puntos.crearPuntos();

        // Llamamos al método calcularDistancia() para obtener la distancia
        double distancia = puntos.calcularDistancia();

        // Mostramos la distancia calculada
        System.out.println("La distancia entre los dos puntos es: " + distancia);
    }
}
