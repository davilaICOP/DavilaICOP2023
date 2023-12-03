package Resolucion;
import java.util.Scanner;

public class Ejercicio_09 {
    public static void ordenacionPorSeleccion() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos del arreglo: ");
        int n = scanner.nextInt();

        int[] arreglo = new int[n];

        System.out.println("Ingrese los elementos del arreglo:");

        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arreglo[i] = scanner.nextInt();
        }

        ordenarPorSeleccion(arreglo);

        System.out.println("Arreglo ordenado por selección:");

        for (int i = 0; i < n; i++) {
            System.out.println(arreglo[i]);
        }
    }

    public static void ordenarPorSeleccion(int[] arreglo) {
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            int temp = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = temp;
        }
    }
}
