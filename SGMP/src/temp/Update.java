//package dao;
//
//import entity.Student;
//import utill.DBcon;
//
//import java.sql.*;
//
//public class Update {
//
//    DBcon dbcon = new DBcon();
//    Select s = new Select();
//
//    public void updateStudentAllInfo(int sno, Student stud) {
//
//        String sql = "UPDATE tbl_student SET name = ?, age = ?, gender = ?, k_score = ?, e_score = ?, m_score = ? WHERE sno = ?;";
//
//        try {
//            Connection conn = dbcon.getConnection();
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//
//            pstmt.setString(1, stud.getName());
//            pstmt.setInt(2, stud.getAge());
//            pstmt.setString(3, stud.getGender());
//            pstmt.setInt(4, stud.getK_score());
//            pstmt.setInt(5, stud.getE_score());
//            pstmt.setInt(6, stud.getM_score());
//            pstmt.setInt(7, sno);
//
//            pstmt.executeUpdate();
//
//            System.out.println("수정이 완료 되었습니다.");
//            s.printStudent(sno);
//
//        } catch (SQLException e) {
//            System.out.println("해당 학번이 존재하지 않습니다.");
//        }
//    }
//
//
//    public void updateStudentColumns(int sno, String columns, String values) {
//
//        String sql = "UPDATE tbl_student SET " + columns + " = ? WHERE sno = ?;";
//
//        try {
//            Connection conn = dbcon.getConnection();
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//
////            pstmt.setString(1, values);
//            pstmt.setInt(2, sno);
//
//            pstmt.executeUpdate();
//
//            System.out.println("수정이 완료 되었습니다.");
//            s.printStudent(sno);
//
//        } catch (SQLException e) {
//            System.out.println("해당 학번이 존재하지 않습니다.");
//        }
//    }
//}
