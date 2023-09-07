/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreriaMain.servicios;

import java.util.List;
import java.util.Scanner;
import libreriaMain.entidad.Editorial;
import libreriaMain.persistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraEditorial {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    Scanner scanner = new Scanner(System.in);
    
    public void crearEditorial(){
    
    System.out.println("Ingresar nombre");
    String nombre = scanner.nextLine();
    
    System.out.println("¿Está la editorial en alta? (true/false):");
    boolean alta = Boolean.parseBoolean(scanner.nextLine());
    Editorial editorial = new Editorial();
    editorial.setNombre(nombre);
    editorial.setAlta(alta);
    controlpersis.crearEditorial(editorial);
    controlpersis.agregarEditorialTemporal(editorial);
    System.out.println("Autor creado exitosamente.");
  }
    public void eliminarEditorial() {
        listarEditoriales();
        System.out.println("Ingrese el ID de la editorial que desea eliminar:");
        int editorialId = Integer.parseInt(scanner.nextLine());

        // Llama al método para eliminar el autor por su ID
        controlpersis.eliminarEditorialPorId(editorialId);
    }
    
     public void editarEditorial() {
     listarEditoriales();
    System.out.println("Ingrese el ID de la editorial que desea editar:");
    int editorialId = Integer.parseInt(scanner.nextLine());

    // Busca el autor por su ID para ver si existe
    Editorial editorial = controlpersis.obtenerEditorialporId(editorialId);

    if (editorial != null) {
        // Muestra los detalles del autor antes de la edición
        System.out.println("Detalles de la editorial:");
        System.out.println("ID: " + editorial.getId());
        System.out.println("Nombre actual: " + editorial.getNombre());
        System.out.println("Alta actual: " + editorial.isAlta());

        // Solicita los nuevos valores al usuario
        System.out.println("Ingrese el nuevo nombre de la editorial (o presione Enter para mantener el actual):");
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.isEmpty()) {
            editorial.setNombre(nuevoNombre);
        }

        System.out.println("¿La editorial está en alta? (true/false) (o presione Enter para mantener el actual):");
        String altaInput = scanner.nextLine();
        if (!altaInput.isEmpty()) {
            boolean nuevoAlta = Boolean.parseBoolean(altaInput);
            editorial.setAlta(nuevoAlta);
        }

        // Llama al método para actualizar el autor en la base de datos
        controlpersis.actualizarEditorial(editorial);
        System.out.println("Editorial actualizada exitosamente.");
    } else {
        System.out.println("No se encontro ninguna editorial con el ID proporcionado.");
    }
}
  public void listarEditoriales() {
    List<Editorial> editoriales = controlpersis.obtenerTodasLasEditoriales();

    if (editoriales.isEmpty()) {
        System.out.println("No se encontraron editoriales.");
    } else {
        System.out.println("Lista de Editoriales:");
        for (Editorial editorial : editoriales) {
            System.out.println("ID: " + editorial.getId() + ", Nombre: " + editorial.getNombre() + ", Alta: " + editorial.isAlta());
        }
    }
}

  
}
