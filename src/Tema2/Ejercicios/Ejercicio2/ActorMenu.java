package Tema2.Ejercicios.Ejercicio2;

import java.sql.*;
import java.util.Scanner;

public class ActorMenu {
    public void listar() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            String consulta = "select * from actor";
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

    public void insertarDatos() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingresa el ID del actor: ");
            int id = sc.nextInt();
            System.out.print("Ingresa el nombre del actor: ");
            String nombre = sc.next();
            System.out.print("Ingresa el apellido del actor: ");
            String apellido = sc.next();
            sc.close();
            Statement st = conexion.createStatement();
            st.executeUpdate("insert into actor (actor_id, first_name, last_name) values (' " + id + "', '" + nombre + "', '" + apellido + "')");
            st.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actualizarDatos() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingresa el ID del actor: ");
            int id = sc.nextInt();
            System.out.print("Ingresa el nombre del actor: ");
            String nombre = sc.next();
            System.out.print("Ingresa el apellido del actor: ");
            String apellido = sc.next();
            sc.close();
            Statement st = conexion.createStatement();
            st.executeUpdate("update actor set first_name = '" + nombre + "', last_name = '" + apellido + "' where actor_id = '" + id + "';");
            st.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void borrarFila() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingresa el id de la fila a borrar");
            int id = sc.nextInt();
            Statement st = conexion.createStatement();
            st.executeUpdate("delete from actor where actor_id = " + id);
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Menu Actor --");
        System.out.println("");
        System.out.println("1) Listar...");
        System.out.println("2) Actualizar datos...");
        System.out.println("3) Insertar datos...");
        System.out.println("4) Borrar datos...");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                listar();
                break;
            case 2:
                actualizarDatos();
                break;
            case 3:
                insertarDatos();
                break;
            case 4:
                borrarFila();
                break;
            default:
                System.err.println("Opcion no valida");
        }
    }

    public static void main(String[] args) {
        new ActorMenu().menu();
    }
}
