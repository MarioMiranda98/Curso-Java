import javax.swing.*;
import java.net.*;
import java.io.*;

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
		setVisible(true);
	}
}

class LaminaMarcoCliente extends JPanel {
	public LaminaMarcoCliente() {
		texto = new JLabel("Cliente");
		add(texto);
		campo1 = new JTextField(20);
		add(campo1);
		miBoton = new JButton("Enviar");
		add(miBoton);
		miBoton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				//System.out.println("Listo Al Evento Enviar!!");
				try {
					Socket miSocket = new Socket("192.168.100.12", 4500);
					DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());
					flujoSalida.writeUTF(campo1.getText());
					flujoSalida.close();
				} catch(UnknownHostException e1) {
					e1.printStackTrace();
				} catch(IOException e2) {
					e2.printStackTrace();
				}
			}
		});
	}

	private JTextField campo1;
	private JButton miBoton;
	private JLabel texto;
}