package Entidad;
import java.util.Scanner;
public class Empleado {
	private String nombre;
	private int edad;
	private double salario;
	
	public Empleado() {
		super();
	}

	public Empleado(String nombre, int edad, double salario) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}
	
	public void calcularAumento() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese nombre del empleado: ");
		String nombre = sc.next();
		
		System.out.println("Ingrese edad del empleado: ");
		int edad = sc.nextInt();
		
		System.out.println("Ingrese salario del empleado: ");
		double salario = sc.nextDouble();
		
		double aumentoMayores = salario*0.1;
		double aumentoMenores = salario*0.05;
		
		if (edad>30) {
			System.out.println("El aumento salarial del empleado es de: "+aumentoMayores);
			}
		else {
			System.out.println("El aumento salarial del empleado es de: "+aumentoMenores);
		}
	}			
}


