package Tema2.Ejercicios.Ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Ejercicio2 {

    private void insertarStore() {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            conexion.setAutoCommit(false);

            System.out.print("Ingresa el ID de la tienda: ");
            int id = sc.nextInt();
            System.out.print("Ingresa el id del staff: ");
            int idStaff = sc.nextInt();
            System.out.print("Ingresa el id de la direccion ");
            int idDir = sc.nextInt();

            String query = "INSERT INTO store (store_id, manager_staff_id, address_id) VALUES (?, ?, ?)";
            pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setInt(2, idStaff);
            pstmt.setInt(3, idDir);
            pstmt.executeUpdate();

            conexion.commit();
        } catch (SQLException e) {
            System.out.println(e);
            try {
                if (conexion != null) conexion.rollback();
                pstmt.close();
                conexion.close();
            } catch (SQLException rollbackEx) {
                System.out.println(rollbackEx);
            }
        }
    }

    private void insertarStaff() {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            conexion.setAutoCommit(false);

            System.out.print("Ingresa el id del staff: ");
            int id = sc.nextInt();
            System.out.print("Ingresa el nombre: ");
            String nombre = sc.next();
            System.out.print("Ingresa el apellido: ");
            String apellido = sc.next();
            System.out.print("Ingresa el id de la direccion: ");
            int direccion = sc.nextInt();
            System.out.print("Ingresa el email: ");
            String email = sc.next();
            System.out.print("Ingresa el id de la tienda: ");
            int tienda = sc.nextInt();
            System.out.print("Ingresa la actividad: (T) o (F): ");
            String actividad = sc.next();
            System.out.print("Ingresa el nombre de usuario: ");
            String usuario = sc.next();
            System.out.print("Ingresa la contraseña: ");
            String contrasena = sc.next();

            pstmt = conexion.prepareStatement("INSERT INTO staff (staff_id, first_name, last_name, address_id, email, store_id, active, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            pstmt.setInt(4, direccion);
            pstmt.setString(5, email);
            pstmt.setInt(6, tienda);
            pstmt.setString(7, actividad);
            pstmt.setString(8, usuario);
            pstmt.setString(9, contrasena);
            pstmt.executeUpdate();

            conexion.commit();
            actualizarStore(id, tienda);
        } catch (SQLException e) {
            System.out.println(e);
            try {
                if (conexion != null) conexion.rollback();
                pstmt.close();
                conexion.close();
            } catch (SQLException rollbackEx) {
                System.out.println(rollbackEx);
            }
        }
    }

    private void actualizarStore(int idStaff, int tienda){
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            conexion.setAutoCommit(false);

            pstmt = conexion.prepareStatement("UPDATE store SET store_id = ? WHERE store_id = ?");
            pstmt.setInt(1, idStaff);
            pstmt.setInt(2, tienda);
            pstmt.executeUpdate();

            conexion.commit();

        } catch (SQLException e) {
            System.out.println(e);
            try {
                if (conexion != null) conexion.rollback();
                pstmt.close();
                conexion.close();
            } catch (SQLException rollbackEx) {
                System.out.println(rollbackEx);
            }
        }
    }

    public void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Menu Store - Staff --");
        System.out.println("");
        System.out.println("1) Insertar store...");
        System.out.println("2) Insertar staff...");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                insertarStore();
                break;
            case 2:
                insertarStaff();
                break;
            default:
                System.err.println("Opcion no valida");
        }
    }
}
