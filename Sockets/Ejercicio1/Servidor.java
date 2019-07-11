import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class Servidor {
	public static void main(String[] args){
        MarcoServidor miMarco = new MarcoServidor();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoServidor extends JFrame implements Runnable {
    public MarcoServidor() {
        setBounds(800, 300, 280, 350);
        JPanel miLamina = new JPanel();
        miLamina.setLayout(new BorderLayout());
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        miLamina.add(areaTexto, BorderLayout.CENTER);
        add(miLamina);
        setVisible(true);
        miHilo = new Thread(this);
        miHilo.start();
    }

    public void run() {
        //System.out.println("A la escucha");
        try {
            ServerSocket servidor = new ServerSocket(4500);//Escucha lo que venga del puerto
            while(true) {
                Socket miSocket = servidor.accept();//Acepta la conexion
                DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
                String mensajeTexto = flujoEntrada.readUTF();
                areaTexto.append("\n" + mensajeTexto);
                miSocket.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private JTextArea areaTexto;
    private Thread miHilo;
}