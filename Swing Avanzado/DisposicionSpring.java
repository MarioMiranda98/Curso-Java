import javax.swing.*;

public class DisposicionSpring {
    public static void main(String[] args) {
        MarcoDisposicionSpring marco = new MarcoDisposicionSpring();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoDisposicionSpring extends JFrame {
    public MarcoDisposicionSpring() {
        setTitle("Disposicion Spring");
        setBounds(450, 150, 1000, 350);
        add(new LaminaDisposicionSpring());
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaDisposicionSpring extends JPanel {
    public LaminaDisposicionSpring() {
        boton1 = new JButton("boton1");
        boton2 = new JButton("boton2");
        boton3 = new JButton("boton3");
        resorte = new SpringLayout();
        muelle = Spring.constant(0, 10, 100);
        setLayout(resorte);
        add(boton1);
        add(boton2);
        add(boton3);

        resorte.putConstraint(SpringLayout.WEST, boton1, muelle, SpringLayout.WEST, this);
        resorte.putConstraint(SpringLayout.WEST, boton2, muelle, SpringLayout.EAST, boton1);
        resorte.putConstraint(SpringLayout.WEST, boton3, muelle, SpringLayout.EAST, boton2);
        resorte.putConstraint(SpringLayout.WEST, this, muelle, SpringLayout.EAST, boton3);
    }

    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private SpringLayout resorte;
    private Spring muelle;
}