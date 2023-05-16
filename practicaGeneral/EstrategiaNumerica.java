package practicaGeneral;
import java.util.Scanner;


import java.util.Random;	
public class EstrategiaNumerica {
	
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	 Random rand = new Random();

	 // Solicitar nombre y edad
	 System.out.print("Ingrese su nombre: ");
	 String nombre = input.nextLine();
	 System.out.print("Ingrese su edad: ");
	 int edad = input.nextInt();

	 // Generar números aleatorios
	 int num1 = rand.nextInt(1000);
	 int num2 = rand.nextInt(1000);
	 int num3 = rand.nextInt(1000);
	 int num4 = rand.nextInt(1000);

	 // Mostramos los resultados
	 System.out.println("Nombre: " + nombre);
	 System.out.println("Edad: " + edad);
	 System.out.println("Número aleatorio 1: " + num1);
	 System.out.println("Número aleatorio 2: " + num2);
	 System.out.println("Número aleatorio 3: " + num3);
	
	 System.out.println("Número aleatorio 4: " + num4);

	 ordenar(num1, num2, num3, num4);
	 ordenar(22, 15, 13, 15);
	 }
	 private static void ordenar(int n1, int n2, int n3, int n4)
	 {
	 int primero, segundo, tercero, cuarto = 0;
	 //Ordeno los 2 primeros numeros
	 if (n1 < n2) { primero = n1;
	  segundo = n2;
	 }
	 else { primero = n2;
	  segundo = n1;
	  };
	  //Ordeno el proximo en relación a los 2 numeros ya ordenados
	 if (n3 < primero) {tercero = segundo;
	  segundo = primero;
	  primero = n3;
	  }
	 else {if (n3 < segundo) {tercero = segundo;
	  segundo = n3;}
	 else tercero=n3;
	 };
	 //Ahora ordeno el ultimo en relación a los 3 numeros ya ordenados
	  if (n4 < primero) {
	  cuarto = tercero;
	  tercero = segundo;
	  segundo = primero;
	  primero = n4;
	  }
	 else {if (n4 < segundo) {cuarto = tercero;
	  tercero = segundo;
	  segundo = n4;}
	 else {if (n4 < tercero) { cuarto = tercero;
	  tercero = n4;}
	 else cuarto = n4;
	 };
	 };
	 System.out.println("Los numeros ordenados ascendentemente quedan asi: " + primero + " " +
	 segundo + " " + tercero + " " + cuarto);
	 };
	 }