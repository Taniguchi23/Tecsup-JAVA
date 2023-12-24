package Semana1;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa un número: ");
        int numero = sc.nextInt();
        long factorial = calcularFactorial(numero);
        System.out.println("El factorial de " + numero + " es: " + factorial);
        sc.close();
    }

    public static long calcularFactorial(int numero) {
        long factorial = 1;
        if (numero < 0) {
            return -1;
        }
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
