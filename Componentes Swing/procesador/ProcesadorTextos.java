package procesador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        } else if (menu.equals("estilo")) {
            estilo.add(elementoMenu);
        } else if (menu.equals("tamanio")) {
            tamanio.add(elementoMenu);
        }

        elementoMenu.addActionListener(new GestionaEvento(rotulo, tipoLetra, estilos, tam));
    }

    private class GestionaEvento implements ActionListener {
        private GestionaEvento(String elemento, String texto2, int esitlo2, int tamLetra) {
            tipoTexto = texto2;
            estiloLetra = esitlo2;
            tamanioLetra = tamLetra;
            menu = elemento;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            letras = area.getFont();
            if (menu == "Arial" || menu == "Courier New" || menu == "Verdana") {
                estiloLetra = letras.getStyle();
                tamanioLetra = letras.getSize();
            } else if (menu == "Cursiva" || menu == "Negrita") {
                if (letras.getStyle() == 1 || letras.getStyle() == 2) {
                    estiloLetra = 3;
                }
                tipoTexto = letras.getFontName();
                tamanioLetra = letras.getSize();
            } else if (menu == "12" || menu == "14" || menu == "16" || menu == "18" || menu == "20" || menu == "22" || menu == "24") {
                estiloLetra = letras.getStyle();
                tipoTexto = letras.getFontName();
            }
            area.setFont(new Font(tipoTexto, estiloLetra, tamanioLetra));
            //System.out.println("Estilo: " + estiloLetra + " Tipo: " + tipoTexto + " Tama\u00F1o: " + tamanioLetra);
        }

        private String tipoTexto, menu;
        private int estiloLetra, tamanioLetra;
    }

    private JPanel laminaMenu;
    private JMenuBar barra;
    private JMenu fuente, estilo, tamanio;
    private Font letras;
    private JTextPane area;
}