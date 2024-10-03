package Serializacion.Binario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ControladorBinario {

    public static void escribir(String fichero, Persona per) throws IOException {
        ArrayList<Persona> p = new ArrayList<>();
        File f = new File(fichero);
        char[] nombre = new char[20];
        int edad = 0;
        char[] direccion = new char[10];

        int numeroRegistros = (int) f.length() / 64;
        RandomAccessFile raf = new RandomAccessFile(f, "r");

        for (int i = 0; i < numeroRegistros; i++) {
            String n;
            for (int j = 0; j < 20; j++) {
                nombre[j] = raf.readChar();
            }
            n = new String(nombre);

            // Leer edad
            edad = raf.readInt();

            for (int j = 0; j < 10; j++) {
                direccion[j] = raf.readChar();
            }
            String d = new String(direccion);

            p.add(new Persona(n, edad, d));

            p.add(new Persona(per));
        }

        raf = new RandomAccessFile(f, "rw");

        StringBuffer sb;
        for (Persona persona : p) {
            sb = new StringBuffer(persona.getNombre());
            sb.setLength(20);
            raf.writeChars(sb.toString());

            raf.writeInt(persona.getEdad());

            sb = new StringBuffer(persona.getDireccion());
            sb.setLength(10);
            raf.writeChars(sb.toString());
        }
        raf.close();
    }

    public static void lectura(String fichero) throws IOException {
        char[] nombre = new char[20];
        int edad = 0;
        char[] direccion = new char[10];
        ArrayList<Persona> p = new ArrayList<>();

        File f = new File(fichero);
        RandomAccessFile raf = new RandomAccessFile(f, "r");

        int numeroRegistros = (int) f.length() / 64;

        for (int i = 0; i < numeroRegistros; i++) {
            String n;
            for (int j = 0; j < 20; j++) {
                nombre[j] = raf.readChar();
            }
            n = new String(nombre);

            // Leer edad
            edad = raf.readInt();

            for (int j = 0; j < 10; j++) {
                direccion[j] = raf.readChar();
            }
            String d = new String(direccion);

            p.add(new Persona(n, edad, d));

            System.out.println(p.get(p.size() - 1));
        }
    }

    public static void lecturaSeek(String fichero, int desp) throws IOException {
        File f = new File(fichero);
        RandomAccessFile raf = new RandomAccessFile(f, "r");

        int numeroRegistros = (int) f.length() / 64;

        for (int i = 0; i < numeroRegistros; i++){

            int puntero = (64*i) + desp;
            raf.seek(puntero);

            int edad = raf.readInt();

            System.out.println("en la posicion " + puntero + " se ha leido la edad " + edad);
        }
    }


}

