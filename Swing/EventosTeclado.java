import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class EventosTeclado {
    public static void main(String[] args) {
        MarcoEventoTeclado marco = new MarcoEventoTeclado();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoEventoTeclado extends JFrame {
    public MarcoEventoTeclado() {
        setBounds(700, 300, 600, 450);
        addKeyListener(new EventoDeTeclado());
        setVisible(true);
    }
}

class EventoDeTeclado implements KeyListener {
    public void keyPressed(KeyEvent e) {
        int codigo = e.getKeyCode();
        System.out.println("Codigo: " + codigo);
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        System.out.println("Tecla: " + c);
    } 
}