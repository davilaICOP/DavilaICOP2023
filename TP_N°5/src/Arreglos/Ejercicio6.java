package Arreglos;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] sopaLetras = new char[20][20];

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese una palabra (entre 3 y 5 caracteres): ");
            String palabra = scanner.nextLine();

            int fila = (int) (Math.random() * 20);
            int columna = (int) (Math.random() * (20 - palabra.length()));

            for (int j = 0; j < palabra.length(); j++) {
                sopaLetras[fila][columna + j] = palabra.charAt(j);
            }
        }

        llenarEspaciosNoUtilizados(sopaLetras);

        imprimirSopaLetras(sopaLetras);

        scanner.close();
    }

    static void llenarEspaciosNoUtilizados(char[][] sopaLetras) {
        for (int i = 0; i < sopaLetras.length; i++) {
            for (int j = 0; j < sopaLetras[i].length; j++) {
                if (sopaLetras[i][j] == 0) {
                    sopaLetras[i][j] = (char) ('0' + (int) (Math.random() * 10));
                }
            }
        }
    }

    static void imprimirSopaLetras(char[][] sopaLetras) {
        System.out.println("Sopa de letras:");
        for (int i = 0; i < sopaLetras.length; i++) {
            for (int j = 0; j < sopaLetras[i].length; j++) {
                System.out.print(sopaLetras[i][j] + " ");
            }
            System.out.println();
        }
    }
}
