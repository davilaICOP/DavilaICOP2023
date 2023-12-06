package resoI.Parcial1.ÁvilaD;

import java.util.*;

public class Empleado extends Persona {
	private static int nro=1;
	private String fechaInicio;
	private int nroLegajo;
	private Cargo cargo;

	public Empleado(String apellido, String nombre, String genero, int dni, String fechaNacimiento, Domicilio domicilio, String fechaInicio, Cargo cargo) {
		super(apellido, nombre, genero, dni, fechaNacimiento, domicilio);
		this.fechaInicio = fechaInicio;
		this.nroLegajo = nro++;
		this.cargo = cargo;
	}

	public Empleado() {
		super();
		this.nroLegajo=nro++;
		System.out.println("-----------------------");
		System.out.println("Ingrese cargo: 1)ADMINISTRATIVO, 2)ESPECIALIZADO, 3)DIRECTIVO, 4)AGENTE AFLILIADOR");
		int o = scanner.nextInt();
		switch(o) {
		case 1: 
			this.cargo=cargo.ADMINISTRATIVO;
			break;
		case 2: 
			this.cargo=cargo.ESPECIALIZADO;
			break;
		case 3:
			this.cargo=cargo.DIRECTIVO;
		case 4: 
			this.cargo=cargo.AGENTE_AFILIADOR;
			break;
		default:
			System.out.println("No ingreso opcion valida.");	
		}
		scanner.nextLine();
		System.out.println("Ingrese fecha de inicio (separado por /):");
		this.fechaInicio=scanner.nextLine();
		System.out.println("-----------------------");
	}
	public void mostrar() {
		super.mostrar();
		System.out.println("Empleado: ");
		System.out.println("Numero de Legajo: "+nroLegajo +", Cargo: "+cargo +"\nFecha de inicio: "+fechaInicio);
		System.out.println("-----------------------");
	}

	//getters & setters
	public static int getNro() {
		return nro;
	}

	public static void setNro(int nro) {
		Empleado.nro = nro;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getNroLegajo() {
		return nroLegajo;
	}

	public void setNroLegajo(int nroLegajo) {
		this.nroLegajo = nroLegajo;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}
