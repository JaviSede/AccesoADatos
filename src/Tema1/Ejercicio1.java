package Tema1;

import java.io.*;

/**
 *
 * @author Francisco
 */

/*
Enunciados

1º Ejemplo de mostrar la lista de ficheros del directorio actual. Para ello usaremos el método list() que devuelve un array de strings con los nombres de los ficheros y directorios contenidos en el objeto asociado File.


2º Crear una función, el cual se le pase por parámetros la ruta de un directorio y muestre por pantalla los directorios que contiene el directorio indicando si son directorios o ficheros

*/


public class Ejercicio1 {

    public static void main(String[] args) throws IOException {
        
        /*
        // Código para ver la información de un archivo.
        File archivo = new File("."); // Se crea un objeto de tipo File en el que le pasamos la ruta del archivo en este caso el punto se refiere al mismo directorio en el que se encuentra el programa.
        
        if(archivo.exists()){ // Se comrpueba si el archivo existe el archivo creado ya que la ruta podría estar mal.
          System.out.println("Nombre del fichero: "+archivo.getName()); // Imprime en consola el nombre del archivo.
          System.out.println("ruta del fichero actual: "+archivo.getPath()); // Imprime en consola la ruta relativa del archivo.
          System.out.println("ruta absoluta del fichero: "+archivo.getAbsolutePath()); // Imprime en consola la ruta absoluta del archivo.
          System.out.println("Se puede leer: "+archivo.canRead()); // Imprime si el archivo se puede leer, devuelve true o false.
          System.out.println("Se puede escribir: "+archivo.canWrite()); // Imprime si en el archivo se puede escribir, devuelve true o false.
          System.out.println("Tamaño : "+archivo.length()); // Imprime el tamaño del archivo.
          System.out.println("Es fichero: "+archivo.isFile()); // Imprime si el archivo es un fichero, devuelve true o false.
          System.out.println("Es directorio: "+archivo.isDirectory()); // Imprime si el archivo es un directorio, devuelve true o false.
        }
        
        String archivos[] = archivo.list();
        
        for (String dato:archivos) {
            
            System.out.println(dato);
        }
        */
        
        // mostrarDirectorios(".");
        
        // ejercicio3();
        
        // ejercicio4();

        // crearFicheroDirectorio(); // Se llama a la función estática
        
        // borrarFicheroDirectorio(); // Se llama a la función estática

        ejercicio7();
    }

    public static void borrarFicheroDirectorio () {
        
        File directorio = new File(".\\Unidad_1\\directorioNuevo"); // Creo el objeto del directorio que se quiere borrar
        File fichero = new File(".\\Unidad_1\\directorioNuevo\\fichero1.txt"); // Creo el objeto del fichero que se quiere borrar
        
        fichero.delete(); // Borro el fichero primero para poder borrar el directorio
        directorio.delete(); // Borro el directorio
    }

    public static void crearFicheroDirectorio () {
        
        File directorioActual = new File("./Unidad_1/"); // Se crea un objeto de tipo File y le añadimos la ruta donde vamos a crear los archivos.
                
        File directorio = new File(directorioActual, "directorioNuevo"); // Creo un objeto para crear un directorio en la ruta del objeto anterior
        File fichero = new File(directorioActual+"\\directorioNuevo\\fichero1.txt"); // Creo un objeto para crear un fichero dentro de la ruta del directorio que se va a crear.
        
        try{ // Se crea un try catch por si falla al ejecutarse por errores de ruta o demás.
            
            directorio.mkdirs(); // Creo primero el directorio para poder guardar el fichero.
            fichero.createNewFile(); // Creo el fichero dentro del directorio ya creado.
            
        
        }catch(IOException e){ // Si hubiese un fallo en la ejecución, se ejecutaría lo siguiente.
            
            e.printStackTrace();
        }

    }

    
    public static String mostrarDirectorios(String ruta) {
        
        File directorioActual = new File(ruta);

        if(directorioActual.exists()){
   
            for (String fichero : directorioActual.list()) {

                File directorio = new File(fichero);

                if (directorio.isFile()) {
                    
                    System.out.println(fichero+" es un fichero");

                } else if (directorio.isDirectory()) {

                    System.out.println(fichero+" es un directorio");

                } else {

                    System.out.println(fichero+" no es ni un fichero ni un directorio");

                }

            }
        }
        
        return null;
    }
    
    public static void ejercicio3 () {
        // Crear un directorio en e directorio actual y a continuación crear dos ficheros vacíos dentro.
        // Posteriormente a uno de ellos se le renombra.
        // El méto createNewFile() puede lanzar una excepción por ello ha de ir entre try catch
        
        File directorioActual = new File(".Unidad");
                
        File fichero1 = new File(directorioActual,"fichero1.txt");
        File fichero2 = new File(directorioActual.getAbsolutePath()+"\\fichero2.txt");
        
        try{
            
            fichero1.createNewFile();
            fichero2.createNewFile();
        
        }catch(IOException e){
            
            e.printStackTrace();
        }
        
        fichero1.renameTo(new File(directorioActual, "renombrado.txt"));
        
        fichero1.delete();
    }
    
    public static void ejercicio4() throws FileNotFoundException, IOException {
        // 4º Lectura y escritura en ficheros binarios
        
        File imagen = new File ("./foto.png");
        
        // Lectura
        FileInputStream fi = new FileInputStream(imagen);
        BufferedInputStream bufferInput = new BufferedInputStream(fi);
        
        // Escritura
        File imagen2 = new File ("./foto2.png");
        FileOutputStream fic = new FileOutputStream(imagen2);
        BufferedOutputStream bufferOutput = new BufferedOutputStream(fic);
        
        byte array[] = new byte[1000];
        
        int leido = bufferInput.read(array);
        
        while(leido > 0) {
            //System.out.println(leido);
            bufferOutput.write(array, 0, leido);
            leido = bufferInput.read(array);
        }
        
        bufferInput.close();
        bufferOutput.close();
    }

    //Lectura de fichero texto
    public static void ejercicio5() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Javi\\Desktop\\Ejercicios.txt"));

        String linea = "";

        linea = br.readLine();
        while (linea != null){
            System.out.println(linea);
        }
        br.close();
    }

    //Escritura de fichero de texto
    public static void ejercicio6() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));
        pw.println("Linea de prueba");
        pw.close();
    }

    //Añadir datos a un fichero de texto
    public static void ejercicio7() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));

        String fichero = "";
        String linea = "";

        while ((linea = br.readLine()) != null){
            fichero += linea;
        }

        br.close();

        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Javi\\Desktop\\ficheroescribir.txt"));
        pw.println(fichero);
        pw.println("Nueva Linea");
        pw.close();
    }
}


