package recoding;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Deque_rerere {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> d = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            switch (cmd){
                case "push_front":
                    int x = Integer.parseInt(st.nextToken());
                    d.offerFirst(x);
                    break;
                case "push_back":
                    int y = Integer.parseInt(st.nextToken());
                    d.offerLast(y);
                    break;
                case "pop_front":
                    bw.write((d.isEmpty()? -1 : d.pollFirst()) + "\n");
                    break;
                case "pop_back":
                    bw.write((d.isEmpty()? -1 : d.pollLast()) + "\n");
                    break;
                case "size":
                    bw.write(d.size() + "\n");
                    break;
                case "empty":
                    bw.write((d.isEmpty()? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write((d.isEmpty()? -1 : d.peekFirst()) + "\n");
                    break;
                case "back":
                    bw.write((d.isEmpty()? -1 : d.peekLast()) + "\n");
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
