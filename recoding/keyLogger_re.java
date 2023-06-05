package recoding;

import java.io.*;
import java.util.Stack;

public class keyLogger_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // TestCase

        for(int i = 1; i <= T; i++){
            Stack<Character> LS = new Stack<>();
            Stack<Character> RS = new Stack<>();

            String pw = br.readLine();

            for(char ch : pw.toCharArray()){
                switch (ch){
                    case '<':
                        if(!LS.isEmpty()) RS.push(LS.pop());
                        break;
                    case  '>':
                        if(!RS.isEmpty()) LS.push(RS.pop());
                        break;
                    case  '-':
                        if(!LS.isEmpty())LS.pop();
                        break;
                    default:
                        LS.push(ch);
                }
            }
            while(!LS.isEmpty()) RS.push(LS.pop());
            StringBuilder sb = new StringBuilder();
            while(!RS.isEmpty()) sb.append(RS.pop());

            bw.write(sb.toString());
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
