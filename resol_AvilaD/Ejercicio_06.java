package resol_AvilaD;

import java.util.Scanner;

public class Ejercicio_06 {
    public void numeroPrimo() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Ingrese un numero: ");
        int numero = scanner.nextInt(); // Número que se desea verificar si es primo
        boolean esPrimo = esPrimo(numero);
        
        if (esPrimo) {
            System.out.println(numero + " es un número primo.");
        } else {
            System.out.println(numero + " no es un número primo.");
        }
    }
    
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false; // Los números menores o iguales a 1 no son primos
        }
        
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Si el número es divisible por otro número, no es primo
            }
        }
        
        return true; // Si el número no es divisible por ningún otro número, es primo
    }
}