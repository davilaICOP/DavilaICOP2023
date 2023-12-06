package Arreglos;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de N para la sucesión de Fibonacci: ");
        int N = scanner.nextInt();

        int[] fibonacci = generarFibonacci(N);

        System.out.println("Los primeros " + N + " números de la sucesión de Fibonacci son:");
        imprimirVector(fibonacci);

        scanner.close();
    }

    static int[] generarFibonacci(int N) {
        int[] fibonacci = new int[N];

        for (int i = 0; i < N; i++) {
            if (i <= 1) {
                fibonacci[i] = 1;
            } else {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }
        }

        return fibonacci;
    }

    static void imprimirVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }
}
