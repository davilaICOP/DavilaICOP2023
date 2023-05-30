package Principal;

import java.util.Scanner;

import Entidad.Operacion;

public class ConstructorOperación {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		Operacion unaoperacion = new Operacion(); // Se crea una instancia de la clase Operacion
        unaoperacion.crearOperacion(); // Se pide al usuario que introduzca los números
        double resultadoSuma = unaoperacion.sumar();
        double resultadoResta = unaoperacion.restar();
        double resultadoMultiplicacion = unaoperacion.multiplicar();
        double resultadoDivision = unaoperacion.dividir();

        System.out.println("Suma: " + resultadoSuma);
        System.out.println("Resta: " + resultadoResta);
        System.out.println("Multiplicación: " + resultadoMultiplicacion);
        System.out.println("División: " + resultadoDivision);
		
	}

}
