package baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Num_1406_Editor{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<String> LS = new Stack<String>();
        Stack<String> RS = new Stack<String>();

        String[] arr = str.split(""); // split() 메소드 : 문자 단위로 분리
        for(String s : arr) {
            LS.push(s);
        }

        for(int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch(c) {
                case 'L':
                    if(!LS.isEmpty())
                        RS.push(LS.pop());

                    break;
                case 'D':
                    if(!RS.isEmpty())
                        LS.push(RS.pop());

                    break;
                case 'B':
                    if(!LS.isEmpty()) {
                        LS.pop();
                    }
                    break;
                case 'P':
                    char ch = command.charAt(2);
                    LS.push(String.valueOf(ch));
                    //LS.push(st.nextToken());

                    break;
                default:
                    break;
            }
        }

        // 왼쪽 스택에 있는 데이터들을 모두 오른쪽 스택으로 옮겨 모든 내용을 출력
        while(!LS.isEmpty())
            RS.push(LS.pop());

        while(!RS.isEmpty())
            bw.write(RS.pop());

        bw.flush();
        bw.close();
    }
}
