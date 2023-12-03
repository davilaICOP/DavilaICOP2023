package Resolucion;
import java.util.Scanner;

public class Ejercicio_13a {
    public static int sumaNaturalesRecursiva(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumaNaturalesRecursiva(n - 1);
        }
    }

    public static void recursiva() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero N: ");
        int N = scanner.nextInt();

        int resultado = sumaNaturalesRecursiva(N);

        System.out.println("La suma de los primeros " + N + " números naturales es: " + resultado);
    }
}
