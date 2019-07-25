package vista;

import javax.swing.*;
import java.awt.*;
import controlador.ControladorCargaSecciones;
import controlador.ControladorBotonEjecuta;
import controlador.ControladorCargaPaises;

public class MarcoAplicacion extends JFrame {
    public MarcoAplicacion() {
        setTitle("Consultas BBDD");
        setBounds(500, 300, 400, 400);
        setLayout(new BorderLayout());
        JPanel menu = new JPanel();
        menu.setLayout(new FlowLayout());
        secciones = new JComboBox();
        secciones.setEditable(false);
        secciones.addItem("Todos");
        paises = new JComboBox();
        paises.setEditable(false);
        paises.addItem("Todos");
        resultado = new JTextArea(4, 50);
        resultado.setEditable(false);
        add(resultado);
        menu.add(secciones);
        menu.add(paises);
        add(menu, BorderLayout.NORTH);
        add(resultado, BorderLayout.CENTER);
        botonConsulta = new JButton("Consulta");
        botonConsulta.addActionListener(new ControladorBotonEjecuta(this));
        add(botonConsulta, BorderLayout.SOUTH);
        addWindowListener(new ControladorCargaSecciones(this));
        addWindowListener(new ControladorCargaPaises(this));
    }
    
    public JComboBox secciones;
    public JComboBox paises;
    public JTextArea resultado;
    public JButton botonConsulta;
}