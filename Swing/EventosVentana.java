import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventosVentana {
    public static void main (String[] args) {
        MarcoEventosVentana marco = new MarcoEventosVentana();
        marco.setTitle("Marco 1");
        marco.setBounds(100, 100, 500, 350);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MarcoEventosVentana marco2 = new MarcoEventosVentana();
        marco2.setTitle("Marco 2");
        marco2.setBounds(700, 100, 500, 350);
        marco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoEventosVentana extends JFrame {
    public MarcoEventosVentana() {
        //setTitle("Eventos Ventana");
        //setBounds(300, 300, 500, 350);
        M_Ventana oyenteVentana = new M_Ventana();
        addWindowListener(oyenteVentana);
        setVisible(true);
    }
}

class M_Ventana implements WindowListener {
    public void windowActivated(WindowEvent we) {
        System.out.println("Ventana activada");
    }

    public void windowClosed(WindowEvent we) {
        System.out.println("Ventana Cerrada");
    }

    public void windowClosing(WindowEvent we) {
        System.out.println("Cerrando Ventana");
    }

    public void windowDeactivated(WindowEvent we) {
        System.out.println("Ventana desactivada");
    }

    public void windowDeiconified(WindowEvent we) {
        System.out.println("Ventana Restaurada");
    }

    public void windowIconified(WindowEvent we) {
        System.out.println("Ventana Minimizada");
    }
    
    public void windowOpened(WindowEvent we) {
        System.out.println("Ventana Abierta");
    }
}