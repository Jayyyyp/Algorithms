package concept;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DynamicProgramming_Jewel {

    public static void main(String[] args) throws IOException{
		/* 훔쳐야하는 보석이 있다. 각 보석은 무게와 가치를 가지고 있다.
		 배낭을 1개 가지고있으며, 배낭의 최대 무게 제한이 있다.
		 최대 무게를 초과하지 않으면서 가장 가치가 높은 보석들을 배낭에 담아야 한다.
		 어떤 보석은 배낭에 담을수도, 담지않을 수 있지만, 보석을 부분적으로 담는것은 불가능하다.
		 배낭에 담을 수 있는 보석들의 최대가치를 구하세요
		 */

        // 입력 : N은 보석의 수, W는 배낭의 무게제한
        // 다음 N개의 줄에는 각 보석의 무게와 가치가 주어진다. 무게와 가치는 모두 100이하

        // 출력 : 배낭에 담을 수 있는 보석들의 최대가치

        /* ex) 입력 : N = 3(보석의 개수)
         * 	  입력 : W = 5(가방의 무게)
         * 	  첫 번째 보석의 무게와 가치 입력 : 3, 6
         * 	  두 번째 보석의 무게와 가치 입력 : 4, 5
         *    세 번째 보석의 무게와 가치 입력 : 1, 1
         *
         *    결과 = 7
         *    */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 보석의 수
        int W = Integer.parseInt(br.readLine()); // 배낭의 무게제한

        int[] weights = new int[N + 1]; // 보석의 무게
        int[] values = new int[N + 1]; // 보석의 가치
        int[][] dp = new int[N + 1][W + 1];
        // 동적 프로그래밍을 위한 2차원 배열 dp를 선언한다.
        // dp[i]{j]는 i개의 보석과 j개의 무게 제한을 가진 배낭을 가지고 얻을 수 있는 최대 가치를 저장

        for(int i = 1; i <= N; i++) { // 보석의 수만큼 각 보석의 무게와 가치 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine()); // 공백으로 문자분리
            weights[i] = Integer.parseInt(st.nextToken()); // 무게
            values[i] = Integer.parseInt(st.nextToken()); // 가치
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= W; j++) {
                if(j < weights[i]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
                }
            }
        }
        bw.write(String.valueOf(dp[N][W]));
        bw.flush();
        br.close();
        bw.close();
    }

}
