import java.awt.*;
import javax.swing.*;

public class UsoJSpinner {
    public static void main(String[] args) {
        MarcoUsoJSpinner marco = new MarcoUsoJSpinner();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoUsoJSpinner extends JFrame {
    public MarcoUsoJSpinner() {
        setBounds(450, 150, 550, 350);
        setTitle("JSpinner");
        setResizable(false);
        add(new LaminaUsoJSpinner());
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaUsoJSpinner extends JPanel {
    public LaminaUsoJSpinner() {
       //String lista[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        spinner = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1) {
            public Object getNextValue() {
                return super.getPreviousValue();
            }
    
            public Object getPreviousValue() {
                return super.getNextValue();
            }
        });

        dimension = new Dimension(75, 20);
        spinner.setPreferredSize(dimension);
        add(spinner);
    }

    /*private class ModeloSpinner extends SpinnerNumberModel {
        public ModeloSpinner() {
            super(5, 0, 10, 1);
        }

        public Object getNextValue() {
            return super.getPreviousValue();
        }

        public Object getPreviousValue() {
            return super.getNextValue();
        }
    }*/

    private JSpinner spinner;
    private Dimension dimension;
}