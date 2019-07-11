import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PruebaEventos2 {
    public static void main(String[] args) {
        MarcoBotones2 marco = new MarcoBotones2();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoBotones2 extends JFrame {
    public MarcoBotones2() {
        setTitle("Botones y Eventos");
        setBounds(500, 250, 500, 300);
        LaminaBotones2 lamina = new LaminaBotones2();
        add(lamina);
        setVisible(true);
    }
}

class LaminaBotones2 extends JPanel {
    public LaminaBotones2(){
        botonAzul = new JButton("Azul");
        botonAmarillo = new JButton("Amarillo");
        botonRojo = new JButton("Rojo");
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);
        botonAzul.addActionListener(new ColorFondo(Color.BLUE));
        botonAmarillo.addActionListener(new ColorFondo(Color.YELLOW));
        botonRojo.addActionListener(new ColorFondo(Color.RED));
    }
    
    private class ColorFondo implements ActionListener {
        public ColorFondo(Color ColorDeFondo) {
            this.ColorDeFondo = ColorDeFondo;
        }

        public void actionPerformed(ActionEvent e) {
            setBackground(ColorDeFondo);
        }

        private Color ColorDeFondo;
    }

    private JButton botonAzul;
    private JButton botonAmarillo;
    private JButton botonRojo;
}