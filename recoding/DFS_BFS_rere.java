package recoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS_rere {
    static int N, M, V;
    static int[][] arr;
    static boolean visited[];
    static StringTokenizer st, str;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1]; // 각 인덱스를 초깃값(false)로 초기화

        for(int i = 1; i <= M; i++){
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1; // 각 정점이 연결되어있다는 표시
        }

        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1]; // bfs 시작 전 각 인덱스를 초깃값으로 세팅
        bfs(V);
        System.out.println(sb);

        br.close();
    }

    public static void dfs(int V){
        visited[V] = true;
        sb.append(V + " ");

        for(int i = 1; i <= N; i++){
            if(arr[V][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int V){
        Queue<Integer> q = new LinkedList<>();
        visited[V] = true;
        q.add(V);
        while(!q.isEmpty()){
            V = q.poll();
            sb.append(V + " ");
            for(int i = 1; i <= N; i++){
            if(arr[V][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
