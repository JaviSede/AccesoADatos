import java.io.*;


public class Ejercicio2Cesar {
    public static void main(String[] args) throws IOException {
        ejercicio2Encriptar();
    }

    public static void ejercicio2Encriptar() throws IOException {
        String abecedario = "abcdefghijklmnñopqrstvwxyz";

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));

        String fichero = "";
        String linea = "";

        while ((linea = br.readLine()) != null){
            fichero += linea;
        }
        br.close();

        System.out.println(fichero);
        char [] ficherochar = fichero.toCharArray();
        // (pos + desp) % abecedario.length
        for (int i = 0; i < ficherochar.length; i++) {
            if (ficherochar[i] == abecedario.indexOf(i)) {
                ficherochar[i] = (char) abecedario.indexOf((i + 1) % 27);
            }
        }

        String cadenaNueva = "";
        for (int i = 0; i < ficherochar.length; i++){
            cadenaNueva += ficherochar[i];
        }
        System.out.println(cadenaNueva);

        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));

        pw.println(cadenaNueva);
        pw.close();
    }

    public static void ejercicio2Desencriptar() throws IOException {
        String abecedario = "abcdefghijklmnñopqrstvwxyz";
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));

        String fichero = "";
        String linea;

        while ((linea  = br.readLine()) != null){
            fichero += linea;
        }

        br.close();

        System.out.println(fichero);
        char [] ficherochar = fichero.toCharArray();
        // (pos + desp) % abecedario.length
        for (int i = 0; i < ficherochar.length; i++) {
            if (ficherochar[i] == abecedario.indexOf(i)) {
                ficherochar[i] = (char) abecedario.indexOf((i - 1) % 27);
            }
        }

        String cadenaNueva = "";
        for (int i = 0; i < ficherochar.length; i++){
            cadenaNueva += ficherochar[i];
        }
        System.out.println(cadenaNueva);

        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));

        pw.println(cadenaNueva);
        pw.close();
    }
}