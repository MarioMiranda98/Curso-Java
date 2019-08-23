import java.awt.BorderLayout;

import javax.swing.*;

public class UsoJTable {
    public static void main(String[] args) {
        MarcoUsoJTable marco = new MarcoUsoJTable();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
}

@SuppressWarnings("serial")
class MarcoUsoJTable extends JFrame {
    public MarcoUsoJTable() {
        setTitle("JTable");
        setBounds(450, 150, 400, 200);

        panelBoton = new JPanel();
        tablaPlanetas = new JTable(datosFila, nombresColumnas);
        imprimir = new JButton("Imprimir Tabla");

        imprimir.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try {
                    tablaPlanetas.print();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    
        panelBoton.add(imprimir);
        add(new JScrollPane(tablaPlanetas), BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
        setVisible(true);
    }
    private String[] nombresColumnas = {
        "Nombre",
        "Radio",
        "Lunas",
        "Gaseoso"
    };

    private Object[][] datosFila = {
        {"Mercurio", 2440.0, 0, false},
        {"Venus", 6502.0, 0, false},
        {"Tierra", 6378.0, 1, false},
        {"Marte", 3397.0, 2, false},
        {"Jupiter", 71492.0, 16, true},
        {"Saturno", 60268.0, 18, true},
        {"Urano", 25559.0, 17, true},
        {"Neptuno", 24776.0, 8, true},
        {"Pluton", 1137.0, 1, false}
    };

    private JTable tablaPlanetas;
    private JButton imprimir;
    private JPanel panelBoton;
}