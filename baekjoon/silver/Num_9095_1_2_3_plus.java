package baekjoon.silver;

import java.io.*;

public class Num_9095_1_2_3_plus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[11];
        numbers[1] = 1; // 1의 경우의 수
        numbers[2] = 2; // 2의 경우의 수
        numbers[3] = 4; // 3의 경우의 수

        for(int i = 4; i <= 10; i++){
            numbers[i] = numbers[i - 1] + numbers[i - 2] + numbers[i - 3];
        }
        int T = Integer.parseInt(br.readLine());
        for(int j = 0; T > j; T--){
            int n = Integer.parseInt(br.readLine());
            bw.write(numbers[n] + "\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
