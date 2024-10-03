import java.io.*;

public class contrasena {
    public static void main(String[] args) throws IOException {
        ejercicio2Desencriptar("si");
    }

    public static void ejercicio2Encriptar(String password) throws IOException {
        String abecedario = "abcdefghijklmnñopqrstvwxyz";

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\javi\\Desktop\\ficheroescribir.txt"));
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

        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\javi\\Desktop\\ficheroescribir.txt"));
        pw.println("ENCRIPTADO:" + password);
        pw.println(cadenaNueva);
        pw.close();
    }

    public static void ejercicio2Desencriptar(String password) throws IOException {
        String abecedario = "abcdefghijklmnñopqrstvwxyz";

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\javi\\Desktop\\ficheroescribir.txt"));
        StringBuilder fichero = new StringBuilder();
        String linea;

        while ((linea = br.readLine()) != null) {
            fichero.append(linea).append("\n");
        }
        br.close();

        String contenidoFichero = fichero.toString().trim();

        if (!contenidoFichero.startsWith("ENCRIPTADO:")) {
            System.out.println("El archivo no está encriptado.");
            return;
        }

        contenidoFichero = contenidoFichero.replace("ENCRIPTADO:", "").trim();

        String[] lineas = contenidoFichero.split("\\r?\\n");

        // Extraer el texto encriptado de la segunda línea y la contraseña
        String contra = lineas[0].trim();
        String textoEncriptado = lineas[1].trim();

        char[] ficherochar = textoEncriptado.toCharArray();
        if (contra.equals(password)){
            for (int i = 0; i < ficherochar.length; i++) {
                for (int x = 0; x < abecedario.length(); x++) {
                    if (ficherochar[i] == abecedario.charAt(x)) {
                        ficherochar[i] = abecedario.charAt((x - 1) % abecedario.length());
                        break;
                    }
                }
            }
        }

        String contenido = new String(ficherochar).trim();
        System.out.println("Contenido desencriptado: '" + contenido + "'");

    }
}
