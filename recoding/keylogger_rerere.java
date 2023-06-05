package recoding;

import java.io.*;
import java.util.Stack;

public class keylogger_rerere {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int commandCount = Integer.parseInt(br.readLine());
        for(int i = 1; commandCount >= i; i++){
            String command = br.readLine();
            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();

            for (char commandStack:command.toCharArray()) {
                switch (commandStack){
                    case '<':
                        if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                            break;
                    case '>':
                        if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                            break;
                    case '-':
                        if(!leftStack.isEmpty())leftStack.pop();
                            break;
                    default:
                        leftStack.push(commandStack);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
            while (!rightStack.isEmpty()) sb.append(rightStack.pop());

            bw.write(sb.toString()+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
