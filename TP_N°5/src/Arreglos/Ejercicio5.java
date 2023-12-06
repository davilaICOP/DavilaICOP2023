package Arreglos;

import java.util.Random;

public class Ejercicio5 {
    public static void main(String[] args) {
        int filas = 3; // Modifica según tus necesidades
        int columnas = 4; // Modifica según tus necesidades

        int[][] matriz = new int[filas][columnas];

        llenarMatrizAleatoria(matriz);
        imprimirMatriz(matriz);

        int suma = sumarMatriz(matriz);
        System.out.println("La suma de los elementos de la matriz es: " + suma);
    }

    static void llenarMatrizAleatoria(int[][] matriz) {
        Random rand = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = rand.nextInt(100); // Modifica el rango según tus necesidades
            }
        }
    }

    static void imprimirMatriz(int[][] matriz) {
        System.out.println("Matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int sumarMatriz(int[][] matriz) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
        }
        return suma;
    }
}
