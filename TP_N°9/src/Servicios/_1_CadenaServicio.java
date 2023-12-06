

// Clase CadenaServicio en el paquete servicios
package Servicios;

import java.util.Scanner;
import Entidades._1_Cadena;

public class _1_CadenaServicio {
    private Scanner scanner;

    // Constructor
    public _1_CadenaServicio() {
        this.scanner = new Scanner(System.in);
    }

    // Método mostrarVocales
    public void mostrarVocales(_1_Cadena cadena) {
        int contadorVocales = 0;
        String vocales = "aeiouAEIOU";

        for (char caracter : cadena.getFrase().toCharArray()) {
            if (vocales.indexOf(caracter) != -1) {
                contadorVocales++;
            }
        }

        System.out.println("La frase contiene " + contadorVocales + " vocales.");
    }

    // Método invertirFrase
    public void invertirFrase(_1_Cadena cadena) {
        StringBuilder fraseInvertida = new StringBuilder(cadena.getFrase());
        fraseInvertida.reverse();
        System.out.println("Frase invertida: " + fraseInvertida);
    }

    // Método vecesRepetido
    public void vecesRepetido(_1_Cadena cadena, String letra) {
        int contador = 0;

        for (char caracter : cadena.getFrase().toCharArray()) {
            if (Character.toString(caracter).equalsIgnoreCase(letra)) {
                contador++;
            }
        }

        System.out.println("El carácter '" + letra + "' se repite " + contador + " veces.");
    }

    // Método compararLongitud
    public void compararLongitud(_1_Cadena cadena, String nuevaFrase) {
        if (cadena.getLongitud() == nuevaFrase.length()) {
            System.out.println("Las dos frases tienen la misma longitud.");
        } else {
            System.out.println("Las dos frases tienen longitudes diferentes.");
        }
    }

    // Método unirFrases
    public void unirFrases(_1_Cadena cadena, String nuevaFrase) {
        cadena.setFrase(cadena.getFrase() + " " + nuevaFrase);
        System.out.println("Frase resultante: " + cadena.getFrase());
    }

    // Método reemplazar
    public void reemplazar(_1_Cadena cadena, String letra) {
        System.out.print("Ingrese el carácter por el cual desea reemplazar 'a': ");
        String nuevoCaracter = scanner.nextLine();

        String fraseReemplazada = cadena.getFrase().replace(letra, nuevoCaracter);
        System.out.println("Frase resultante: " + fraseReemplazada);
    }

    // Método contiene
    public void contiene(_1_Cadena cadena, String letra) {
        boolean contiene = cadena.getFrase().toLowerCase().contains(letra.toLowerCase());
        System.out.println("La frase " + (contiene ? "sí" : "no") + " contiene la letra '" + letra + "'.");
    }
}
