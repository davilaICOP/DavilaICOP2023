package Entidad;
import java.util.Scanner;

public class Juego {
    private int jugador1Wins;
    private int jugador2Wins;

    // Método para iniciar el juego
    public void iniciar_juego() {
        Scanner scanner = new Scanner(System.in);
        boolean continuarJugando = true;

        while (continuarJugando) {
            System.out.println("Jugador 1, elige un número:");
            int numeroElegido = scanner.nextInt();

            System.out.println("Jugador 2, intenta adivinar el número:");
            int intentos = 0;
            boolean adivinado = false;

            while (intentos < 3 && !adivinado) {
                int intento = scanner.nextInt();
                intentos++;

                if (intento == numeroElegido) {
                    System.out.println("¡Correcto! Jugador 2 ha adivinado el número en " + intentos + " intentos.");
                    jugador2Wins++;
                    adivinado = true;
                } else if (intento < numeroElegido) {
                    System.out.println("Más alto. Intenta nuevamente.");
                } else {
                    System.out.println("Más bajo. Intenta nuevamente.");
                }
            }

            if (!adivinado) {
                System.out.println("Se acabaron los intentos. El número era: " + numeroElegido);
                jugador1Wins++;
            }

            System.out.println("¿Desean jugar de nuevo? (s/n)");
            String opcion = scanner.next();
            if (!opcion.equalsIgnoreCase("s")) {
                continuarJugando = false;
            }
        }

        System.out.println("Jugador 1 ha ganado " + jugador1Wins + " veces.");
        System.out.println("Jugador 2 ha ganado " + jugador2Wins + " veces.");
    }

}
