package controller;

import service.Service;
import utill.Login;
import utill.Scan;
import utill.Script;

public class Controller {

    Scan sc = new Scan();
    Script spt = new Script();
    Service ser = new Service();
    Login log = new Login();

    public void mainController() {

        int sno;
        int sw;
        boolean loginCheck = false;

        ser.createStudentTable();
        ser.createLoginTable();

        loginCheck = log.login();

        if (loginCheck) {

            int program = 0;

            while (program == 0) {

                spt.printMainMenu();

                int menu = sc.returnInt();

                switch (menu) {

                    // 학생 정보 저장
                    case 1:
                        spt.printInsertScript();

                        ser.insertStudentInfo(sc.returnStudent());
                        break;

                    // 학생 정보 출력
                    case 2:
                        spt.printSelectMenu();

                        sw  = sc.returnInt();

                        switch (sw) {

                            // 전체 학생의 정보 출력
                            case 1:
                                ser.printStudents();
                                break;

                            // 입력한 학번의 학생 정보 출력
                            case 2:
                                spt.choiceScript();
                                ser.printStudent(sc.returnInt());
                                break;

                            default:
                                spt.errorScript();
                        }
                        break;

                    // 학생 정보 수정
                    case 3:
                        spt.printUpdateMenu();

                        sw = sc.returnInt();

                        switch (sw) {

                            // 입력한 학번의 학생 정보 전체 수정
                            case 1:
                                spt.choiceScript();
                                sno = sc.returnInt();

                                // 입력한 학번의 정보를 출력
                                // 학번이 존재하지 않을 경우 메뉴로 되돌림
                                if (!ser.printStudent(sno)) {
                                    break;
                                }

                                spt.choiceScript();
                                spt.printColumns();

                                ser.updateStudentAllInfo(sno, sc.returnStudent());
                                break;

                            // 입력한 학번의 학생의 정보 하나 수정
                            case 2:
                                spt.choiceScript();
                                sno = sc.returnInt();

                                // 입력한 학번의 정보를 출력
                                // 학번이 존재하지 않을 경우 메뉴로 되돌림
                                if (!ser.printStudent(sno)) {
                                    break;
                                }

                                spt.printUpdateDetailMenu();

                                // 수정할 정보 선택
                                int columnsChoice = sc.returnInt();
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
                                    spt.errorScript();
                                }

                                // 수정할 정보 입력
                                System.out.println("수정할 값을 입력하세요.");
                                String value = sc.returnString();

                                ser.updateStudentColumns(sno, columns, value);
                                break;

                            default:
                                spt.errorScript();
                        }
                        break;

                    // 학생 정보 삭제
                    case 4:
                        spt.choiceScript();
                        sno = sc.returnInt();

                        if (!ser.printStudent(sno)) {
                            break;
                        }

                        spt.deleteScript();

                        // 선택한 정보 삭제 전 재확인
                        String deleteCheck = sc.returnString();
                        if (deleteCheck.equals("Y") || deleteCheck.equals("y")) {
                            ser.deleteStudent(sno);
                        } else if (deleteCheck.equals("N") || deleteCheck.equals("n")) {
                            System.out.println("취소했습니다.");
                            break;
                        } else {
                            spt.errorScript();
                        }
                        break;

                    // 종료
                    case 5:
                        program = 5;
                        ser.dropStudentTable();
                        ser.dropLoginTable();
                        break;

                    // 1~5 이외의 입력
                    default:
                        spt.errorScript();
                }
            }
        }
    }
}
