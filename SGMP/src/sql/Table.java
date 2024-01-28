package sql;

import utill.DBcon;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Table {

    DBcon dbcon = new DBcon();

    public void createStudentTable() {

        String sql = "CREATE TABLE if not exists students.tbl_student(sno INT AUTO_INCREMENT primary key, name VARCHAR(20), age INT, gender CHAR(1), k_score INT, e_score INT, m_score INT);";

        try {
            Connection conn = dbcon.getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void dropStudentTable() {

        String sql = "DROP TABLE tbl_student;";

        try {
            Connection conn = dbcon.getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void createLoginTable() {

        String sql = "CREATE TABLE if not exists students.loginInfo(pk INT AUTO_INCREMENT primary key, id VARCHAR(45), password VARCHAR(45));";

        try {
            Connection conn = dbcon.getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void dropLoginTable() {

        String sql = "DROP TABLE loginInfo;";

        try {
            Connection conn = dbcon.getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
