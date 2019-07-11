import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class PruebaColores { 
    public static void main (String[] args) {
        MarcoColores marco = new MarcoColores();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoColores extends JFrame {
    public MarcoColores() {
        setTitle("Probando colores");
        setBounds(400, 200, 400, 400);
        LaminaColor lamina = new LaminaColor();
        lamina.setBackground(Color.DARK_GRAY);
        add(lamina);
        setVisible(true);
    }
}

class LaminaColor extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        g2.setPaint(new Color(150, 25, 34));
        //g2.draw(rectangulo);
        g2.fill(rectangulo);
        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        g2.setPaint(Color.CYAN.brighter().brighter());
        g2.draw(elipse);
    }
}