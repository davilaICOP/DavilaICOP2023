package practicaGeneral;
import java.util.Scanner;
import java.util.Random;

public class EstrategiaNumerica {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        // Solicitar nombre y edad
        System.out.print("Ingrese su nombre: ");
        String nombre = input.nextLine();
        System.out.print("Ingrese su edad: ");
        int edad = input.nextInt();

        // Generar números aleatorios
        int num1 = rand.nextInt(1000);
        int num2 = rand.nextInt(1000);
        int num3 = rand.nextInt(1000);
        int num4 = rand.nextInt(1000);

        // Mostrar los resultados
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Número aleatorio 1: " + num1);
        System.out.println("Número aleatorio 2: " + num2);
        System.out.println("Número aleatorio 3: " + num3);
        System.out.println("Número aleatorio 4: " + num4);

        // Solicitar preferencia de orden
        System.out.print("¿En qué orden desea mostrar los números? (asc/desc): ");
        String orden = input.next();

        if (orden.equalsIgnoreCase("asc")) {
            ordenarAscendente(num1, num2, num3, num4);
        } else if (orden.equalsIgnoreCase("desc")) {
            ordenarDescendente(num1, num2, num3, num4);
        } else {
            System.out.println("Orden no reconocido. Mostrando en orden ascendente por defecto.");
            ordenarAscendente(num1, num2, num3, num4);
        }
    }

    private static void ordenarAscendente(int n1, int n2, int n3, int n4) {
        int primero, segundo, tercero, cuarto;

        // Ordeno los 2 primeros numeros
        if (n1 < n2) {
            primero = n1;
            segundo = n2;
        } else {
            primero = n2;
            segundo = n1;
        }

        // Ordeno el próximo en relación a los 2 números ya ordenados
        if (n3 < primero) {
            tercero = segundo;
            segundo = primero;
            primero = n3;
        } else {
            if (n3 < segundo) {
                tercero = segundo;
                segundo = n3;
            } else
                tercero = n3;
        }

        // Ahora ordeno el último en relación a los 3 números ya ordenados
        if (n4 < primero) {
            cuarto = tercero;
            tercero = segundo;
            segundo = primero;
            primero = n4;
        } else {
            if (n4 < segundo) {
                cuarto = tercero;
                tercero = segundo;
                segundo = n4;
            } else {
                if (n4 < tercero) {
                    cuarto = tercero;
                    tercero = n4;
                } else
                    cuarto = n4;
            }
        }

        System.out.println("Los números ordenados ascendentemente quedan así: " + primero + " " +
                segundo + " " + tercero + " " + cuarto);
    }

    private static void ordenarDescendente(int n1, int n2, int n3, int n4) {
        int primero, segundo, tercero, cuarto;

        // Ordeno los 2 primeros numeros en orden descendente
        if (n1 > n2) {
            primero = n1;
            segundo = n2;
        } else {
            primero = n2;
            segundo = n1;
        }

        // Ordeno el próximo en relación a los 2 números ya ordenados
        if (n3 > primero) {
            tercero = segundo;
            segundo = primero;
            primero = n3;
        } else {
            if (n3 > segundo) {
                tercero = segundo;
                segundo = n3;
            } else
                tercero = n3;
        }

        // Ahora ordeno el último en relación a los 3 números ya ordenados
        if (n4 > primero) {
            cuarto = tercero;
            tercero = segundo;
            segundo = primero;
            primero = n4;
        } else {
            if (n4 > segundo) {
                cuarto = tercero;
                tercero = segundo;
                segundo = n4;
            } else {
                if (n4 > tercero) {
                    cuarto = tercero;
                    tercero = n4;
                } else
                    cuarto = n4;
            }
        }

        System.out.println("Los números ordenados descendentemente quedan así: " + primero + " " +
                segundo + " " + tercero + " " + cuarto);
    }

}
