import java.awt.*;
import javax.swing.*;

public class CreandoMarcoCentrado {
    public static void main (String[] args) {
        MarcoCentrado marco = new MarcoCentrado();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoCentrado extends JFrame {
    public MarcoCentrado () {
        //setLocationRelativeTo(null); -> Coloca el marco centrado
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension TamanioPantalla = miPantalla.getScreenSize();
        int alturaPantalla = TamanioPantalla.height;
        int anchoPantalla = TamanioPantalla.width;
        setSize(anchoPantalla/2, alturaPantalla/2);
        setLocation(anchoPantalla/4, alturaPantalla/4);
        setTitle("Marco Centrado");
        setResizable(false);
        Image miIcono = miPantalla.getImage("./red.png");
        setIconImage(miIcono);
        setVisible(true);
    }
}