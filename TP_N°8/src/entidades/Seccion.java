package entidades;

import java.util.Scanner;

public class Seccion {
private String nombre;

Scanner scanner = new Scanner(System.in);

public Seccion() {
	super();
	System.out.println("---------------------------- ");
	System.out.println("| Registrar nueva seccion: |");
	System.out.println("----------------------------");
	System.out.println("Ingrese Nombre: ");
	this.nombre=scanner.nextLine();
}

public Seccion(String nombre) {
	super();
	this.nombre = nombre;
}
public void mostrar() {
	System.out.println("Nombre de seccion: "+this.nombre);
}
public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}


}
