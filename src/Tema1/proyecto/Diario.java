package Tema1.proyecto;

import java.io.*;

public class Diario {
    File fichero;

    public Diario(String fichero) {
        this.fichero = new File(fichero);
    }

    public File getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = new File(fichero);
    }

    public void addEntrada(String entrada, String fecha) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;
        String contenidoFichero = "";
        while ((linea = br.readLine()) != null) {
            contenidoFichero += linea;
        }
        br.close();
        PrintWriter pw = new PrintWriter(new FileWriter(fichero));
        pw.println(contenidoFichero);
        pw.println(fecha + " " + entrada);
        pw.close();
    }

    public void buscarEntrada(String fecha) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;
        while ((linea = br.readLine()) != null){
            if (linea.contains(fecha)){
                System.out.println(linea);
            }
        }
    }

    public void modificarEntrada(String fecha, String entradaNueva) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;
        String contenidoFichero = "";
        while ((linea = br.readLine()) != null){
            if (linea.contains(fecha)){
                linea = fecha + " " + entradaNueva;
            }
            contenidoFichero += linea + "\n";
        }
        br.close();
        PrintWriter pw = new PrintWriter(new FileWriter(fichero));
        pw.println(contenidoFichero);
        pw.close();
    }

    public void mostrarDiario() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;
        while ((linea = br.readLine()) != null){
            System.out.println(linea);
        }
    }

    public void borrarEntrada(String fecha) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;
        String contenidoFichero = "";
        while ((linea = br.readLine()) != null){
            if (linea.contains(fecha)){
                linea = "";
            }
            contenidoFichero += linea + "\n";
        }
        br.close();
        PrintWriter pw = new PrintWriter(new FileWriter(fichero));
        pw.println(contenidoFichero);
        pw.close();
    }
}
