import javax.swing.*;
import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import java.awt.event.*;

public class PruebaTexto {
    public static void main(String[] args) {
        MarcoPruebaTexto marco = new MarcoPruebaTexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoPruebaTexto extends JFrame {
    public MarcoPruebaTexto() {
        setBounds(450, 150, 600, 350);
        setTitle("Prueba Texto");
        setResizable(false);
        LaminaPruebaTexto lamina = new LaminaPruebaTexto();
        add(lamina);
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaPruebaTexto extends JPanel {
    public LaminaPruebaTexto() {
        this.setLayout(new BorderLayout());
        lamina1 = new JPanel();
        campo1 = new JTextField(20);
        lcampo1 = new JLabel("Correo:");
        boton = new JButton("Accion!");
        resultado = new JLabel("", JLabel.CENTER);
        lamina1.add(lcampo1);
        lamina1.add(campo1);
        lamina1.add(boton);
        add(resultado, BorderLayout.CENTER);
        add(lamina1, BorderLayout.NORTH);
        boton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                validar(campo1.getText().trim());
            }
        }); 
        //System.out.println(campo1.getText().trim());
    }


    private void validar(String correo) {
        //System.out.println(correo);
        int arroba = 0;
        char caracter;
        for (int i = 0; i < correo.length(); i += 1) {
            caracter = correo.charAt(i);
            if (caracter == '@') 
                arroba += 1;
        }

        if (arroba != 1) {
            System.out.println("Correo incorrecto");
            resultado.setText("Correo incorrecto");
        } else {
            System.out.println("Correo correcto");
            resultado.setText("Correo correcto");
        }
    }

    private JTextField campo1;
    private JButton boton;
    private JLabel lcampo1;
    private JLabel resultado;
    private JPanel lamina1;
}