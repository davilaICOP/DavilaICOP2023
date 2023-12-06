package Principal;
import java.util.Scanner;
import Entidad.Rectangulo;
public class RectanguloConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo rectangulo1 = new Rectangulo(4,6);
		double area = rectangulo1.calcularArea();
		System.out.println("El área del rectángulo es: " + area);
		
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese la longitud del primer lado: ");
		double lado1 = sc.nextDouble();
		
		System.out.println("Ingrese la longitud del segundo lado: ");
		double lado2 = sc.nextDouble();
		
		Rectangulo unrectangulo = new Rectangulo(lado1, lado2);
		
		double area1 = unrectangulo.calcularArea();
        System.out.println("El área del rectángulo es: " + area1);
	}
}
