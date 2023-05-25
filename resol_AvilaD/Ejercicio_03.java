package resol_AvilaD;
import java.util.Scanner;
public class Ejercicio_03 {
	public void numero() {
		System.out.println("Se creo una instancia de Ejercicio_03");
	}
	public int invertirNumero(int numero) {
		int resto=0;
		int aux=0;
		int nroInvertido;
		while(numero>0) {
			resto=numero%10;
			numero=(int)Math.floor(numero/10);
			aux=aux*10+resto;
			//System.out.println("resto= " +resto+" aux= "+aux+" numero= " + numero);
		}
		
		return aux;
		
	}
	public void capicua() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese numero: ");
		int numero = scanner.nextInt();
		if (invertirNumero(numero)==numero) {
			System.out.println("Es capicua");
			
		}else {
			System.out.println("No es capicua");
		}
	}
}