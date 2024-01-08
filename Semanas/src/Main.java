import Semana2.Calculadora;
import Semana2.Usuario;

public class Main {
    public static void main(String[] args) {
      /*  Usuario user1 = new Usuario();
        Usuario user2 = new Usuario();

        user1.nombre = "George";
        user2.nombre = "Andres";

        user1.edad = 27;
        user2.edad = 32;

        user1.email = "email@gmail.com";
        user2.email = "a.email@gmail.com";*/

        Calculadora calculadora =  new Calculadora();

        double resultado = calculadora.sumar(12, 15);
        System.out.println(resultado);

    }
}