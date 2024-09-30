import java.io.*;

public class contrasena {
    public static void main(String[] args) throws IOException {
        ejercicio2Desencriptar("si");
    }

    public static void ejercicio2Encriptar(String password) throws IOException {
        String abecedario = "abcdefghijklmnñopqrstvwxyz";

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));
        String fichero ="";
        String linea = "";

        while ((linea = br.readLine()) != null) {
            fichero += linea;
        }
        br.close();

        // Comprobar si el fichero ya está encriptado
        if (fichero.startsWith("ENCRIPTADO:")) {
            System.out.println("El archivo ya está encriptado.");
            return;
        }

        char[] ficherochar = fichero.toCharArray();
        for (int i = 0; i < ficherochar.length; i++) {
            for (int x = 0; x < abecedario.length(); x++) {
                if (ficherochar[i] == abecedario.charAt(x)) {
                    ficherochar[i] = abecedario.charAt((x + 1) % abecedario.length());
                    break;
                }
            }
        }

        String cadenaNueva = new String(ficherochar);

        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));
        pw.println("ENCRIPTADO:" + password);
        pw.println(cadenaNueva);
        pw.close();
    }

    public static void ejercicio2Desencriptar(String password) throws IOException {
        String abecedario = "abcdefghijklmnñopqrstvwxyz";

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));
        String fichero = "" ;
        String linea;

        while ((linea = br.readLine()) != null) {
            fichero += linea;
        }
        br.close();

        // Verificar si está encriptado
        if (!fichero.startsWith("ENCRIPTADO:")) {
            System.out.println("El archivo no está encriptado.");
            return;
        }

        // Extraer contraseña
        String[] lineas = fichero.split;

        String pass = lineas[0].replace("ENCRIPTADO:", "");

        // Comprobar contraseña
        if (!pass.equals(password)) {
            System.out.println("Contraseña incorrecta.");
            return;
        }

        // Obtener el contenido encriptado y desencriptarlo
        String textoEncriptado = lineas[1];
        char[] ficherochar = textoEncriptado.toCharArray();

        for (int i = 0; i < ficherochar.length; i++) {
            for (int j = 0; j <abecedario.length(); j++){
                if (ficherochar[i] == abecedario.indexOf(j)) {
                    ficherochar[i] = (char) abecedario.indexOf((j - 1) % 27);
                    break;
                }
            }

        }

        String cadenaNueva = new String(ficherochar);

        // Escribir el contenido desencriptado al fichero
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));
        pw.println(cadenaNueva);
        pw.close();
    }
}
