package utill;

import java.util.Scanner;

public class Login {

    Scanner sc = new Scanner(System.in);

    public boolean login() {

        System.out.println("아이디, 비밀번호를 입력하세요.");

        String userId = sc.next();
        String userPassword = sc.next();

        String id = "admin";
        String password = "123123";

        if (id.equals(userId) && password.equals(userPassword)) {
            System.out.println("로그인 성공");
            return true;

        } else {
            System.out.println("로그인 실패");
            return false;
        }
    }
}
