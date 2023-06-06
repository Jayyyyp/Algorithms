package concept;

public class DFS_JavaTutor {
        static int[][] arr;
        static boolean[] visited;
        static StringBuilder sb = new StringBuilder();
        static int N, M, V;

        public static void main(String[] args) {
            N = 4; // 정점
            M = 5; // 간선
            V = 1; // 탐색시작할 정점의 번호

            arr = new int[N + 1][N + 1];
            visited = new boolean[N + 1];

            int[][] edges = {
                    {1, 2},
                    {1, 3},
                    {1, 4},
                    {2, 4},
                    {3, 4}
            };

            for(int i = 0; i < M; i++){
                int a = edges[i][0];
                int b = edges[i][1];

                arr[a][b] = arr[b][a] = 1;
            }

            dfs(V);
            visited = new boolean[N + 1];

            System.out.println(sb.toString());
        }

        public static void dfs(int V){
            visited[V] = true;
            sb.append(V).append(' ');
            for(int i = 1; i <= N; i++){
                if(arr[V][i] == 1 && !visited[i]){
                    dfs(i);
                }
            }
        }
    }


