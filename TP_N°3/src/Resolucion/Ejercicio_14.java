package Resolucion;
import java.util.Scanner;
public class Ejercicio_14 {
    public static void valores() {
        
    	int[] array = new int[10];

        // Llenar el array con valores ingresados por teclado
        llenarValores(array);

        // Mostrar los índices y valores del array
        mostrarArray(array);
    }

    public static void llenarValores(int[] array) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los valores del array:");

        for (int i = 0; i < array.length; i++) {
            System.out.print("Ingrese el valor para el índice " + i + ": ");
            array[i] = scanner.nextInt();
        }
    }

    public static void mostrarArray(int[] array) {
        System.out.println("Valores del array:");

        for (int i = 0; i < array.length; i++) {
            System.out.println("Índice " + i + ": " + array[i]);
        }
    }
}