import java.io.*;

public class LeyendoEscribiendoBytes {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./Hokuto_no_Ken_(manga_cast).JPG");
            boolean finalArchivo = false;
            long tam = fis.getChannel().size();
            tam += 1;
            int[] bytes = new int[(int) tam];
            int i = 0;

            while(!finalArchivo) {
                bytes[i] = fis.read();

                if(bytes[i] == -1) 
                    finalArchivo = true;

                System.out.println(bytes[i]);
                i++;
            }

            fis.close();

            creaFichero(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void creaFichero(int datosNuevoFichero[]) {
        try {
            FileOutputStream fos = new FileOutputStream("./HokutoNuevo.jpg");

            for(int i = 0; i < datosNuevoFichero.length; i++) {
                fos.write(datosNuevoFichero[i]);
            }

            fos.close();
        }catch(Exception e) { e.printStackTrace(); }
    }
}