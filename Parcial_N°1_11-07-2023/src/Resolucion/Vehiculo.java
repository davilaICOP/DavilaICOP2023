package Resolucion;
import java.util.Scanner;
public abstract class Vehiculo {
	private String marca;
	private String modelo;
	private int año;
	private int nro_motor;
	private int nro_chasis;
	private String color;
	private int potenciaCV;
	private String matricula;
	
	Scanner scanner = new Scanner(System.in);
	
	public Vehiculo(String marca, String modelo, int año, int nro_motor, int nro_chasis, String color, int potenciaCV,
			String matricula) {
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.nro_motor = nro_motor;
		this.nro_chasis = nro_chasis;
		this.color = color;
		this.potenciaCV = potenciaCV;
		this.matricula = matricula;
	}

	public Vehiculo() {
		System.out.println("NUEVO VEHICULO");
		System.out.println("Ingrese marca");
		this.marca=scanner.nextLine();
		System.out.println("Ingrese modelo");
		this.modelo=scanner.nextLine();
		System.out.println("Ingrese año");
		this.año=scanner.nextInt();
		System.out.println("Ingrese nro motor");
		this.nro_motor=scanner.nextInt();
		System.out.println("Ingrese nro chasis");
		this.nro_chasis=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese color");
		this.color=scanner.nextLine();
		System.out.println("Ingrese potencia en CV");
		this.potenciaCV=scanner.nextInt();
		System.out.println("Ingrese matricula");
		scanner.nextLine();
		this.matricula=scanner.nextLine();
	}
	public void mostrar() {
		System.out.println("------------------------------------------");
		System.out.println("MARCA: "+this.marca+", MODELO: "+this.modelo +", AÑO: "+this.año + "\nNRO MOTOR: "+this.nro_motor+", NRO CHASIS: "+this.nro_chasis+"\nPOTENCIA EN CV: "+this.potenciaCV+", MATRICULA: "+this.matricula);
	}
	//gettes && setters:
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getNro_motor() {
		return nro_motor;
	}

	public void setNro_motor(int nro_motor) {
		this.nro_motor = nro_motor;
	}

	public int getNro_chasis() {
		return nro_chasis;
	}

	public void setNro_chasis(int nro_chasis) {
		this.nro_chasis = nro_chasis;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPotenciaCV() {
		return potenciaCV;
	}

	public void setPotenciaCV(int potenciaCV) {
		this.potenciaCV = potenciaCV;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}