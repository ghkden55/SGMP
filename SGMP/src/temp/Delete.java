//package dao;
//
//import utill.DBcon;
//
//import java.sql.*;
//
//public class Delete {
//
//    DBcon dbcon = new DBcon();
//
//    public void deleteStudent(int sno) {
//
//        String sql = "DELETE FROM tbl_student WHERE sno = " + sno;
//
//        try {
//            Connection conn = dbcon.getConnection();
//            Statement stmt = conn.createStatement();
//            stmt.executeQuery(sql);
//
//            System.out.println(sno + "번이 삭제되었습니다.");
//
//        } catch (SQLException e) {
//            System.out.println("해당 학번이 존재하지 않습니다.");
//        }
//    }
//
//
//}
