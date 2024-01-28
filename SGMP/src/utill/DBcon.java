package utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {

    String url = "jdbc:mysql://127.0.0.1:3306/students";
    String user = "root";
    String password = "2745";

    public Connection getConnection() {

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
