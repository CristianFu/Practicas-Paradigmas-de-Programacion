package T09P1;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

// Interfaz para figuras geométricas calculables
interface Calculable {
    double calcularArea();
    double calcularPerimetro();
}

// Clase abstracta FiguraGeometrica que implementa Calculable
abstract class FiguraGeometrica implements Calculable {
    protected String nombre;

    public FiguraGeometrica(String nombre) {
        this.nombre = nombre;
    }

    public abstract boolean validarFigura();
}

// Clase derivada Circulo que implementa Calculable
class Circulo extends FiguraGeometrica {
    private double radio;

    public Circulo(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public boolean validarFigura() {
        return radio > 0; // Un círculo válido tiene radio mayor que cero.
    }
}

// Clase derivada Rectangulo que implementa Calculable
class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Rectangulo(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    public boolean validarFigura() {
        return base > 0 && altura > 0; // Un rectángulo válido tiene base y altura mayores que cero.
    }
}

// Clase derivada Triangulo que implementa Calculable
class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Triangulo(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public double calcularPerimetro() {
        if (!validarFigura()) {
            throw new IllegalArgumentException("No es posible crear un triángulo con base o altura igual a cero.");
        }
        double hipotenusa = Math.sqrt(base * base + altura * altura);
        return base + altura + hipotenusa;
    }

    @Override
    public boolean validarFigura() {
        return base > 0 && altura > 0; // Un triángulo válido tiene base y altura mayores que cero.
    }
}

public class MainFiguras {
    public static void main(String[] args) {
        ArrayList<Calculable> figuras = new ArrayList<>();
        Scanner consola = new Scanner(System.in);

        System.out.println("Por favor, ingrese las dimensiones de las figuras:");

        // Solicitar al usuario ingresar las dimensiones de un círculo
        System.out.print("Radio del Círculo: ");
        double radioCirculo = consola.nextDouble();
        if (radioCirculo > 0) {
            figuras.add(new Circulo("Círculo", radioCirculo));
        } else {
            System.out.println("El radio debe ser mayor que cero. El círculo no se agregó.");
        }

        // Solicitar al usuario ingresar las dimensiones de un rectángulo
        System.out.print("Base del Rectángulo: ");
        double baseRectangulo = consola.nextDouble();
        System.out.print("Altura del Rectángulo: ");
        double alturaRectangulo = consola.nextDouble();
        if (baseRectangulo > 0 && alturaRectangulo > 0) {
            figuras.add(new Rectangulo("Rectángulo", baseRectangulo, alturaRectangulo));
        } else {
            System.out.println("La base y la altura deben ser mayores que cero. El rectángulo no se agregó.");
        }

        // Solicitar al usuario ingresar las dimensiones de un triángulo
        System.out.print("Base del Triángulo: ");
        double baseTriangulo = consola.nextDouble();
        System.out.print("Altura del Triángulo: ");
        double alturaTriangulo = consola.nextDouble();
        if (baseTriangulo > 0 && alturaTriangulo > 0) {
            figuras.add(new Triangulo("Triángulo", baseTriangulo, alturaTriangulo));
        } else {
            System.out.println("La base y la altura deben ser mayores que cero. El triángulo no se agregó.");
        }

        consola.close();

        System.out.println("Descripción de Areas y Perímetros:");
        System.out.println("==================================");

        DecimalFormat decimalFormat = new DecimalFormat("#.####"); // Formato con cuatro decimales

        for (Calculable figura : figuras) {
            String area = decimalFormat.format(figura.calcularArea());
            String perimetro = decimalFormat.format(figura.calcularPerimetro());
            System.out.println(figura.getClass().getSimpleName() + ": Area=" + area + ", Perímetro=" + perimetro);
        }
    }
}
