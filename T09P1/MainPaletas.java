package T09P1;
import java.util.Scanner;

interface Vendible {
    double calcularPrecioFinal();
    void mostrarInformacion();
}

abstract class PaletaAbstracta {
    private String sabor;
    private double precio;

    public PaletaAbstracta(String sabor, double precio) throws PrecioInvalidoException {
        if (precio < 0) {
            throw new PrecioInvalidoException("El precio no puede ser negativo.");
        }
        this.sabor = sabor;
        this.precio = precio;
    }

    public abstract void mostrarInformacion();

    public void cambiarPrecio(double incremento) throws PrecioInvalidoException {
        double nuevoPrecio = precio + incremento;
        if (nuevoPrecio < 0) {
            throw new PrecioInvalidoException("El precio no puede ser negativo.");
        }
        precio = nuevoPrecio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getSabor() {
        return sabor;
    }
}

class PrecioInvalidoException extends Exception {
    public PrecioInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class PaletaAgua extends PaletaAbstracta implements Vendible {
    private boolean baseAgua;

    public PaletaAgua(String sabor, double precio, boolean baseAgua) throws PrecioInvalidoException {
        super(sabor, precio);
        this.baseAgua = baseAgua;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Sabor: " + super.getSabor());
        System.out.println("Precio: " + super.getPrecio() + " pesos");
        System.out.println("Base de agua: " + (baseAgua ? "Sí" : "No"));
    }

    @Override
    public double calcularPrecioFinal() {
        return super.getPrecio() + 2.0;
    }
}

class PaletaCrema extends PaletaAbstracta implements Vendible {
    private boolean cremosa;

    public PaletaCrema(String sabor, double precio, boolean cremosa) throws PrecioInvalidoException {
        super(sabor, precio);
        this.cremosa = cremosa;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Sabor: " + super.getSabor());
        System.out.println("Precio: " + super.getPrecio() + " pesos");
        System.out.println("Textura cremosa: " + (cremosa ? "Sí" : "No"));
    }

    @Override
    public double calcularPrecioFinal() {
        return super.getPrecio() + 6.0;
    }
}

public class MainPaletas {
    public static void main(String[] args) {
        try {
            Scanner consola = new Scanner(System.in);
            System.out.print("Ingrese el sabor de la paleta de agua: ");
            String saborAgua = consola.nextLine();
            
            System.out.print("Ingrese el precio de la paleta de agua: ");
            double precioAgua = consola.nextDouble();
            
            consola.nextLine(); // Consumir la nueva línea
            
            System.out.print("¿La paleta de agua tiene base de agua? (si/no): ");
            String baseAguaInput = consola.nextLine();
            boolean baseAgua = baseAguaInput.equalsIgnoreCase("si");
            
            System.out.print("Ingrese el sabor de la paleta cremosa: ");
            String saborCremosa = consola.nextLine();
            
            System.out.print("Ingrese el precio de la paleta cremosa: ");
            double precioCremosa = consola.nextDouble();
            
            consola.nextLine(); // Consumir la nueva línea
            
            System.out.print("¿La paleta " + saborCremosa + " es cremosa? (si/no): ");
            String cremosaInput = consola.nextLine();
            boolean cremosa = cremosaInput.equalsIgnoreCase("si");
            
            Vendible[] paletas = new Vendible[2];
            paletas[0] = new PaletaAgua(saborAgua, precioAgua, baseAgua);
            paletas[1] = new PaletaCrema(saborCremosa, precioCremosa, cremosa);

            for (Vendible paleta : paletas) {
                System.out.println("Paleta:");
                paleta.mostrarInformacion();
                System.out.println("Precio final: " + paleta.calcularPrecioFinal() + " pesos");
                System.out.println();
            }
        } catch (PrecioInvalidoException e) {
            System.err.println("Error de precio: " + e.getMessage());
        }
    }
}
