package Principal;
import Entidad.Libro;
import java.util.Scanner;
public class Principal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc= new Scanner(System.in);

        Libro primerlibro= new Libro(24234324, "titulo","romeo", 120);
        System.out.println(primerlibro.getIsbn());
        System.out.println(primerlibro.getTitulo());
        System.out.println(primerlibro.getAutor());
        System.out.println(primerlibro.getPag());

        System.out.println();

        Libro unlibro = new Libro();
        unlibro.cargarLibro();
        unlibro.mostrarLibro();
    }

}