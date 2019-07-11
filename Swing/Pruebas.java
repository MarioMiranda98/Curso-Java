import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class Pruebas {
    public static void main(String[] args) {
        String [] nombreFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String nombre : nombreFuentes) {
            System.out.println(nombre);
        }
        String fuente = JOptionPane.showInputDialog("Introduce fuente");
        boolean estaFuenta = false;
        for (Strign nombre : nombreFuentes) {
            if (fuente.equals(nombre)){
                estaFuenta = true;
            }
        }

        if(estaFuenta)
            System.out.println("La fuente esta instalada");
        else 
            System.out.println("La fuente no esta instalada");
    }
}