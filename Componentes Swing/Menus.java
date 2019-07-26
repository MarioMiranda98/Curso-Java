import javax.swing.*;

@SuppressWarnings("serial")
public class Menus extends JFrame {
    public Menus() {
        setTitle("Menu en Java");
        setResizable(false);
        setBounds(450, 150, 550, 400);
        add(new LaminaMenus());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Menus();
    }
}

@SuppressWarnings("serial")
class LaminaMenus extends JPanel {
    public LaminaMenus() {
        barra = new JMenuBar();
        archivo = new JMenu("Archivo");
        editar = new JMenu("Editar");
        herramientas = new JMenu("Herramientas");
        opciones = new JMenu("Opciones");
        guardar = new JMenuItem("Guardar");
        guardarComo = new JMenuItem("Guardar Como");
        cortar = new JMenuItem("Cortar", new ImageIcon("./imgs/llave.png"));
        copiar = new JMenuItem("Copiar", new ImageIcon("./imgs/localizacion.png"));
        copiar.setHorizontalTextPosition(SwingConstants.LEFT);
        pegar = new JMenuItem("Pegar", new ImageIcon("./imgs/play.png"));
        generales = new JMenuItem("Generales");
        opcion1 = new JMenuItem("Opcion 1");
        opcion2 = new JMenuItem("Opcion 2");

        archivo.add(guardar);
        archivo.add(guardarComo);
        editar.add(cortar);
        editar.add(copiar);
        editar.add(pegar);
        editar.addSeparator();
        herramientas.add(generales);
        opciones.add(opcion1);
        opciones.add(opcion2);
        editar.add(opciones);
        barra.add(archivo);
        barra.add(editar);
        barra.add(herramientas);

        add(barra);
    }
    
    private JMenuBar barra;
    private JMenu archivo;
    private JMenu editar;
    private JMenu herramientas;
    private JMenuItem guardar;
    private JMenuItem guardarComo;
    private JMenuItem cortar;
    private JMenuItem copiar;
    private JMenuItem pegar;
    private JMenuItem generales;
    private JMenu opciones;
    private JMenuItem opcion1;
    private JMenuItem opcion2;
}