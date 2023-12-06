package Entidad;

import java.util.Scanner;

public class Libreria {
    private String ISBN;
    private String titulo;
    private String autor;
    private int numPaginas;

    // Constructor vacío
    public Libreria() {
    }

    // Constructor con parámetros
    public Libreria(String ISBN, String titulo, String autor, int numPaginas) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    // Método para cargar un libro pidiendo los datos al usuario
    public void cargarLibro() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ISBN del libro: ");
        ISBN = scanner.nextLine();

        System.out.print("Ingrese el título del libro: ");
        titulo = scanner.nextLine();

        System.out.print("Ingrese el autor del libro: ");
        autor = scanner.nextLine();

        System.out.print("Ingrese el número de páginas del libro: ");
        numPaginas = scanner.nextInt();
    }

    // Método para informar la información del libro
    public void informarLibro() {
        System.out.println("Información del libro:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Número de páginas: " + numPaginas);
    }
}    