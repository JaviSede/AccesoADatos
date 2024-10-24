package Tema2.Ejercicios.Ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio2 {
    public void insertarStore() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingresa el ID de la tienda: ");
            int id = sc.nextInt();
            System.out.print("Ingresa el id del staff: ");
            String nombre = sc.next();
            System.out.print("Ingresa el id de la direccion ");
            String apellido = sc.next();
            sc.close();
            Statement st = conexion.createStatement();
            st.executeUpdate("insert into store (store_id, manager_staff_id, address_id) values ( " + id + "," + nombre + "," + apellido + ")");
            st.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
