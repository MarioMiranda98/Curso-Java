import java.awt.*;
import javax.swing.*;

public class CreandoMarcos { 
    public static void main (String[] args) {
        miMarco marco = new miMarco();
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class miMarco extends JFrame {
    public miMarco() {
        //setSize(500, 300);
        //setLocation(500, 250);
        setBounds(500, 250, 300, 300); //(x, y, ancho, largo)
        setTitle("Primer Marco");//Pone titulo
        setResizable(false);//Para permitir que se redimencione
    }
}