package baekjoon.silver.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class Num_1003_fibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];
        // 0 ~ 40까지의 피보나치 수에 대해 0과 1이 각각 몇 번 호출되는지 저장하는 2차원 배열

        // 피보나치 수열의 첫 두 항에 대한 0과 1의 호출 횟수를 초기화
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2; i <= 40; i++) { // 2 ~ 40까지의 피보나치 수에 대해 0과 1의 호출횟수 계산
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for(int i = 0; i < T; i++) {
            // 각 테스트 케이스에 대해 입력받은 피보나치 수 'N'의 0과 1의 호출 횟수 출력
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[N][0] + " " + dp[N][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
