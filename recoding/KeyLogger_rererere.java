package recoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class KeyLogger_rererere {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++){
            Stack<Character> LS = new Stack<>();
            Stack<Character> RS = new Stack<>();
            String L = br.readLine();
            for(var word:L.toCharArray()){
                switch (word) {
                    case '<' -> {
                        if (!LS.isEmpty()) RS.push(LS.pop());
                    }
                    case '>' -> {
                        if (!RS.isEmpty()) LS.push(RS.pop());
                    }
                    case '-' -> {
                        if (!LS.isEmpty()) LS.pop();
                    }
                    default -> LS.push(word);
                }
            }
            while (!LS.isEmpty())RS.push(LS.pop());
            while (!RS.isEmpty())sb.append(RS.pop());
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
