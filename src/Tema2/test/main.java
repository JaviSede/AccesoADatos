package Tema2.test;

import java.sql.*;

public class main {
    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/accesoadatos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
            //Consulta
            Statement consulta = conexion.createStatement();
            ResultSet rs = consulta.executeQuery("select * from prueba");
            while (rs.next()) {
                int id = rs.getInt("idprueba");
                System.out.println("idprueba : " + id);
            }

            //Actualizacion
            consulta.executeUpdate("insert into prueba(idprueba) values(2)");


            rs.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
