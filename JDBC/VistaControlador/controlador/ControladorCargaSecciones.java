package controlador;

import java.awt.event.*;
import java.sql.*;
import modelo.CargaSecciones;
import vista.MarcoAplicacion;

public class ControladorCargaSecciones extends WindowAdapter {

    public ControladorCargaSecciones(MarcoAplicacion marco) {
        this.marco = marco;
    }

    public void windowOpened(WindowEvent we) {
        ResultSet rs = null;
        try { 
            rs = objeto.ejecutaConsulta();
            while(rs.next()) {
                marco.secciones.addItem(rs.getString(1));
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        rs.close();
    }

    CargaSecciones objeto = new CargaSecciones();
    private MarcoAplicacion marco;
}