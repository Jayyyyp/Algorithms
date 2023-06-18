package recoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Editor_rerere {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> LS = new Stack<>();
        Stack<Character> RS = new Stack<>();

        String base = br.readLine(); // abcd
        for(var v:base.toCharArray()){
            LS.push(v);
        }
        int command = Integer.parseInt(br.readLine());
            for(int i = 1; i <= command; i++) {
                String realCommand = br.readLine();
                StringTokenizer st = new StringTokenizer(realCommand);
                char realRealCommand = st.nextToken().charAt(0);

                switch (realRealCommand) {
                    case 'P':
                        char ch = st.nextToken().charAt(0);
                        LS.push(ch);
                        break;
                    case 'L':
                        if (!LS.isEmpty()) RS.push(LS.pop());
                        break;
                    case 'D':
                        if (!RS.isEmpty()) LS.push(RS.pop());
                        break;
                    case 'B':
                        if (!LS.isEmpty()) LS.pop();
                        break;
                    default:
                        break;
                }
            }
                while (!LS.isEmpty()) RS.push(LS.pop());
                while (!RS.isEmpty()) sb.append(RS.pop());

        System.out.println(sb.toString());
        br.close();
    }
}
