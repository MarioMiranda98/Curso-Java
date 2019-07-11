package controlador;

import java.sql.*;

public class Conexion {
    public Conexion() {

    }

    conexion = null;

    public Connection dameConexion() {
        try {
             conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica?serverTimezone=UTC&useSSL=false","root","root");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conexion;
    }

    public Connection conexion;
}