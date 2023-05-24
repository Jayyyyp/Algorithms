package recoding;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue_rere {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int last = 0;

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch(command){
                case "push":
                   last = Integer.parseInt(st.nextToken());
                   q.offer(last);
                    break;
                case "pop":
                    bw.write((q.isEmpty()? -1 : q.poll()) + "\n");
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    bw.write((q.isEmpty()? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write((q.isEmpty()? -1 : q.peek()) + "\n");
                    break;
                case "back":
                    bw.write((q.isEmpty()? -1 : last) + "\n");
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
