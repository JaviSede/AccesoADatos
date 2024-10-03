package Ejercicio3;

import java.util.ArrayList;

public class Ciudades {
    ArrayList<Ciudad> ciudades = new ArrayList<>();

    public Ciudades(){
        this.ciudades = new ArrayList<>();
    }

    public Ciudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = new ArrayList<>(ciudades);
    }

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public void anadirCiudad(Ciudad ciudad){
        this.ciudades.add(ciudad);
    }
}
