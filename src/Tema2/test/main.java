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
            // consulta.executeUpdate("insert into prueba(idprueba) values(2)");

            // Transacciones
            conexion.setAutoCommit(false);
            try {
                consulta.executeUpdate("insert into prueba(idprueba) values(3)");
                consulta.executeUpdate("insert into prueba(idprueba) values(4)");
                consulta.executeUpdate("insert into prueba(idprueba) values(5)");
                conexion.commit();
            } catch (SQLException e) {
                conexion.rollback();
            }


            //Consulta con metadatos
            rs = consulta.executeQuery("select * from prueba");
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rsmd.getColumnName(i) + " = " + rs.getString(rsmd.getColumnName(i)) + " ");
                }
                System.out.println("");
            }
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
