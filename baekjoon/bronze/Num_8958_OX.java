package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_8958_OX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // TestCase
        String arr[] = new String[T]; // OX score arr

        for(int i = 0; i < T; i++){ // input OX score in arr
            arr[i] = br.readLine();
        }
        br.close();

        for (String s : arr) {
            int count = 0;
            int sum = 0;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    count++;
                } else count = 0;
                sum += count;
            }
            System.out.println(sum);
        }
    }
}
