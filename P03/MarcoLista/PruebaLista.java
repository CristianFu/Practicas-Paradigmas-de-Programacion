package MarcoLista;
// Fig. 12.24: PruebaLista.java
// Selección de colores de un objeto JList.
import javax.swing.JFrame;

public class PruebaLista {
    public static void main(String[] args) { 
        MarcoLista marcoLista = new MarcoLista(); // crea objeto MarcoLista
        marcoLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoLista.setSize(350, 150);
        marcoLista.setVisible(true);
    }
} // fin de la clase PruebaLista