import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*; 

public class UsoJTree {
    public static void main(String[] args) {
        MarcoUsoJTree marco = new MarcoUsoJTree();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoUsoJTree extends JFrame {
    public MarcoUsoJTree() {
        setTitle("Arbol Sencillo");
        setResizable(false);
        setBounds(450, 150, 600, 600);

        raiz = new DefaultMutableTreeNode("Mundo");
        paisEspania = new DefaultMutableTreeNode("Espa\u00F1a");
        alemania = new DefaultMutableTreeNode("Alemania");
        raiz.add(paisEspania);
        raiz.add(alemania);

        madrid = new DefaultMutableTreeNode("Madrid");
        paisEspania.add(madrid);
        mostoles = new DefaultMutableTreeNode("Mostoles");
        madrid.add(mostoles);
        alcobendas = new DefaultMutableTreeNode("Alcobendas");
        madrid.add(alcobendas); 
        cantabria = new DefaultMutableTreeNode("Cantabria");
        paisEspania.add(cantabria);
        santillana = new DefaultMutableTreeNode("Santillana del Mar");
        cantabria.add(santillana);
        baviera = new DefaultMutableTreeNode("Baviera");
        alemania.add(baviera);
        munich = new DefaultMutableTreeNode("Munich");
        baviera.add(munich);
        arbol = new JTree(raiz);

        add(new LaminaUsoJTree(arbol));
        setVisible(true);
    }

    private DefaultMutableTreeNode raiz;
    private DefaultMutableTreeNode paisEspania, madrid, mostoles;
    private DefaultMutableTreeNode alcobendas;
    private DefaultMutableTreeNode cantabria, santillana;
    private DefaultMutableTreeNode alemania, munich, baviera;
    private JTree arbol;
}

@SuppressWarnings("serial")
class LaminaUsoJTree extends JPanel {
    public LaminaUsoJTree(JTree arbol) {
        setLayout(new BorderLayout());
        add(arbol, BorderLayout.NORTH);
    }
}