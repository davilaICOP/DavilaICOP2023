package Resolucion;
import java.util.Scanner;

public class Ejercicio_08 {
    public static void contarBilletes() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el monto de dinero: $");
        int monto = scanner.nextInt();

        contarBilletes(monto);
    }

    public static void contarBilletes(int monto) {
        int billete100 = monto / 100;
        monto %= 100; //Equivalente a: monto = monto % 100. El operador % calcula el resto de la división;

        int billete50 = monto / 50;
        monto %= 50;

        int billete20 = monto / 20;
        monto %= 20;

        int billete10 = monto / 10;
        monto %= 10;

        int billete5 = monto / 5;
        monto %= 5;

        int billete2 = monto / 2;
        monto %= 2;

        int billete1 = monto;

        System.out.println("Cantidad mínima de billetes:");
        System.out.println("$100: " + billete100);
        System.out.println("$50: " + billete50);
        System.out.println("$20: " + billete20);
        System.out.println("$10: " + billete10);
        System.out.println("$5: " + billete5);
        System.out.println("$2: " + billete2);
        System.out.println("$1: " + billete1);
    }
}