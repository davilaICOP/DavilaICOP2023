package Resolucion;
import java.util.Scanner;

public class Ejercicio_07 {
    public static void contadorPalabras() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una cadena de texto: ");
        String texto = scanner.nextLine();

        int totalPalabras = contarPalabras(texto);
        System.out.println("El número total de palabras es: " + totalPalabras);
    }

    public static int contarPalabras(String texto) {
        Scanner scanner = new Scanner(texto);
        int contador = 0;

        while (scanner.hasNext()) {
            scanner.next();
            contador++;
        }

        return contador;
    }
}