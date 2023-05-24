package recoding;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_rere {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command){
                case "push":
                    s.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write((s.isEmpty()? -1 : s.pop()) + "\n");
                    break;
                case "size":
                    bw.write(s.size() + "\n");
                    break;
                case "empty":
                    bw.write((s.isEmpty()? 1 : 0) + "\n");
                    break;
                case "top":
                    bw.write((s.isEmpty()? -1 : s.peek()) + "\n");
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
