package TP_1;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();

        System.out.println("El doble del número es: " + (numero * 2));
        System.out.println("El triple del número es: " + (numero * 3));
        System.out.println("La raíz cuadrada del número es: " + Math.sqrt(numero));

        scanner.close();
    }
}
