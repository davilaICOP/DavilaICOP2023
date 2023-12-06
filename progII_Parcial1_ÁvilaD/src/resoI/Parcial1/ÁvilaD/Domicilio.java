package resoI.Parcial1.ÁvilaD;

import java.util.Scanner;
public class Domicilio {
	Scanner scanner = new Scanner(System.in);
	private String barrio;
	private String calle;
	private int nro;
	private int localidad;

	public Domicilio(String barrio, String calle, int nro, int localidad) {
		this.barrio = barrio.toLowerCase();
		this.calle = calle.toLowerCase();
		this.nro = nro;
		this.localidad = localidad;
	}

	public Domicilio() {
		System.out.println("-----------------------");
		System.out.println("Ingrese nombre del barrio: ");
		this.barrio=scanner.nextLine().toLowerCase();;
		System.out.println("Ingrese nombre de la calle: ");
		this.calle=scanner.nextLine().toLowerCase();
		System.out.println("Ingrese numero de casa: ");
		this.nro=scanner.nextInt();
		System.out.println("-----------------------");
		
	}
	public void mostrar() {
		System.out.println("Domicilio:");
		System.out.println("Barrio: "+this.barrio+", Cod. Localidad: "+this.localidad+", Calle: "+this.calle+", Numero: "+this.nro);
	}

	//getters & setters
	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public int getLocalidad() {
		return localidad;
	}

	public void setLocalidad(int localidad) {
		this.localidad = localidad;
	}


} 
