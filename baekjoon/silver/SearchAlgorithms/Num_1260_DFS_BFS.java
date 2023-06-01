package baekjoon.silver.SearchAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Num_1260_DFS_BFS {

    static int[][] arr; // 그래프 연결상태를 나타내는 2차원 배열
    static boolean[] visited; // 각 정점의 방문여부를 나타내는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);   // 정점
        int M = Integer.parseInt(str[1]);   // 간선
        int V = Integer.parseInt(str[2]);   // 탐색시작 정점 번호

        arr = new int[N + 1][N + 1];
        // 정점 번호는 1번부터 N번까지이므로 편의상 배열의 크기를 +1
        // 간선 정보를 입력받아 arr[a][b]와 arr[b][a]에 1을 할당해 a와 b가 연결됨을 표시

        for(int i = 0; i < M; i++) {
            // 간선의 개수 M만큼 반복하며 간선 정보를 입력받는다
            String[] str2 = br.readLine().split(" ");
            // 띄어쓰기 기준으로 문자열 분리

            // 각 간선은 두개의 정점 a와 b로 이루어져 있다.
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);

            arr[a][b] = 1;
            arr[b][a] = 1;
            // 두 정점이 연결되어있음을 표시하기 위해 arr[a][b]와 a[b][a]를 1로 설정
            // Why? 입력으로 주어지는 간선은 양방향이어서 a와 b로의 연결과 b에서 a로의 연결을 모두 표시해야 하기 때문
        }
        visited = new boolean[N + 1]; // 방문 여부를 배열 visited 생성하여 정점의 개수에 +1한 값으로 설정
        // 정점의 번호가 1부터 시작하기 때문에, 배열의 인덱스와 정점의 번호를 일치시키기 위함
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1]; // 여기서 다시 선언을 해주지 않으면 위에 dfs(V)함수에서 사용한 visited를 bfs(V)에서도 사용하게 되므로 초기화 시켜준다.
        bfs(V);
    }

    static void dfs(int V) {
        visited[V] = true;
        System.out.print(V + " ");
        // V: 탐색을 시작할 정점의 번호
        // 해당 번호는 이미 방문한 정점이므로 방문했다는 표식을 남겨줌
        if(V > arr.length - 1) {
           // 정점 V의 번호가 정점의 총 개수보다 큰 경우에는 함수를 종료
           // Why? 정점의 번호가 정점의 총 개수를 초과할 수 없기 때문
            return;
        }

        for(int node = 1; node < arr.length; node++) {
            // 정점 V와 연결된 다른 정점을 탐색
            if(arr[V][node] == 1 && visited[node] == false) {
                // arr[V][node] == 1: 연결된 두 정점이다
                // visited[node] == false: 아직 방문하지 않았다

                dfs(node);
                // dfs(node) 함수를 호출해줌(재귀함수)
                // 호출하면 방문했다는 표식을 남길 수 있음
            }
        }
    }
    
    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(V); // 큐에 해당 정점 번호를 넣어줌
        visited[V] = true; // 방문했다는 표식을 남겨줌
        System.out.print(V + " ");

        while(!queue.isEmpty()) { // 큐가 비어있지 않으면(방문해야할 정점이 남아있는 동안)
            int temp = queue.poll(); // 정점을 하나씩 꺼내 그 정점과 연결된 다른 정점 탐색
            for(int node = 1; node < arr.length; node++) {
                if(arr[temp][node] == 1 && visited[node] == false) {
                    // 해당 노드와 연결된 다른 노드가 있고 그 다른 노드를 아직 방문하지 않았다면
                    queue.add(node); // 다른 노드를 queue에 넣고
                    visited[node] = true; // 방문했다는 표식을 남겨줌
                    System.out.print(node + " "); // 방문한 정점의 번호 출력
                }
            }
        }
    }
}