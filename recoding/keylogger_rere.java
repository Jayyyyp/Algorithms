package recoding;

import java.io.*;
import java.util.Stack;

public class keylogger_rere {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++){
            String command = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for(char ch : command.toCharArray()){
                switch (ch){
                    case '<':
                        if(!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if(!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if (!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(ch);
                }
            }
            while(!left.isEmpty()) right.push(left.pop());
            StringBuilder sb = new StringBuilder();
            while(!right.isEmpty()) sb.append(right.pop());

            bw.write(sb.toString());
            bw.write("\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
