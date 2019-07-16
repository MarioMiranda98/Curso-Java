import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class PruebaDibujo {
    public static void main(String[] args) {
        MarcoConDibujos marco = new MarcoConDibujos();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoConDibujos extends JFrame {
    public MarcoConDibujos () {
        setTitle("Prueba Dibujos");
        setSize(400, 400);
        setLocation(400, 200);
        add(new LaminaConFiguras());
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaConFiguras extends JPanel {
    /*public void paintComponent(Graphics g) { Primer video
        super.paintComponent(g);
        g.drawRect(50, 50, 200, 200);//Dibujando Cuadrado
        g.setColor(Color.cyan);
        g.drawLine(100, 100, 300, 200);
        g.setColor(Color.GREEN);
        g.drawArc(50, 100, 100, 200, 120, 150);
    }*/

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));//Antialiasing
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        g2.setColor(Color.MAGENTA);
        g2.draw(rectangulo);
        g2.setColor(Color.CYAN);
        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        g2.draw(elipse);
        g2.setColor(Color.ORANGE);
        g2.draw(new Line2D.Double(100, 100, 300, 250));
        g2.setColor(Color.GREEN);
        Double centroX = rectangulo.getCenterX();
        Double centroY = rectangulo.getCenterY();
        final Double RADIO = 150.0;
        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(centroX, centroY, centroX + RADIO, centroY + RADIO);
        g2.draw(circulo);
    }
}