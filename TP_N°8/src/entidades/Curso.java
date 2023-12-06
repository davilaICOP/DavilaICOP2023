package entidades;
import java.util.Scanner;
import entidades.*;
public class Curso {
private static int nro=1;
private String nombre;
private int idCurso;

public Curso() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("-------------------------- ");
	System.out.println("| Registrar nuevo curso: |");
	System.out.println("-------------------------- ");
	System.out.println("Ingrese nombre de curso: ");
	this.nombre=scanner.nextLine();
	this.idCurso=nro++;
	
}
public Curso(String nombre) {
	this.nombre = nombre;
	this.idCurso=nro++;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void mostrar(){
	System.out.println(this.nombre);
}
public int getIdCurso() {
	return idCurso;
}
public void setIdCurso(int idCurso) {
	this.idCurso = idCurso;
}
}
