package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection conn;
    private final static String url = "jdbc:mysql://localhost:3307/comercializadora";
    
    public static Connection open() throws Exception{
        if (conn == null || conn.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
        }
        return conn;
    }
}
