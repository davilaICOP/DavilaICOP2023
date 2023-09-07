/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreriaMain.persistencia;

import java.util.ArrayList;
import java.util.List;
import libreriaMain.entidad.Editorial;
import libreriaMain.entidad.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import libreriaMain.entidad.Libro;
/**
 *
 * @author ULTRA
 */
public class ControladoraPersistencia {
    private EntityManagerFactory emf;
    private EntityManager em;
    private List<Autor> autoresTemporales = new ArrayList<>();
    private List<Editorial> editorialesTemporales = new ArrayList<>();
    private List<Libro> librosTemporales = new ArrayList<>();
    
    AutorJpaController autorJpa = new AutorJpaController();
    EditorialJpaController editJpa = new EditorialJpaController();
    LibroJpaController libroJpa = new LibroJpaController();

    public ControladoraPersistencia(EntityManagerFactory emf, EntityManager em) {
        this.emf = emf;
        this.em = em;
    }
    
    public ControladoraPersistencia() {
        emf = Persistence.createEntityManagerFactory("libreriajpaPU");
    }
    
    public void crearAutor(Autor autor) {
        autorJpa.create(autor);
    }
    public void crearEditorial(Editorial editorial){
        editJpa.create(editorial);
    }
    public void crearLibro(Libro libro) {
        libroJpa.create(libro);
    }
    
    
    public void mostrarAutoresTemporales() {
    System.out.println("Autores temporales:");
    for (Autor autor : autoresTemporales) {
        System.out.println("Nombre: " + autor.getNombre() + ", Alta: " + autor.isAlta());
    }
    
    }
    
    public void eliminarAutorPorId(int autorId) {
        em = emf.createEntityManager();
        try {
            // Busca el autor por su ID
            Autor autor = em.find(Autor.class, autorId);
            
            if (autor != null) {
                // Comienza una transacción para realizar la eliminación
                em.getTransaction().begin();
                
                // Elimina el autor de la base de datos
                em.remove(autor);
                
                // Confirma la transacción
                em.getTransaction().commit();
                
                System.out.println("Autor eliminado exitosamente.");
            } else {
                System.out.println("No se encontró ningún autor con el ID proporcionado.");
            }
        } finally {
            em.close();
        }
    
    }
    public void eliminarEditorialPorId(int editorialId) {
         em = emf.createEntityManager();
        try {
            // Busca el autor por su ID
            Editorial editorial = em.find(Editorial.class, editorialId);
            
            if (editorial != null) {
                // Comienza una transacción para realizar la eliminación
                em.getTransaction().begin();
                
                // Elimina el autor de la base de datos
                em.remove(editorial);
                
                // Confirma la transacción
                em.getTransaction().commit();
                
                System.out.println("Editorial eliminado exitosamente.");
            } else {
                System.out.println("No se encontró ninguna editorial con el ID proporcionado.");
            }
        } finally {
            em.close();
        }
    }

    public void agregarAutorTemporal(Autor autor) {
        autoresTemporales.add(autor);
    }

   
    public void agregarEditorialTemporal(Editorial editorial) {
        editorialesTemporales.add(editorial);
    }

    public List<Autor> getAutoresTemporales() {
        return autoresTemporales;
    }

    public void setAutoresTemporales(List<Autor> autoresTemporales) {
        this.autoresTemporales = autoresTemporales;
    }

    public List<Editorial> getEditorialesTemporales() {
        return editorialesTemporales;
    }

    public void setEditorialesTemporales(List<Editorial> editorialesTemporales) {
        this.editorialesTemporales = editorialesTemporales;
    }

    public Autor obtenerAutorPorId(int autorId) {
    em = emf.createEntityManager();
    try {
        return em.find(Autor.class, autorId);
    } finally {
        em.close();
    }
}

public void actualizarAutor(Autor autor) {
    em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        em.merge(autor); // Actualiza el autor en la base de datos
        em.getTransaction().commit();
    } finally {
        em.close();
    }
}


public Editorial obtenerEditorialporId(int editorialId) {
         em = emf.createEntityManager();
    try {
        return em.find(Editorial.class, editorialId);
    } finally {
        em.close();
    }
    }
public void actualizarEditorial(Editorial editorial) {
    em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        em.merge(editorial); // Actualiza la editorial en la base de datos
        em.getTransaction().commit();
    } finally {
        em.close();
    }
}

    
    public List<Editorial> obtenerTodasLasEditoriales() {
    em = emf.createEntityManager();
    try {
        // Realiza una consulta JPA para obtener todas las editoriales
        Query query = em.createQuery("SELECT e FROM Editorial e");
        List<Editorial> editoriales = query.getResultList();
        return editoriales;
    } finally {
        em.close();
    }
}
   public List<Autor> obtenerTodosLosAutores() {
    em = emf.createEntityManager();
    try {
        // Realiza una consulta JPA para obtener todos los autores
        Query query = em.createQuery("SELECT a FROM Autor a");
        List<Autor> autores = query.getResultList();
        return autores;
    } finally {
        em.close();
    }
}
public void eliminarLibroPorId(int libroId) {
    em = emf.createEntityManager();
    try {
        // Busca el libro por su ID
        Libro libro = em.find(Libro.class, libroId);

        if (libro != null) {
            // Comienza una transacción para realizar la eliminación
            em.getTransaction().begin();

            // Elimina el libro de la base de datos
            em.remove(libro);

            // Confirma la transacción
            em.getTransaction().commit();

            System.out.println("Libro eliminado exitosamente.");
        } else {
            System.out.println("No se encontró ningún libro con el ID proporcionado.");
        }
    } finally {
        em.close();
    }
}


    public List<Libro> obtenerTodosLosLibros() {
        em = emf.createEntityManager();
    try {
        // Realiza una consulta JPA para obtener todos los libros
        Query query = em.createQuery("SELECT l FROM Libro l");
        List<Libro> libros = query.getResultList();
        return libros;
    } finally {
        em.close();
    }
    }



}

    

    
    

