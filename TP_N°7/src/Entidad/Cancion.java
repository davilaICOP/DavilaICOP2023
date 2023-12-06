package Entidad;
import java.util.Scanner;
public class Cancion {
    Scanner sc= new Scanner(System.in);
	private String titulo;
	private String autor;

	public Cancion() {
		super();
	}
	public Cancion(String titulo, String autor) {
		super();
		
		this.titulo = titulo;
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void cargarCancion() {
		System.out.println("Ingrese titulo de la cancion: ");
		String titulo = sc.next();
		
		System.out.println("Ingrese autor de la cancion: ");
		String autor = sc.next();
		
		this.setTitulo(titulo);
		this.setAutor(autor);	
	}
	
	public void mostrarCancion() {
		System.out.println("Titulo: "+this.getTitulo());
		System.out.println("Autor: "+this.getAutor());
	}
}
