package recoding;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Editor_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        // String[] editor = N.split("");

        for(char s : N.toCharArray()){
            left.push(s);
        }

        for(int i = 0; i < M; i++){
            String command = br.readLine();
            StringTokenizer st = new StringTokenizer(command," ");
            char word = st.nextToken().charAt(0);

            switch (word){
                case 'L':
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case 'D':
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case 'B':
                    if(!left.isEmpty()) left.pop();
                    break;
                case 'P':
                    char ch = st.nextToken().charAt(0);
                    left.push(ch);
                    break;
                default:
                    break;
            }
        }
        while(!left.isEmpty()) right.push(left.pop());
        while(!right.isEmpty()) bw.write(right.pop());

        bw.flush();
        bw.close();
    }
}
