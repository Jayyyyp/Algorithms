package baekjoon.bronze;

import java.io.*;
import java.util.Arrays;

public class Num_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            System.out.println(arr[i]);
        }
        br.close();
        bw.flush();
        bw.close();
    }

}
