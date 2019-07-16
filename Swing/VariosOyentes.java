import java.awt.event.*;
import javax.swing.*;

public class VariosOyentes {
    public static void main(String [] args) {
        MarcoVariosOyentes marco = new MarcoVariosOyentes();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoVariosOyentes extends JFrame {
    public MarcoVariosOyentes() {
        setTitle("Prueba Varios");
        setBounds(350, 150, 300, 200);
        setResizable(false);
        LaminaVariosOyentes lamina = new LaminaVariosOyentes();
        add(lamina);
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaVariosOyentes extends JPanel {
    public LaminaVariosOyentes() {
        botonAbrir = new JButton("Abrir");
        botonCerrar = new JButton("Cerrar Todo");
        add(botonAbrir);
        add(botonCerrar);
        botonAbrir.addActionListener(new OyenteNuevo());
    }

    private class OyenteNuevo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoEmergente marco = new MarcoEmergente(botonCerrar);
            marco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    private JButton botonAbrir;
    private JButton botonCerrar;
}

@SuppressWarnings("serial")
class MarcoEmergente extends JFrame {
    public MarcoEmergente(JButton cerrar) {
        setTitle("Ventana " + (++contador));
        setBounds((40 * contador), (40 * contador), 300, 150);
        setResizable(false);
        cerrar.addActionListener(new CierraTodos());
        setVisible(true);
    }

    private class CierraTodos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            contador = 0;
        }
    }

    private static int contador = 0;
}