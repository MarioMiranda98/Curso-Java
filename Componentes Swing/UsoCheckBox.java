import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UsoCheckBox {
    public static void main(String[] args) {
        MarcoUsoCheckBox marco = new MarcoUsoCheckBox();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoUsoCheckBox extends JFrame {
    public MarcoUsoCheckBox() {
        setTitle("CheckBox");
        setResizable(false);
        setBounds(450, 150, 550, 350);
        add(new LaminaUsoCheckBox());
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaUsoCheckBox extends JPanel {
    public LaminaUsoCheckBox() {
        setLayout(new BorderLayout());
        laminaTexto = new JPanel();
        laminaCheck = new JPanel();
        Font letra = new Font("Serif", Font.PLAIN, 24);
        texto = new JLabel("En un lugar de la mancha que cuyo nombre...");
        texto.setFont(letra);
        check1 = new JCheckBox("Negrita", false);
        check2 = new JCheckBox("Cursiva", false);

        check1.addActionListener(new ManejaChecks());
        check2.addActionListener(new ManejaChecks());

        laminaTexto.add(texto);
        laminaCheck.add(check1);
        laminaCheck.add(check2);
        add(laminaTexto, BorderLayout.CENTER);
        add(laminaCheck, BorderLayout.SOUTH);
    }

    private class ManejaChecks implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e) {
            int tipo = 0;
            if (check1.isSelected()) tipo += Font.BOLD;
            if (check2.isSelected()) tipo += Font.ITALIC;

            texto.setFont(new Font("Serif", tipo, 24));
        }
    }

    private JLabel texto;
    private JCheckBox check1, check2;
    private JPanel laminaTexto, laminaCheck;
}