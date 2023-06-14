package recoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS_rere {
    static int N, M, V;
    static int[][] arr; // 탐색 배열
    static boolean visited[]; // 방문 확인 배열
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        // 한 줄을 공백을 기준으로 나누기위해 사용

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1]; // 탐색 배열 크기 선언
        visited = new boolean[N + 1]; // 각 인덱스를 초깃값(false)로 초기화

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            // for문안에서 공백을 기준으로 나누기 위해 재선언
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1; // 각 정점이 연결되어있다는 표시
        }

        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1]; // bfs 시작 전 각 인덱스를 초깃값으로 세팅
        bfs(V);
        System.out.println(sb);

        br.close();
    }
    public static void dfs(int V){ // 깊이우선탐색(재귀)
        visited[V] = true; // 방문 처리
        sb.append(V + " "); // 방문된 숫자 출력 후, 띄어쓰기

        for(int i = 1; i <= N; i++){ // 정점만큼 탐색(숫자 길이만큼)
            if(arr[V][i] == 1 && !visited[i]){
                // 탐색대상인 숫자와 탐색하는 숫자가 연결되어있고,
                // 방문되지 않았다면,
                dfs(i); // 탐색하는 숫자로 재귀호출
            }
        }
    }
    public static void bfs(int V){ // 너비우선탐색(큐)
        Queue<Integer> q = new LinkedList<>(); // 큐(FIFO) 생성
        visited[V] = true; // 방문 처리
        q.add(V); // 방문된 숫자 큐에 add
        while(!q.isEmpty()){ // 큐가 비어있지 않으면,
            V = q.poll(); // 앞 숫자 poll
            sb.append(V + " "); // poll한 앞의 숫자를 append
            for(int i = 1; i <= N; i++){  // 정점만큼 탐색(숫자 길이만큼)
            if(arr[V][i] == 1 && !visited[i]){
                // 탐색대상인 숫자와 탐색하는 숫자가 연결되어있고,
                // 방문되지 않았다면,
                    q.add(i); // 탐색하는 숫자를 큐에 add하고,
                    visited[i] = true; // 해당 숫자를 방문처리
                }
            }
        }
    }
}
