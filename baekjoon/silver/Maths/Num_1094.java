package baekjoon.silver.Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_1094 {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int cm = Integer.parseInt(br.readLine());
            int stick = 64;
            int count = 0;

            while(cm > 0) {
                if(stick > cm) {
                    stick /= 2;
                }
                else{
                    cm -= stick;
                    count++;
                }
            }

            System.out.println(count);

        }catch(IOException e) {
            System.out.println("error");
        }
    }
}
