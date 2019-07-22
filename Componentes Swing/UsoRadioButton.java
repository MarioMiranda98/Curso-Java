import javax.swing.*;

public class UsoRadioButton {
    public static void main(String[] args) {
        MarcoUsoRadioButton marco = new MarcoUsoRadioButton();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

@SuppressWarnings("serial")
class MarcoUsoRadioButton extends JFrame {
    public MarcoUsoRadioButton() {
        setTitle("Radio Button");
        setResizable(false);
        setBounds(425, 150, 500, 300);
        add(new LaminaUsoRadioButton());
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class LaminaUsoRadioButton extends JPanel {
    public LaminaUsoRadioButton() {
        grupo = new ButtonGroup();
        grupo2 = new ButtonGroup();
        boton1 = new JRadioButton("Azul", false);
        boton2 = new JRadioButton("Rojo", true);
        boton3 = new JRadioButton("Verde", false);
        masculino = new JRadioButton("Masculino", true);
        femenino = new JRadioButton("Femenino", false);

        grupo.add(boton1);
        grupo.add(boton2);
        grupo.add(boton3);
        grupo2.add(masculino);
        grupo2.add(femenino);
        add(boton1);
        add(boton2);
        add(boton3);
        add(masculino);
        add(femenino);
    }

    private ButtonGroup grupo, grupo2;
    private JRadioButton boton1;
    private JRadioButton boton2;
    private JRadioButton boton3;
    private JRadioButton masculino, femenino;
}