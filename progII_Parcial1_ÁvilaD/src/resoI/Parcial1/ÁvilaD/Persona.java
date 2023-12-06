package resoI.Parcial1.ÁvilaD;

import java.util.Scanner;

public class Persona {
	Scanner scanner = new Scanner(System.in);
	private String apellido;
	private String nombre;
	private String genero;
	private int dni;
	private String fechaNacimiento;
	private Domicilio domicilio;

	public Persona(String apellido, String nombre, String genero, int dni, String fechaNacimiento, Domicilio domicilio) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.genero = genero;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio=domicilio;
	}

	public Persona() {
		System.out.println("-----------------------");
		System.out.println("Carga de nueva persona:");
		System.out.println("Ingrese nombre: ");
		this.nombre=scanner.nextLine();
		System.out.println("Ingrese apellido: ");
		this.apellido=scanner.nextLine();
		System.out.println("Ingrese genero: ");
		this.genero=scanner.nextLine();
		System.out.println("Ingrese DNI: ");
		this.dni=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese fecha de nacimiento (separando con /): ");
		this.fechaNacimiento=scanner.nextLine();
		System.out.println("-----------------------");
	}
	public void mostrar() {
		System.out.println("Nombre: "+this.nombre+", Apellido: "+this.apellido+", Genero: "+this.genero+", DNI: "+this.dni+", Fecha de nacimiento: "+this.fechaNacimiento );
		domicilio.mostrar();
	}

	//getters & setters
	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	}