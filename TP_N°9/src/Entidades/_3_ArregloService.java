package Entidades;

import java.util.Arrays;
import java.util.Random;

class _3_ArregloService {

    // Método para inicializar un arreglo con números aleatorios
    public static void inicializarA(double[] arreglo) {
        Random random = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = random.nextDouble() * 100; // Números aleatorios entre 0 y 100
        }
    }

    // Método para mostrar un arreglo
    public static void mostrar(double[] arreglo) {
        for (double elemento : arreglo) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    // Método para ordenar un arreglo de mayor a menor
    public static void ordenar(double[] arreglo) {
        Arrays.sort(arreglo);
        for (int i = 0; i < arreglo.length / 2; i++) {
            double temp = arreglo[i];
            arreglo[i] = arreglo[arreglo.length - 1 - i];
            arreglo[arreglo.length - 1 - i] = temp;
        }
    }

    // Método para inicializar arreglo B con los primeros 10 elementos de arreglo A y llenar las últimas 10 posiciones con 0.5
    public static void inicializarB(double[] arregloA, double[] arregloB) {
        for (int i = 0; i < 10; i++) {
            arregloB[i] = arregloA[i];
        }
        for (int i = 10; i < arregloB.length; i++) {
            arregloB[i] = 0.5;
        }
    }
}