import sql.*;
import utill.Login;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int sno;
        String name;
        int age;
        String gender;
        int k_score;
        int e_score;
        int m_score;
        boolean login = false;

        Table t = new Table();
        t.createStudentTable();
        t.createLoginTable();

        Login l = new Login();
        login = l.login();

        if (login) {

            int program = 0;

            while (program == 0) {

                Scanner sc = new Scanner(System.in);
                Insert i = new Insert();
                Select s = new Select();
                Update u = new Update();
                Delete d = new Delete();

                System.out.println("메뉴를 선택하세요.");
                System.out.println("1. 학생 정보 입력");
                System.out.println("2. 학생 정보 조회");
                System.out.println("3. 학생 정보 수정");
                System.out.println("4. 학생 정보 삭제");
                System.out.println("5. 종료");

                int menu = sc.nextInt();

                switch (menu) {

                    // 학생 정보 저장
                    case 1:
                        System.out.println("학생 정보를 입력해주세요.");
                        System.out.println("이름, 나이, 성별, 국어 점수, 영어 점수, 수학 점수");

                        name = sc.next();
                        age = sc.nextInt();
                        gender = sc.next();
                        k_score = sc.nextInt();
                        e_score = sc.nextInt();
                        m_score = sc.nextInt();

                        i.insertStudentInfo(name, age, gender, k_score, e_score, m_score);
                        break;

                    // 학생 정보 출력
                    case 2:
                        System.out.println("학생 정보 조회");
                        System.out.println("1. 전체 학생 조회");
                        System.out.println("2. 학생 한 명 조회");

                        int sw;
                        sw  = sc.nextInt();

                        switch (sw) {

                            // 전체 학생의 정보 출력
                            case 1:
                                s.printStudents();
                                break;

                            // 입력한 학번의 학생 정보 출력
                            case 2:
                                System.out.println("조회할 학생의 학번을 입력하세요.");
                                sno = sc.nextInt();
                                s.printStudent(sno);
                                break;

                            default:
                                System.out.println("다시 입력하세요.");
                        }
                        break;

                    // 학생 정보 수정
                    case 3:
                        System.out.println("학생 정보 수정");
                        System.out.println("1. 학생 정보 전체 수정");
                        System.out.println("2. 학생 정보 일부 수정");

                        sw = sc.nextInt();

                        switch (sw) {

                            // 입력한 학번의 학생 정보 전체 수정
                            case 1:
                                System.out.println("정보를 수정할 학생의 학번을 입력하세요.");
                                sno = sc.nextInt();

                                System.out.println("수정할 학생 정보를 입력하세요.");
                                System.out.println("이름, 나이, 성별, 국어 점수, 영어 점수, 수학 점수");
                                name = sc.next();
                                age = sc.nextInt();
                                gender = sc.next();
                                k_score = sc.nextInt();
                                e_score = sc.nextInt();
                                m_score = sc.nextInt();

                                u.updateStudentAllInfo(sno, name, age, gender, k_score, e_score, m_score);
                                break;

                            // 입력한 학번의 학생의 정보 하나 수정
                            case 2:
                                System.out.println("정보를 수정할 학생의 학번을 입력하세요.");
                                sno = sc.nextInt();

                                // 입력한 학번의 정보를 출력
                                // 학번이 존재하지 않을 경우 메뉴로 되돌림
                                if (!s.printStudent(sno)) {
                                    break;
                                }

                                System.out.println("수정할 값을 선택하세요.");
                                System.out.println("1. 이름");
                                System.out.println("2. 나이");
                                System.out.println("3. 성별");
                                System.out.println("4. 국어점수");
                                System.out.println("5. 영어점수");
                                System.out.println("6. 수학점수");
                                System.out.println("7. 돌아가기");

                                // 수정할 정보 선택
                                int columnsChoice = sc.nextInt();
                                String columns = "";

                                if (columnsChoice == 1) {
                                    columns = "name";
                                } else if (columnsChoice == 2) {
                                    columns = "age";
                                } else if (columnsChoice == 3) {
                                    columns = "gender";
                                } else if (columnsChoice == 4) {
                                    columns = "k_score";
                                } else if (columnsChoice == 5) {
                                    columns = "e_score";
                                } else if (columnsChoice == 6) {
                                    columns = "m_score";
                                } else if (columnsChoice == 7) {
                                    break;
                                } else {
                                    System.out.println("다시 입력하세요.");
                                }

                                // 수정할 정보 입력
                                System.out.println("수정할 값을 입력하세요.");
                                String value = sc.next();

                                u.updateStudentColumns(sno, columns, value);
                                break;

                            default:
                                System.out.println("다시 입력하세요.");
                        }
                        break;

                    // 학생 정보 삭제
                    case 4:
                        System.out.println("삭제할 학생의 학번을 입력하세요.");
                        sno = sc.nextInt();

                        // 삭제할 정보 출력
                        s.printStudent(sno);

                        System.out.println("삭제하시겠습니까?");
                        System.out.println("y / n");

                        // 선택한 정보 삭제 전 재확인
                        String deleteCheck = sc.next();
                        if (deleteCheck.equals("Y") || deleteCheck.equals("y")) {
                            d.deleteStudent(sno);
                        } else if (deleteCheck.equals("N") || deleteCheck.equals("n")) {
                            break;
                        }
                        break;

                    // 종료
                    case 5:
                        program = 5;
                        t.dropStudentTable();
                        t.dropLoginTable();
                        break;

                    // 1~5 이외의 입력
                    default:
                        System.out.println("다시 입력하세요.");
                }
            }
        }
    }
}
