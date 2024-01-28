package sql;

import utill.DBcon;

import java.sql.*;

public class Insert {

    DBcon dbcon = new DBcon();

    public void insertStudentInfo(String name, int age, String gender, int k_score, int e_score, int m_score) {

        String sql = "INSERT INTO tbl_student(name, age, gender, k_score, e_score, m_score) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            Connection conn = dbcon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.setInt(4, k_score);
            pstmt.setInt(5, e_score);
            pstmt.setInt(6, m_score);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
