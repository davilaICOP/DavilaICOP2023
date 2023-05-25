package resol_AvilaD;
import java.util.Scanner;
public class Ejercicio_01 {
	
	public void saludar() {
		Scanner sc = new Scanner (System.in);
		String nombre;
		System.out.println("Ingrese su nombre: ");
		nombre = sc.next();
		System.out.println("Hola " +nombre);

	}

}