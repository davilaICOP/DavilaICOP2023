package main;
import entidades.*;
import java.util.Scanner;
public class Principal {
private static String eleccion="";
	
	private static void mostrarMenu()
	{
		System.out.println("Menu: ");
		System.out.println("1: Agregar persona");
		System.out.println("2: Cambiar estado civil de persona");
		System.out.println("3: Reasignar legajo de empleado");
		System.out.println("4: Matricular alumno a curso");
		System.out.println("5: Alta de curso");
		System.out.println("6: Cambio de departamento de Profesor");
		System.out.println("7: Cambio de seccion de un empleado de servicio");
		System.out.println("8: Mostrar personas de instituto");
		System.out.println("9: Mostrar informacion de Instituto");
		System.out.println("10: Mostrar cursos disponibles");
		System.out.println("11: Mostrar alumnos inscriptos a curso");
		System.out.println("12: Agregar seccion");
		System.out.println("13: Agregar grupo de cursado");
		
		System.out.println("q: Salir");	
		System.out.println("");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Opción: ");
		eleccion = scanner.nextLine();
	}
	public static void main(String[] args) {
		Instituto instituto = new Instituto();
		Departamento depto = new Departamento("DESARROLO DE SOFTWARE");
		Departamento depto2 = new Departamento("RECURSOS HUMANOS");
		Departamento depto3 = new Departamento("PUBLICIDAD");
		Departamento depto4 = new Departamento("CURSOS ESPECIALES");
		Departamento depto5 = new Departamento("MATERIAS BASICAS");
		instituto.agragrDepto(depto);
		instituto.agragrDepto(depto2);
		instituto.agragrDepto(depto3);
		instituto.agragrDepto(depto3);
		instituto.agragrDepto(depto4);
		instituto.agragrDepto(depto5);
		Seccion seccion = new Seccion("SECRETARIA");
		Seccion seccion2 = new Seccion("MANTENIMIENTO");
		Seccion seccion3 = new Seccion("BIBLIOTECA");
		Seccion seccion4 = new Seccion("REGENCIA");
		Seccion seccion5 = new Seccion("ADMINISTRACION");
		instituto.agregarSeccion(seccion);
		instituto.agregarSeccion(seccion2);
		instituto.agregarSeccion(seccion3);
		instituto.agregarSeccion(seccion4);
		instituto.agregarSeccion(seccion5);
		Curso curso = new Curso("Ingenieria de software");
		Curso curso2 = new Curso("Redes y comunicacion");
		instituto.agregarCurso(curso2);
		instituto.agregarCurso(curso);
		Matricula matricula = new Matricula(curso,2022);
		Matricula matricula2 = new Matricula(curso,2023);
		instituto.agregarMatricula(matricula2);
		instituto.agregarMatricula(matricula);
		Alumno alumno1 = new Alumno("Marcos", "Welschen", estadoCivil.SOLTERO , 123456);
		instituto.agregarPersona(alumno1);
		instituto.matricularAlumnoCurso(alumno1, matricula);
		Alumno alumno2 = new Alumno("Alejandro", "Eberhardt", estadoCivil.SOLTERO, 42330346);
		instituto.agregarPersona(alumno2);
		instituto.matricularAlumnoCurso(alumno2, matricula2);
		Profesor profesor1 = new Profesor("Maria Juana", "Stalder", estadoCivil.CASADO,54321, 1995, depto);
		instituto.agregarPersona(profesor1);
		Profesor profesor2 = new Profesor("Segundo", "Kuchen", estadoCivil.SOLTERO,78910, 2017, depto2);
		instituto.agregarPersona(profesor2);
		DeServicio deservicio1 = new DeServicio("Juan Carlos", "Lopez", estadoCivil.VIUDO, 22222, 2000, seccion2);
		instituto.agregarPersona(deservicio1);
		DeServicio deservicio2 = new DeServicio("Maria Marta", "Serralima", estadoCivil.DIVORCIADO, 12345, 2001, seccion);
		instituto.agregarPersona(deservicio2);
		while (!eleccion.equals("q"))
		 {
			mostrarMenu();	
			switch (eleccion){
			case "1":
				System.out.println("Eligio la opcion 1 -> Agregar persona");
				System.out.println("");
				instituto.agregarPersona();
				break;
			case "2":
				System.out.println("Elegi la opcion 2 -> Cambiar estado civil de la persona");
				instituto.cambiarEstadoCivil();
				System.out.println("");
				break;
			case "3":
				System.out.println("Elegi la opcion 3 -> Reasignacion de legajo");
				instituto.reasigancionLegajo();
				System.out.println("");
				break;
			case "4":
				System.out.println("Elegi la opcion 4 -> Matricular alumno a curso");
				instituto.matricularAlumnoCurso();
				break;
			case "5":
				System.out.println("Eligio la opcion 5 -> Alta de curso");
				instituto.cargarCurso();
				break;
			case "6":
				System.out.println("Eligio la opcion 6 -> Cambiar departamento a profesor");
				instituto.cambiarDepto();
				break;
			case "7":
				System.out.println("Eligio la opcion 7 -> Cambiar seccion a empleado de servicio");
				instituto.cambiarSeccion();
				break;
			case "8":
				System.out.println("Eligió la opcion 8 -> Mostrar personas");
				instituto.mostrarPersonas();
				break;
			case "9":
				System.out.println("Eligió la opcion 9 -> Mostrar Informacion");
				instituto.mostrar();
				break;
			case "10":
				System.out.println("Eligio la opcion 10 -> Mostrar cursos");
				instituto.mostrarCursos();
				break;
			case "11":
				System.out.println("Eligio la opcion 11 -> Mostrar alumnos inscriptos a cursos");
				instituto.mostrarAlumnosCurso();
				break;
			case "12":
				System.out.println("Eligio la opcion 12 -> Agregar seccion");
				instituto.agregarSeccion();
				break;
			case "13":
				System.out.println("Eligió la opcion 13 -> Agregar grupo de cursado");
				instituto.crearNuevoGrupo();
				break;
				
			case "q":
				System.out.println("Saliendo del sistema...");
				break;
				default:
					System.out.println("Ingreso opcion incorrecta.");
			}  
		}		
	}
}

