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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) { // while문
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W ==0 && H == 0)
                break;

            arr = new int[H][W];
            visited = new boolean[H][W];
            islandCount = 0 ;

            for(int i = 0; i< H; i++) { // 지도 크기 입력 for문
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j< W; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            } // 지도 크기 입력 for문

            for(int i = 0; i< H; i++) { // dfs실행 for문
                for(int j = 0; j< W; j++) {
                    if(arr[i][j] == 1 && !visited[i][j]) {

                        visited[i][j] = true;
                        dfs(i, j);
                        islandCount++;
                    }
                }
            } // dfs 실행 for문

            System.out.println(islandCount);

        } // while문
    }

    static void dfs(int row,int col) {

        for(int d = 0; d < 8; d++) {
            int nx = row + searchX[d];
            int ny = col + searchY[d];

            if(nx < 0 || nx >= H || ny < 0 || ny >= W || arr[nx][ny] ==0 || visited[nx][ny]) {
                continue;
            }else{
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
        return;
    }


}