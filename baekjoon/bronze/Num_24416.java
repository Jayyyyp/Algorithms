package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_24416 {
    static int recursiveCnt = 0;
    static int dpCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        fib(n);

        fibonacci(n);

        System.out.println(recursiveCnt + " " + dpCnt);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            recursiveCnt++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 1;

        for (int i = 3; i <= n; i++) {
            dpCnt++;
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
