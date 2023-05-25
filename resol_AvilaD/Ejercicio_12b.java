package resol_AvilaD;
import java.util.Scanner;

public class Ejercicio_12b {
    public static void verificacionC() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");
        int C = scanner.nextInt();

        String signo = (C >= 0) ? "positivo" : "negativo";
        String parImpar = (C % 2 == 0) ? "par" : "impar";
        String multiplo5 = (C % 5 == 0) ? "es múltiplo de 5" : "no es múltiplo de 5";
        String multiplo10 = (C % 10 == 0) ? "es múltiplo de 10" : "no es múltiplo de 10";
        String mayorMenor100 = (C > 100) ? "mayor que 100" : "menor o igual que 100";

        System.out.println("El número es " + signo);
        System.out.println("El número es " + parImpar);
        System.out.println("El número " + multiplo5);
        System.out.println("El número " + multiplo10);
        System.out.println("El número es " + mayorMenor100);
    }
}
