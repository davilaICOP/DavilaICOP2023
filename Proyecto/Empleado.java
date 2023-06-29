package Proyecto;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import Proyecto.Profesor.Departamento;

public class Empleado extends Constructor {
    Scanner sc= new Scanner(System.in);
	private	int anio;
	private int mes;
	private int dia;
	private Date anioIncorp;
	private static int idLegajo;
	private int nroLegajo=1;
	private tipoEmpleado empleado;

	public Empleado(String nom, String ape,EstadoCivil est, Departamento depa, int anio, int mes, int dia) {
		super(nom, ape, est);
		
	}
	
	public Empleado() {
		super();
		
		System.out.println("Ingresar año: ");
		anio = sc.nextInt();
		System.out.println("Ingresar mes: ");
		mes = sc.nextInt();
		System.out.println("Ingresar día: ");
		dia = sc.nextInt();
		
		GregorianCalendar calendario= new GregorianCalendar(anio,mes-1,dia);
		this.anioIncorp=calendario.getTime();
			
		idLegajo = nroLegajo;
		nroLegajo++;
	}
}

enum tipoEmpleado{
	profesor,
	personalServicio
}

/*
public void setTipo(String tip) {
	this.tipo = tip;
}
public void setanioIngreso(int anio, int mes, int dia) {
	GregorianCalendar calendario= new GregorianCalendar(anio,mes-1,dia);
	anioIncorp=calendario.getTime();
}

public void legajo() {
	idLegajo = nroLegajo;
	nroLegajo++;
}

public String getTipo() {
	return this.tipo;
}*/