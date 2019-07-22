import javax.swing.*;
import java.awt.event.*;

public class AreasDeTexto {
    public static void main(String[] args) {
        MarcoAreasDeTexto marco = new MarcoAreasDeTexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoAreasDeTexto extends JFrame {
    public MarcoAreasDeTexto() {
        setBounds(450, 150, 500, 350);
        setTitle("Areas De Texto");
        setResizable(false);
        add(new laminaAreasDeTexto());
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class laminaAreasDeTexto extends JPanel {
    public laminaAreasDeTexto() {
        area = new JTextArea(8, 20);
        imprimir = new JButton("Imprimir");
        scroll = new JScrollPane(area); //Para ponerle scroll al area

        area.setLineWrap(true);
        imprimir.addActionListener(new dameTexto());

        add(scroll);
        add(imprimir);
    }   

    private class dameTexto implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(area.getText());
        }
    }

    private JTextArea area;
    private JButton imprimir;
    private JScrollPane scroll;
}