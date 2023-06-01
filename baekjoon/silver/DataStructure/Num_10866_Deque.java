package baekjoon.silver.DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*DEQUE : 데이터를 양쪽 끝에서 모두 데이터를 추가하거나 제거할 수 있는 자료구조
 		 원형 덱 :  배열의 처음과 끝이 연결되어 있는 것처럼 사용하는 방법
 		 이렇게 하면 배열의 시작 부분을 활용할 수 있게 되므로 메모리 사용량을 줄일 수 있다.
 		 front와 back 인덱스를 계산할 때 % deque.length를 사용하여 원형 덱으로 만들기
 		 이 연산은 배열의 길이로 나눈 나머지를 계산하므로, 인덱스가 배열의 길이를 초과하게 되면
 		 자동으로 0으로 돌아가게 된다. (배열의 끝과 시작이 연결된 것처럼 동작)
 		 */

public class Num_10866_Deque {
    static int[] deque; // 덱을 구현하는데 사용되는 배열
    static int size = 0; // 덱의 크기 변수
    static int front = 0; // 덱의 가장 앞의 변수
    static int back = 0; // 덱의 뒤를 가리키는 변수

    public static void push_front(int num) { // 덱의 앞쪽에 데이터를 추가
        front = (front - 1 + deque.length) % deque.length;
        // front 위치를 감소시키며(원형 덱 구현을 위해 배열의 길이로 나눈 나머지를 구함)
        deque[front] = num; // 덱의 front 위치에 num 값 저장
        size++; // 덱의 크기를 1 증가
    }

    public static void push_back(int num) { // 덱의 뒤쪽에 데이터를 추가
        deque[back] = num; // num을 back의 위치에 데이터 저장
        back = (back + 1) % deque.length;
        // back의 위치를 증가시켜(원형 덱 구현을 위해 배열의 길이로 나눈 나머지를 구함)
        size++; // 덱의 크기를 1 증가
    }

    public static int pop_front() { // 덱의 앞쪽에서 데이터를 제거
        if (size == 0) { // 덱이 비어있으면
            return -1; // -1 반환
        } else { // 덱이 비어있지 않으면
            int outNum = deque[front];
            front = (front + 1) % deque.length; // front 위치를 1 증가시키고,
            size--; // 덱의 크기를 1 감소
            return outNum; // front의 데이터 반환
        }
    }

    public static int pop_back() { // 덱의 뒤쪽에서 데이터를 제거하는 작업
        if (size == 0) { // 덱이 비어있으면,
            return -1; // -1을 반환하고
        } else { // 그렇지 않으면
            back = (back - 1 + deque.length) % deque.length;
            int outNum = deque[back];
            // back의 위치 바로앞의 데이터를 반환하고, back 위치를 1 감소시키고,
            size--; // 덱의 크기 1 감소
            return outNum; // back 위치 바로 앞의 데이터 반환
        }
    }

    public static int size() { // 덱의 현재 크기 반환
        return size;
    }

    public static int empty() { // 덱이 비어있는지 확인
        if (size == 0) { // 비어있으면,
            return 1; // 1 반환
        } else { // 비어있지 않으면,
            return 0; // 0 반환
        }
    }

    public static int front() { // 덱의 앞쪽에 있는 데이터 반환
        if (size == 0) { // 덱이 비어있으면
            return -1; // -1 반환
        } else { // 덱이 비어있지 않으면
            return deque[front]; // front 위치의 데이터 반환
        }
    }

    public static int back() { // 덱의 뒤쪽에 있는 데이터를 반환
        if (size == 0) { // 덱이 비어있으면,
            return -1; // -1을 반환
        } else { // 덱이 비어있지 않으면,
            return deque[(back - 1 + deque.length) % deque.length];
            // back의 위치 바로 앞의 데이터를 반환
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        deque = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    bw.write(pop_front() + "\n");
                    break;
                case "pop_back":
                    bw.write(pop_back() + "\n");
                    break;
                case "size":
                    bw.write(size() + "\n");
                    break;
                case "empty":
                    bw.write(empty() + "\n");
                    break;
                case "front":
                    bw.write(front() + "\n");
                    break;
                case "back":
                    bw.write(back() + "\n");
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
