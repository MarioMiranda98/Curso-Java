import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CambioEstado {
    public static void main (String[] args) {
        MarcoCambioEstado marco = new MarcoCambioEstado();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoCambioEstado extends JFrame {
    public MarcoCambioEstado() {
        setBounds(300, 300, 500, 350);
        addWindowStateListener(new CambiaEstado());
        setVisible(true);
    }
}

class CambiaEstado implements WindowStateListener {
    public void windowStateChanged(WindowEvent we) {
        System.out.println("La ventana ha cambiado de estado");
        System.out.println(we.getOldState());
        System.out.println(we.getNewState());
    }
}