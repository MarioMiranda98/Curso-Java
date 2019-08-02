import javax.swing.*;

public class LaminaBotones extends JPanel {
    private static final long serialVersionUID = 2L;
    public LaminaBotones(String titulo, String[] opciones) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
        grupo = new ButtonGroup();

        for (int i = 0; i < opciones.length; i += 1) {
            JRadioButton bot = new JRadioButton(opciones[i]);
            grupo.add(bot);
            add(bot);
            bot.setSelected(i == 0);
        }
    }

    private ButtonGroup grupo;
}