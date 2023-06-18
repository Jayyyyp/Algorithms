package recoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_M_rerere {
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int N, int M, int depth){
        if(depth == M){
            for(int v : arr){
                sb.append(v +" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i<= N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N + 1];
        dfs(N, M, 0);

        System.out.println(sb);
        br.close();
    }
}
