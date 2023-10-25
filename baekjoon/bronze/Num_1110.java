package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = N;

        int count = 0;

        while (true) {
            count++;
            N = ((N % 10) * 10) + (((N % 10) + (N / 10)) % 10);
            if (M == N) break;
        }
        System.out.println(count);
    }
}
