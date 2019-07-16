import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PruebaEventos {
    public static void main(String[] args) {
        MarcoBotones marco = new MarcoBotones();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoBotones extends JFrame {
    public MarcoBotones() {
        setTitle("Botones y Eventos");
        setBounds(500, 250, 500, 300);
        LaminaBotones lamina = new LaminaBotones();
        add(lamina);
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaBotones extends JPanel {
    public LaminaBotones(){
        botonAzul = new JButton("Azul");
        botonAmarillo = new JButton("Amarillo");
        botonRojo = new JButton("Rojo");
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);

        botonAzul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.BLUE);
            }
        });

        botonAmarillo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.YELLOW);
            }
        });

        botonRojo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.RED);
            }
        });
    }
    
    private JButton botonAzul;
    private JButton botonAmarillo;
    private JButton botonRojo;
}