package Semana2;

public class Circulo extends Figura {
    private final float pi = 3.1416f;
    private float radio;

    public Circulo(String color, float radio) {
        super(color);
        this.radio = radio;
    }


    @Override
    public float area(){
        return pi*radio*radio;
    }
    @Override
    public float perimetro()
    {
        return 2*pi*radio;
    }

    @Override
    public void printColor()
    {
        System.out.println("El color del cuadrado es: " + color);
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "pi=" + pi +
                ", radio=" + radio +
                ", color='" + color + '\'' +
                '}';
    }
}
