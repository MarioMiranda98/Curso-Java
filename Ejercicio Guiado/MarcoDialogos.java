import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class MarcoDialogos extends JFrame {
    private static final long serialVersionUID = 1L;
    public MarcoDialogos() {
        setTitle("Prueba de Dialogos");
        setBounds(450, 150, 600, 450);
        setLayout(new BorderLayout());

        laminaCuadricula = new JPanel();
        laminaCuadricula.setLayout(new GridLayout(2, 3, 5, 5));
        laminaMostrar = new JPanel();
        mostrar = new JButton("Mostrar");
        icono = new ImageIcon("./imgs/llave.png");
        objetoMensaje = new Date();
        componente = new LaminaEjemplo();
        cadenaMensaje = "Mensaje";

        mostrar.addActionListener(new AccionMostrar());

        laminaTipo = new LaminaBotones("Tipo", new String[]{
            "Mensaje",
            "Confirmar",
            "Opcion",
            "Entrada"
        });
        laminaCuadricula.add(laminaTipo);

        laminaTipoMensaje = new LaminaBotones("Tipo de Mensaje", new String[]{
            "ERROR_MESSAGE", 
            "INFORAMTION_MESSAGE",
            "WARNING_MESSAGE",
            "QUESTION_MESSAGE",
            "PLAIN_MESSAGE"
        });
        laminaCuadricula.add(laminaTipoMensaje);

        laminaMensaje = new LaminaBotones("Mensaje", new String[]{
            "Cadena",
            "Icono",
            "Componente",
            "Otros",
            "Objects[]"
        });
        laminaCuadricula.add(laminaMensaje);

        laminaTipoOpcion = new LaminaBotones("Confirmar", new String[]{
            "DEFAULT_OPTION",
            "YES_NO_OPTION",
            "YES_NO_CANCEL_OPTION",
            "OK_CANCEL_OPTION"
        });
        laminaCuadricula.add(laminaTipoOpcion);

        laminaOpciones = new LaminaBotones("Opcion", new String[]{
            "String[]",
            "Icon[]",
            "Object[]"
        });
        laminaCuadricula.add(laminaOpciones);

        laminaEntrada = new LaminaBotones("Entrada", new String[]{
            "Campo De Texto",
            "Combo"
        });
        laminaCuadricula.add(laminaEntrada);

        laminaMostrar.add(mostrar);
        add(laminaCuadricula, BorderLayout.CENTER);
        add(laminaMostrar, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Object dameMensaje() {
        String s = laminaMensaje.dameSeleccion();
        if (s.equals("Cadena"))
            return cadenaMensaje;
        else if (s.equals("Icono")) 
            return icono;
        else if (s.equals("Componente"))
            return componente;
        else if (s.equals("Otros"))
            return objetoMensaje;
        else {
            return new Object[]{
                cadenaMensaje,
                icono, 
                componente,
                objetoMensaje
            };
        }
    }

    public int dameTipo(LaminaBotones lamina) {
        String s = lamina.dameSeleccion();
        if (s.equals("ERROR_MESSAGE") || s.equals("YES_NO_OPTION")) 
            return 0;
        else if (s.equals("INFORMATION_MESSAGE") || s.equals("YES_NO_CANCEL_OPTION"))
            return 1;
        else if (s.equals("WARNING_MESSAGE") || s.equals("OK_CANCEL_OPTION")) 
            return 2;
        else if (s.equals("QUESTION_MESSAGE"))
            return 3;
        else   
            return -1;
   }

   public Object[] dameOpciones(LaminaBotones lamina){
        String s = lamina.dameSeleccion();
        if (s.equals("String[]")) 
            return new String[] {
                "Azul",
                "Amarillo",
                "Rojo"
            };
        else if (s.equals("Icon[]"))
            return new Icon[] {
                new ImageIcon("./imgs/llave.png"),
                new ImageIcon("./imgs/localizacion.png"),
                new ImageIcon("./imgs/play.png")
            };
        else 
            return new Object[] {
                cadenaMensaje,
                icono, 
                componente,
                objetoMensaje
            };
   }

    private class AccionMostrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println("Funciona");
            //System.out.println(laminaTipo.dameSeleccion());
            if (laminaTipo.dameSeleccion().equals("Mensaje")) {
                JOptionPane.showMessageDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipo(laminaTipoMensaje));
            } else if (laminaTipo.dameSeleccion().equals("Confirmar")) {
                JOptionPane.showConfirmDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipo(laminaTipoOpcion), dameTipo(laminaTipoMensaje));
            } else if (laminaTipo.dameSeleccion().equals("Entrada")) {
                if (laminaEntrada.dameSeleccion().equals("Campo De Texto"))
                    JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipo(laminaTipoMensaje));
                else 
                    JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipo(laminaTipoMensaje), null, new String[] {"Amariilo", "Azul", "Rojo"}, 0);
            } else if (laminaTipo.dameSeleccion().equals("Opcion")) {
                JOptionPane.showOptionDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipo(laminaTipoOpcion), dameTipo(laminaTipoMensaje), null, dameOpciones(laminaOpciones), null);
            }
        }
    }

    private JPanel laminaCuadricula;
    private LaminaBotones laminaTipo;
    private LaminaBotones laminaTipoMensaje;
    private LaminaBotones laminaMensaje;
    private LaminaBotones laminaTipoOpcion;
    private LaminaBotones laminaOpciones;
    private LaminaBotones laminaEntrada;
    private JPanel laminaMostrar;
    private JButton mostrar;
    private String cadenaMensaje;
    private ImageIcon icono;
    private Object objetoMensaje;
    private Component componente;
}

class LaminaEjemplo extends JPanel {
    private static final long serialVersionUID = 3L;
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
        g2.draw(rectangulo);
        g2.setColor(Color.CYAN);
        g2.fill(rectangulo);
    }
}