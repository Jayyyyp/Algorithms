package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num_1427 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine(); // 문자형 변수 N

        int Arr[] = new int[N.length()]; 		// int 배열[N의 자릿수만큼]

        for(int i = 0; i < N.length(); i++) {	// N만큼 반복

            char NIntoNumbers = N.charAt(i);		// 문자열에서 각 자리 문자 가져오기
            int numbers = Character.getNumericValue(NIntoNumbers); // 문자를 숫자로
            Arr[i] = numbers;
            Arrays.sort(Arr);
        }

        br.close();
    }
}
