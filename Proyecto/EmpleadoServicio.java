package Proyecto;
import java.util.Scanner;

public class EmpleadoServicio extends Empleado {
    Scanner sc= new Scanner(System.in);
    private Seccion seccion;
	int sec;

	public EmpleadoServicio() {
		
		System.out.println("Ingresar sección a la que está asignado: 1)Biblioteca - 2)Regencia - 3)Secretaría - 4)Administración");
		sec = sc.nextInt();
		
		switch(sec) {
		case 1: seccion = Seccion.Biblioteca;
		break;
		case 2: seccion = Seccion.Regencia;
		break;
		case 3: seccion = Seccion.Secretaría;
		break;
		case 4: seccion = Seccion.Administración;
		break;
		
		}	
	}
	
	enum Seccion{
		Biblioteca,
		Regencia,
		Secretaría,
		Administración
	}
}
