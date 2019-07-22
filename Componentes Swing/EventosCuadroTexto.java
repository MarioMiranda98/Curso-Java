import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Document;

public class EventosCuadroTexto {
    public static void main(String[] args) {
        MarcoEventosCuadroTexto marco = new MarcoEventosCuadroTexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoEventosCuadroTexto extends JFrame {
    public MarcoEventosCuadroTexto() {
        setTitle("Eventos Cuadros de Texto");
        setResizable(false);
        setBounds(450, 200, 500, 350);
        LaminaEventosCuadroTexto lamina = new LaminaEventosCuadroTexto();
        add(lamina);
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaEventosCuadroTexto extends JPanel {
    public LaminaEventosCuadroTexto() {
        miCampo = new JTextField(20);
        documento = miCampo.getDocument();
        documento.addDocumentListener(new EscuchaTexto());
        add(miCampo);
    }

    private class EscuchaTexto implements DocumentListener {
        @Override
        public void changedUpdate(DocumentEvent de) {

        }

        @Override
        public void insertUpdate(DocumentEvent de) {
            System.out.println("Haz insertado texto");
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
            System.out.println("Haz borrado Texto");
        }
    }

    private JTextField miCampo;
    private Document documento;
}