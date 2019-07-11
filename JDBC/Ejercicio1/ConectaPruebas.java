import java.io.*;
import java.sql.*;

public class ConectaPruebas {
    public static void main (String [] args) {
        try {
            //Conexion
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba1?serverTimezone=UTC&useSSL=false", "root", "root");
            //Objeto Statement
            Statement sentencia = miConexion.createStatement();
            //Ejecutar la instruccion SQL
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM usuarios");
            //Leer el Result Set
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getString("id") + " Nombre: " + resultado.getString("nombre") + " Edad: " + resultado.getString("edad"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}