/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreriaMain.servicios;

import java.util.List;
import java.util.Scanner;
import libreriaMain.entidad.Autor;
import libreriaMain.entidad.Editorial;
import libreriaMain.entidad.Libro;
import libreriaMain.persistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraLibro {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    Scanner scanner = new Scanner(System.in);
    public void crearLibro() {
    System.out.println("Ingrese el ISBN del libro:");
    long isbn = Long.parseLong(scanner.nextLine());

    System.out.println("Ingrese el título del libro:");
    String titulo = scanner.nextLine();

    System.out.println("Ingrese el año de publicación del libro:");
    int anio = Integer.parseInt(scanner.nextLine());

    System.out.println("Ingrese la cantidad total de ejemplares:");
    int ejemplares = Integer.parseInt(scanner.nextLine());

    System.out.println("Ingrese la cantidad de ejemplares prestados (0 si ninguno):");
    int ejemplaresPrestados = Integer.parseInt(scanner.nextLine());

    // Obtener todas las editoriales disponibles
    List<Editorial> editoriales = controlPersis.obtenerTodasLasEditoriales();

    // Mostrar la lista de editoriales y obtener la elección del usuario
    System.out.println("Editoriales disponibles:");
    for (Editorial editorial : editoriales) {
        System.out.println("ID: " + editorial.getId() + ", Nombre: " + editorial.getNombre());
    }
    System.out.println("Ingrese el ID de la editorial del libro:");
    int editorialId = Integer.parseInt(scanner.nextLine());

    // Buscar la editorial seleccionada por el usuario
    Editorial editorial = null;
    for (Editorial e : editoriales) {
        if (e.getId() == editorialId) {
            editorial = e;
            break;
        }
    }

    // Validar que la editorial seleccionada exista
    if (editorial == null) {
        System.out.println("La editorial seleccionada no existe.");
        return;
    }

    // Obtener todas los autores disponibles
    List<Autor> autores = controlPersis.obtenerTodosLosAutores();

    // Mostrar la lista de autores y obtener la elección del usuario
    System.out.println("Autores disponibles:");
    for (Autor autor : autores) {
        System.out.println("ID: " + autor.getId() + ", Nombre: " + autor.getNombre());
    }
    System.out.println("Ingrese el ID del autor del libro:");
    int autorId = Integer.parseInt(scanner.nextLine());

    // Buscar el autor seleccionado por el usuario
    Autor autor = null;
    for (Autor a : autores) {
        if (a.getId() == autorId) {
            autor = a;
            break;
        }
    }

    // Validar que el autor seleccionado exista
    if (autor == null) {
        System.out.println("El autor seleccionado no existe.");
        return;
    }

    boolean alta = true; // Puedes establecerlo como quieras o preguntar al usuario

    // Crea una nueva instancia de Libro
    Libro libro = new Libro();
    libro.setIsbn(isbn);
    libro.setTitulo(titulo);
    libro.setAnio(anio);
    libro.setEjemplares(ejemplares);
    libro.setEjemplaresPrestados(ejemplaresPrestados);
    libro.setEjemplaresRestantes(ejemplares - ejemplaresPrestados);
    libro.setAlta(alta);
    libro.setEditorial(editorial);
    libro.setAutor(autor);

    // Llama al método para crear el libro en la base de datos
    controlPersis.crearLibro(libro);
    System.out.println("Libro creado exitosamente.");
}
 public void eliminarLibro() {
        listarLibros();
        System.out.println("Ingrese el ID del libro que desea eliminar:");
        int libroId = Integer.parseInt(scanner.nextLine());

        // Llama al método para eliminar el autor por su ID
        controlPersis.eliminarLibroPorId(libroId);
    }
 
 public void listarLibros() {
    List<Libro> libros = controlPersis.obtenerTodosLosLibros();

    if (libros.isEmpty()) {
        System.out.println("No se encontraron libros.");
    } else {
        System.out.println("Lista de Libros:");
        for (Libro libro : libros) {
            System.out.println("ID: " + libro.getId());
            System.out.println("ISBN: " + libro.getIsbn());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Año: " + libro.getAnio());
            System.out.println("Ejemplares: " + libro.getEjemplares());
            System.out.println("Ejemplares Prestados: " + libro.getEjemplaresPrestados());
            System.out.println("Ejemplares Restantes: " + libro.getEjemplaresRestantes());
            System.out.println("Alta: " + libro.isAlta());
            System.out.println("Autor: " + libro.getAutor().getNombre()); // Asumiendo que Autor tiene un método getNombre()
            System.out.println("Editorial: " + libro.getEditorial().getNombre()); // Asumiendo que Editorial tiene un método getNombre()
            System.out.println("-------------------");
        }
    }
}

 
}