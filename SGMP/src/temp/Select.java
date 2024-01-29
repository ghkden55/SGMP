//package dao;
//
//import entity.Student;
//import utill.DBcon;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Select {
//
//    DBcon dbcon = new DBcon();
//
//    public boolean printStudent(int sno) {
//
//        String sql = "SELECT * FROM tbl_student WHERE sno = " + sno;
//
//        try {
//            Connection conn = dbcon.getConnection();
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            Student stud = new Student();
//
//            rs.next();
//            stud.setSno(rs.getInt("sno"));
//            stud.setName(rs.getString("name"));
//            stud.setAge(rs.getInt("age"));
//            stud.setGender(rs.getString("gender"));
//            stud.setK_score(rs.getInt("k_score"));
//            stud.setE_score(rs.getInt("e_score"));
//            stud.setM_score(rs.getInt("m_score"));
//
//            System.out.println(stud.toString());
//            return true;
//
//        } catch (SQLException e) {
//            System.out.println("해당 학번이 존재하지 않습니다.");
//            return false;
//        }
//    }
//
//
//    public void printStudents() {
//
//        String sql = "SELECT * FROM tbl_student";
//
//        try {
//            Connection conn = dbcon.getConnection();
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            List<Student> students = new ArrayList<>();
//
//            while (rs.next()) {
//
//                Student stud = new Student();
//
//                stud.setSno(rs.getInt("sno"));
//                stud.setName(rs.getString("name"));
//                stud.setAge(rs.getInt("age"));
//                stud.setGender(rs.getString("gender"));
//                stud.setK_score(rs.getInt("k_score"));
//                stud.setE_score(rs.getInt("e_score"));
//                stud.setM_score(rs.getInt("m_score"));
//
//                students.add(stud);
//            }
//
//            for (Student stud : students) {
//                System.out.println(stud.toString());
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
