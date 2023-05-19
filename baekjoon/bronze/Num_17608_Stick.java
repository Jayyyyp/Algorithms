package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_17608_Stick {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int StickArr[] = new int [T];

        for(int i = 0; i < T; i++) {
            StickArr[i] = Integer.parseInt(br.readLine());
        }
        int frontStick = StickArr[T-1]; // 가장 오른쪽의 막대를 기준으로 설정
        int count = 1; // 가장 오른쪽의 막대는 보이니까 1로 초기화
        for(int j = T - 2; j >= 0; j--) { // 오른쪽에서 왼쪽으로 이동하며 검사
            // 가장 오른쪽 막대를 기준으로 잡았기때문에, 비교대상에서 제외하고 -2를 쓰면 데이터 절약가능
            if(StickArr[j] > frontStick) { // 현재 막대가 최대막대보다 길다면,
                frontStick = StickArr[j]; // 현재 막대를 최대 막대로 바꾸고,
                count++; // 보이는 막대의 수 증가
            }
        }
        br.close();
        System.out.println(count);

    }

}
