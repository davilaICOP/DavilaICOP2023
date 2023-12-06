package Entidades;


import Servicios._2_ParDeNumerosService;

public class _2_Main {
    public static void main(String[] args) {
        _2_ParDeNumeros par = new _2_ParDeNumeros();
        
        _2_ParDeNumerosService.mostrarValores(par);

        double mayor = _2_ParDeNumerosService.devolverMayor(par);
        System.out.println("El mayor número es: " + mayor);

        double potencia = _2_ParDeNumerosService.calcularPotencia(par);
        System.out.println("La potencia del mayor elevado al menor es: " + potencia);

        double raiz = _2_ParDeNumerosService.calcularRaiz(par);
        System.out.println("La raíz cuadrada del menor valor es: " + raiz);
    }
}
