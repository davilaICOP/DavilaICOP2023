package davilaICOP2023;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner d = new Scanner (System.in);
		
		int Numero;
		
		System.out.println("Escriba un numero:");
		
		Numero = d.nextInt();
		
		int RaizCuadrada = (int) Math.sqrt(Numero);
		int Doble = (int) (Numero*2);
		int Triple = (int) (Numero*3);
		
		System.out.println("El doble es: "+Doble);
		System.out.println("El triple es: "+Triple);
		System.out.println("La raiz cuadrada es: "+RaizCuadrada);
	}

}
