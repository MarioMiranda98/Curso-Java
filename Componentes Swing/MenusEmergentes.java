import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

public class MenusEmergentes {
    public static void main(String[] args) {
        MarcoMenusEmergentes marco = new MarcoMenusEmergentes();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
}

@SuppressWarnings("serial")
class MarcoMenusEmergentes extends JFrame {
    public MarcoMenusEmergentes() {
        setTitle("Menus Emergentes");
        setBounds(450, 150, 300, 250);
        setResizable(false);
        add(new LaminaMenusEmergentes());
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaMenusEmergentes extends JPanel {
    public LaminaMenusEmergentes() {
        setLayout(new BorderLayout());
        panelSuperior = new JPanel();
        barra = new JMenuBar();
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamanio = new JMenu("Tama\u00F1o");
        area = new JTextPane();
        emergente = new JPopupMenu();
        opcion1 = new JMenuItem("Opcion 1");
        opcion2 = new JMenuItem("Opcion 2");
        opcion3 = new JMenuItem("Opcion 3");

        barra.add(fuente);
        barra.add(estilo);
        barra.add(tamanio);
        panelSuperior.add(barra);
        emergente.add(opcion1);
        emergente.add(opcion2);
        emergente.add(opcion3);
        area.setComponentPopupMenu(emergente);
        add(panelSuperior, BorderLayout.NORTH);
        add(area, BorderLayout.CENTER);
    }

    private JPopupMenu emergente;
    private JMenuItem opcion1, opcion2, opcion3;
    private JMenuBar barra;
    private JMenu fuente, estilo, tamanio;
    private JPanel panelSuperior;
    private JTextPane area;
}