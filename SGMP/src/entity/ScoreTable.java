package entity;

public class ScoreTable {

    private int sno;

    private String name;

    private int age;

    private String gender;

    private int k_score;

    private int e_score;

    private int m_score;

    private int totalScore;

    private int AverageScore;

    private String grade;


    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getK_score() {
        return k_score;
    }

    public void setK_score(int k_score) {
        this.k_score = k_score;
    }

    public int getE_score() {
        return e_score;
    }

    public void setE_score(int e_score) {
        this.e_score = e_score;
    }

    public int getM_score() {
        return m_score;
    }

    public void setM_score(int m_score) {
        this.m_score = m_score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getAverageScore() {
        return AverageScore;
    }

    public void setAverageScore(int averageScore) {
        AverageScore = averageScore;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
