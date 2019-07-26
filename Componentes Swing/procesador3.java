import javax.swing.*;
import javax.swing.text.*;

import com.sun.glass.events.KeyEvent;

import java.awt.*;
import java.awt.event.InputEvent;

public class procesador3 {
    public static void main(String[] args) {
        MarcoProcesadorTextos marco = new MarcoProcesadorTextos();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoProcesadorTextos extends JFrame {
    public MarcoProcesadorTextos() {
        setTitle("Procesador de Textos");
        setResizable(false);
        setBounds(450, 150, 550, 400);
        add(new LaminaProcesadorTextos());
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaProcesadorTextos extends JPanel {
    public LaminaProcesadorTextos() {
        setLayout(new BorderLayout());
        laminaMenu = new JPanel();
        area = new JTextPane();
        barra = new JMenuBar();
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamanio = new JMenu("Tama\u00F1o");

        configuraMenu("Arial", "fuente", "Arial", 9, 10);
        configuraMenu("Verdana", "fuente", "Verdana", 9, 10);
        configuraMenu("Courier New", "fuente", "Courier New", 9, 10);

        configuraMenu("Negrita", "estilo", "", Font.BOLD, 1);
        configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1);
        negrita = new JCheckBoxMenuItem("Negrita", new ImageIcon("./imgs/llave.png"));
        cursiva = new JCheckBoxMenuItem("Cursiva", new ImageIcon("./imgs/play.png"));
        grupoTamanio = new ButtonGroup();
        tam12 = new JRadioButtonMenuItem("12");
        tam14 = new JRadioButtonMenuItem("14");
        tam16 = new JRadioButtonMenuItem("16");
        tam18 = new JRadioButtonMenuItem("18");
        tam20 = new JRadioButtonMenuItem("20");
        tam24 = new JRadioButtonMenuItem("24");
        emergente = new JPopupMenu();
        opcion1 = new JMenuItem("Negrita");
        opcion2 = new JMenuItem("Cursiva");
        //opcion3 = new JMenuItem("Opcion 3");

       /* configuraMenu("12", "tamanio", "", 9, 12);
        configuraMenu("14", "tamanio", "", 9, 14);
        configuraMenu("16", "tamanio", "", 9, 16);
        configuraMenu("18", "tamanio", "", 9, 18);
        configuraMenu("20", "tamanio", "", 9, 20);
        configuraMenu("22", "tamanio", "", 9, 22);
        configuraMenu("24", "tamanio", "", 9, 24);*/

        //negrita.addActionListener(new StyledEditorKit.BoldAction());
        //cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        tam12.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamanio", 12));
        tam14.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamanio", 14));
        tam16.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamanio", 16));
        tam18.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamanio", 18));
        tam20.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamanio", 20));
        tam24.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamanio", 24));
        //tam24.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        opcion1.addActionListener(new StyledEditorKit.BoldAction());
        opcion2.addActionListener(new StyledEditorKit.ItalicAction());

        grupoTamanio.add(tam12);
        grupoTamanio.add(tam14);
        grupoTamanio.add(tam16);
        grupoTamanio.add(tam18);
        grupoTamanio.add(tam20);
        grupoTamanio.add(tam24);       
        tamanio.add(tam12);
        tamanio.add(tam14);
        tamanio.add(tam16);
        tamanio.add(tam18);
        tamanio.add(tam20);
        tamanio.add(tam24);       
        estilo.add(negrita);
        estilo.add(cursiva);
        barra.add(fuente);
        barra.add(estilo);
        barra.add(tamanio);  
        emergente.add(opcion1);
        emergente.add(opcion2);
        //emergente.add(opcion3); 
        laminaMenu.add(barra);
        area.setComponentPopupMenu(emergente);
        add(laminaMenu, BorderLayout.NORTH);
        add(area, BorderLayout.CENTER);
    }

    public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam) {
        JMenuItem elementoMenu = new JMenuItem(rotulo);

        if (menu.equals("fuente")) {
            fuente.add(elementoMenu);
            if (tipoLetra == "Courier New") 
                elementoMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia Letra", "Courier New"));
            else if (tipoLetra == "Arial")
                elementoMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia Letra", "Arial"));
            else if (tipoLetra == "Verdana")
                elementoMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia Letra", "Verdana"));
        } else if (menu.equals("estilo")) {
            estilo.add(elementoMenu);
            if (estilos == Font.ITALIC) {
                elementoMenu.addActionListener(new StyledEditorKit.ItalicAction());
                elementoMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
            } else if (estilos == Font.BOLD){ 
                elementoMenu.addActionListener(new StyledEditorKit.BoldAction());
                elementoMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
            }
        } else if (menu.equals("tamanio")) {
            tamanio.add(elementoMenu);
            elementoMenu.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamanio", tam));
        }
    }

    private JPanel laminaMenu;
    private JMenuBar barra;
    private JMenu fuente, estilo, tamanio;
    private JTextPane area;
    private JCheckBoxMenuItem negrita, cursiva;
    private JRadioButtonMenuItem tam12, tam14, tam16, tam18, tam20, tam24;
    private ButtonGroup grupoTamanio;
    private JPopupMenu emergente;
    private JMenuItem opcion1, opcion2;
}