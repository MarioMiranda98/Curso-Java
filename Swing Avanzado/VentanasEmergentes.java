import javax.swing.*;

public class VentanasEmergentes {
    public static void main(String[] args) {
        MarcoVentanasEmergentes marco = new MarcoVentanasEmergentes();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoVentanasEmergentes extends JFrame {
    public MarcoVentanasEmergentes() {
        setTitle("Ventanas Dialogo");
        setResizable(false);
        setBounds(450, 150, 400, 250);
        add(new LaminaVentanasEmergentes());
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaVentanasEmergentes extends JPanel {
    public LaminaVentanasEmergentes() {
        boton1 = new JButton("Boton 1");
        boton2 = new JButton("Boton 2");
        boton3 = new JButton("Boton 3");
        boton4 = new JButton("Boton 4");
        oyente = new AccionBotones();
        
        boton1.addActionListener(oyente);
        boton2.addActionListener(oyente);
        boton3.addActionListener(oyente);
        boton4.addActionListener(oyente);

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
    }

    private class AccionBotones implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (e.getSource() == boton1) {
                JOptionPane.showMessageDialog(LaminaVentanasEmergentes.this, "Haz pulsado el boton 1", "Advertencia", 0);
            } else if (e.getSource() == boton2) {
                JOptionPane.showInputDialog(LaminaVentanasEmergentes.this, "Introduce tu nombre", "Introduce Datos", 2);
            } else if (e.getSource() == boton3) {
                JOptionPane.showConfirmDialog(LaminaVentanasEmergentes.this, "Elige opcion?", "VConfirm", 0);
            } else if (e.getSource() == boton4) {
                JOptionPane.showOptionDialog(LaminaVentanasEmergentes.this, "Elige", "VOpciones", 1, 1, null, null, null);
            }
        }
    }

    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private java.awt.event.ActionListener oyente;
}