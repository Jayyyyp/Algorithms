package baekjoon.silver.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num_1010 {
    public static long[][] memo;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; ++tc) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            memo = new long[31][31];

            for (int i = 1; i <= M; ++i) {
                memo[1][i] = i;
            }

            for (int i = 2; i <= N; ++i) {
                for (int j = i; j <= M; ++j) {
                    for (int k = j - 1; k >= 0; k--) {
                        memo[i][j] += memo[i - 1][k];
                    }
                }
            }

            System.out.println(memo[N][M]);
        }
    }
}
