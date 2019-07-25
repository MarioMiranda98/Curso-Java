package principal;

import vista.*;
import vista.MarcoAplicacion;
import javax.swing.*;

public class Ejeccucion {
    public static void main(String[] args) {
        MarcoAplicacion miMarco = new MarcoAplicacion();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}