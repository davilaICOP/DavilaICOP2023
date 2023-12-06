package Principal;
import Entidad.Libreria;
public class ConstructorLibreria {

	public static void main(String[] args) {
        // Crear una instancia de la clase Libreria
        Libreria miLibro = new Libreria();

        // Cargar el libro con los datos ingresados por el usuario
        miLibro.cargarLibro();

        // Mostrar la información del libro
        miLibro.informarLibro();
    }

}