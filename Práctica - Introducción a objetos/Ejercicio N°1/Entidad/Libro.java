package Entidad;
import java.util.Scanner;
public class Libro {
    Scanner sc= new Scanner(System.in);
    private int isbn;
    private String titulo;
    private String autor;
    private int pag;

    public Libro() {
        super();
    }
    public Libro(int Unisbn, String Untitulo,String unautor , int Unpag) {
        super();
        this.isbn = Unisbn;
        this.titulo = Untitulo;
        this.autor=unautor;
        this.pag = Unpag;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getPag() {
        return pag;
    }
    public void setPag(int pag) {
        this.pag = pag;
    }
     public void cargarLibro() {
            System.out.println("Ingrese el ISBN del libro:");
            int isbn = sc.nextInt();

            System.out.println("Ingrese el titulo del libro:");
            String titulo = sc.next();

            System.out.println("Ingrese el autor del libro:");
            String autor = sc.next();

            System.out.println("Ingrese el numero de paginas del libro:");
            int numeroPaginas = sc.nextInt();

            this.setIsbn(isbn);
            this.setTitulo(titulo);
            this.setAutor(autor);
            this.setPag(numeroPaginas);
          }
     public void mostrarLibro() {
            System.out.println("ISBN: " + this.getIsbn());
            System.out.println("Titulo: " + this.getTitulo());
            System.out.println("Autor: " + this.getAutor());
            System.out.println("Numero de paginas: " + this.getPag());
          }
}