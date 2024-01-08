package Semana2;

public class Calculadora {
    final float pi = 3.14f;


    public double sumar (double numero1, double numero2){
        return numero1 + numero2;
    }

    public double restar (double numero1, double numero2){
        return numero1 - numero2;
    }
    public double multiplicar (double numero1, double numero2){
        return numero1 * numero2;
    }

    public double dividir (double numerador, double denominador){
        return denominador == 0 ? -1 : numerador/denominador ;
    }



}
