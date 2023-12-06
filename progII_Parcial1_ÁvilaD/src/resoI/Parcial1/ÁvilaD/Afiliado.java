package resoI.Parcial1.ÁvilaD;

import java.util.*;

public class Afiliado extends Persona {
	private static int nro=1;
	private int nroSocio;
	private boolean afeccionPrevia;
	private String fechaAdhesion;
	private PlanCobertura plan;
	private Empleado agenteAfiliador;
	Scanner scanner = new Scanner(System.in);
	public Afiliado(String apellido, String nombre, String genero, int dni, String fechaNacimiento, Domicilio domicilio, boolean afeccionPrevia,
			String fechaAdhesion, PlanCobertura plan, Empleado agenteAfiliador) {
		super(apellido, nombre, genero, dni, fechaNacimiento, domicilio);
		this.afeccionPrevia = afeccionPrevia;
		this.fechaAdhesion = fechaAdhesion;
		this.plan = plan;
		this.agenteAfiliador = agenteAfiliador;
	}
	public Afiliado() {
		super();
		System.out.println("-----------------------");
		System.out.println("Tiene afeccion previa: (Si/No)");
		boolean correcto=false;
		do {
			String ap=scanner.nextLine();
		if (ap.equalsIgnoreCase("si")) {
			this.afeccionPrevia=true;
			correcto=true;
		}else if (ap.equalsIgnoreCase("no")) {
			this.afeccionPrevia=false;
			correcto=true;
		}else {
			System.out.println("Ingrese Si o No! papanata");
		}
		}while(!correcto);
		System.out.println("Ingrese fecha de adhesion: (separado por /)");
		this.fechaAdhesion=scanner.nextLine();
		System.out.println("Ingrese PLAN: 1)PMO, 2)PMI, 3)PME");
		int o=scanner.nextInt();
		switch(o) {
		case 1:
			this.plan=PlanCobertura.PMO;
			break;
		case 2:
			this.plan=PlanCobertura.PMI;
			break;
		case 3:
			this.plan=PlanCobertura.PME;
			break;
		default:
			System.out.println("No ingreso opcion valida.");
		}
	}
	public void mostrar() {
		super.mostrar();
		System.out.println("Afiliado:");
		if (this.afeccionPrevia==true)
			System.out.print("Tiene afeccion previa");
		else {
			System.out.print("No tiene afeccion previa");
		}
		System.out.println(", Fecha de adhesion: "+this.fechaAdhesion+"\nPlan: "+this.plan +", Agente Afiliador: "+this.agenteAfiliador.getNombre()+" "+this.agenteAfiliador.getApellido());
		System.out.println("-----------------------");
	}
	//getterrs & setters
	public static int getNro() {
		return nro;
	}
	public static void setNro(int nro) {
		Afiliado.nro = nro;
	}
	public int getNroSocio() {
		return nroSocio;
	}
	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}
	public boolean isAfeccionPrevia() {
		return afeccionPrevia;
	}
	public void setAfeccionPrevia(boolean afeccionPrevia) {
		this.afeccionPrevia = afeccionPrevia;
	}
	public String getFechaAdhesion() {
		return fechaAdhesion;
	}
	public void setFechaAdhesion(String fechaAdhesion) {
		this.fechaAdhesion = fechaAdhesion;
	}
	public PlanCobertura getPlan() {
		return plan;
	}
	public void setPlan(PlanCobertura plan) {
		this.plan = plan;
	}
	public Empleado getAgenteAfiliador() {
		return agenteAfiliador;
	}
	public void setAgenteAfiliador(Empleado agenteAfiliador) {
		this.agenteAfiliador = agenteAfiliador;
	}
	}


