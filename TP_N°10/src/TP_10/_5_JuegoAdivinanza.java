package TP_10;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class _5_JuegoAdivinanza {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroAleatorio = random.nextInt(500) + 1;
        int intentos = 0;

        System.out.println("Bienvenido al juego de adivinanza de números entre 1 y 500.");

        try {
            while (true) {
                System.out.print("Ingrese su intento: ");
                int intento = scanner.nextInt();
                intentos++;

                if (intento == numeroAleatorio) {
                    System.out.println("¡Felicidades! Has adivinado el número " + numeroAleatorio +
                            " en " + intentos + " intentos.");
                    break;
                } else if (intento < numeroAleatorio) {
                    System.out.println("El número a adivinar es mayor.");
                } else {
                    System.out.println("El número a adivinar es menor.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido. El carácter ingresado se contará como un intento.");
        } finally {
            scanner.close(); // Cerrar el scanner al finalizar
        }
    }
}
