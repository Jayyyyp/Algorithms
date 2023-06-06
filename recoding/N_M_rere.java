package recoding;

import java.io.*;
import java.util.StringTokenizer;

public class N_M_rere {
    public static int[] arr;
    public static boolean[] visit;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int N, int M, int depth) throws IOException {
        if(depth == M){
            for(int v : arr){
                bw.write(v + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
}
