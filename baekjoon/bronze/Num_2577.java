package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_2577 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        br.close();
        int gob = A * B * C;
        int result[] = new int [10];

        String gobToString = Integer.toString(gob);

        for(int i = 0; i < gobToString.length(); i++) {
            result[gobToString.charAt(i) - '0']++; // 인덱스 값 증가
        }

        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < 10; j++) {
            sb.append(result[j]).append("\n");
        }
        System.out.println(sb);

//		for(int j = 0; j < 10; j++) {
//			System.out.println(result[j]);
//		}
    }

}
