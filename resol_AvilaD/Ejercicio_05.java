package resol_AvilaD;
import java.util.Scanner;
public class Ejercicio_05 {
	public static void numero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de n: ");
        int n = scanner.nextInt();

        int resultado = fibonacci(n);
        System.out.println("El enésimo elemento de la serie de Fibonacci es: " + resultado);
    }
    
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // Casos base: Fibonacci(0) = 0, Fibonacci(1) = 1
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // Llamada recursiva
        }
    }
}