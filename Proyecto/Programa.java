package Proyecto;
import java.util.*;
public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Empleado emple = new Empleado("pedro","gutierres",EstadoCivil.casado,"Estudiante", 2000,5,11);

		boolean ingreso = true;
        Scanner sc= new Scanner(System.in);
        int dato;
        int persona;

		while (ingreso) {
	        System.out.println("Bienvenido, ingrese una de las opciones");
	        System.out.println("1 - Agregar Persona");
	        System.out.println("2 - Cambiar Estado Civil Persona");
	        System.out.println("3 - Reasignar Legajo");
	        System.out.println("4 - Matricular Estudiante");
	        System.out.println("5 - Dar de Alta curso");
	        System.out.println("6 - Cambiar Departamento Profesor");
	        System.out.println("7 - Trasladar Personal de Servicio");
	        System.out.println("8 - Mostrar información");
	        System.out.println("0 - Salir");
			dato = sc.nextInt();
			
			switch(dato) {
			
			case 1: System.out.println("¿Qué desea agregar?");
					System.out.println("1) Estudiante");
					System.out.println("2) Empleado");
					persona = sc.nextInt();
					switch(persona) {
					case 1: Estudiantes estu = new Estudiantes();
							System.out.println("Has salido del programa");
					break;
					case 2: System.out.println("1) Profesor - 2) Empleado de Servicio");
						 	int empleado = sc.nextInt();
						 	switch(empleado) {
						 	case 1: Profesor profe = new Profesor();
						 	        System.out.println("Operación completada");
						 	break;
						 	case 2: EmpleadoServicio emple = new EmpleadoServicio();
						 	        System.out.println("Operación completada");
						 	break;
						 	}
			}
			case 2: 
				
			case 3:
				
			case 4:
				
			case 5:
				
			case 6:
				
			case 7:
				
			case 8:
				
			case 0: ingreso = false;
			break;
			}
			
		}
		
	}

}