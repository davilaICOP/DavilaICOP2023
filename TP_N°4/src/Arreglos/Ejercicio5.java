package Arreglos;

public class Ejercicio5 {
    public static void main(String[] args) {
        int[][] matriz = {
                {0, 1, -2},
                {-1, 0, 3},
                {2, -3, 0}
        };

        // Verificar si la matriz es antisimétrica
        if (esMatrizAntisimetrica(matriz)) {
            System.out.println("La matriz es antisimétrica.");
        } else {
            System.out.println("La matriz no es antisimétrica.");
        }
    }

    private static boolean esMatrizAntisimetrica(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        if (filas != columnas) {
            return false; // No es cuadrada, por lo tanto, no puede ser antisimétrica
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != -matriz[j][i]) {
                    return false; // No cumple con la condición de antisimetría
                }
            }
        }

        return true;
    }
}
