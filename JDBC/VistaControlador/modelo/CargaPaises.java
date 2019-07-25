package modelo;

import java.sql.*;
import controlador.Conexion;

public class CargaPaises {
    public CargaPaises() {
        miConexion = new Conexion();
    }

    public ResultSet ejecutaConsultaPaises() {
        Connection acceso = miConexion.dameConexion();
        try {
            Statement paises = acceso.createStatement();
            rs = paises.executeQuery("SELECT DISTINCTROW PAISDEORIGEN FROM PRODUCTOS");
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