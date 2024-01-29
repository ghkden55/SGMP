package utill;

public class Script {

    public void printMainMenu() {
        System.out.println("메뉴를 선택하세요.");
        System.out.println("1. 학생 정보 입력");
        System.out.println("2. 학생 정보 조회");
        System.out.println("3. 학생 정보 수정");
        System.out.println("4. 학생 정보 삭제");
        System.out.println("5. 종료");
    }

    public void printColumns() {
        System.out.println("이름, 나이, 성별, 국어 점수, 영어 점수, 수학 점수");
    }

    public void printInsertScript() {
        System.out.println("학생 정보를 입력해주세요.");
        printColumns();
    }

    public void printSelectMenu() {
        System.out.println("학생 정보 조회");
        System.out.println("1. 전체 학생 조회");
        System.out.println("2. 학생 한 명 조회");
    }

    public void printUpdateMenu() {
        System.out.println("학생 정보 수정");
        System.out.println("1. 학생 정보 전체 수정");
        System.out.println("2. 학생 정보 일부 수정");
    }

    public void printUpdateDetailMenu() {
        System.out.println("수정할 값을 선택하세요.");
        System.out.println("1. 이름");
        System.out.println("2. 나이");
        System.out.println("3. 성별");
        System.out.println("4. 국어점수");
        System.out.println("5. 영어점수");
        System.out.println("6. 수학점수");
        System.out.println("7. 돌아가기");
    }

    public void choiceScript() {
        System.out.println("선택할 학생의 학번을 입력하세요.");
    }

    public void errorScript() {
        System.out.println("다시 입력하세요.");
    }

    public void deleteScript() {
        System.out.println("삭제하시겠습니까?");
        System.out.println("y / n");
    }
}
