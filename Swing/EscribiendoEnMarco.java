import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {
    public static void main (String[] args) {
        new MarcoConTexto();
    }
}

@SuppressWarnings("serial")
class MarcoConTexto extends JFrame {
    public MarcoConTexto() {
        setLocation(400, 200);
        setSize(600, 450);
        setTitle("Primer Texto");
        add(new Lamina());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class Lamina extends JPanel {
    public Lamina() {
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Estamos aprendiendo swing", 100, 100);
    }
}