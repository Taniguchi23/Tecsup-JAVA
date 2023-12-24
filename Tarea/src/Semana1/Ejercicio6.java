package Semana1;

public class Ejercicio6 {
    public static void main(String[] args) {
        encontrarCuadradosPerfectos(101);
    }

    public static void encontrarCuadradosPerfectos(int limite) {
        for (int i = 1; i * i <= limite; i++) {
            int cuadrado = i * i;
            System.out.println(cuadrado);
        }
    }
}
