package Entidades;

import Entidades._1_Cadena;
import Servicios._1_CadenaServicio;

public class _1_Main {
    public static void main(String[] args) {
        // Crear una instancia de Cadena
        _1_Cadena cadena = new _1_Cadena("Denis y Maxi");

        // Mostrar la información inicial
        System.out.println("Información inicial de la cadena:");
        System.out.println(cadena);

        // Crear una instancia de CadenaServicio
        _1_CadenaServicio cadenaServicio = new _1_CadenaServicio();

        // Ejecutar los métodos de CadenaServicio
        cadenaServicio.mostrarVocales(cadena);
        cadenaServicio.invertirFrase(cadena);
        cadenaServicio.vecesRepetido(cadena, "a");

        // Comparar longitud con una nueva frase
        cadenaServicio.compararLongitud(cadena, "otra frase");

        // Unir frases
        cadenaServicio.unirFrases(cadena, "son hermanos");

        // Reemplazar letras
        cadenaServicio.reemplazar(cadena, "a");

        // Comprobar si contiene una letra
        cadenaServicio.contiene(cadena, "x");
    }
}
