package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_1100 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        int cnt=0;
        for(int i=0;i<8;i++) {
            line = br.readLine();

            if(i%2==0) { //0,2,4,6
                for(int j=0;j<=6;j+=2) {
                    if(line.charAt(j)=='F') cnt++;
                }
            } else { //1,3,5,7
                for(int j=1;j<=7;j+=2) {
                    if(line.charAt(j)=='F') cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
