package baekjoon.silver.SearchAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num_4963_IslandCount_DFS{

    static int W, H;
    static int arr[][];
    static int searchX[] = {0,0,-1,1,-1,-1,1,1};
    static int searchY[] = {-1,1,0,0,-1,1,-1,1}; //8방향 탐색
    static boolean visited[][];
    static int islandCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader
                (new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W ==0 && H == 0) // 0 0 이면 출력 끝
                break;

            arr = new int[H][W];
            visited = new boolean[H][W];
            islandCount = 0 ;

            for(int i = 0; i< H; i++) { // 지도 크기 입력 for문
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j< W; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i< H; i++) { // dfs실행 for문
                for(int j = 0; j< W; j++) {
                    if(arr[i][j] == 1 && !visited[i][j]) {

                        visited[i][j] = true;
                        dfs(i, j);
                        islandCount++;
                    }
                }
            }
            System.out.println(islandCount);
        } // while문
    }

    static void dfs(int row,int col) {

        for(int d = 0; d < 8; d++) {
            // 현재 위치에서 8방향으로 이동할 수 있는지 확인
            int nx = row + searchX[d];
            int ny = col + searchY[d];
            // 현재 위치에서 d방향으로 이동한 위치값

            if(nx < 0 || nx >= H || ny < 0 || ny >= W || arr[nx][ny] ==0
                    || visited[nx][ny]) {
            // 이동한 위치가 배열의 범위를 벗어나거나, 이동한 위치값이 0이거나,
            // 이미 방문한 위치인 경우,
                continue; // 다음방향으로 이동
            }else{ // 위의 경우를 벗어날 경우,
                visited[nx][ny] = true; // 방문표시 후,
                dfs(nx, ny); // dfs 다시 수행하러 출발
            }
        }
        // return 구문 생략 가능
        // for 반복문이 종료되면, 함수는 자동으로 종료되고, 호출한 곳으로 돌아가기때문
    }
}