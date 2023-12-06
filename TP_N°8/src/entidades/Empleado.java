package entidades;
import java.util.Scanner;
public abstract class Empleado extends Persona {
private boolean esActivo=true;
private static int nro=1;
private int nroLegajo;
private int añoIncorp;
public Empleado() {
	super();
	Scanner scanner = new Scanner(System.in);
	System.out.println("----------------------- ");
	System.out.println("| Registrar empleado: |");
	System.out.println("----------------------- ");
	System.out.println("Ingresar año de incorporacion: ");
	this.añoIncorp=scanner.nextInt();
	this.nroLegajo=nro++;
	this.esActivo=true;
	
}

public Empleado(String nombre, String apellido, estadoCivil estCivil, int dni, int añoIncorp) {
	super(nombre, apellido, estCivil, dni);
	this.añoIncorp = añoIncorp;
	this.nroLegajo = nro++;
}

public Empleado(int añoIncorp) {
	super();
	this.nroLegajo = nro++;
	this.añoIncorp = añoIncorp;
	this.esActivo=true;
}
public void mostrar() {
	super.mostrar();
	System.out.println("Nro Legajo: "+this.nroLegajo+", Año de incorp: "+this.añoIncorp);
	System.out.println("ACTIVO?: "+esActivo);
}
public int getNroLegajo() {
	return nroLegajo;
}
public void setNroLegajo(int nroLegajo) {
	this.nroLegajo = nroLegajo;
}
public int getAñoIncorp() {
	return añoIncorp;
}
public void setAñoIncorp(int añoIncorp) {
	this.añoIncorp = añoIncorp;
}
public boolean isEsActivo() {
	return esActivo;
}
public void setEsActivo(boolean esActivo) {
	this.esActivo = esActivo;
}
public void cambiarLegajo() {
	this.esActivo=false;
}


}
