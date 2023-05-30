package Principal;
import java.util.Scanner;

import Entidad.Circunferencia;
import Entidad.Libro;
public class ConstructorCircunferencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc= new Scanner(System.in);    

	     Circunferencia unacircunferencia = new Circunferencia(0);
	        unacircunferencia.crearCircunferencia();
	        unacircunferencia.calcularArea();
	        unacircunferencia.calcularPerimetro();
	        
	        System.out.println("Área de la circunferencia: " + unacircunferencia.getArea());
	        System.out.println("Perímetro de la circunferencia: " + unacircunferencia.getPerimetro());
	}

}