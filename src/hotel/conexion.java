package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion{
    private static final String URL = "jdbc:mysql://localhost:3306/proyecto_hotel";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión correcta.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar.");
        }
        return connection;
    }
}