package Arreglos;

import java.util.Random;

public class Ejercicio3 {
    public static void main(String[] args) {
        int[] vector = new int[10];

        llenarVectorAleatorio(vector);
        imprimirVector(vector);
    }

    // Función para llenar un vector con números aleatorios
    static void llenarVectorAleatorio(int[] vector) {
        Random rand = new Random();

        for (int i = 0; i < vector.length; i++) {
            vector[i] = rand.nextInt(100); // Modifica el rango según tus necesidades
        }
    }

    // Función para imprimir un vector
    static void imprimirVector(int[] vector) {
        System.out.println("Vector:");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
    }
}
