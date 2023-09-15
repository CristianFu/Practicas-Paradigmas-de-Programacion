package Practica02;
import java.util.Scanner;

// Paso 1: Creación de la Clase Abstracta Empleado
abstract class Empleado {
    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public abstract double calcularSalario(); // Método abstracto para calcular el salario
}

// Paso 2: Creación de las Clases EmpleadoPorHora y EmpleadoAsalariado
class EmpleadoPorHora extends Empleado {
    private int horasTrabajadas;
    private double valorPorHora;

    public EmpleadoPorHora(String nombre, double salario, int horasTrabajadas, double valorPorHora) throws SalarioInvalidoException {
        super(nombre, salario);
        if (salario <= 0) {
            throw new SalarioInvalidoException("El salario no puede ser negativo o igual a cero.");
        }
        this.horasTrabajadas = horasTrabajadas;
        this.valorPorHora = valorPorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * valorPorHora;
    }
}
class EmpleadoAsalariado extends Empleado implements Bonificable {
    private int diasTrabajados;
    private double sueldoMensual;

    public EmpleadoAsalariado(String nombre, double salario, int diasTrabajados, double sueldoMensual) throws SalarioInvalidoException {
        super(nombre, salario);
        if (salario <= 0) {
            throw new SalarioInvalidoException("El salario no puede ser negativo o igual a cero.");
        }
        this.diasTrabajados = diasTrabajados;
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public double calcularSalario() {
        return sueldoMensual;
    }

    @Override
    public double calcularBonificacion() {
        // Implementa el cálculo de bonificación aquí
        return 0; // Por ejemplo, podría ser 0 en este caso
    }
}

// Paso 3: Implementación de la Interfaz Bonificable
interface Bonificable {
    double calcularBonificacion(); // Método de la interfaz para calcular bonificación
}

// Paso 4: Definición de la Excepción SalarioInvalidoException
class SalarioInvalidoException extends Exception {
    public SalarioInvalidoException(String mensaje) {
        super(mensaje);
    }
}

// Paso 5: Uso del Polimorfismo en el programa principal
public class MainHoteles {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in); // Cambio de nombre a "consola"

        System.out.println("Ingrese los datos para el Empleado Por Hora:");
        System.out.print("Nombre: ");
        String nombrePorHora = consola.nextLine();
        System.out.print("Salario: ");
        double salarioPorHora = Double.parseDouble(consola.nextLine());
        System.out.print("Horas Trabajadas: ");
        int horasTrabajadasPorHora = Integer.parseInt(consola.nextLine());
        System.out.print("Valor por Hora: ");
        double valorPorHora = Double.parseDouble(consola.nextLine());

        System.out.println("Ingrese los datos para el Empleado Asalariado:");
        System.out.print("Nombre: ");
        String nombreAsalariado = consola.nextLine();
        System.out.print("Salario: ");
        double salarioAsalariado = Double.parseDouble(consola.nextLine());
        System.out.print("Días Trabajados: ");
        int diasTrabajadosAsalariado = Integer.parseInt(consola.nextLine());
        System.out.print("Sueldo Mensual: ");
        double sueldoMensual = Double.parseDouble(consola.nextLine());

        try {
            Empleado empleadoPorHora = new EmpleadoPorHora(nombrePorHora, salarioPorHora, horasTrabajadasPorHora, valorPorHora);
            Empleado empleadoAsalariado = new EmpleadoAsalariado(nombreAsalariado, salarioAsalariado, diasTrabajadosAsalariado, sueldoMensual);

            double salarioPorHoraCalculado = empleadoPorHora.calcularSalario();
            double salarioAsalariadoCalculado = empleadoAsalariado.calcularSalario();

            System.out.println("\nInformación del Empleado Por Hora:");
            System.out.println("Nombre: " + empleadoPorHora.getNombre());
            System.out.println("Salario: " + empleadoPorHora.getSalario());
            System.out.println("Salario Calculado: " + salarioPorHoraCalculado);

            System.out.println("\nInformación del Empleado Asalariado:");
            System.out.println("Nombre: " + empleadoAsalariado.getNombre());
            System.out.println("Salario: " + empleadoAsalariado.getSalario());
            System.out.println("Salario Calculado: " + salarioAsalariadoCalculado);

            if (empleadoAsalariado instanceof Bonificable) {
                double bonificacion = ((Bonificable) empleadoAsalariado).calcularBonificacion();
                System.out.println("Bonificación: " + bonificacion);
            }
        } catch (SalarioInvalidoException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            consola.close();
        }
    }
}
