package Entidad;
import java.util.Scanner;
public class Rectangulo {
	private double lado1;
	private double lado2;

	// Método para crear un rectángulo con los lados especificados
	public Rectangulo(double lado1, double lado2) {
		super();
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
	
	// Método para calcular el área del rectángulo
	public double calcularArea() {	
		double area = lado1*lado2;
		return area;
	}
	
}
