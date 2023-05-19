package concept;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Fibonacci {
    static BufferedWriter bw;

    public static int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }else if(n == 1) {
            return 1;
        }else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    public static int fibonacciPercentQ(int p, int q) {
        int m= fibonacci(p) % q;
        return m;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            bw.write("Case #" + i + ": " + fibonacciPercentQ(P, Q) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }

}
