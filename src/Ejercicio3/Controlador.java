package Ejercicio3;

import Serializacion.Binario.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Controlador {
    public static void main(String[] args) throws IOException {
        Ciudades ciudades = new Ciudades();
        Ciudad ciudad = new Ciudad(1, "Sevilla".toCharArray(), "ESP".toCharArray(), 68000);
        Ciudad ciudad1 = new Ciudad(2, "Malaga".toCharArray(), "ESP".toCharArray(), 90000);
        Ciudad ciudad2 = new Ciudad(3, "Madrid".toCharArray(), "ESP".toCharArray(), 60000);
        ciudades.anadirCiudad(ciudad);
        ciudades.anadirCiudad(ciudad1);
        ciudades.anadirCiudad(ciudad2);
        System.out.println(calcularMediaPopulationSeek("C:\\Users\\javi\\Desktop\\ficherobinario.dat"));
    }
    public static void guardarEnFicheroTexto(String fichero, ArrayList<Ciudad> ciudades) throws IOException {
        File f = new File(fichero);
        FileWriter fw = new FileWriter(f);
        BufferedWriter salida = new BufferedWriter(fw);
        for (Ciudad c : ciudades){
            String nombre = new String(c.getNombre());
            String countryCode = new String(c.getCountryCode());
            salida.write(c.getID() + "," + nombre + "," + countryCode + "," + c.getPoblacion() + ";" + "\n");
        }
        salida.close();
        fw.close();
    }

    public static void guardarEnFicheroAleatorio(String fichero, ArrayList<Ciudad> ciudades) throws IOException {
        File f = new File(fichero);
        RandomAccessFile raf = new RandomAccessFile(f, "rw");

        StringBuffer sb;
        for (Ciudad c : ciudades) {
            String nombre = new String(c.getNombre());
            String countryCode = new String(c.getCountryCode());
            raf.writeInt(c.getID());

            sb = new StringBuffer(nombre);
            sb.setLength(10);
            raf.writeChars(sb.toString());

            sb = new StringBuffer(countryCode);
            sb.setLength(3);
            raf.writeChars(sb.toString());

            raf.writeInt(c.getPoblacion());
        }
        raf.close();
    }

    public static int calcularMediaPopulationSeek(String fichero) throws IOException {
        File f = new File(fichero);
        if (f.exists()){
            RandomAccessFile raf = new RandomAccessFile(f, "r");
            int numeroRegistros = (int) f.length() / 34;
            int total = 0;
            for(int i = 0; i < numeroRegistros; i++){
                int puntero = (34*i) + 30  ;
                raf.seek(puntero);
                total += raf.readInt();
            }
            return total / numeroRegistros;
        }
        return -1;
    }
}
