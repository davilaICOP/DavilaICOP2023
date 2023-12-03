package juego;
import java.util.Scanner;
public class Ejercicio {

	public static void main(String[] args) {
		Scanner lectura= new Scanner(System.in);
		int jugador1;
		int jugador2;
		int saldo1 = 1000;
		int saldo2 = 1000;
		int pozo = 0;
		int chance1 = 10;
		int chance2 = 10;
		int apuesta = 0;
		String doblarapuesta= "";
		int aleatorio = (int)(Math.random()*100+1);
		
		System.out.println("Comenzo el juego !!!");
		System.out.println("el numero aleatorio es "+aleatorio);
		while( chance1 != 0 || chance2 != 0 ) {
		
		//JUGADOR 1;
		System.out.println();
		System.out.println("Jugador 1 elija su numero entre el 1 al 100");
		jugador1= lectura.nextInt();
		while(jugador1 > 100 ) {
        	System.out.println("El numero ingresado es mayor al 100 ");
        	System.out.println("Ingrese de nuevo un numero ");
        	jugador1= lectura.nextInt();
        }
		System.out.println("Su saldo es de "+saldo1+" cuanto desea apostar ?");
        apuesta = lectura.nextInt();
        while(apuesta > saldo1) {
        	System.out.println("Apueste menos su saldo es de "+ saldo1);
        	apuesta= lectura.nextInt();
        }
        
        while (apuesta < 50) {
        	System.out.println("La apuesta minima es de 50 ");
        	apuesta= lectura.nextInt();
        	
        }
        chance1--;
        System.out.println("Jugador 1, desea doblar la apuesta ?? ");
        System.out.println("Presione === Y / N ");
        doblarapuesta=lectura.next();
        if (doblarapuesta.equalsIgnoreCase("Y") && apuesta < (saldo1/2)) {
        	apuesta= apuesta*2;
        }else if(doblarapuesta.equalsIgnoreCase("Y") && apuesta > (saldo1/2)) {
        	System.out.println("No se pudo doblar la apuesta por falta de dinero ");
        	
        }else {
        	System.out.println("No se doblo la apuesta ");
        	
        }
        System.out.println("Apuesta de jugador1 " +apuesta);
        saldo1 -= apuesta;
        pozo += apuesta;
        if (saldo1 < 50 ) {
        	System.out.println("El jugador 1 se quedo sin dinero ");
			System.out.println("El jugador 2 gano, se lleva el pozo " + pozo);
			break;
		}
        if (aleatorio > jugador1) {
        	System.out.println("El numero ingresado es menor al aleatorio ");
        	System.out.println("Jugador 1 te quedan "+ chance1 + " intentos ");
        }else if (aleatorio < jugador1) {
        	System.out.println("El numero ingresador es mayor al aleatorio ");
        	System.out.println("Jugador 1 te quedan "+ chance1 + " intentos ");
        	
        }else {
        	System.out.println("El jugador 1 gano el juego!!!. El numero aleatorio es " +aleatorio);
        	System.out.println();
        	System.out.println("Se ha ganado el pozo de "+ pozo);
        	System.out.println();
            System.out.println("Cantidad de chances de J1 : "+chance1);
            System.out.println();
            System.out.println("Cantidad de chances de J2 : "+chance2);
            System.out.println();
            System.out.println("Saldo Final J1 : "+saldo1);
            System.out.println();
            System.out.println("Saldo Final J2 : "+saldo2);
            System.out.println();
            System.out.println("Ultima apuesta fue de : "+apuesta);
            break;
        	
        }
        
        
        // Jugador 2
        
        System.out.println();
		System.out.println("Jugador 2 elija su numero entre el 1 al 100 ");
		jugador2= lectura.nextInt();
		while(jugador2 > 100) {
        	System.out.println("El numero ingresado es mayor al 100 ");
        	System.out.println("Ingrese de nuevo un numero ");
        	jugador2= lectura.nextInt();
        }
		System.out.println("Su saldo es de "+saldo2+" cuanto desea apostar? ");
        apuesta = lectura.nextInt();
        while(apuesta > saldo2) {
        	System.out.println("Apueste menos su saldo es de "+ saldo2);
        	apuesta= lectura.nextInt();
        }
        
        while (apuesta < 50) {
        	System.out.println("La apuesta minima es de 50 ");
        	apuesta= lectura.nextInt();
        	
        }
        chance2--;
        System.out.println("Jugador 2, desea doblar la apuesta ?? ");
        System.out.println("Presione === Y / N ");
        doblarapuesta=lectura.next();
        if (doblarapuesta.equalsIgnoreCase("Y") && apuesta < saldo1) {
        	apuesta= apuesta*2;
        }else if(doblarapuesta.equalsIgnoreCase("Y") && apuesta > (saldo1/2)) {
        	System.out.println("No se pudo doblar la apuesta por falta de dinero ");
        }else {
        	System.out.println("No se doblo la apuesta ");
        	
        }
        System.out.println("Apuesta de jugador2 " +apuesta);
        saldo2 -= apuesta;
        pozo += apuesta;
        if (saldo2<50 ) {
        	System.out.println("El jugador 1 se quedo sin dinero ");
			System.out.println("El jugador 2 gano, se lleva el pozo " + pozo);
			break;
		}
        if (aleatorio > jugador2) {
        	System.out.println("El numero ingresado es menor al aleatorio ");
        	System.out.println("Jugador 2 te quedan "+ chance2 + " intentos ");
        }else if (aleatorio < jugador2) {
        	System.out.println("El numero ingresador es mayor al aleatorio ");
        	System.out.println("Jugador 2 te quedan "+ chance2 + " intentos ");
        }else {
        	System.out.println("El jugador 2 gano el juego!!!. El numero aleatorio es " +aleatorio);
        	System.out.println();
        	System.out.println("Se ha ganado el pozo de "+ pozo);
        	System.out.println();
            System.out.println("Cantidad de chances de J1 : "+chance1);
            System.out.println();
            System.out.println("Cantidad de chances de J2 : "+chance2);
            System.out.println();
            System.out.println("Saldo Final J1 : "+saldo1);
            System.out.println();
            System.out.println("Saldo Final J2 : "+saldo2);
            System.out.println();
            System.out.println("Ultima apuesta fue de : "+apuesta);
            break;
        	
        }
        
		}
		if (chance1 == 0 && chance2 == 0) {
			System.out.println();
			System.out.println("Se agotaron los tiros ");
			System.out.println("El premio quedo vacante ");
		
		}
		
		}
			
	  }
	