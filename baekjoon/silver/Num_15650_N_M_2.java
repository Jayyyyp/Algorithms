package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Num_15650_N_M_2 {
    static int N, M;
    static int[] arr; // M개의 수열을 저장하기 위한 배열
    static boolean[] visit; // 해당 인덱스 숫자가 이미 방문되었는지 표시하는 Boolean 배열
    static BufferedWriter bw; // 출력 빠르게 !

    static void dfs(int start, int depth) throws IOException { // 시작인덱스를 갖고있으므로, 이전 숫자보다 큰숫자만 선택
        if (depth == M) {
            for (int val : arr) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                arr[depth] = i;
                dfs(i + 1, depth + 1); // 현재인덱스 i에 1을 더하여 다음 숫자부터 탐색하게 만듦
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N + 1];

        dfs(1, 0);

        br.close();
        bw.flush();
        bw.close();
    }
}
