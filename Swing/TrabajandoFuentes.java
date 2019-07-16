import javax.swing.*;
import java.awt.*;

public class TrabajandoFuentes { 
    public static void main(String[] args) {
        MarcoConFuentes marco = new MarcoConFuentes();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoConFuentes extends JFrame {
    public MarcoConFuentes() {
        setTitle("Prueba Con Fuentes");
        setSize(400, 400);
        setResizable(false);
        LaminaConFuentes lamina = new LaminaConFuentes();
        add(lamina);
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaConFuentes extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Font miFuente = new Font("Courier New", Font.BOLD, 26);
        g2.setFont(miFuente);
        g2.setColor(new Color(200, 150, 38));
        g2.drawString("Mario", 50, 100);
        g2.setColor(new Color(150, 200, 38));
        g2.drawString("Alberto", 100, 150);
        g2.setColor(new Color(38, 150, 200));
        g2.drawString("Miranda", 150, 200);
        g2.setColor(new Color(150, 38, 200));
        g2.drawString("Sandoval", 200, 250);
    }
}