package resol_AvilaD;
import java.util.Scanner;
public class Principal {
    
	public static void unMetodo() {
		System.out.println("Escribo desde el metodo que esta en la clase que");
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);	
		int opcion;
		do {
		    System.out.println("Ingrese opcion: \n"
		         +"1)Ejercicio 1:\n"
		         +"2)Ejercicio 2:\n"
		         +"3)Ejercicio 3:\n"
		         +"4)Ejercicio 4:\n"
		         +"5)Ejercicio 5:\n"
		         +"6)Ejercicio 6:\n"
		         +"7)Ejercicio 7:\n"
		         +"8)Ejercicio 8:\n"
		         +"9)Ejercicio 9:\n"
		         +"10)Ejercicio 10:\n"
		         +"11)Ejercicio 11:\n"
		         +"12)Ejercicio 12a:\n"
		         +"13)Ejercicio 12b:\n"
		         +"14)Ejercicio 13a:\n"
		         +"15)Ejercicio 13b:\n"
		         +"15)Ejercicio 14:\n"
		         +"16)Ejercicio 15:\n"
		         +"17)Ejercicio 16:\n"
		         +"0)Salir");
		opcion = scanner.nextInt();
		switch(opcion) {
		
		case 1:{
			System.out.println("Ingreso la opcion 1");
			Ejercicio_01 mi_ejercicio1 = new Ejercicio_01();
			mi_ejercicio1.saludar();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		}
		case 2:
			System.out.println("Ingrese la opcion 2: ");
			Ejercicio_02 mi_ejercicio2 = new Ejercicio_02();
			mi_ejercicio2.promedioMayores();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 3:
			System.out.println("Ingrese la opcion 3: ");
			Ejercicio_03 mi_ejercicio3 = new Ejercicio_03();
			mi_ejercicio3.capicua();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 4:
			System.out.println("Ingrese la opcion 4: ");
			Ejercicio_04 mi_ejercicio4 = new Ejercicio_04();
			mi_ejercicio4.verificarContrasena();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 5:
			System.out.println("Ingrese la opcion 5: ");
			Ejercicio_05 mi_ejercicio5 = new Ejercicio_05();
			mi_ejercicio5.numero();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 6:
			System.out.println("Ingrese la opcion 6: ");
			Ejercicio_06 mi_ejercicio6 = new Ejercicio_06();
			mi_ejercicio6.numeroPrimo();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 7:
			System.out.println("Ingrese la opcion 7: ");
			Ejercicio_07 mi_ejercicio7 = new Ejercicio_07();
			mi_ejercicio7.contadorPalabras();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 8:
			System.out.println("Ingrese la opcion 8: ");
			Ejercicio_08 mi_ejercicio8 = new Ejercicio_08();
			mi_ejercicio8.contarBilletes();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 9:
			System.out.println("Ingrese la opcion 9: ");
			Ejercicio_09 mi_ejercicio9 = new Ejercicio_09();
			mi_ejercicio9.ordenacionPorSeleccion();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 10:
			System.out.println("Ingrese la opcion 10: ");
			Ejercicio_10 mi_ejercicio10 = new Ejercicio_10();
			mi_ejercicio10.calcularDigitoVerificadorISBN();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 11:
			System.out.println("Ingrese la opcion 11: ");
			Ejercicio_11 mi_ejercicio11 = new Ejercicio_11();
			mi_ejercicio11.operacionesVariables();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 12:
			System.out.println("Ingrese la opcion 12a: ");
			Ejercicio_12a mi_ejercicio12a = new Ejercicio_12a();
			mi_ejercicio12a.parImpar();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 13:
			System.out.println("Ingrese la opcion 12b: ");
			Ejercicio_12b mi_ejercicio12b = new Ejercicio_12b();
			mi_ejercicio12b.verificacionC();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 14:
			System.out.println("Ingrese la opcion 13a: ");
			Ejercicio_13a mi_ejercicio13a = new Ejercicio_13a();
			mi_ejercicio13a.recursiva();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 15:
			System.out.println("Ingrese la opcion 13b: ");
			Ejercicio_13b mi_ejercicio13b = new Ejercicio_13b();
			mi_ejercicio13b.iterativa();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 16:
			System.out.println("Ingrese la opcion 14: ");
			Ejercicio_14 mi_ejercicio14 = new Ejercicio_14();
			mi_ejercicio14.valores();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 17:
			System.out.println("Ingrese la opcion 15: ");
			Ejercicio_15 mi_ejercicio15 = new Ejercicio_15();
			mi_ejercicio15.arrayVocales();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		case 18:
			System.out.println("Ingrese la opcion 16: ");
			Ejercicio_16 mi_ejercicio16 = new Ejercicio_16();
			mi_ejercicio16.notas();
			System.out.print("Ingrese que ejercicio quiere: ");
			opcion =scanner.nextInt();
			break;
		default:
			System.out.println("Ingrese opción correcta");
		}	
		}while(opcion !=0);
		}
	}
		
	
		
		
