/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.libreriamain;

import java.util.Scanner;
import libreriaMain.entidad.Autor;
import libreriaMain.persistencia.ControladoraPersistencia;
import libreriaMain.servicios.ControladoraAutor;
import libreriaMain.servicios.ControladoraEditorial;
import libreriaMain.servicios.ControladoraLibro;

/**
 *
 * @author ULTRA
 */
public class LibreriaMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladoraAutor autorejem = new ControladoraAutor();
        ControladoraEditorial editejem = new ControladoraEditorial();
        ControladoraLibro libroejem = new ControladoraLibro();
      
      while (true) {
            System.out.println("Menú Principal");
            System.out.println("1. Crear Autor");
            System.out.println("2. Eliminar Autor");
            System.out.println("3. Crear Editorial");
            System.out.println("4. Eliminar Editorial");
            System.out.println("5. Editar Autor");
            System.out.println("6. Editar Editorial");
            System.out.println("7. Listar Editoriales");
            System.out.println("8. Listar Autores");
            System.out.println("9. Crear Libro");
            System.out.println("10. Listar Libros");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpia el buffer del teclado

            switch (opcion) {
                case 1:
                    autorejem.crearAutor();
                    break;
                case 2:
                    autorejem.eliminarAutor();
                    break;
                case 3:
                    editejem.crearEditorial();
                    break;
                case 4:
                    editejem.eliminarEditorial();
                    break;
                case 5:
                    autorejem.editarAutor();
                    break;
                case 6:
                    editejem.editarEditorial();
                    break;
                case 7:
                    editejem.listarEditoriales();
                    break;
                case 8:
                    autorejem.listarAutores();
                    break;
                case 9:
                    libroejem.crearLibro();
                    break;
                case 10:
                    libroejem.listarLibros();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }
}
    
