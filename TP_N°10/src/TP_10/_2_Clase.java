package TP_10;

import java.util.Scanner;

class MiClase {
    private int[] arreglo;

    public MiClase(int tamano) {
        // Inicializar el array con el tamaño proporcionado
        arreglo = new int[tamano];
    }

    public void asignarValor(int indice, int valor) {
        try {
            // Intentar asignar un valor en el índice proporcionado
            arreglo[indice] = valor;
            System.out.println("Valor asignado correctamente en el índice " + indice);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Capturar la excepción ArrayIndexOutOfBoundsException
            System.out.println("Error: Índice fuera de rango. " + e.getMessage());
        }
    }
}

public class _2_Clase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del array: ");
        int tamano = scanner.nextInt();

        // Crear una instancia de la clase MiClase
        MiClase miObjeto = new MiClase(tamano);

        System.out.print("Ingrese el índice para asignar un valor: ");
        int indice = scanner.nextInt();

        System.out.print("Ingrese el valor a asignar: ");
        int valor = scanner.nextInt();

        // Llamar al método de asignación en MiClase
        miObjeto.asignarValor(indice, valor);

        scanner.close(); // Cerrar el scanner al finalizar
    }
}
