package davilaICOP2023;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner d = new Scanner (System.in);
		
		int C;
		
		System.out.println("Cantidad de grados centígrados: ");
		
		C = d.nextInt();
		int F = 32+(9*C/5);
		
		System.out.println("Cantidad de grados Fahrenheit: "+F);
		
	}

}
