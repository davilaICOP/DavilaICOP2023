package Entidad;
import java.util.Scanner;

public class Puntos {
    private int x1, y1, x2, y2;

    // Método para crear un objeto Puntos y obtener las coordenadas desde el usuario
    public void crearPuntos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese las coordenadas del primer punto:");
        System.out.print("x1: ");
        x1 = scanner.nextInt();
        System.out.print("y1: ");
        y1 = scanner.nextInt();

        System.out.println("Ingrese las coordenadas del segundo punto:");
        System.out.print("x2: ");
        x2 = scanner.nextInt();
        System.out.print("y2: ");
        y2 = scanner.nextInt();
    }

    // Método para calcular y devolver la distancia entre los dos puntos
    public double calcularDistancia() {
        int deltaX = x2 - x1;
        int deltaY = y2 - y1;

        // Usamos el teorema de Pitágoras para calcular la distancia
        double distancia = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

        return distancia;
    }

}
