package baekjoon.silver.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_2579_Stairs{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n + 1];
        // 코드의 가독성을 위하여 1번째 배열부터 입력되게 설정(인덱스 0 은 비워져있음)
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        // 동적 프로그래밍을 위한 배열 dp 설정
        int[] dp = new int[n + 1];
        dp[1] = stairs[1]; // 첫 번째 계단까지의 최대점수를 stairs[1]에 초기화(초기값)

        for (int i = 2; i <= n; i++) {
            if(i==2){
                dp[2] = stairs[1] + stairs[2];
            }else if(i==3){
                dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
            }else{
                dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
            }
        }

        System.out.println(dp[n]);
    }
}