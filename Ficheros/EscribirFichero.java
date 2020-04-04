import java.io.*;

public class EscribirFichero {
    public static void main(String[] args) {
        new Escribiendo().escribir();
    }
}

class Escribiendo {
    public void escribir() {
        String frase = "Esto es una prueba de escritura";
        try {
            FileWriter escritura = new FileWriter("./TextoNuevo.txt");
            
            for(int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));
            }

            escritura.close();
        }catch(Exception e) { e.printStackTrace(); }
    }   
}