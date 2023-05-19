package concept;

public class Try_Catch_ {

    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            int result = a / b; // 10 / 0
            System.out.println("결과: " + result);
        } catch (ArithmeticException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("프로그램 계속 실행");
    }

}
