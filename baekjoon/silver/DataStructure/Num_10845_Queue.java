package baekjoon.silver.DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*QUEUE : 데이터를 임시 저장하는 자료구조
 		  FIFO 구조(먼저 저장된 데이터가 먼저 추출)
 */
public class Num_10845_Queue {
    static int[] queue; // 큐 구현 배열
    static int size = 0; // 큐 크기 변수
    static int front = 0; // 큐의 앞을 가리키는 변수(출력)
    static int back = 0; // 큐의 뒤를 가리키는 변수(입력)

    public static void push(int num) { // 큐의 front에 데이터 추가
        queue[back++] = num; // 큐의 back 데이터 위치에 데이터 저장
        size++; // 큐의 크기를 1 증가
    }

    public static int pop() { // 큐의 front에 있는 데이터를 제거
        if(size == 0) { // 비어있으면
            return -1; // -1 반환
        } else { // 비어있지 않으면
            size--; // 큐의 크기를 1 감소시키고,
            return queue[front++]; // front 데이터 반환 후, front 위치 1 증가
        }
    }

    public static int size() { // 큐의 현재 크기 반환
        return size;
    }

    public static int empty() { // 큐가 비어있는지 확인
        return size == 0 ? 1 : 0;
        // if(size ==0){return 1;}else{return 0}
    }

    public static int front() { // 큐의 front에 있는 데이터 반환
        if(size == 0) { // 큐가 비어있으면,
            return -1; // -1을 반환하고
        } else { // 큐가 비어있지 않으면,
            return queue[front]; // front의 데이터 반환
        }
    }

    public static int back() { // 큐의 back에 있는 데이터 반환
        if(size == 0) { // 큐가 비어있다면,
            return -1; // -1 반환
        } else { // 큐가 비어있지 않다면,
            return queue[back-1]; // back 위치 바로 앞의 데이터 반환
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        queue = new int[N];

        for(int i = 0; i < N; i++) { // N만큼 반복하는 반복문
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) { // Switch Case를 활용한 명령어 실행
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(pop() + "\n");
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

