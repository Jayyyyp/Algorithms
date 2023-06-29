package recoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OX_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String arr[] = new String[T];

        for(int i = 0; i < T; i++){
            arr[i] = br.readLine();
        }
        for (String s : arr) {
            int count = 0;
            int sum = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    count++;
                } else {
                    count = 0;
                }
                sum += count;
            }
            System.out.println(sum);
        }

        br.close();
    }
}
