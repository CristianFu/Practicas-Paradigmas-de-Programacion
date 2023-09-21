package MarcoBoton;
// Fig. 12.16: PruebaBoton.java
// Prueba de MarcoBoton.
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) { 
        CampoTextoMarco marcoBoton = new CampoTextoMarco();
        marcoBoton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoBoton.setSize(275, 110);
        marcoBoton.setVisible(true);
    }
} // fin de la clase PruebaBoton