package Resolucion;
import java.util.Scanner;
public class Autobus extends Vehiculo {
	private int nroPlazas;

	public Autobus(String marca, String modelo, int año, int nro_motor, int nro_chasis, String color, int potenciaCV, String matricula,
			int nroPlazas) {
		super(marca, modelo, año, nro_motor, nro_chasis, color, potenciaCV, matricula);
		this.nroPlazas = nroPlazas;
	}
	Scanner scanner = new Scanner(System.in);

	public Autobus() {
		super();
		System.out.println("ingrese plazas");
		this.nroPlazas = scanner.nextInt();
	}
	//getters y setters
	public void mostrar() {
		super.mostrar();
		System.out.println("NRO DE BUTACAS AUTOBUS: "+this.nroPlazas);
	}
	public int getNroPlazas() {
		return nroPlazas;
	}

	public void setNroPlazas(int nroPlazas) {
		this.nroPlazas = nroPlazas;
	}

	
}