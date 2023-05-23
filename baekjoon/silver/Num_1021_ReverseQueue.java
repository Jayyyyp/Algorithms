package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num_1021_ReverseQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] index = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            index[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> dq = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }

        int min = 0;

        for (int i = 0; i < m; i++) {
            int peek = dq.indexOf(index[i]);
            while (dq.get(0) != index[i]) {
                if (peek <= dq.size() / 2) { // 뽑으려는 인덱스가 맨 앞 인덱스 숫자보다 작거나 같은 경우
                    dq.add(dq.size(), dq.get(0)); // 오른쪽으로 이동
                    dq.remove(0);
                } else {
                    dq.add(0, dq.get(dq.size() - 1)); // 왼쪽으로 이동
                    dq.remove(dq.size() - 1);
                }
                min += 1;

                // 큐의 상태를 출력합니다.
                System.out.println(dq.toString() +"\n" + min + "\n");
            }
            dq.remove(0);
        }

        System.out.println("답은 " + min);
    }
}
