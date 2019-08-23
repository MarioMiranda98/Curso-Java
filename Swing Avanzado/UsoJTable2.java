import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;

public class UsoJTable2 {
    public static void main(String[] args) {
        MarcoUsoJTable2 marco = new MarcoUsoJTable2();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoUsoJTable2 extends JFrame {
    public MarcoUsoJTable2() {
        setTitle("Tabla Personalizada");
        setBounds(450, 150, 400, 200);

        miModelo = new ModeloTablaPersonalizada();
        miTabla = new JTable(miModelo);
        add(new JScrollPane(miTabla));
        
        setVisible(true);
    }

    private TableModel miModelo;
    private JTable miTabla;
}

@SuppressWarnings("serial")
class ModeloTablaPersonalizada extends AbstractTableModel {
    public int getColumnCount() {
        return 3;
    }

    public int getRowCount() {
        return 5;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        int z = rowIndex + 1;
        int y = columnIndex + 2;

        return " " + z + " " + y;
    }

    public String getColumnName(int c) {
        return "Columna " + c;
    }
}