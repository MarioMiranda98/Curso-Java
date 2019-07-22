import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class EventosCuadroTexto2 {
    public static void main(String[] args) {
        MarcoEventosCuadroTexto2 marco = new MarcoEventosCuadroTexto2();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoEventosCuadroTexto2 extends JFrame {
    public MarcoEventosCuadroTexto2() {
        setTitle("Ejemplo de prueba");
        setResizable(false);
        setBounds(450, 150, 350, 400);
        LaminaEventosCuadroTexto2 lamina = new LaminaEventosCuadroTexto2();
        add(lamina);
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaEventosCuadroTexto2 extends JPanel {
    public LaminaEventosCuadroTexto2() {
        setLayout(new BorderLayout(10, 10));
        laminaGrid = new JPanel();
        laminaGrid.setLayout(new GridLayout(2, 2, 5, 5));
        
        etiquetaUsuario = new JLabel("Usuario:");
        etiquetaPass = new JLabel("Pass:");
        cuadroUsuario = new JTextField(15);
        cuadroPass = new JPasswordField(15);
        botonEnvio = new JButton("Enviar");
        
        laminaGrid.add(etiquetaUsuario);
        laminaGrid.add(cuadroUsuario);
        laminaGrid.add(etiquetaPass);
        laminaGrid.add(cuadroPass);

        documento= cuadroPass.getDocument();
        documento.addDocumentListener(new compruebaPass()); 

        add(laminaGrid, BorderLayout.NORTH);
        add(botonEnvio, BorderLayout.SOUTH);
    }

    private class compruebaPass implements DocumentListener {
        @Override
        public void changedUpdate(DocumentEvent de) {
        
        }

        @Override
        public void insertUpdate(DocumentEvent de) {
            char[] pass = cuadroPass.getPassword();
            validar(pass);
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
            char[] pass = cuadroPass.getPassword();
            validar(pass);
        }

        private void validar(char[] pass) {
            //System.out.println(pass);
            if (pass.length < 8 || pass.length > 12)
                cuadroPass.setForeground(Color.RED);
            else 
                cuadroPass.setForeground(Color.BLACK);
        }
    }

    private JLabel etiquetaUsuario;
    private JLabel etiquetaPass;
    private JTextField cuadroUsuario;
    private JPasswordField cuadroPass;
    private JButton botonEnvio;
    private JPanel laminaGrid;
    private Document documento;
}