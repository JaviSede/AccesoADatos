package Tema2.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class prueba {
    Connection conexion;

    public void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/accesoadatos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}