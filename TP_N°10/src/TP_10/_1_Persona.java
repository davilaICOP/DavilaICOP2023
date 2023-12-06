package TP_10;

import java.util.Scanner;

class Persona {
    public void mostrar() {
        System.out.println("Método mostrar() invocado");
    }
}

public class _1_Persona {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializar el objeto Persona a null
        Persona persona = null;

        try {
            // Intentar invocar el método mostrar() en un objeto null
            persona.mostrar();
        } catch (NullPointerException e) {
            System.out.println("Se ha producido una NullPointerException: " + e.getMessage());
        } finally {
            scanner.close(); // Cerrar el scanner al finalizar
        }
    }
}

