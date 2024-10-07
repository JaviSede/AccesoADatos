package Tema1.proyecto;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

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

    public void menu() throws IOException {
        System.out.print("Bienvenido al programa, dispone de las siguiente funcionalidades: Agregar entrada (1), Buscar entrada (2), Modificar entrada (3)," +
                " Mostrar diario (4), Borrar entrada (5)");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        sc.close();

        switch (opcion) {
            case 1:
                System.out.print("Quiere especificar una fecha (1) o usar la fecha actual? (2)");
                Scanner sc1 = new Scanner(System.in);
                int op1 = sc1.nextInt();
                if (op1 == 1){
                    System.out.print("Introduzca un dia formato (dd): ");
                    String dia = String.valueOf(sc1.nextInt());

                    System.out.print("Introduzca un mes: formato (mm): ");
                    String mes = String.valueOf(sc1.nextInt());

                    System.out.print("Introduzca un año: formato (yyyy): ");
                    String anyo = String.valueOf(sc1.nextInt());

                    String fecha = dia + "/" + mes + "/" + anyo;
                    System.out.print("Introduzca lo que ha hecho hoy: ");
                    String entrada = sc1.nextLine();
                    sc1.close();
                    addEntrada(entrada, fecha);
                } else if (op1 == 2) {
                    LocalDateTime hoy = LocalDateTime.now();
                    String fecha = hoy.getDayOfMonth() + "/" + hoy.getMonthValue() + "/" + hoy.getYear();
                    System.out.print("Introduzca lo que ha hecho hoy: ");
                    String entrada = sc1.nextLine();
                    sc1.close();
                    addEntrada(entrada, fecha);
                }
                break;
            case 2:
                System.out.print("Introduzca la fecha a buscar: ");

        }
    }
}
