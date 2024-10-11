package Tema1.proyecto;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Diario {
    File fichero;

    public Diario() {
        this.setFichero("/home/tarde/IdeaProjects/AccesoADatos/src/Tema1/diario.txt");
    }

    public Diario(String fichero) {
        this.fichero = new File(fichero);
    }

    public File getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = new File(fichero);
    }

    private void addEntrada(String entrada, String fecha) throws IOException {
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

    private void buscarEntrada(String fecha) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;
        while ((linea = br.readLine()) != null){
            if (linea.contains(fecha)){
                System.out.println(linea);
            }
        }
    }

    private void modificarEntrada(String fecha, String entradaNueva) throws IOException {
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

    private void mostrarDiario() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;
        while ((linea = br.readLine()) != null){
            System.out.println(linea);
        }
    }

    private void borrarEntrada(String fecha) throws IOException {
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

    public void exportarXML(String xml) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));

        String linea;


    }

    public void menu() throws IOException {
        String dia;
        String mes;
        String anyo;
        String fecha;
        System.out.print("Bienvenido al programa, dispone de las siguiente funcionalidades: Agregar entrada (1), Buscar entrada (2), Modificar entrada (3)," +
                " Mostrar diario (4), Borrar entrada (5): ");
        Scanner sc = new Scanner(System.in);
        Scanner scanerTexto = new Scanner(System.in);
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Quiere especificar una fecha (1) o usar la fecha actual? (2): ");
                int op1 = sc.nextInt();
                if (op1 == 1){
                    System.out.print("Introduzca un dia formato (dd): ");
                    dia = String.valueOf(sc.nextInt());
                    System.out.print("Introduzca un mes: formato (mm): ");
                    mes = String.valueOf(sc.nextInt());
                    System.out.print("Introduzca un año: formato (yyyy): ");
                    anyo = String.valueOf(sc.nextInt());
                    fecha = dia + "/" + mes + "/" + anyo;
                    System.out.print("Introduzca lo que ha hecho hoy: ");
                    String entrada = scanerTexto.nextLine();
                    sc.close();
                    scanerTexto.close();
                    addEntrada(entrada, fecha);
                } else if (op1 == 2) {
                    LocalDateTime hoy = LocalDateTime.now();
                    fecha = hoy.getDayOfMonth() + "/" + hoy.getMonthValue() + "/" + hoy.getYear();
                    System.out.print("Introduzca lo que ha hecho hoy: ");
                    String entrada = scanerTexto.nextLine();
                    sc.close();
                    scanerTexto.close();
                    addEntrada(entrada, fecha);
                }
                break;
            case 2:
                System.out.print("Introduzca un dia formato (dd): ");
                dia = String.valueOf(sc.nextInt());
                System.out.print("Introduzca un mes: formato (mm): ");
                mes = String.valueOf(sc.nextInt());
                System.out.print("Introduzca un año: formato (yyyy): ");
                anyo = String.valueOf(sc.nextInt());
                sc.close();
                scanerTexto.close();
                fecha = dia + "/" + mes + "/" + anyo;
                buscarEntrada(fecha);
                break;
            case 3:
                System.out.print("Introduzca un dia formato (dd): ");
                dia = String.valueOf(sc.nextInt());
                System.out.print("Introduzca un mes: formato (mm): ");
                mes = String.valueOf(sc.nextInt());
                System.out.print("Introduzca un año: formato (yyyy): ");
                anyo = String.valueOf(sc.nextInt());
                fecha = dia + "/" + mes + "/" + anyo;
                System.out.print("Introduce la nueva entrada para la fecha: ");
                sc.close();
                String entrada = scanerTexto.nextLine();
                scanerTexto.close();
                modificarEntrada(fecha, entrada);
                break;
            case 4:
                mostrarDiario();
                break;
            case 5:
                System.out.print("Introduzca un dia formato (dd): ");
                dia = String.valueOf(sc.nextInt());
                System.out.print("Introduzca un mes: formato (mm): ");
                mes = String.valueOf(sc.nextInt());
                System.out.print("Introduzca un año: formato (yyyy): ");
                anyo = String.valueOf(sc.nextInt());
                fecha = dia + "/" + mes + "/" + anyo;
                sc.close();
                scanerTexto.close();
                borrarEntrada(fecha);
                break;
        }
    }
}
