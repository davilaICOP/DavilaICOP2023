package Arreglos;

import java.util.Arrays;

public class Ejercicio1 {
    public static void main(String[] args) {
        int[] vector = new int[100];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = i + 1;
        }

        // Ordenar en orden descendente
        Arrays.sort(vector);
        for (int i = vector.length - 1; i >= 0; i--) {
            System.out.print(vector[i] + " ");
        }
    }
}
