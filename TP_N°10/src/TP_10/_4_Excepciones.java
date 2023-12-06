package TP_10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _4_Excepciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Leer dos números en forma de cadena
            System.out.print("Ingrese el primer número: ");
            String numero1Str = scanner.nextLine();

            System.out.print("Ingrese el segundo número: ");
            String numero2Str = scanner.nextLine();

            // Convertir las cadenas a tipo int
            int numero1 = Integer.parseInt(numero1Str);
            int numero2 = Integer.parseInt(numero2Str);

            // Realizar la división
            if (numero2 != 0) {
                int resultado = numero1 / numero2;
                System.out.println("Resultado de la división: " + resultado);
            } else {
                System.out.println("Error: No se puede dividir por cero.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese números válidos. " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: No se pudo convertir la cadena a un número entero. " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: Se ha producido una excepción aritmética. " + e.getMessage());
        } finally {
            scanner.close(); // Cerrar el scanner al finalizar
        }
    }
}
