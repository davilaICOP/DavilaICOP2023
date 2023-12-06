package Entidades;

import java.util.Scanner;

public class _1_Cadena {
 private String frase;
 private int longitud;

 // Constructor vacío
 public _1_Cadena() {
 }

 // Constructor con atributo frase
 public _1_Cadena(String frase) {
     this.frase = frase;
     this.longitud = frase.length();
 }

 // Getters y setters
 public String getFrase() {
     return frase;
 }

 public void setFrase(String frase) {
     this.frase = frase;
     this.longitud = frase.length();
 }

 public int getLongitud() {
     return longitud;
 }

 // Método toString para imprimir la cadena
 @Override
 public String toString() {
     return "Cadena{" +
             "frase='" + frase + '\'' +
             ", longitud=" + longitud +
             '}';
 }
}
