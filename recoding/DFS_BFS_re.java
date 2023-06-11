package recoding;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS_re {
    static int arr[][];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점
        M = Integer.parseInt(st.nextToken()); // 간선
        V = Integer.parseInt(st.nextToken()); // 탐색시작할 정점의 번호

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b= Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
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