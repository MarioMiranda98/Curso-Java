import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsoRadioButton2 {
    public static void main(String[] args) {
        MarcoUsoRadioButton2 marco = new MarcoUsoRadioButton2();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoUsoRadioButton2 extends JFrame {
    public MarcoUsoRadioButton2() {
        setTitle("Radio Button 2");
        setResizable(false);
        setBounds(450, 150, 500, 350);
        add(new LaminaUsoRadioButton2());
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaUsoRadioButton2 extends JPanel {
    public LaminaUsoRadioButton2() {
        setLayout(new BorderLayout());
        laminaRadio = new JPanel();
        texto = new JLabel("En un lugar de la mancha cuyo nombre...");
        grupo = new ButtonGroup();
        /*boton1 = new JRadioButton("Peque\u00F1o", false);
        boton2 = new JRadioButton("Mediano", true);
        boton3 = new JRadioButton("Grande", false);
        boton4 = new JRadioButton("Muy Grande", false);
        EventoRadio evento = new EventoRadio();

        boton1.addActionListener(evento);
        boton2.addActionListener(evento);        
        boton3.addActionListener(evento);
        boton4.addActionListener(evento);        

        grupo.add(boton1);
        grupo.add(boton2);
        grupo.add(boton3);
        grupo.add(boton4);
        laminaRadio.add(boton1);
        laminaRadio.add(boton2);
        laminaRadio.add(boton3);
        laminaRadio.add(boton4);*/
        colocarBoton("Peque\u00F1o", false, 10);
        colocarBoton("Mediano", true, 12);
        colocarBoton("Grande", false, 18);
        colocarBoton("Muy Grande", false, 24);
        add(texto, BorderLayout.CENTER);
        add(laminaRadio, BorderLayout.SOUTH);
    }

    public void colocarBoton(String nombre, boolean seleccionado, final int tamanio) {
        JRadioButton boton = new JRadioButton(nombre, seleccionado);
        grupo.add(boton);
        laminaRadio.add(boton);

        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setFont(new Font("Serif", Font.PLAIN, tamanio));
            }
        };

        boton.addActionListener(evento);
    }

    /*private class EventoRadio implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == boton1) 
                texto.setFont(new Font("Serif", Font.PLAIN, 10));
            else if (e.getSource() == boton2)
                texto.setFont(new Font("Serif", Font.PLAIN, 12));
            else if (e.getSource() == boton3)
                texto.setFont(new Font("Serif", Font.PLAIN, 18));
            else if (e.getSource() == boton4)
                texto.setFont(new Font("Serif", Font.PLAIN, 24));
        }
    }*/

    private JLabel texto;
    //private JRadioButton boton1, boton2, boton3, boton4;
    private ButtonGroup grupo;
    private JPanel laminaRadio;
}