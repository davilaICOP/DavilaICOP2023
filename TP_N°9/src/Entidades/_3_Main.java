package Entidades;

import java.util.Scanner;

public class _3_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear los arreglos A y B
        double[] arregloA = new double[50];
        double[] arregloB = new double[20];

        // Inicializar arreglo A con números aleatorios
        _3_ArregloService.inicializarA(arregloA);
        System.out.println("Arreglo A inicializado:");
        _3_ArregloService.mostrar(arregloA);

        // Ordenar arreglo A de mayor a menor
        _3_ArregloService.ordenar(arregloA);
        System.out.println("Arreglo A ordenado de mayor a menor:");
        _3_ArregloService.mostrar(arregloA);

        // Inicializar arreglo B y mostrar ambos arreglos
        _3_ArregloService.inicializarB(arregloA, arregloB);
        System.out.println("Arreglo A:");
        _3_ArregloService.mostrar(arregloA);
        System.out.println("Arreglo B inicializado:");
        _3_ArregloService.mostrar(arregloB);
    }
}