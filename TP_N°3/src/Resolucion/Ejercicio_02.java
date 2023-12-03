package Resolucion;
import java.util.Scanner;

public class Ejercicio_02 {
    public static void promedioMayores() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos del arreglo: ");
        int n = scanner.nextInt();

        int[] arreglo = new int[n];

        System.out.println("Ingrese los elementos del arreglo:");

        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arreglo[i] = scanner.nextInt();
        }

        int promedio = calcularPromedio(arreglo);
        int[] mayores = obtenerMayores(arreglo, promedio);

        System.out.println("El promedio es: " + promedio);
        System.out.println("Elementos mayores que el promedio:");

        for (int i = 0; i < mayores.length; i++) {
            System.out.println(mayores[i]);
        }
    }

    public static int calcularPromedio(int[] arreglo) {
        int suma = 0;

        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }

        return suma / arreglo.length;
    }

    public static int[] obtenerMayores(int[] arreglo, int promedio) {
        int contador = 0;

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > promedio) {
                contador++;
            }
        }

        int[] mayores = new int[contador];
        int indice = 0;

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > promedio) {
                mayores[indice] = arreglo[i];
                indice++;
            }
        }

        return mayores;
    }
}
