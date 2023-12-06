package Servicios;

import Entidades._2_ParDeNumeros;
import java.text.DecimalFormat;

public class _2_ParDeNumerosService {
    private static DecimalFormat df = new DecimalFormat("#.##");

    public static void mostrarValores(_2_ParDeNumeros par) {
        System.out.println("Número 1: " + df.format(par.getNumero1()));
        System.out.println("Número 2: " + df.format(par.getNumero2()));
    }

    public static double devolverMayor(_2_ParDeNumeros par) {
        return Math.max(par.getNumero1(), par.getNumero2());
    }

    public static double calcularPotencia(_2_ParDeNumeros par) {
        double mayor = devolverMayor(par);
        double menor = Math.min(par.getNumero1(), par.getNumero2());
        return Math.pow(mayor, Math.round(menor));
    }

    public static double calcularRaiz(_2_ParDeNumeros par) {
        double menor = Math.min(par.getNumero1(), par.getNumero2());
        double valorAbsoluto = Math.abs(menor);
        return Math.sqrt(valorAbsoluto);
    }
}
