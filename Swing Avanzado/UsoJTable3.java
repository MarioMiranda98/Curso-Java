import java.awt.BorderLayout;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class UsoJTable3 {
    public static void main(String[] args) {
        JFrame marco = new MarcoUsoJTable3();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoUsoJTable3 extends JFrame {
    public MarcoUsoJTable3() {
        setTitle("Productos");
        setBounds(450, 150, 800, 400);

        panelSuperior = new JPanel();
        nombresTablas = new JComboBox<>();

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?serverTimezone=UTC&useSSL=false", "root", "root");
            datosBBDD = conexion.getMetaData();
            rs = datosBBDD.getTables(null, null, "productos", null);
            while(rs.next()) {
                nombresTablas.addItem(rs.getString("TABLE_NAME"));
            }
        } catch(Exception e) { e.printStackTrace(); }

        nombresTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String tablaSeleccionda = (String) nombresTablas.getSelectedItem();
                String consulta = "SELECT * FROM " + tablaSeleccionda;
                try {
                    sentencia = conexion.createStatement();
                    rs = sentencia.executeQuery(consulta);

                    modelo = new ResultSetModeloTabla(rs);
                    JTable tabla = new JTable(modelo);
                    add(new JScrollPane(tabla), BorderLayout.CENTER);
                    validate();


                } catch (SQLException e1) {
                    e1.printStackTrace();
				}
            }
        });
    
        panelSuperior.add(nombresTablas);    
        add(panelSuperior, BorderLayout.NORTH);
        setVisible(true);
    }

    private JPanel panelSuperior;
    private JComboBox<String> nombresTablas;
    private DatabaseMetaData datosBBDD;
    private ResultSet rs;
    private Connection conexion;
    private Statement sentencia;
    private ResultSetModeloTabla modelo;
}

@SuppressWarnings("serial")
class ResultSetModeloTabla extends AbstractTableModel {
    public ResultSetModeloTabla(ResultSet rs) {
        rsRegistro = rs;

        try {
            resmd = rsRegistro.getMetaData();
        } catch(Exception e) { e.printStackTrace(); }
    }

    @Override
    public int getRowCount() {
        try {
            rsRegistro.last();
            return rsRegistro.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        
    }

    @Override
    public int getColumnCount() {
        try {
            return resmd.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rsRegistro.absolute(rowIndex + 1);
            return rsRegistro.getObject(columnIndex + 1);
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getColumnName(int c) {
        try {
            return resmd.getColumnName(c + 1);
        }catch(Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private ResultSet rsRegistro;
    private ResultSetMetaData resmd;
}