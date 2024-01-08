package Semana2;

public class main {

    public static void main(String[] args) {
        Cuadrado cuadrado1 = new Cuadrado("Rojo", 12f);
        Cuadrado cuadrado2 = new Cuadrado("Verde", 13f);
        Cuadrado cuadrado3 = new Cuadrado("Azul", 14f);

        System.out.println("El perímetro  es : " + cuadrado1.perimetro());
        System.out.println("El área  es : " + cuadrado1.area());
        System.out.println(cuadrado1.toString());

        System.out.println("El perímetro  es : " + cuadrado2.perimetro());
        System.out.println("El área  es : " + cuadrado2.area());
        System.out.println(cuadrado2.toString());

        System.out.println("El perímetro  es : " + cuadrado3.perimetro());
        System.out.println("El área  es : " + cuadrado3.area());
        System.out.println(cuadrado3.toString());

        Circulo circulo1 = new Circulo("Azul", 1.9f);
        Circulo circulo2 = new Circulo("Amarillo", 3.9f);
        Circulo circulo3 = new Circulo("Blanco", 6.9f);

        System.out.println("El perimetro es : " + circulo1.perimetro());
        System.out.println("El área es : " + circulo1.area());
        System.out.println(circulo1.toString());

        System.out.println("El perimetro es : " + circulo2.perimetro());
        System.out.println("El área es : " + circulo2.area());
        System.out.println(circulo2.toString());

        System.out.println("El perimetro es : " + circulo3.perimetro());
        System.out.println("El área es : " + circulo3.area());
        System.out.println(circulo3.toString());

    }
}
