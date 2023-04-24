package davilaICOP2023;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner d = new Scanner (System.in);
		
		System.out.println("Escriba el primer numero: ");
		int Numero1 = d.nextInt();
		System.out.println("Escriba el segundo numero: ");
		int Numero2 = d.nextInt();
		int suma = Numero1 + Numero2;
		System.out.println("La suma de "+Numero1+" y "+Numero2+" 8es igual a "+suma);
	}

}
