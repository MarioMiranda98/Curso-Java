import java.awt.*;
import javax.swing.*;

public class DispocisionBox {
    public static void main(String[] args) {
        MarcoDisposicionBox marco = new MarcoDisposicionBox();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoDisposicionBox extends JFrame {
    public MarcoDisposicionBox() {
        setTitle("Caja en el marco");
        setBounds(450, 150, 200, 200);

        etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setMaximumSize(etiquetaNombre.getPreferredSize());
        cuadroNombre = new JTextField(10);
        cuadroNombre.setMaximumSize(cuadroNombre.getPreferredSize());
        cajaHorizontal1 = Box.createHorizontalBox();
        cajaHorizontal1.add(etiquetaNombre);
        cajaHorizontal1.add(Box.createHorizontalStrut(10));
        cajaHorizontal1.add(cuadroNombre);

        etiquetaContra = new JLabel("Contrase\u00F1a");
        etiquetaContra.setMaximumSize(etiquetaContra.getPreferredSize());
        cuadroContra = new JTextField(10);
        cuadroContra.setMaximumSize(cuadroContra.getPreferredSize());
        cajaHorizontal2 = Box.createHorizontalBox();
        cajaHorizontal2.add(etiquetaContra);
        cajaHorizontal2.add(Box.createHorizontalStrut(10));
        cajaHorizontal2.add(cuadroContra);

        ok = new JButton("Ok");
        cancelar = new JButton("Cancelar");
        cajaHorizontal3 = Box.createHorizontalBox();
        cajaHorizontal3.add(ok);
        cajaHorizontal3.add(Box.createGlue());
        cajaHorizontal3.add(cancelar);

        cajaPadreVertical = Box.createVerticalBox();
        cajaPadreVertical.add(cajaHorizontal1);
        cajaPadreVertical.add(cajaHorizontal2);
        cajaPadreVertical.add(cajaHorizontal3);

        add(cajaPadreVertical, BorderLayout.CENTER);
        setVisible(true);
    }

    private JLabel etiquetaNombre;
    private JTextField cuadroNombre;
    private Box cajaHorizontal1;
    private JLabel etiquetaContra;
    private JTextField cuadroContra;
    private Box cajaHorizontal2;
    private JButton ok, cancelar;
    private Box cajaHorizontal3;
    private Box cajaPadreVertical;
}