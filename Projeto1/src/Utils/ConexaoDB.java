package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/mercado";
    private static final String USER = "root"; 
    private static final String PASSWORD = "admin"; 
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
