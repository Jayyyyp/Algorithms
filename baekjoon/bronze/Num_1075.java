package baekjoon.bronze;

import java.io.*;

public class Num_1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        N /= 100;
        N *= 100;

        int F = Integer.parseInt(br.readLine());
        int result = 0;

        while (N % F != 0){
            N++;
            result++;
        }
        if(10 > result){
            System.out.println("0" + result);
        }else {
            System.out.println(result);
        }

        br.close();
    }
}
