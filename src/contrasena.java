public class Ejercicio2Ampliacion {
    public static void main(String[] args) throws IOException {
      
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

        char[] ficherochar = fichero.toString().toCharArray();
        for (int i = 0; i < ficherochar.length; i++) {
            int pos = abecedario.indexOf(ficherochar[i]);
            if (ficherochar[i] == abecedario.indexOf(i)) {
                ficherochar[i] = (char) abecedario.indexOf((i + 1) % 27);
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
        String[] lineas = fichero.split("\n");
        String pass = lineas[0].replace("ENCRIPTADO:", "").trim();

        // Comprobar contraseña
        if (!pass.equals(password)) {
            System.out.println("Contraseña incorrecta.");
            return;
        }

        // Obtener el contenido encriptado y desencriptarlo
        String textoEncriptado = lineas[1];
        char[] ficherochar = textoEncriptado.toCharArray();

        for (int i = 0; i < ficherochar.length; i++) {
            if (ficherochar[i] == abecedario.indexOf(i)) {
                ficherochar[i] = (char) abecedario.indexOf((i - 1) % 27);
            }
        }

        String cadenaNueva = new String(ficherochar);

        // Escribir el contenido desencriptado al fichero
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));
        pw.println(cadenaNueva);
        pw.close();
    }
}
