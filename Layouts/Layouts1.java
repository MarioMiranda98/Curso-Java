import java.awt.*;
import javax.swing.*;

public class Layouts1 {
    public static void main(String[] args) {
        MarcoLayouts1 marco = new MarcoLayouts1();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoLayouts1 extends JFrame {
    public MarcoLayouts1() {
        setTitle("Flow Layout");
        setBounds(450, 150, 600, 350);
        PanelLayouts1 lamina = new PanelLayouts1();
        //FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT);
        //lamina.setLayout(disposicion);
        add(lamina);
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class PanelLayouts1 extends JPanel {
    public PanelLayouts1() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 100));
        add(new JButton("Amarrilo"));
        add(new JButton("Rojo"));
        add(new JButton("Azul"));
    }
}