package Principal;

import Entidad.Rectangulo;

public class ConstructorRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangulo unrectangulo = new Rectangulo(); // Se crea una instancia de la clase Rectangulo
        unrectangulo.crearRectangulo(); // Se pide al usuario que introduzca los datos del rectángulo
        double superficie = unrectangulo.calcularSuperficie();
        double perimetro = unrectangulo.calcularPerimetro();

        System.out.println("Superficie del rectángulo: " + superficie);
        System.out.println("Perímetro del rectángulo: " + perimetro);
        System.out.println("Dibujo del rectángulo:");
        unrectangulo.dibujarRectangulo();

	}

}
