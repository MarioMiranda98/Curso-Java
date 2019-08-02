import javax.swing.*;
import java.awt.*;

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

    private JPanel laminaCuadricula;
    private LaminaBotones laminaTipo;
    private LaminaBotones laminaTipoMensaje;
    private LaminaBotones laminaMensaje;
    private LaminaBotones laminaTipoOpcion;
    private LaminaBotones laminaOpciones;
    private LaminaBotones laminaEntrada;
    private JPanel laminaMostrar;
    private JButton mostrar;
}