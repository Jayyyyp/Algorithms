package baekjoon.silver.DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num_1158_Josephus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        // LinkedList를 이용한 queue 구현

        // 모든 사람을 큐에 넣는다.
        for (int i = 1; i <= N; i++) {
            queue.offer(i); // 큐의 끝에 i 요소 추가
        }

        StringBuilder sb = new StringBuilder();
        // 새로운 문자열을 계속 생성하게 되면 성능이 저하될 수 있으므로,
        // StringBuffer을 사용하여 내부의 문자열 버퍼를 직접 변경해 메모리 사용량을 줄이고 성능을 향상
        sb.append("<");

        // 큐가 빌 때까지 반복한다.
        while (!queue.isEmpty()) {
            // K - 1번째 사람까지는 맨 뒤로 보낸다.
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll()); // 큐 끝에 (큐의 첫번째 요소를 제거하고 반환한 값) 추가
            }

            // K번째 사람을 제거한다.
            sb.append(queue.poll()); // 큐의 첫번째 요소 제거

            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}
