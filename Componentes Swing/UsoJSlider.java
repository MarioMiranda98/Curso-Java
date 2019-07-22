import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class UsoJSlider {
    public static void main(String[] args) {
        MarcoUsoJSlider marco = new MarcoUsoJSlider();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoUsoJSlider extends JFrame {
    public MarcoUsoJSlider() {
        setTitle("JSlider");
        setResizable(false);
        setBounds(450, 150, 550, 350);
        add(new LaminaUsoJSlider());
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaUsoJSlider extends JPanel {
    public LaminaUsoJSlider() {
        setLayout(new BorderLayout());
        panelSuperior = new JPanel();
        control = new JSlider(/*SwingConstants.VERTICAL,*/ 10, 50, 12);
        rotulo = new JLabel("En un lugar de la mancha cuyo nombre...");
        control.setOrientation(SwingConstants.HORIZONTAL);
        control.setFont(new Font("Courier New", Font.ITALIC, 12));
        control.setMajorTickSpacing(10);
        control.setMinorTickSpacing(2);
        control.setPaintTicks(true);
        //control.setPaintTrack(true);
        control.setPaintLabels(true);
        //control.setSnapToTicks(true);*/

        control.addChangeListener(new EventoSlider());

        panelSuperior.add(control);
        add(panelSuperior, BorderLayout.NORTH);
        add(rotulo, BorderLayout.CENTER);
    }

    private class EventoSlider implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent ce) {
            //System.out.println("Moviendo el Slider: " + (++contador));
            //System.out.println(control.getValue());
            rotulo.setFont(new Font("Courier New", Font.ITALIC, control.getValue()));
        }
    }

    private JSlider control;
    private JLabel rotulo;
    private JPanel panelSuperior;
    //private static int contador = 0;
}