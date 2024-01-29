package service;

import dao.Dao;
import entity.ScoreTable;
import entity.Student;

public class Service {

    Dao dao = new Dao();

    public void createStudentTable() {
        dao.createStudentTable();
    }

    public void createLoginTable() {
        dao.createLoginTable();
    }

    public void insertStudentInfo(Student stud) {
        dao.insertStudentInfo(stud);
    }

    public void printStudents() {
        dao.printStudents();
    }

    public boolean printStudent(int sno) {
        return dao.printStudent(sno);
    }

    public void updateStudentAllInfo(int sno, Student stud) {
        dao.updateStudentAllInfo(sno, stud);
    }

    public void updateStudentColumns(int sno, String columns, String value) {
        dao.updateStudentColumns(sno, columns, value);
    }

    public void deleteStudent(int sno) {
        dao.deleteStudent(sno);
    }

    public void dropStudentTable() {
        dao.dropStudentTable();
    }

    public void dropLoginTable() {
        dao.dropLoginTable();
    }

    public void totalScore(int sno) {
        ScoreTable st = dao.selecStudent(sno);

        String name = st.getName();
        int k = st.getK_score();
        int e = st.getE_score();
        int m = st.getM_score();

        st.setTotalScore(k + e + m);

        System.out.println(sno + "번 " + name + "의 총 점수는 " + st.getTotalScore() + "입니다.");
    }
}
