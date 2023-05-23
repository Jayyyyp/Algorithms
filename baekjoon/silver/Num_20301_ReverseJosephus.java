package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Num_20301_ReverseJosephus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        boolean reverse = true;
        int idx = 0;

        for (int i = 0; i < N; i++) {
            if (reverse) {
                idx = (idx + K - 1) % list.size();
            } else {
                idx = (idx - K + list.size()) % list.size();
                if (idx < 0) {
                    idx += list.size();
                }
            }

            sb.append(list.remove(idx));

            if ((i + 1) % M == 0) {
                reverse = !reverse;
            }

            if (!list.isEmpty()) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
