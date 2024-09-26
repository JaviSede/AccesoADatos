package Serializacion;

import java.io.*;
import java.util.ArrayList;

public class ControladorFichero {
    private static FileOutputStream fileout;
    private static ObjectOutputStream datosSalida;
    private static FileInputStream filein;
    private static ObjectInputStream datosEntrada;

    public static void guardar(String fichero, Persona p) {
        try {
            //Leer datos previos al fichero
            ArrayList<Persona> datosLeidos = new ArrayList<Persona>(cargar(fichero));

            //Añadir a esos datos el nuevo
            datosLeidos.add(p);

            fileout = new FileOutputStream(new File(fichero));
            datosSalida = new ObjectOutputStream(fileout);

            //escribir todos los datos en el fichero
            for(int i = 0; i < datosLeidos.size(); i++)
                datosSalida.writeObject(datosLeidos.get(i));

            datosSalida.close();
            fileout.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Persona> cargar(String fichero) throws IOException, ClassNotFoundException {
        File f = new File(fichero);
        if (!f.exists()){return new ArrayList<Persona>();}

        filein = new FileInputStream(f);
        datosEntrada = new ObjectInputStream(filein);
        Persona p;
        ArrayList<Persona> personas = new ArrayList<>();
        try {
            while ((p = (Persona)datosEntrada.readObject()) != null){
                personas.add(p);
            }
        } catch (Exception e){}
        return personas;
    }
}
