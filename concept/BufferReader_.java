package concept;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BufferReader_{
    public static void main(String[] args) throws IOException{
        // IOException을 처리할 수 있는 throw문을 포함한 Main 클래스
        // 입출력 관련 예외를 처리하는 데 사용되는 클래스이다
        // BufferedReader에서 데이터를 읽어들일 때, IOException이 발생할 수 있으며,
        // IOException을 처리하지 않으면 컴파일 오류가 발생한다.
        // 따라서, try-catch문을 사용해 처리하거나, 메소드에 throws IOException을 추가하여 예외처리를 위임한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader로 문자열을 읽기
        String input = br.readLine();
        // readLine()메소드를 사용하여 입력받은 문자열을 문자열 변수 input에 저장
        // readLine()메소드는 한 줄씩 문자열을 읽어들인다.
        // 개행 문자(\n)을 포함하고 있으므로, 입력한 한 줄의 문자열을 효과적으로 읽을 수 있다.
        StringTokenizer st = new StringTokenizer(input);
        // StringTokenizer를 사용해 input 문자열을 공백을 분리

        while(st.hasMoreTokens()) { // while문을 사용해, StringTokenizer에서 분리한 토큰이 더 있는지 확인
            String token = st.nextToken(); // nextToken()메소드를 사용해 다음 토큰 가져오기
            int number = Integer.parseInt(token); // 가져온 메소드(문자열)을 정수로 변환
            System.out.println("입력한 숫자 : " + number);
        }

        br.close(); // BufferedReader 닫기

    }
}