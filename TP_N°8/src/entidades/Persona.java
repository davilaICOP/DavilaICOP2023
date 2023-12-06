package entidades;
import java.util.Scanner;
//enum estadoCivil{SOLTERO, CASADO, VIUDO, DIVORCIADO}
public abstract class Persona {
private static int num=1;
private String nombre;
private String apellido;
private int numId;
private estadoCivil estado;
private int dni;

Scanner scanner = new Scanner(System.in);

public Persona() {
	System.out.println("--------------------------- ");
	System.out.println("| Registrar nueva persona |");
	System.out.println("--------------------------- ");
	System.out.print("Ingrese Apellido: ");
	this.apellido=scanner.nextLine();
	System.out.print("Ingrese Nombre: ");
	this.nombre=scanner.nextLine();
	System.out.println("Ingrese DNI: ");
	this.dni=scanner.nextInt();
	this.numId=num;
	num++;
	System.out.println("Ingrese estado civil: {1)SOLTERO, 2)CASADO, 3)VIUDO, 4)DIVORCIADO}");
	int eCivil=scanner.nextInt();
	switch(eCivil) {
	case 1:
		this.estado=estadoCivil.SOLTERO;
		break;
	case 2:
		this.estado= estadoCivil.CASADO;
		break;
	case 3:
		this.estado= estadoCivil.VIUDO;
		break;
	case 4:
		this.estado= estadoCivil.DIVORCIADO;
		break;
		default:
			System.out.println("No ingreso una opcion valida, no se le asigno estado civil");
			this.estado=null;
	}
	
}
public Persona(String nombre, String apellido, estadoCivil estCivil, int dni) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.estado=estCivil;
	this.numId=num;
	num++;
	this.dni=dni;
}
public void mostrar() {
	System.out.println("-----------------------------------------------------------");
	System.out.println("Nombre: "+nombre+"\nApellido: "+ apellido+"\nE.Civil: "+this.estado +"\nDNI: "+this.dni);
	System.out.println("ID: "+this.numId);
	System.out.println("-----------------------------------------------------------");
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public estadoCivil getEstado() {
	return estado;
}
public void setEstado() {
	System.out.println("Ingrese estado civil: {1)SOLTERO, 2)CASADO, 3)VIUDO, 4)DIVORCIADO}");
	int esCivil=scanner.nextInt();
	switch(esCivil) {
	case 1:
		this.estado=estadoCivil.SOLTERO;
		break;
	case 2:
		this.estado= estadoCivil.CASADO;
		break;
	case 3:
		this.estado= estadoCivil.VIUDO;
		break;
	case 4:
		this.estado= estadoCivil.DIVORCIADO;
		break;
		default:
			System.out.println("No ingreso una opcion valida, no se le asigno estado civil");
			this.estado=null;
	}
}
public int getDni() {
	return dni;
}
public void setDni(int dni) {
	this.dni = dni;
}
public int getNumId() {
	return numId;
}
public void setNumId(int numId) {
	this.numId = numId;
}


}
