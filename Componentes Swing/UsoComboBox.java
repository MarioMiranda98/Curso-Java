import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UsoComboBox {
    public static void main(String[] args) {
        MarcoUsoComboBox marco = new MarcoUsoComboBox();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoUsoComboBox extends JFrame {
    public MarcoUsoComboBox() {
        setTitle("Combo Box");
        setResizable(false);
        setBounds(450, 150, 550, 400);
        add(new LaminaUsoComboBox());
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaUsoComboBox extends JPanel {

    public LaminaUsoComboBox() {
        setLayout(new BorderLayout());
        laminaCombo = new JPanel();
        texto = new JLabel("En algun lugar de la macha cuyo nombre...");
        texto.setFont(new Font("Serif", Font.PLAIN, 18));
        combo = new JComboBox<>();
        combo.setEditable(false);
        combo.addItem("Courier New");
        combo.addItem("Consolas");
        combo.addItem("Sans Serif");
        combo.addItem("Monospace");
        combo.addItem("Arial");
        combo.addItem("Calibri");

        combo.addActionListener(new EventoCombo());

        laminaCombo.add(combo);
        add(laminaCombo, BorderLayout.NORTH);
        add(texto, BorderLayout.CENTER);
    }

    private class EventoCombo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            texto.setFont(new Font((String) combo.getSelectedItem(), Font.PLAIN, 18));
        }
    }

    private JLabel texto;
    private JPanel laminaCombo;
    private JComboBox combo;
}