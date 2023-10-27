package baekjoon.silver.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int times = Integer.parseInt(br.readLine());
        int[][] human = new int[times][3];
        StringTokenizer st;

        for (int i = 0; i < times; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            human[i][0] = Integer.parseInt(st.nextToken());
            human[i][1] = Integer.parseInt(st.nextToken());
            human[i][2] = 1;
        }

        for (int i = 0; i < times; i++) {
            for (int j = 0; j < times; j++) {
                if (i == j) continue;

                if (human[i][0] > human[j][0] && human[i][1] > human[j][1]) {
                    human[j][2]++;
                }
            }
        }

        for (int i = 0; i < times; i++) {
            sb.append(human[i][2]).append(" ");
        }

        System.out.println(sb);
    }
}
