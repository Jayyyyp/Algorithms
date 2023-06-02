package recoding;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue <Integer> queue = new LinkedList<>();

        int last = 0;

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command){
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    queue.offer(last);
                    break;
                case "pop":
                    bw.write((queue.isEmpty() ? -1 : queue.poll()) + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    bw.write((queue.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write((queue.isEmpty()? -1 : queue.peek()) + "\n");
                    break;
                case "back":
                    bw.write((queue.isEmpty() ? -1 : last) + "\n");
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
