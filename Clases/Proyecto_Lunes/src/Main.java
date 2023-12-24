import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      /* String nombre = "Sonny";
       String apellidos = "Taniguchi";
       String ciudad = "Lima";
       float altura = 1.73f;

        System.out.println("Mi nombre es "+ nombre);
        System.out.println("Mi apellido es "+ apellidos);
        System.out.println("Mi ciudad es "+ ciudad);
        System.out.println("Mi altura es "+ altura);*/

        /*int numero = -8;

        String response =  numero >= 0 ? "Es positivo" : "Es negativo";
        System.out.println(response);*/

        int num1 = 10, num2 = 15 , num3 = 18 , max;
        max = num1 >= num2 ? num1 :num2;
        max = num3 >= max ? num3 :max;

        System.out.println("El numero máximo es : " + max);



        int notaMatematica = 66 , notaFisica = 60, notaQuimica = 45, sumaNotas;

        String response = (notaMatematica >= 65 && notaFisica >= 55 && notaQuimica >= 60 && ((notaMatematica + notaFisica + notaQuimica ) >= 140 ) ) || (notaFisica + notaMatematica) >= 140 ? "Es apto" : "No es apto";
        System.out.println(response);


        Scanner scanner = new Scanner(System.in);

      /*  System.out.print("Ingrese un número 'n': ");
        int n = scanner.nextInt();

        System.out.println("Los números pares menores que " + n + " son:");

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        scanner.close();*/


        System.out.print("Ingrese un número 'n': ");
        int n = scanner.nextInt();
        int total = 0 ;
        System.out.println("La suma de los n primeros es : ");

        for (int i = 1; i <= n; i++) {
            total += i;
        }

        System.out.print(total);
        scanner.close();


    }
}