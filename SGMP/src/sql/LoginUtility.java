package sql;

import utill.DBcon;

import java.sql.*;

public class LoginUtility {

    DBcon dbcon = new DBcon();

    public void createLoginInfo() {

        String sql = "INSERT INTO loginInfo(id, password) VALUES (?, ?);";

        try {
            Connection conn = dbcon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
