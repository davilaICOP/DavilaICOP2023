package Arreglos;

public class Ejercicio4 {
    public static void main(String[] args) {
        int[][] matriz = new int[4][4];

        // Llenar la matriz con valores aleatorios
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = (int) (Math.random() * 100); // Cambiar el rango si es necesario
            }
        }

        // Mostrar la matriz original
        System.out.println("Matriz Original:");
        mostrarMatriz(matriz);

        // Calcular y mostrar la traspuesta
        int[][] traspuesta = calcularTraspuesta(matriz);
        System.out.println("\nMatriz Traspuesta:");
        mostrarMatriz(traspuesta);
    }

    private static int[][] calcularTraspuesta(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] traspuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                traspuesta[j][i] = matriz[i][j];
            }
        }

        return traspuesta;
    }

    private static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + "\t");
            }
            System.out.println();
        }
    }
}
