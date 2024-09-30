package Ejercicio3;

import java.util.ArrayList;

public class Ciudades {
    static ArrayList<Ciudad> ciudades;

    public Ciudades(){
        this.ciudades = new ArrayList<>();
    }

    public Ciudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = new ArrayList<>(ciudades);
    }
}
