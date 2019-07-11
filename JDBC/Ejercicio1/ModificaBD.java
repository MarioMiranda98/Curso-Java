import java.io.*;
import java.sql.*;

public class ModificaBD {
    public static void main (String [] args) {
        try {
            ResultSet resultado;
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba1?serverTimezone=UTC&useSSL=false", "root", "root");
            Statement sentencia = conexion.createStatement();

            System.out.println ("Insertando usuarios");
            String insersionSQL = "INSERT INTO usuarios (id, nombre, edad) values (4, 'Mario4', 25)";
            sentencia.executeUpdate(insersionSQL);
            resultado = sentencia.executeQuery("SELECT * FROM usuarios");
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getString("id") + " Nombre: " + resultado.getString("nombre") + " Edad: " + resultado.getString("edad"));
            }

            System.out.println ("Actualizando usuarios");
            String instruccionSQL = "UPDATE usuarios SET nombre = 'MarioFuturo4' WHERE EDAD = 25";
            sentencia.executeUpdate(instruccionSQL);
            resultado = sentencia.executeQuery("SELECT * FROM usuarios");
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getString("id") + " Nombre: " + resultado.getString("nombre") + " Edad: " + resultado.getString("edad"));
            }

            System.out.println ("Borrando usuarios");
            String eliminarSQL = "DELETE FROM usuarios WHERE nombre = 'MarioFuturo4'";
            sentencia.executeUpdate(eliminarSQL);
            resultado = sentencia.executeQuery("SELECT * FROM usuarios");
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getString("id") + " Nombre: " + resultado.getString("nombre") + " Edad: " + resultado.getString("edad"));
            }
        } catch (Exception e) {

        }
    }
}
