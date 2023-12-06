package Arreglos;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del vector: ");
        int N = scanner.nextInt();

        int[] vector = new int[N];

        System.out.println("Ingrese los elementos del vector:");
        for (int i = 0; i < N; i++) {
            vector[i] = scanner.nextInt();
        }

        int suma = 0;
        for (int i = 0; i < N; i++) {
            suma += vector[i];
        }

        System.out.println("La suma de los elementos del vector es: " + suma);

        scanner.close();
    }
}
