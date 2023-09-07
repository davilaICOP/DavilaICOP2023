/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreriaMain.servicios;

import java.util.List;
import java.util.Scanner;
import libreriaMain.entidad.Autor;
import libreriaMain.persistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */

public class ControladoraAutor {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
     Scanner scanner = new Scanner(System.in);
    public void crearAutor(){
    System.out.println("Ingrese el nombre del autor:");
        String nombre = scanner.nextLine();

        System.out.println("¿Está el autor en alta? (true/false):");
        boolean alta = Boolean.parseBoolean(scanner.nextLine());

        // Crea una nueva instancia de Autor
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(alta);

       controlpersis.crearAutor(autor);
       controlpersis.agregarAutorTemporal(autor);
        System.out.println("Autor creado exitosamente.");
    }
   
    public void eliminarAutor() {
        listarAutores();
        System.out.println("Ingrese el ID del autor que desea eliminar:");
        int autorId = Integer.parseInt(scanner.nextLine());

        // Llama al método para eliminar el autor por su ID
        controlpersis.eliminarAutorPorId(autorId);
    }
    public void editarAutor() {
        listarAutores();
    System.out.println("Ingrese el ID del autor que desea editar:");
    int autorId = Integer.parseInt(scanner.nextLine());

    // Busca el autor por su ID para ver si existe
    Autor autor = controlpersis.obtenerAutorPorId(autorId);

    if (autor != null) {
        // Muestra los detalles del autor antes de la edición
        System.out.println("Detalles del autor:");
        System.out.println("ID: " + autor.getId());
        System.out.println("Nombre actual: " + autor.getNombre());
        System.out.println("Alta actual: " + autor.isAlta());

        // Solicita los nuevos valores al usuario
        System.out.println("Ingrese el nuevo nombre del autor (o presione Enter para mantener el actual):");
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.isEmpty()) {
            autor.setNombre(nuevoNombre);
        }

        System.out.println("¿El autor está en alta? (true/false) (o presione Enter para mantener el actual):");
        String altaInput = scanner.nextLine();
        if (!altaInput.isEmpty()) {
            boolean nuevoAlta = Boolean.parseBoolean(altaInput);
            autor.setAlta(nuevoAlta);
        }

        // Llama al método para actualizar el autor en la base de datos
        controlpersis.actualizarAutor(autor);
        System.out.println("Autor actualizado exitosamente.");
    } else {
        System.out.println("No se encontró ningún autor con el ID proporcionado.");
    }
}
   public void listarAutores() {
    List<Autor> autores = controlpersis.obtenerTodosLosAutores();

    if (autores.isEmpty()) {
        System.out.println("No se encontraron autores.");
    } else {
        System.out.println("Lista de Autores:");
        for (Autor autor : autores) {
            System.out.println("ID: " + autor.getId() + ", Nombre: " + autor.getNombre() + ", Alta: " + autor.isAlta());
        }
    }
}

  
    }

