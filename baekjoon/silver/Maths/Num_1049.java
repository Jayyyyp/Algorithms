package baekjoon.silver.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int packages = 1001;
        int each = 1001;
        for(int i = 0;i < M; i++){
            st = new StringTokenizer(in.readLine());
            packages = Math.min(packages, Integer.parseInt(st.nextToken()));
            each = Math.min(each, Integer.parseInt(st.nextToken()));
        }

        if(each * 6 < packages){
            System.out.println(each*N);
            return;
        }

        int total = packages * (N / 6);
        total += Math.min(N % 6 * each, packages);
        System.out.println(total);
    }
}
