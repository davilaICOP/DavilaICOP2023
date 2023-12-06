package Arreglos;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numAlumnos = 10;
        double[] promedios = new double[numAlumnos];
        int aprobados = 0;
        int desaprobados = 0;

        for (int i = 0; i < numAlumnos; i++) {
            double promedio = calcularPromedio(scanner, i + 1);
            promedios[i] = promedio;

            if (promedio >= 7.0) {
                aprobados++;
            } else {
                desaprobados++;
            }
        }

        System.out.println("Cantidad de aprobados: " + aprobados);
        System.out.println("Cantidad de desaprobados: " + desaprobados);

        scanner.close();
    }

    static double calcularPromedio(Scanner scanner, int numAlumno) {
        System.out.println("Ingrese las notas del alumno " + numAlumno + ":");
        double nota1 = scanner.nextDouble() * 0.1;
        double nota2 = scanner.nextDouble() * 0.15;
        double nota3 = scanner.nextDouble() * 0.25;
        double nota4 = scanner.nextDouble() * 0.5;

        return nota1 + nota2 + nota3 + nota4;
    }
}
