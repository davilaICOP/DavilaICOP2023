package davilaICOP2023;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner d = new Scanner (System.in);
		
		String Nombre;
		
		System.out.println("Escriba su nombre: ");
		
		Nombre = d.nextLine();
		
		System.out.println("Usted es "+Nombre);
    }
}