package Tema1.proyecto;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Diario diario = new Diario();
        //diario.exportarHTML("/home/tarde/IdeaProjects/AccesoADatos/src/Tema1/diario.html");
        //Cifrado.encriptar("dhksfehdfjsd4321", new File("/home/tarde/IdeaProjects/AccesoADatos/src/Tema1/diario.txt"), new File("/home/tarde/IdeaProjects/AccesoADatos/src/Tema1/cifrado.txt"));
        //Cifrado.desencriptar("dhksfehdfjsd4321", new File("/home/tarde/IdeaProjects/AccesoADatos/src/Tema1/cifrado.txt"), new File("/home/tarde/IdeaProjects/AccesoADatos/src/Tema1/descifrado.txt"));
        diario.menu();
    }
}
