package procesador2;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class ProcesadorTextos {
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

        configuraMenu("12", "tamanio", "", 9, 12);
        configuraMenu("14", "tamanio", "", 9, 14);
        configuraMenu("16", "tamanio", "", 9, 16);
        configuraMenu("18", "tamanio", "", 9, 18);
        configuraMenu("20", "tamanio", "", 9, 20);
        configuraMenu("22", "tamanio", "", 9, 22);
        configuraMenu("24", "tamanio", "", 9, 24);

        barra.add(fuente);
        barra.add(estilo);
        barra.add(tamanio);   
        laminaMenu.add(barra);
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
            if (estilos == Font.ITALIC)
                elementoMenu.addActionListener(new StyledEditorKit.ItalicAction());
            else if (estilos == Font.BOLD)
                elementoMenu.addActionListener(new StyledEditorKit.BoldAction());
        } else if (menu.equals("tamanio")) {
            tamanio.add(elementoMenu);
            elementoMenu.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamanio", tam));
        }
    }

    private JPanel laminaMenu;
    private JMenuBar barra;
    private JMenu fuente, estilo, tamanio;
    private JTextPane area;
}