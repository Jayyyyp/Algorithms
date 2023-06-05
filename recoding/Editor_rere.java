package recoding;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Editor_rere {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int commandCount = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char innerStack:input.toCharArray()) {
            leftStack.push(innerStack);
        }

        for(int i = 1; i <= commandCount; i++){
            String command = br.readLine();
            StringTokenizer st = new StringTokenizer(command, " ");
            char realCommand = st.nextToken().charAt(0);

            switch (realCommand){
                case 'L':
                    if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) leftStack.pop();
                    break;
                case 'P':
                    char ch = st.nextToken().charAt(0);
                    leftStack.push(ch);
                    break;
                default:
                    break;
            }
        }
        while (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
        while (!rightStack.isEmpty()) bw.write(rightStack.pop());

        br.close();
        bw.flush();
        bw.close();
    }
}
