package resol_AvilaD;
import java.util.Scanner;

public class Ejercicio_15 {
    public static void arrayVocales() {
        Scanner scanner = new Scanner(System.in);

        char[] vocales = {'A', 'E', 'I', 'O', 'U'};
        StringBuilder cadenaResultante = new StringBuilder();

        System.out.println("Introduce las posiciones del array (0-4) o -1 para finalizar:");

        int posicion;
        do {
            posicion = scanner.nextInt();

            if (posicion >= 0 && posicion < vocales.length) {
                cadenaResultante.append(vocales[posicion]);
            } else if (posicion != -1) {
                System.out.println("Error: posición inválida, introduce otro número.");
            }
        } while (posicion != -1);

        System.out.println("Cadena resultante: " + cadenaResultante.toString());
    }
}
