package baekjoon.silver;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Num_9711_Fibonacci_BigInteger {
    static BigInteger[] fibo; // 매우 큰 정수를 다루기위한 배열 선언
    static BigInteger zero = new BigInteger("0"); // 비교나 연산에 사용하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트케이스

        int[] ps = new int[t+1]; // 테스트케이스 수+1 크기로 ps 배열 생성
        BigInteger[] qs = new BigInteger[t+1];
        // 테스트케이스 수+1 크기로 qs 배열 생성
        int max = 0; // 입력받은 P 값 중 가장 큰 값을 저장하는 변수 초기화
        StringTokenizer st;

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            ps[i] = Integer.parseInt(st.nextToken()); // P값
            qs[i] = new BigInteger(st.nextToken());   // Q값
            max = Math.max(max,ps[i]);
        }

        fibo = new BigInteger[10001];
        // fibo 배열을 10001로 초기화하고, 1<=P<=100000
        fibo[1] = new BigInteger("1");
        fibo[2] = new BigInteger("1");
        // 피보나치수열의 첫 번째와 두 번째 값을 1로 설정

        for (int i = 3; i <= max; i++) { // 그 중 가장 큰값까지 반복하여
            fibo[i] = fibo[i-1].add(fibo[i-2]); // 피보나치 수열을 계산해 fibo에 저장
        }

        StringBuilder sb = new StringBuilder(); // 결과 출력을 위해 생성

        for (int i = 1; i <= t; i++) {
            sb.append("Case #" + i + ": " + fibo[ps[i]].remainder(qs[i]) + "\n");
        }

        System.out.print(sb);
    }
}
