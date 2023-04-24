package davilaICOP2023;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner d = new Scanner (System.in);
		
		System.out.println("Escriba una frase: ");
		
		String Frase;
		
		Frase = d.nextLine();
		System.out.println("Frase en minuscula: "+Frase.toLowerCase());
		System.out.println("Frase en mayuscula: "+Frase.toUpperCase());

	}

}
