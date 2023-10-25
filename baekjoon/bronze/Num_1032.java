package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int line = Integer.parseInt(br.readLine());

        String[] arr = new String[line];
        for(int i=0; i<line; i++){
            arr[i] = br.readLine();
        }

        boolean pattern = true;
        for(int i=0; i<arr[0].length(); i++){
            for(int j=0; j<line; j++){
                if(arr[0].charAt(i) != arr[j].charAt(i)){
                    pattern = false;
                    break;
                }
            }

            if(pattern){
                System.out.print(arr[0].charAt(i));
            } else{
                System.out.print('?');
                pattern = !pattern;
            }
        }
    }
}
