import java.awt.BorderLayout;

import javax.swing.*;
import java.util.List;

public class UsoJList {
    public static void main(String[] args) {
        new MarcoUsoJList();
    }
}

@SuppressWarnings("serial")
class MarcoUsoJList extends JFrame {
    public MarcoUsoJList() {
        setTitle("Prueba de Lista");
        setBounds(450, 150, 400, 300);
        setResizable(false);

        String[] meses = {
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre"
        };

        listaDeMeses = new JList<String>(meses);
        listaDeMeses.setVisibleRowCount(4);
        scroll = new JScrollPane(listaDeMeses);
        panelLista = new JPanel();
        panelInferior = new JPanel();
        rotulo = new JLabel("Mes Seleccionado: ");

        listaDeMeses.addListSelectionListener(new javax.swing.event.ListSelectionListener(){
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent le) {
                List<String> lista = listaDeMeses.getSelectedValuesList();
                StringBuilder texto = new StringBuilder("Mes Seleccionado: ");
                for (String elemento : lista) {
                    String palabra = elemento;
                    texto.append(palabra);
                    texto.append(" ");
                }

                rotulo.setText(texto.toString());
            }
        });

        panelLista.add(scroll);
        panelInferior.add(rotulo);
        add(panelLista, BorderLayout.NORTH);
        add(panelInferior, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JList<String> listaDeMeses;
    private JPanel panelLista;
    private JPanel panelInferior;
    private JLabel rotulo;
    private JScrollPane scroll;

}
