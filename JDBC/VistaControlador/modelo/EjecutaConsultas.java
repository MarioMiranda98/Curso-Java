package modelo;

import java.sql.*;
import controlador.Conexion;

public class EjecutaConsultas {

    public EjecutaConsultas() {
        conexion = new Conexion();
    }

    public ResultSet filtraBase(String seccion, String pais) {
        //prueba = "";
        Connection conxionClase = conexion.dameConexion();
        rs = null;
        try {
            if(!seccion.equals("Todos") && pais.equals("Todos")) {
                //prueba = "Haz escogido seccion";
                enviaConsultaSeccion = conxionClase.prepareStatement(consultaSeccion);
                enviaConsultaSeccion.setString(1, seccion);
                rs = enviaConsultaSeccion.executeQuery();
                rs.close();
            } else if (seccion.equals("Todos") && !pais.equals("Todos")){ 
                //prueba = "Haz escogido Pais";
                enviaConsultaPais = conxionClase.prepareStatement(consultaPais);
                enviaConsultaPais.setString(1, pais);
                rs = enviaConsultaPais.executeQuery();
                rs.close();
            } else {
                //prueba = "Haz escogido seccion y pais";
                enviaConsultaAmbos = conxionClase.prepareStatement(consultaAmbos);
                enviaConsultaAmbos.setString(1, seccion);
                enviaConsultaAmbos.setString(2, pais);
                rs = enviaConsultaAmbos.executeQuery();
                rs.close();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    //private String prueba;
    private Conexion conexion;
    private ResultSet rs;
    private PreparedStatement enviaConsultaSeccion;
    private PreparedStatement enviaConsultaPais;
    private PreparedStatement enviaConsultaAmbos;
    private final String consultaSeccion = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE SECCION = ?";
    private final String consultaPais = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE PAISDEORIGEN = ?";
    private final String consultaAmbos = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE SECCION = ? AND PAISDEORIGEN = ?";
}