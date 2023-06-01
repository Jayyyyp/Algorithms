package baekjoon.silver.DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Num_5397_KeyLoger {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) { // 테스트케이스 반복문
            Stack<Character> leftStack = new Stack<>(); //
            Stack<Character> rightStack = new Stack<>();

            String input = br.readLine();

            for(char ch : input.toCharArray()) {
                switch(ch) {
                    case '<':
                        if (!leftStack.isEmpty()) {
                            rightStack.push(leftStack.pop());
                        }
                        break;
                    case '>':
                        if (!rightStack.isEmpty()) {
                            leftStack.push(rightStack.pop());
                        }
                        break;
                    case '-':
                        if (!leftStack.isEmpty()) {
                            leftStack.pop();
                        }
                        break;
                    default:
                        leftStack.push(ch);
                }
            }

            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }

            StringBuilder sb = new StringBuilder();
            while (!rightStack.isEmpty()) {
                sb.append(rightStack.pop());
            }

            bw.write(sb.toString());
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
