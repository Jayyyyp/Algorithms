package baekjoon.silver.SearchAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*깊이우선탐색
  1 ~ N까지의 자연수 중 중복 없이 M개를 고른 수열을 출력
 */
public class Num_15649_N_M {
    static int[] arr; // M개의 수열을 저장하기 위한 배열
    static boolean[] visit; // 해당 인덱스 숫자가 이미 방문되었는지 표시하는 Boolean 배열
    static BufferedWriter bw; // 출력 빠르게 !

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N + 1];

        dfs(N, M, 0);

        br.close();
        bw.flush();
        bw.close();
    }
    static void dfs(int N, int M, int depth) throws IOException {
        if (depth == M) { // 깊이(depth)가 M과 같아지면, M개의 수열이 완성된 것으로
            for (int val : arr) {
                bw.write(val + " ");// arr 배열에 저장된 수열 출력
            }
            bw.write("\n");
            return;
        } // depth가 M보다 작은 경우, M개의 수열이 완성되지 않았으므로, 계속 탐색 진행

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) { // 만약, 해당 숫자가 아직 방문되지 않았다면
                visit[i] = true; // 해당 숫자를 방문처리한 후
                arr[depth] = i ; // arr 배열의 depth 인덱스에 해당 숫자를 저장
                dfs(N, M, depth + 1); // dfs메서드를 재귀호출하여 depth를 1 증가시키고 탐색계속
                visit[i] = false;
                // 한 번 수열이 완성된 후 백트래킹을 위해 visit 배열에서 해당 숫자의 방문상태를 false로 변경
                // 이렇게 하면, 그 다음 숫자에 대해 동일한 탐색과정 반복 가능
            }
        }
    }
}
