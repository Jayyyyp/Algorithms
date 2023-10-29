package baekjoon.silver.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        int lastIndex = -1;

        for (int i = 0; i < k; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0 && lastIndex >= 0) {
                lastIndex--;
            } else if (number != 0) {
                lastIndex++;
                arr[lastIndex] = number;
            }
        }

        int sum = 0;
        for (int i = 0; i <= lastIndex; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
        br.close();
    }
}
