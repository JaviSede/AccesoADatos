package Ejercicio3;

import java.io.*;

public class Controlador {
    public static void anadirCiudad(Ciudad ciudad){
        Ciudades.ciudades.add(ciudad);
    }

    public static void guardarEnFicheroTexto(String fichero) throws IOException {
        File f = new File(fichero);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream salida = new ObjectOutputStream(fos);
        for (Ciudad c : Ciudades.ciudades){

        }
        salida.close();
        fos.close();
    }
}
