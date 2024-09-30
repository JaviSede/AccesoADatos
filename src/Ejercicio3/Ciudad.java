package Ejercicio3;

public class Ciudad {
    private int ID;
    private char[] nombre;
    private char[] countryCode;
    private int poblacion;

    public Ciudad() {
        this.ID = -1;
        this.nombre = new char[10];
        this.countryCode = new char[3];
        this.poblacion = -1;
    }

    public Ciudad(int ID, char[] nombre, char[] countryCode, int poblacion) {
        this.ID = ID;
        this.nombre = nombre;
        this.countryCode = countryCode;
        this.poblacion = poblacion;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public char[] getNombre() {
        return nombre;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }

    public char[] getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(char[] countryCode) {
        this.countryCode = countryCode;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }
}
