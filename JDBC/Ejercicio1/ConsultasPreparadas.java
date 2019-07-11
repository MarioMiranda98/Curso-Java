import java.io.*;
import java.sql.*;

public class ConsultasPreparadas {
    public static void main (String[] args) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba1?serverTimezone=UTC&useSSL=false", "root", "root");
            PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM usuarios WHERE nombre = ?");//Consulta preparada
            sentencia.setString(1, "Mario");
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                System.out.println("ID:" + rs.getString("id") + " Nombre:" + rs.getString("nombre") + " Edad:" +rs.getString("edad"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}