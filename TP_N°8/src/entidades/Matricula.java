package entidades;
import java.util.ArrayList;
import java.util.Scanner;
public class Matricula {
private Curso curso;
private ArrayList<Alumno>alumnos;
private int año;

Scanner scanner = new Scanner(System.in);

public Matricula(Curso curso, int año) {
	super();
	this.curso = curso;
	this.año = año;
	alumnos= new ArrayList();
}
public void agregarAlumno(Alumno alumno) {
	alumnos.add(alumno);
}
public void mostrarInscriptos() {
	for (int i=0;i<alumnos.size();i++) {
		System.out.println(alumnos.get(i).getNombre()+" "+alumnos.get(i).getApellido()+", ");
	}
}
public void mostrar() {
	System.out.println("ID: "+this.curso.getIdCurso()+", NOMBRE: "+this.curso.getNombre());
	System.out.println("Año: "+this.año);
	for (int i=0;i<alumnos.size();i++) {
		System.out.println((alumnos.get(i)).getNombre()+" "+(alumnos.get(i).getApellido())+", ");
	}
	System.out.println();
}

public Curso getCurso() {
	return this.curso;
}
public void setIdCurso(Curso curso) {
	this.curso = curso;
}
public int getAño() {
	return año;
}
public void setAño(int año) {
	this.año = año;
}




}