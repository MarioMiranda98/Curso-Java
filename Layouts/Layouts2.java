import java.awt.*;
import javax.swing.*;

public class Layouts2 {
    public static void main(String[] args) {
        MarcoLayouts2 marco = new MarcoLayouts2();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoLayouts2 extends JFrame {
    public MarcoLayouts2() {
        setTitle("Border Layout");
        setBounds(450, 150, 600, 350);
        PanelLayouts2 lamina = new PanelLayouts2();
        //FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT);
        //lamina.setLayout(disposicion);
        PanelLayouts2_1 lamina2 = new PanelLayouts2_1();
        add(lamina, BorderLayout.NORTH);
        add(lamina2, BorderLayout.SOUTH);
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class PanelLayouts2 extends JPanel {
    public PanelLayouts2() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        add(new JButton("Amarrilo"), BorderLayout.NORTH);
        add(new JButton("Rojo"), BorderLayout.SOUTH);
    }
}

@SuppressWarnings("serial")
class PanelLayouts2_1 extends JPanel {
    public PanelLayouts2_1() {
        setLayout(new BorderLayout(10, 10));
        add(new JButton("Azul"), BorderLayout.WEST);
        add(new JButton("Verde"), BorderLayout.EAST);
        add(new JButton("Negro"), BorderLayout.CENTER);
    }
}