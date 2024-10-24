package Tema2.Ejercicios;

import java.sql.*;
import java.util.Scanner;

public class ejercicio1 {
    public void hacerConsulta() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            Scanner sc = new Scanner(System.in);
            System.out.println("-- ingresar consulta --");
            String consulta = sc.nextLine();
            sc.close();
            if(consulta.equals("")){
                return;
            }
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rsmd.getColumnName(i) + " = " + rs.getString(rsmd.getColumnName(i)) + " ");
                }
                System.out.println("");
            }
            rs.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actualizarDatos() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            Scanner sc = new Scanner(System.in);
            System.out.println("-- Selecciona tabla --");
            System.out.println("1) City");
            System.out.println("2) Country");
            System.out.println("3) CountryLanguage");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el ID de la ciudad: ");
                    int id = sc.nextInt();
                    System.out.print("Ingresa el nombre de la ciudad: ");
                    String nombre = sc.next();
                    System.out.print("Ingresa el codigo de la ciudad: ");
                    String codigo = sc.next();
                    System.out.print("Ingresa distrito de la ciudad: ");
                    String distrito = sc.next();
                    System.out.print("Ingresa la poblacion de la ciudad: ");
                    int poblacion = sc.nextInt();
                    sc.close();
                    Statement st = conexion.createStatement();
                    st.executeUpdate("update city set Name = ' " + nombre + "', CountryCode = '" + codigo + "', District = '" + distrito + "', Population = " + poblacion + " where id =" + id);
                    st.close();
                    conexion.close();
                    break;
                case 2:
                    System.out.println("Ingresa el ID de la pais: ");
                    int id2 = sc.nextInt();
                    System.out.print("Ingresa el nombre de la pais: ");
                    String nombre2 = sc.next();
                    System.out.print("Ingresa el continente de la pais: ");
                    String continente = sc.next();
                    System.out.print("Ingresa la region del pais: ");
                    String region = sc.next();
                    System.out.print("Ingresa el area del pais: ");
                    float area = sc.nextFloat();
                    System.out.print("Ingresa el indepYear del pais: ");
                    int indepYear = sc.nextInt();
                    System.out.println("Ingresa la poblacion del pais: ");
                    int poblacion2 = sc.nextInt();
                    System.out.println("Ingresa la esperanza de vida: ");
                    float vida = sc.nextFloat();
                    System.out.println("Ingresa el GNP: ");
                    float gnp = sc.nextFloat();
                    System.out.println("Ingresa el GNPOld: ");
                    float gnpold = sc.nextFloat();
                    System.out.println("Ingresa el LocalName: ");
                    String localName = sc.next();
                    System.out.print("Ingresa la forma de gobierno: ");
                    String forma = sc.next();
                    System.out.print("Ingresa la cabeza de estado: ");
                    String cabeza = sc.next();
                    System.out.print("Ingresa la capital: ");
                    int capital = sc.nextInt();
                    System.out.print("Ingresa el code2: ");
                    String code2 = sc.next();
                    sc.close();
                    Statement st2 = conexion.createStatement();
                    st2.executeUpdate("update country SET Name ='" + nombre2 + "', Continent = '"+ continente + "', Region = '" + region + "', SurfaceArea = " + area +
                            ", IndepYear = " + indepYear + ", Population = " + poblacion2 + ", LifeExpentacy = " + vida + ", GNP = " + gnp + ", GNPOld = " + gnpold +
                            ", LocalName = '" + localName + "', GovernmentForm = '" + forma + "', HeadOfState = '"+ cabeza +"', Capital = " + capital + ", code2 = " + code2 +" WHERE id = " + id2);
                    st2.close();
                    conexion.close();
                    break;
                // TODO terminar la mierda esta y ver porque cojones falla
                case 3:
                    System.out.print("Ingresa el idioma: ");
                    String idioma = sc.next();
                    System.out.print("Ingresa oficial es oficial (1: true, 0: false): ");
                    boolean oficial = sc.nextBoolean();
                    System.out.println("Ingresa el porcentaje: ");
                    float porcentaje = sc.nextFloat();
                    sc.close();
                    Statement st3 = conexion.createStatement();
                    st3.executeUpdate("update countrylanguage set Language = '" + idioma + "', isOfficial =" + oficial + ", Percentaje = " + porcentaje + " where Language ='" + idioma + "';");
                    st3.close();
                    conexion.close();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void borrarFila(){
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingresa el nombre de la tabla: ");
            String tabla = sc.nextLine();

            switch (tabla) {
                case "City":
                    System.out.println("Ingresa el id de la fila a borrar");
                    int id = sc.nextInt();
                    Statement st = conexion.createStatement();
                    st.executeUpdate("delete from city where id = " + id);
                    break;
                case "Country":
                    System.out.println("Ingresa el id de la fila a borrar");
                    int id2 = sc.nextInt();
                    Statement st2 = conexion.createStatement();
                    st2.executeUpdate("delete from country where id = " + id2);
                    break;
                case "CountryLanguage":
                    System.out.println("Ingresa el id de la fila a borrar");
                    int id3 = sc.nextInt();
                    Statement st3 = conexion.createStatement();
                    st3.executeUpdate("delete from countrylanguage where id = " + id3);
                    break;
                default:
                    System.out.println("El nombre de la tabla no es valido");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Menu --");
        System.out.println("");
        System.out.println("1) Realizar consulta...");
        System.out.println("2) Actualizar datos...");
        System.out.println("3) Borrar datos...");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                hacerConsulta();
                break;
            case 2:
                actualizarDatos();
                break;
            case 3:
                borrarFila();
                break;
            default:
                System.err.println("Opcion no valida");
        }

    }

    public static void main(String[] args) {
        ejercicio1 ejercicio1 = new ejercicio1();
        ejercicio1.menu();
    }
}
