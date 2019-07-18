import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculadora {
    public static void main(String[] args) {
        MarcoCalculadora marco = new MarcoCalculadora();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoCalculadora extends JFrame {
    public MarcoCalculadora() {
        setTitle("Calculadora");
        setResizable(false);
        setBounds(450, 200,  350, 450);
        lamina = new LaminaCalculadora();
        add(lamina);
        //pack();
        setVisible(true);
    }

    private LaminaCalculadora lamina;
}

@SuppressWarnings("serial")
class LaminaCalculadora extends JPanel {
    public LaminaCalculadora() {
        setLayout(new BorderLayout());
        principio = true;
        ultimaOrden = "=";
        ac = new AccionCalculadora();
        op = new Operadores();
        Display = new JButton("0");
        Display.setEnabled(false);
        add(Display, BorderLayout.NORTH);
        teclado = new JPanel();
        teclado.setLayout(new GridLayout(4, 4, 5, 5));
        botones = new JButton[16];
        for (int i = 0; i < 16; i++)
            teclado.add(botones[i] = new JButton(etiquetas[i]));
        add(teclado, BorderLayout.CENTER);
        for (int i = 0; i < 16; i++)
            if (i != 3 && i != 7 && i != 11 && i != 14 && i != 15 )
                botones[i].addActionListener(ac);

        for (int i = 0; i < 5; i++)
            botones[faltantes[i]].addActionListener(op);
    }

    private class AccionCalculadora implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton Boton = (JButton) e.getSource();
            //System.out.println("Boton Pulsado: " + Boton.getText());
            if(principio){
                Display.setText("");    
                principio = false;
            }
            Display.setText(Display.getText() + Boton.getText());
        }
    }

    private class Operadores implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println(e.getActionCommand());
            operacion = e.getActionCommand();
            calcular(Double.parseDouble(Display.getText()));
            ultimaOrden = operacion;
            principio = true;
        }
    }

    public void calcular(double x) {
        if (ultimaOrden.equals("+")) {
            resultado += x;
        } else if (ultimaOrden.equals("-")) {
            resultado -= x;
        } else if (ultimaOrden.equals("*")) {
            resultado *= x;
        } else if (ultimaOrden.equals("/")) {
            resultado /= x;
        } else if (ultimaOrden.equals("=")) {
            resultado = x;
        }
        //System.out.println(resultado);
        Display.setText(""+resultado);
    }

    private JButton Display;
    private JPanel teclado;
    private JButton[] botones;
    private String[] etiquetas = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "+", "0", ".", "+", "="};
    private boolean principio;
    private AccionCalculadora ac;
    private Operadores op;
    private int faltantes[] = {3, 7, 11, 14, 15};
    private double resultado;
    private String ultimaOrden;
    private String operacion;
}