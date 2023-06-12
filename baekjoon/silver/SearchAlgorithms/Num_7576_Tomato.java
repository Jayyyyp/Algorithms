package baekjoon.silver.SearchAlgorithms;

import java.io.*;
import java.util.*;

public class Num_7576_Tomato{
    static int M, N;
    static int[][] box;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1)
                    queue.add(new Point(i, j));
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;

                if(box[nextX][nextY] != 0)
                    continue;

                box[nextX][nextY] = box[point.x][point.y] + 1;
                queue.add(new Point(nextX, nextY));
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(box[i][j] == 0)
                    return -1;
                max = Math.max(max, box[i][j]);
            }
        }

        return max - 1;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
