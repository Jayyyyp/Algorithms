package baekjoon.bronze;

import java.io.*;

public class Num_1434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sizes = br.readLine().split(" ");
        int n = Integer.parseInt(sizes[0]);
        int m = Integer.parseInt(sizes[1]);

        int remainingSpace = 0;

        String[] boxesStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            remainingSpace += Integer.parseInt(boxesStr[i]);
        }

        String[] booksStr = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            remainingSpace -= Integer.parseInt(booksStr[i]);
        }

        bw.write(String.valueOf(remainingSpace));
        bw.flush();
        bw.close();
    }
}
