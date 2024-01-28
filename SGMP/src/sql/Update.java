package sql;

import utill.DBcon;

import java.sql.*;

public class Update {

    DBcon dbcon = new DBcon();
    Select s = new Select();

    public void updateStudentAllInfo(int sno, String name, int age, String gender, int k_score, int e_score, int m_score) {

        String sql = "UPDATE tbl_student SET name = ?, age = ?, gender = ?, k_score = ?, e_score = ?, m_score = ? WHERE sno = ?;";

        try {
            Connection conn = dbcon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.setInt(4, k_score);
            pstmt.setInt(5, e_score);
            pstmt.setInt(6, m_score);
            pstmt.setInt(7, sno);

            pstmt.executeUpdate();

            System.out.println("수정이 완료 되었습니다.");
            s.printStudent(sno);

        } catch (SQLException e) {
            System.out.println("해당 학번이 존재하지 않습니다.");
        }
    }


    public void updateStudentColumns(int sno, String columns, String values) {

        String sql = "UPDATE tbl_student SET " + columns + " = ? WHERE sno = ?;";

        try {
            Connection conn = dbcon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, values);
            pstmt.setInt(2, sno);

            pstmt.executeUpdate();

            System.out.println("수정이 완료 되었습니다.");
            s.printStudent(sno);

        } catch (SQLException e) {
            System.out.println("해당 학번이 존재하지 않습니다.");
        }
    }
}
