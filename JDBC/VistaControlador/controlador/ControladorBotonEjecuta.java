package controlador;

import java.awt.event.ActionListener;
import modelo.EjecutaConsultas;
import vista.MarcoAplicacion;
import java.sql.*;

public class ControladorBotonEjecuta implements ActionListener { 

    public ControladorBotonEjecuta (MarcoAplicacion marco) {
        this.marco = marco;
        marco = new EjecutaConsultas();
    }

    public void actionPerformed (ActionEvent e) {
        String seleccionSeccion = (String) marco.secciones.getSelectedItem();
        String seleccionPais = (String) marco.secciones.getSelectedItem();
        rs = consulta.filtraBase(seleccionSeccion, seleccionPais);
        marco.resultado.setText("");
        try {
            while(rs.next()) {
                marco.resultado.append("Producto: " + rs.getString(1) + ", Seccion: " + rs.getString(2) + ", Precio: " + rs.getString(3) + ", Pais de Origen: " + rs.getString(4));
                marco.resultado.append("\n");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }    
    }

    private MarcoAplicacion marco;
    private EjecutaConsultas consulta;
    private ResultSet rs;
}