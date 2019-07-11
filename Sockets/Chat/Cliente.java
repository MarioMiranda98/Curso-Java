import javax.swing.*;
import java.net.*;
import java.io.*;
//100116571195
//457211693279
public class Cliente { 
	public static void main(String[] args){
		MarcoCliente miMarco = new MarcoCliente();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoCliente extends JFrame {
	public MarcoCliente() {
		setBounds(600, 300, 280, 350);
		LaminaMarcoCliente miLamina = new LaminaMarcoCliente();
		add(miLamina);
        addWindowListener(new EnvioOnline());
		setVisible(true);
	}
}

class LaminaMarcoCliente extends JPanel implements Runnable {
	public LaminaMarcoCliente() {
        nickUsuario = JOptionPane.showInputDialog("Nick:");
        JNick = new JLabel("Nick: ");
        add(JNick);
        nick = new JLabel();
        nick.setText(nickUsuario);
        add(nick);
		texto = new JLabel("Online: ");
		add(texto);
        ip = new JComboBox();
        //ip.addItem("Usuario 1");
        //ip.addItem("Usuario 2");
        //ip.addItem("Usuario 3");
        add(ip);
        campoChat = new JTextArea(12, 20);
        add(campoChat);
        campoChat.setEditable(false);
		campo1 = new JTextField(20);
		add(campo1);
		miBoton = new JButton("Enviar");
		add(miBoton);
        miEvento = new EnviaTexto();
		miBoton.addActionListener(miEvento);
        hilo = new Thread(this);
        hilo.start();
	}

    private class EnviaTexto implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent e) {
				//System.out.println("Listo Al Evento Enviar!!");
                //datos.imprimeDatos();
                campoChat.append("\n" + campo1.getText() + "\n");
				try {
					Socket miSocket = new Socket("192.168.100.12", 4500);
                    PaqueteEnvio datos = new PaqueteEnvio(nick.getText(), ip.getSelectedItem().toString(), campo1.getText());
                    ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
                    paqueteDatos.writeObject(datos);
                    miSocket.close();
					/*DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());
					flujoSalida.writeUTF(campo1.getText());
					flujoSalida.close();*/
				} catch(UnknownHostException e1) {
					e1.printStackTrace();
				} catch(IOException e2) {
					e2.printStackTrace();
				}
			}
    }

    public void run() {
        try {
            ServerSocket servidorCliente = new ServerSocket(9090);
            Socket cliente;
            PaqueteEnvio paqueteRecibido;
            String nick;
            String ip;
            String mensaje;
            while(true) {
                cliente = servidorCliente.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
                paqueteRecibido = (PaqueteEnvio) (flujoEntrada.readObject());
                if(paqueteRecibido.getMensaje().equals("Online")) {
                    campoChat.append("\n" + paqueteRecibido.getNick() + " : " ++ paqueteRecibido.getMensaje());
                } else {
                    //campoChat.append("\n" + paqueteRecibido.getIPs());
                    ArrayList <String> IPMenu = new ArrayList <String>();
                    IPMenu = paqueteRecibido.getIPs();
                    ip.removeAllItems();
                    for (String z : IPMenu) 
                        ip.addItem(z);
                }
                nick = paqueteRecibido.getNick();
                ip = paqueteRecibido.getIP();
                mensaje = paqueteRecibido.getMensaje();
                campoChat.append("Nick: " + nick + " IP: " + ip + " Mensaje: " + mensaje + "\n");
                campoChat.append("\n" + paqueteRecibido.getIPs());
                cliente.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

	private JTextField campo1;
	private JButton miBoton;
	private JLabel texto;
    private JTextArea campoChat;
    private EnviaTexto miEvento;
    private JLabel nick;
    private JLabel JNick;
    private JComboBox ip;
    private Thread hilo;
    private String nickUsuario;
}

class PaqueteEnvio implements Serializable { 
    public PaqueteEnvio(String nick, String ip, String mensaje) {
        this.nick = nick;
        this.ip = ip;
        this.mensaje = mensaje;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public void setIP(String ip) {
        this.ip = ip;
    }

    public String getIP() {
        return ip;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public ArrayList <String> getIPs(){
        return IPs;
    }

    public void setIPs(ArrayList <String> IPs) {
        this.IPs = IPs;
    }

    public void imprimeDatos(){
        System.out.println("Nick: " + nick + " IP: " + ip + " Mensaje: " +mensaje);
    }

    private String nick;
    private String ip;
    private String mensaje;
    private ArrayList <String> IPs;
}

class EnvioOnline extends WindowAdapter {
    public void windowOpened(WindowEvent e) {
        try {
            Socket miSocket = new Socket("192.168.100.12", 4500);
            PaqueteEnvio datos = new PaqueteEnvio("", "", "Online");
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
            paqueteDatos.writeObject(datos);
            miSocket.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}