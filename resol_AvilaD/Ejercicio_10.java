package resol_AvilaD;
import java.util.Scanner;

public class Ejercicio_10 {
    public static void calcularDigitoVerificadorISBN() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código ISBN sin el dígito verificador: ");
        String codigoISBN = scanner.nextLine();

        int suma = 0;
        int multiplicador = 1;

        // Calcular la suma ponderada de los dígitos del código ISBN
        for (int i = 0; i < codigoISBN.length(); i++) {
            char digito = codigoISBN.charAt(i);
            int valor = Character.getNumericValue(digito);
            suma += valor * multiplicador;
            multiplicador++;
        }

        // Calcular el dígito verificador
        int digitoVerificador = suma % 11;

        // Verificar si el dígito verificador es 10 y reemplazarlo con 'X'
        String isbnCompleto = codigoISBN + (digitoVerificador == 10 ? "X" : digitoVerificador);

        System.out.println("ISBN completo: " + isbnCompleto);
    }
}
