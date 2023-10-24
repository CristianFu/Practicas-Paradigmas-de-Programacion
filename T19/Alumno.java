package T19;
public class Alumno {
    private int numCuenta;
    private String nombre;
    private String apellido;
    private double altura;
    private SituacionAcademica situacionAcademica;

    public Alumno(int numCuenta, String nombre, String apellido, double altura, SituacionAcademica situacionAcademica) {
        this.numCuenta = numCuenta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.situacionAcademica = situacionAcademica;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getAltura() {
        return altura;
    }

    public SituacionAcademica getSituacionAcademica() {
        return situacionAcademica;
    }

    
}