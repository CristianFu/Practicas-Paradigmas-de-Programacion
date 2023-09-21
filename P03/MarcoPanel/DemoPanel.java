package MarcoPanel;
// Fig. 12.46: DemoPanel.java
// Prueba de MarcoPanel.
import javax.swing.JFrame;

public class DemoPanel extends JFrame {
    public static void main(String[] args) { 
        MarcoPanel marcoPanel = new MarcoPanel(); 
        marcoPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoPanel.setSize(450, 200);
        marcoPanel.setVisible(true);
    }
} // fin de la clase DemoPanel