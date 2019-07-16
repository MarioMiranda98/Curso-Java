import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PruebaAcciones {
    public static void main(String[] args) {
        MarcoPruebaAcciones marco = new MarcoPruebaAcciones();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoPruebaAcciones extends JFrame {
    public MarcoPruebaAcciones() {
        setTitle("Prueba Acciones");
        setBounds(450, 150, 600, 300);
        PanelPruebaAcciones lamina = new PanelPruebaAcciones();
        add(lamina);
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class PanelPruebaAcciones extends JPanel {
    public PanelPruebaAcciones() {
        accionAmarillo = new AccionColor("Amarillo", new ImageIcon("./red.png"), Color.YELLOW);
        accionAzul = new AccionColor("Azul", new ImageIcon("./red.png"), Color.BLUE);
        accionRojo = new AccionColor("Rojo", new ImageIcon("./red.png"), Color.RED);
        botonAzul = new JButton(accionAzul);
        botonAmarillo = new JButton(accionAmarillo);
        botonRojo = new JButton(accionRojo);
        add(botonAzul);
        add(botonRojo);
        add(botonAmarillo);

        mapaDeEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        combinacionAmarilla = KeyStroke.getKeyStroke("ctrl A");
        mapaDeEntrada.put(combinacionAmarilla, "fondoAmarillo");
        mapaAccion = getActionMap();
        mapaAccion.put("fondoAmarillo", accionAmarillo);
        

        combinacionAzul = KeyStroke.getKeyStroke("ctrl B");
        mapaDeEntrada.put(combinacionAzul, "fondoAzul");
        mapaAccion = getActionMap();
        mapaAccion.put("fondoAzul", accionAzul);

        combinacionRojo = KeyStroke.getKeyStroke("ctrl R");
        mapaDeEntrada.put(combinacionRojo, "fondoRojo");
        mapaAccion = getActionMap();
        mapaAccion.put("fondoRojo", accionRojo);
    }

    private class AccionColor extends AbstractAction {
        public AccionColor(String nombre, Icon icono, Color color) {
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Color: " + nombre);
            putValue("colorDeFondo", color);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            /*Color c = (Color) getValue("colorDeFondo");
            setBackground(c);*/
            setBackground((Color)(getValue("colorDeFondo")));
            System.out.println("Nombre: " + getValue(Action.NAME) + " Descripcion: " + getValue(Action.SHORT_DESCRIPTION));
        }
    }

    private JButton botonAzul;
    private JButton botonRojo;
    private JButton botonAmarillo;
    private AccionColor accionAmarillo;
    private AccionColor accionAzul;
    private AccionColor accionRojo;
    private InputMap mapaDeEntrada;
    private KeyStroke combinacionAmarilla;
    private KeyStroke combinacionAzul;
    private KeyStroke combinacionRojo;
    private ActionMap mapaAccion;
}