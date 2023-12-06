package Arreglos;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del vector: ");
        int N = scanner.nextInt();

        int[] vector = new int[N];

        // Llenar el vector con valores
        for (int i = 0; i < N; i++) {
            System.out.print("Ingrese el elemento " + (i + 1) + ": ");
            vector[i] = scanner.nextInt();
        }

        int[] conteoDigitos = new int[6]; // Índice 0 no se utiliza

        // Contar la cantidad de números de 1 a 5 dígitos
        for (int num : vector) {
            int digitos = String.valueOf(num).length();
            if (digitos >= 1 && digitos <= 5) {
                conteoDigitos[digitos]++;
            }
        }

        // Mostrar los resultados
        for (int i = 1; i <= 5; i++) {
            System.out.println("Número de " + i + " dígitos: " + conteoDigitos[i]);
        }

        scanner.close();
    }
}
