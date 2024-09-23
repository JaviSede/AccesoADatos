import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        ejercicio2Encriptar("Holaz");
    }

    public static void ejercicio2Encriptar(String input) throws IOException {
        // Modificar String
        char [] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++){
            chars[i] += 1 ;
        }
        String cadenaNueva = "";

        for (int i = 0; i < chars.length; i++){
            cadenaNueva += chars[i];
        }

        // Agregar al fichero.
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));

        String fichero = "";
        String linea = "";

        while ((linea = br.readLine()) != null){
            fichero += linea;
        }

        br.close();

        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));

        pw.println(fichero);
        pw.println(cadenaNueva);
        pw.close();
    }

    public static void ejercicio2Desencriptar() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));

        String fichero = "";
        String linea;

        while ((linea  = br.readLine()) != null){
            fichero += linea;
        }

        br.close();

        char [] chars = fichero.toCharArray();
        for(int i = 0; i < chars.length; i++){
            chars[i] -= 1 ;
        }
        String cadenaNueva = "";
        for (int i = 0; i < chars.length; i++){
            cadenaNueva += chars[i];
        }
        System.out.println(cadenaNueva);
    }
}
