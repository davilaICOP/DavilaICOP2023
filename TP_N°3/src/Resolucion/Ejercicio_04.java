package Resolucion;
import java.util.Scanner;
public class Ejercicio_04 {
    public void verificarContrasena() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una contraseña: ");
        String contrasena = scanner.nextLine();
        
        if (esContrasenaSegura(contrasena)) {
            System.out.println("La contraseña es segura.");
        } else {
            System.out.println("La contraseña no es segura.");
        }
    }
    
    public static boolean esContrasenaSegura(String contrasena) {
        // Verificar la longitud de la contraseña
        if (contrasena.length() < 8) {
            return false;
        }
        
        int letrasMayusculas = 0;
        int letrasMinusculas = 0;
        int digitosNumericos = 0;
        
        // Verificar cada carácter de la contraseña
        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) {
                letrasMayusculas++;
            } else if (Character.isLowerCase(c)) {
                letrasMinusculas++;
            } else if (Character.isDigit(c)) {
                digitosNumericos++;
            } else if (c != '_') {
                return false; // Carácter no permitido
            }
        }
        
        // Verificar el número de letras mayúsculas, minúsculas y dígitos numéricos
        if (letrasMayusculas < 2 || letrasMinusculas < 3 || digitosNumericos < 2) {
            return false;
        }
        
        return true;
    }
}