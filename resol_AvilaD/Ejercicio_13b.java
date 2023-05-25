package resol_AvilaD;
import java.util.Scanner;

public class Ejercicio_13b {
    public static int sumaNaturalesIterativa(int n) {
        int suma = 0;

        for (int i = 1; i <= n; i++) {
            suma += i;
        }

        return suma;
    }

    public static void iterativa() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero N: ");
        int N = scanner.nextInt();

        int resultado = sumaNaturalesIterativa(N);

        System.out.println("La suma de los primeros " + N + " números naturales es: " + resultado);
    }
}
