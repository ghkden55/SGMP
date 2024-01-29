package entity;

public class Student {

    // 학번
    private int sno;

    // 이름
    private String name;

    // 나이
    private int age;

    // 성별
    private String gender;

    // 국어 점수
    private int k_score;

    // 영어 점수
    private int e_score;

    // 수학 점수
    private int m_score;


    public int getSno() {
        return sno;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getK_score() {
        return k_score;
    }

    public int getE_score() {
        return e_score;
    }

    public int getM_score() {
        return m_score;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setK_score(int k_score) {
        this.k_score = k_score;
    }

    public void setE_score(int e_score) {
        this.e_score = e_score;
    }

    public void setM_score(int m_score) {
        this.m_score = m_score;
    }


    @Override
    public  String toString() {
        return "학번: " + sno + " | " + "이름: " + name + " | " + "나이: " + age + " | " + "성별: " + gender + " | " + "국어점수: " + k_score + " | " + "영어점수: " + e_score + " | " + "수학점수: " + m_score;
    }
}
