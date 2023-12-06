package Arreglos;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del vector: ");
        int N = scanner.nextInt();

        int[] vector = new int[N];

        // Llenar el vector con valores aleatorios
        for (int i = 0; i < N; i++) {
            vector[i] = (int) (Math.random() * 100); // Cambiar el rango si es necesario
        }

        System.out.print("Ingrese el número a buscar: ");
        int numeroBuscado = scanner.nextInt();

        // Buscar el número en el vector
        boolean encontrado = false;
        for (int i = 0; i < N; i++) {
            if (vector[i] == numeroBuscado) {
                System.out.println("El número se encuentra en la posición " + i);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("El número no se encuentra en el vector.");
        }

        // Verificar si el número está repetido
        if (Arrays.stream(vector).filter(x -> x == numeroBuscado).count() > 1) {
            System.out.println("El número está repetido en el vector.");
        }

        scanner.close();
    }
}
