package Tema1.proyecto;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Diario diario = new Diario();
        diario.exportarHTML("/home/tarde/IdeaProjects/AccesoADatos/src/Tema1/diario.html");
    }
}
