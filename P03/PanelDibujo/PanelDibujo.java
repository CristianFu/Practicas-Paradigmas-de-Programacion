package PanelDibujo;
// Fig. 12.34: PanelDibujo.java
// Clase adaptadora que se usa para implementar manejadores de eventos.
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel {
    // lista de referencias Point
    private final ArrayList<Point> puntos = new ArrayList<>();
    // establece la GUI y registra el manejador de eventos del ratón

    public PanelDibujo() {
        // maneja evento de movimiento del ratón en el marco
        addMouseMotionListener(new MouseMotionAdapter() {
            // almacena las coordenadas de arrastre y vuelve a dibujar
            @Override
            public void mouseDragged(MouseEvent evento) {
                puntos.add(evento.getPoint());
                repaint(); // vuelve a dibujar JFrame
            }
        });
    }

    // dibuja óvalos en un cuadro delimitador de 4 x 4, en las ubicaciones
    // especificadas en la ventana
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // borra el área de dibujo

        // dibuja todos los puntos
        for (Point punto : puntos)
            g.fillOval(punto.x, punto.y, 4, 4);
    }
} // fin de la clase PanelDibujo