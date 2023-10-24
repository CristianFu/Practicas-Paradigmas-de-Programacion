package T19;

public class Estudiante {
    private int numCuenta;
    private String nombre;

    public Estudiante (int numCuenta, String nombre){
        this.numCuenta= numCuenta;
        this.nombre= nombre;
    }

    public int getNumCuenta() {
        return numCuenta;
    }
    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
