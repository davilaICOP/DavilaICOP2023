package TP_10;

import java.util.Scanner;

public class _3_DivisionNumero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer dos números en forma de cadena
        System.out.print("Ingrese el primer número: ");
        String numero1Str = scanner.nextLine();

        System.out.print("Ingrese el segundo número: ");
        String numero2Str = scanner.nextLine();

        // Convertir las cadenas a tipo int
        try {
            int numero1 = Integer.parseInt(numero1Str);
            int numero2 = Integer.parseInt(numero2Str);

            // Realizar la división
            if (numero2 != 0) {
                int resultado = numero1 / numero2;
                System.out.println("Resultado de la división: " + resultado);
            } else {
                System.out.println("Error: No se puede dividir por cero.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese números válidos. " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: Se ha producido una excepción aritmética. " + e.getMessage());
        } finally {
            scanner.close(); // Cerrar el scanner al finalizar
        }
    }
}
