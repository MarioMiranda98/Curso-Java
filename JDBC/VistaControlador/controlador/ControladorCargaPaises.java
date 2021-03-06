package controlador;

import java.awt.event.*;
import java.sql.*;
import modelo.CargaPaises;
import vista.MarcoAplicacion;

public class ControladorCargaPaises extends WindowAdapter {

    public ControladorCargaPaises(MarcoAplicacion marco) {
        this.marco = marco;
    }

    public void windowOpened(WindowEvent we) {
        ResultSet rs = null;
        try { 
            rs = objeto.ejecutaConsultaPaises();
            while(rs.next()) {
                marco.paises.addItem(rs.getString(1));
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    CargaPaises objeto = new CargaPaises();
    private MarcoAplicacion marco;
}