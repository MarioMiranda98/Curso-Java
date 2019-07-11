package modelo;

import java.sql.*;
import controlador.Conexion;

public class CargaSecciones {
    public CargaSecciones() {
        miConexion = new Conexion();    
    }

    public ResultSet ejecutaConsulta() {
        Connection acceso = miConexion.dameConexion();
        try {
            statement secciones = acceso.createStatement();
            rs = secciones.executeQuery("SELECT DISTINCTROW SECCION FROM PRODUCTOS");
            rs.close();
            acceso.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public Conexion miConexion;
    public ResultSet rs;
}