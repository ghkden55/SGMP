package dao;

import entity.ScoreTable;
import entity.Student;
import utill.DBcon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    DBcon dbcon = new DBcon();

    public void insertStudentInfo(Student stud) {

        String sql = "INSERT INTO tbl_student(name, age, gender, k_score, e_score, m_score) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            Connection conn = dbcon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, stud.getName());
            pstmt.setInt(2, stud.getAge());
            pstmt.setString(3, stud.getGender());
            pstmt.setInt(4, stud.getK_score());
            pstmt.setInt(5, stud.getE_score());
            pstmt.setInt(6, stud.getM_score());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println("잘못입력했습니다.");
        }
    }


    public ScoreTable selecStudent(int sno) {

        String sql = "SELECT * FROM tbl_student WHERE sno = " + sno;

        try {
            Connection conn = dbcon.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ScoreTable st = new ScoreTable();

            rs.next();
            st.setSno(rs.getInt("sno"));
            st.setName(rs.getString("name"));
            st.setAge(rs.getInt("age"));
            st.setGender(rs.getString("gender"));
            st.setK_score(rs.getInt("k_score"));
            st.setE_score(rs.getInt("e_score"));
            st.setM_score(rs.getInt("m_score"));

            rs.close();
            stmt.close();

            return st;

        } catch (SQLException e) {
            System.out.println("해당 학번이 존재하지 않습니다.");
            return null;
        }
    }


    public boolean printStudent(int sno) {

        String sql = "SELECT * FROM tbl_student WHERE sno = " + sno;

        try {
            Connection conn = dbcon.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            Student stud = new Student();

            rs.next();
            stud.setSno(rs.getInt("sno"));
            stud.setName(rs.getString("name"));
            stud.setAge(rs.getInt("age"));
            stud.setGender(rs.getString("gender"));
            stud.setK_score(rs.getInt("k_score"));
            stud.setE_score(rs.getInt("e_score"));
            stud.setM_score(rs.getInt("m_score"));

            System.out.println(stud.toString());

            rs.close();
            stmt.close();

            return true;

        } catch (SQLException e) {
            System.out.println("해당 학번이 존재하지 않습니다.");
            return false;
        }
    }


    public void printStudents() {

        String sql = "SELECT * FROM tbl_student";

        try {
            Connection conn = dbcon.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<Student> students = new ArrayList<>();

            while (rs.next()) {

                Student stud = new Student();

                stud.setSno(rs.getInt("sno"));
                stud.setName(rs.getString("name"));
                stud.setAge(rs.getInt("age"));
                stud.setGender(rs.getString("gender"));
                stud.setK_score(rs.getInt("k_score"));
                stud.setE_score(rs.getInt("e_score"));
                stud.setM_score(rs.getInt("m_score"));

                students.add(stud);
            }

            for (Student stud : students) {
                System.out.println(stud.toString());
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateStudentAllInfo(int sno, Student stud) {

        String sql = "UPDATE tbl_student SET name = ?, age = ?, gender = ?, k_score = ?, e_score = ?, m_score = ? WHERE sno = ?;";

        try {
            Connection conn = dbcon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, stud.getName());
            pstmt.setInt(2, stud.getAge());
            pstmt.setString(3, stud.getGender());
            pstmt.setInt(4, stud.getK_score());
            pstmt.setInt(5, stud.getE_score());
            pstmt.setInt(6, stud.getM_score());
            pstmt.setInt(7, sno);

            pstmt.executeUpdate();

            System.out.println("수정이 완료 되었습니다.");
            printStudent(sno);

            pstmt.close();

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
            printStudent(sno);

            pstmt.close();

        } catch (SQLException e) {
            System.out.println("해당 학번이 존재하지 않습니다.");
        }
    }


    public void deleteStudent(int sno) {

        String sql = "DELETE FROM tbl_student WHERE sno = " + sno;

        try {
            Connection conn = dbcon.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            System.out.println(sno + "번이 삭제되었습니다.");

            stmt.close();

        } catch (SQLException e) {
            System.out.println("해당 학번이 존재하지 않습니다.");
        }
    }


    public void createStudentTable() {

        String sql = "CREATE TABLE if not exists students.tbl_student(sno INT AUTO_INCREMENT primary key, name VARCHAR(20), age INT, gender CHAR(1), k_score INT, e_score INT, m_score INT);";

        try {
            Connection conn = dbcon.getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);

            stmt.close();

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

            stmt.close();

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

            stmt.close();

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

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
