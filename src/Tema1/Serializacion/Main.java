package Tema1.Serializacion;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    //   ControladorFichero.guardar("./nuevo.dat", new Persona("jojo", 17));
        ControladorFichero.guardar("./nuevo.dat", new Persona("Joseph", 16));

    }

//    public static void guardar() throws IOException {
//        FileOutputStream fileout = new FileOutputStream(new File("./guardado.dat"));
//        ObjectOutputStream datos = new ObjectOutputStream(fileout);
//
//        ArrayList<Persona> arrayList = new ArrayList<Persona>();
//        arrayList.add(new Persona("Juan", 12));
//        arrayList.add(new Persona("Pepe", 30));
//        arrayList.add(new Persona("Ana", 16));
//        arrayList.add(new Persona("Luna", 18));
//
//        for (Persona p : arrayList){
//            datos.writeObject(p);
//        }
//
//        datos.close();
//        fileout.close();
//    }
//
//    public static void cargar() throws IOException, ClassNotFoundException {
//        FileInputStream fileinput = new FileInputStream(new File("./guardado.dat"));
//        ObjectInputStream datos = new ObjectInputStream(fileinput);
//
//        Persona p;
//
//        try {
//            while ((p = (Persona) datos.readObject()) != null) {
//                System.out.println(p.toString());
//            }
//        } catch (EOFException e){}
//
//        datos.close();
//        fileinput.close();
//    }
}
