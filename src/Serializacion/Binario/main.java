package Serializacion.Binario;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.RandomAccess;


public class main {
    public static void main(String[] args) throws IOException {
//        ControladorBinario.escribir("./nuevo.dat", new Persona("p", 10, "h"));
        ControladorBinario.lectura("./nuevo.dat");
    }


}

