package resol_AvilaD;
import java.util.Scanner;

public class Ejercicio_12a {
    public static void parImpar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");
        int A = scanner.nextInt();

        String mensaje = (A % 2 == 0) ? "El número " +A+ " es par" : "El número " +A+ " es impar";

        System.out.println(mensaje);
    }
}
