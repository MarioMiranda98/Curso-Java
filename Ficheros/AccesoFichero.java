import java.io.*;

public class AccesoFichero {
    public static void main(String[] args) {
        new LeerFichero().lee();
    }
}

class LeerFichero {
    public void lee() {
        try {
            FileReader entrada = new FileReader("./ejemplo.txt");
            /*int c = entrada.read(); LEe caracter a caracter

            while(c != -1) {
                c = entrada.read();
                System.out.print((char) c);
            }

            System.out.printf("\n");
            entrada.close();*/

            //Usando buffer
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";

            while(true) {
                linea = miBuffer.readLine();

                if(linea == null)
                    break;

                System.out.println(linea);
            }

            miBuffer.close();
        } catch(Exception e) { e.printStackTrace(); }
    }
}