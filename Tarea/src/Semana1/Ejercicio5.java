package Semana1;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa un número: ");
        int numero = sc.nextInt();
        int suma = sumarDigitos(numero);
        System.out.println("La suma de los dígitos es: " + suma);
        sc.close();
    }

    public static int sumarDigitos(int num) {
        int suma = 0;
        while (num != 0) {
            int digito = num % 10;
            suma += digito;
            num /= 10;
        }
        return suma;
    }
}
