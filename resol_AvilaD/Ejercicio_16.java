package resol_AvilaD;
import java.util.Scanner;
public class Ejercicio_16 {
	public static void notas() {
	Scanner scanner = new Scanner (System.in);
	double notas[]= new double[10];
	String alumnos[]= new String[10];
	int j= 0;
	int i= 0;
	for ( i = 0; i < alumnos.length; i++) {
		System.out.println("Ingresar nombre del alumno:");
		alumnos[i]=scanner.next();
		System.out.println("Ingresar nota del alumno:");
		notas[j]=scanner.nextDouble();
		while(notas[j]>10) {
			System.out.println("Nota ingresada erronea, vuelve a ingresar: ");
			notas[j]=scanner.nextDouble();
		}
		if (notas[j]>=0 && notas[j]<=4.99) {
			System.out.println("El alumno " + alumnos[i] + " sacó un " + notas[j] +" Suspenso");
			
		}else if (notas[j]>=5 && notas[j]<=6.99) {
			System.out.println("El alumno " + alumnos[i] + " sacó un " + notas[j] +" Bien");
		
		}else if (notas[j]>=7 && notas[j]<=8.99) {
			System.out.println("El alumno " + alumnos[i] + " sacó un " + notas[j] +" Notable");
			
		}else {
			System.out.println("El alumno " + alumnos[i] + " sacó un " + notas[j] +" Sobresaliente");
			
	    }
		j++;
     }
}
}