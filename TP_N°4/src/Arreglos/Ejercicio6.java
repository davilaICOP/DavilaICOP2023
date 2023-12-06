package Arreglos;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] cuadrado = new int[3][3];

        // Ingresar valores del cuadrado por teclado
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Ingrese el valor en la posición [" + i + "][" + j + "]: ");
                cuadrado[i][j] = scanner.nextInt();
            }
        }

        // Verificar si es un cuadrado mágico
        if (esCuadradoMagico(cuadrado)) {
            System.out.println("Es un cuadrado mágico.");
        } else {
            System.out.println("No es un cuadrado mágico.");
        }

        scanner.close();
    }

    private static boolean esCuadradoMagico(int[][] cuadrado) {
        // Calcular la suma de la primera fila para comparar
        int sumaFila = 0;
        for (int j = 0; j < 3; j++) {
            sumaFila += cuadrado[0][j];
        }

        // Verificar la suma de las filas
        for (int i = 1; i < 3; i++) {
            int sumaActual = 0;
            for (int j = 0; j < 3; j++) {
                sumaActual += cuadrado[i][j];
            }
            if (sumaActual != sumaFila) {
                return false;
            }
        }

        // Verificar la suma de las columnas
        for (int j = 0; j < 3; j++) {
            int sumaActual = 0;
            for (int i = 0; i < 3; i++) {
                sumaActual += cuadrado[i][j];
            }
            if (sumaActual != sumaFila) {
                return false;
            }
        }

        // Verificar la suma de las diagonales
        int sumaDiagonal1 = cuadrado[0][0] + cuadrado[1][1] + cuadrado[2][2];
        int sumaDiagonal2 = cuadrado[0][2] + cuadrado[1][1] + cuadrado[2][0];

        return sumaDiagonal1 == sumaFila && sumaDiagonal2 == sumaFila;
    }
}
