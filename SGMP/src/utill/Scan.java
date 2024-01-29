package utill;

import entity.Student;

import java.util.Scanner;

public class Scan {

    Scanner sc = new Scanner(System.in);

    public int returnInt() {
        int i = sc.nextInt();
        return i;
    }

    public String returnString() {
        String str = sc.next();
        return str;
    }

    public Student returnStudent() {

        String name = sc.next();
        int age = sc.nextInt();
        String gender = sc.next();
        int k_score = sc.nextInt();
        int e_score = sc.nextInt();
        int m_score = sc.nextInt();

        Student stud = new Student();
        stud.setName(name);
        stud.setAge(age);
        stud.setGender(gender);
        stud.setK_score(k_score);
        stud.setE_score(e_score);
        stud.setM_score(m_score);

        return stud;
    }
}
