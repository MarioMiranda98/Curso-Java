import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AplicacionConsulta {
    public static void main (String[] args) {
        JFrame miMarco = new MarcoAplicacion();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoAplicacion extends JFrame {
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
        botonConsulta.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evento) {
                ejecutaConsulta();
            }
        });
        add(botonConsulta, BorderLayout.SOUTH);
        //---------Conexion con BBDD-----------------//
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica?serverTimezone=UTC&useSSL=false","root","root");
            Statement sentencia = conexion.createStatement();
            //---------Carga combo box seleccion---------//
            String consulta = "SELECT DISTINCTROW SECCION FROM PRODUCTOS";
            ResultSet resultado = sentencia.executeQuery(consulta);
            while(resultado.next()) {
                secciones.addItem(resultado.getString(1));
            }
            resultado.close();

            //---------Carga combo box países----------//
            String consulta2 = "SELECT DISTINCTROW PAISDEORIGEN FROM PRODUCTOS";
            ResultSet resultado2 = sentencia.executeQuery(consulta2);
            while(resultado.next()) {
                paises.addItem(resultado2.getString(1));
            }
            resultado2.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void ejecutaConsulta() {
        ResultSet rs = null;
        try {
            resultado.setText("");
            String seccion = secciones.getSelectedItem().toString();
            String pais = paises.getSelectedItem().toString();

            if(!seccion.equals("Todos") && pais.equals("Todos")) {
                enviaConsultaSeccion = conexion.prepareStatement(consultaSeccion);
                enviaConsultaSeccion.setString(1, seccion);
                rs = enviaConsultaSeccion.executeQuery();
            } else if(seccion.equals("Todos") && !pais.equals("Todos")) {
                enviaConsultaPais = conexion.prepareStatement(consultaPais);
                enviaConsultaPais.setString(1, pais);
                rs = enviaConsultaPais.executeQuery();
            } else {
                enviaAmbos = conexion.prepareStatement(consultaAmbos);
                enviaAmbos.setString(1, seccion);
                enviaAmbos.setString(2, pais);
                rs = enviaAmbos.executeQuery();
            }
            
            while(rs.next()) {
                resultado.append(rs.getString(1));
                resultado.append(", ");
                resultado.append(rs.getString(2));
                resultado.append(", ");
                resultado.append(rs.getString(3));
                resultado.append(", ");
                resultado.append(rs.getString(4));
                resultado.append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection conexion;
    private PreparedStatement enviaConsultaSeccion;
    private PreparedStatement enviaConsultaPais;
    private PreparedStatement enviaAmbos;
    private final String consultaSeccion = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE SECCION = ?";
    private final String consultaPais = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE PAISDEORIGEN = ?";
    private final String consultaAmbos = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE SECCION = ? AND PAISDEORIGEN = ?";
    private JComboBox secciones;
    private JComboBox paises;
    private JTextArea resultado;
    private JButton botonConsulta;
}

