package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_2755 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [][] arr = new String [n][3];

        double sum = 0;
        double haksum = 0;

        for(int i = 0; i < n; i++) {
            double temp = 0;
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = input[j];
            }
            String score = arr[i][2];
            if (score.charAt(0) == 'A') temp = 4;
            if (score.charAt(0) == 'B') temp = 3;
            if (score.charAt(0) == 'C') temp = 2;
            if (score.charAt(0) == 'D') temp = 1;
            if (score.length() > 1) {
                if (score.charAt(1) == '+') temp += 0.3;
                if (score.charAt(1) == '-') temp -= 0.3;
            }

            sum += Integer.parseInt(arr[i][1]) * temp;
            haksum += Integer.parseInt(arr[i][1]);
        }

        System.out.println(String.format("%.2f", sum/haksum));
        br.close();
    }
}
