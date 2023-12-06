package Arreglos;

import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de los vectores: ");
        int N = scanner.nextInt();

        int[] vector1 = new int[N];
        int[] vector2 = new int[N];

        System.out.println("Ingrese los elementos del primer vector:");
        for (int i = 0; i < N; i++) {
            vector1[i] = scanner.nextInt();
        }

        System.out.println("Ingrese los elementos del segundo vector:");
        for (int i = 0; i < N; i++) {
            vector2[i] = scanner.nextInt();
        }

        if (Arrays.equals(vector1, vector2)) {
            System.out.println("Los vectores son iguales.");
        } else {
            System.out.println("Los vectores son diferentes.");
        }

        scanner.close();
    }
}
