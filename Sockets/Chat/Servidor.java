import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;

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
            String nick;
            String ip;
            String mensaje;
            PaqueteEnvio paqueteRecibido;
            ArrayList <String> listaIP = new ArrayList <String>();
            while(true) {
                Socket miSocket = servidor.accept();//Acepta la conexion
                ObjectInputStream paqueteDatos = new ObjectInputStream(miSocket.getInputStream());
                paqueteRecibido = (PaqueteEnvio) (paqueteDatos.readObject());
                nick = paqueteRecibido.getNick();
                ip = paqueteRecibido.getIP();
                mensaje = paqueteRecibido.getMensaje();
                /*DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
                String mensajeTexto = flujoEntrada.readUTF();
                areaTexto.append("\n" + mensajeTexto);*/
                if(!mensaje.equals("Online")) {
                    areaTexto.append("Nick: " + nick + " Ip: " + ip + " mensaje: " + mensaje + "\n");
                    Socket enviaDestinatario = new Socket(ip, 9090);
                    ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                    paqueteReenvio.writeObject(paqueteRecibido);
                    enviaDestinatario.close();
                    miSocket.close();
                } else {
                    InetAddress localizacion = miSocket.getInetAddress();
                    String ipRemota = localizacion.getHostAddress();
                    System.out.println("Online: " + ipRemota);
                    listaIP.add(ipRemota);
                    paqueteRecibido.setIPs(listaIP);
                    for (String z : listaIP) {
                        System.out.println(z);
                        Socket enviaDestinatario = new Socket(z, 9090);
                        ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                        paqueteReenvio.writeObject(paqueteRecibido);
                        enviaDestinatario.close();
                        miSocket.close();
                    }
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private JTextArea areaTexto;
    private Thread miHilo;
}