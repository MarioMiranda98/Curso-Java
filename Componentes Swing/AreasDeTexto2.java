import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class AreasDeTexto2 {
    public static void main(String[] args) {
        MarcoAreasDeTexto2 marco = new MarcoAreasDeTexto2();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoAreasDeTexto2 extends JFrame {
    public MarcoAreasDeTexto2() {
        setTitle("Area de Texto 2");
        setResizable(false);
        setBounds(450, 150, 500, 350);
        add(new LaminaAreasDeTexto2());
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaAreasDeTexto2 extends JPanel {
    public LaminaAreasDeTexto2() {
        setLayout(new BorderLayout(5, 5));
        laminaBotones = new JPanel();
        area = new JTextArea();
        scrollBar = new JScrollPane(area);
        insertarTexto = new JButton("Insertar Texto");
        salto = new JButton("Salto Linea? (On/Off)");

        insertarTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.append("En un lugar de la mancha que cuyo nombre no quiero acordarme ");
            }
        });

        salto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setLineWrap(!area.getLineWrap());
                salto.setText(!area.getLineWrap() == true ? "Agregar Salto" : "Quitar Salto");
            }
        });

        laminaBotones.setLayout(new FlowLayout());
        laminaBotones.add(insertarTexto);
        laminaBotones.add(salto);
        add(scrollBar, BorderLayout.CENTER);
        add(laminaBotones, BorderLayout.SOUTH);

    }

    private JTextArea area;
    private JScrollPane scrollBar;
    private JButton insertarTexto;
    private JButton salto;
    private JPanel laminaBotones;
}