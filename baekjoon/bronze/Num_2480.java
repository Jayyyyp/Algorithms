package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class Num_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 0;

        if(N == M && M == K && N == K){
            result = 10000 + N * 1000;
        } else if (N == M || N == K){
            result = 1000 + N * 100;
        } else if (M == K) {
            result = 1000 + M * 100;
        }else {
            result = Math.max(N, Math.max(M, K)) * 100;
        }
        System.out.println(result);

        br.close();
        bw.flush();
        bw.close();
    }
}
