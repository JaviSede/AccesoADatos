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

                    st.close();
                    conexion.close();
                    break;
                case 2:

            }


            Statement st = conexion.createStatement();


        } catch (Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        ejercicio1 ejercicio1 = new ejercicio1();
        ejercicio1.hacerConsulta();
    }
}
