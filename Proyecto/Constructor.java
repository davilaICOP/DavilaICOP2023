package Proyecto;
import java.util.*;
public abstract class Constructor {
    Scanner sc= new Scanner(System.in);
	private String nombre;
	private String apellido;
	private int dni;
	private static int idUsuario=1;
	private int idUser;
	private EstadoCivil Estado;
	private rol rolAcademico;
	
	
	public Constructor(String nom, String ape, EstadoCivil EstadoCivil) {
		this.nombre = nom;
		this.apellido = ape;
		this.Estado = EstadoCivil;
		idUser=idUsuario;
		idUsuario++;
	}

	public Constructor() {
		int Est;
		int ro;
		System.out.println("Ingrese nombre: ");
		nombre = sc.next();
		System.out.println("Ingrese apellido: ");
		apellido = sc.next();
		System.out.println("Ingrese DNI: ");
		dni = sc.nextInt();
		//Elegir numero de estado civil
		System.out.println("Estado civíl: 1)Casado - 2)Soltero - 3)Viudo - 4)Divorciado - 5)Separado");

		Est = sc.nextInt();
		
		switch(Est) {
		case 1: Estado = EstadoCivil.casado;
		break;
		case 2: Estado = EstadoCivil.soltero;
		break;
		case 3: Estado = EstadoCivil.viudo;
		break;
		case 4: Estado = EstadoCivil.divorciado;
		break;
		case 5: Estado = EstadoCivil.separado;
		break;
		}
	
	}
	
	//public static void cambiarEstado(int documento) {
		//if(getdni() == documento ) {
			
		//}else {
			//System.out.println("No existe el DNI ingresado");
		//}
	//}
	
	//public static int getdni() {
		//return dni;
	//}
	
}

// ayudame loco

enum EstadoCivil{
	soltero,
	casado,
	viudo,
	divorciado,
	separado
}

enum rol{
	estudiante,
	empleado
}