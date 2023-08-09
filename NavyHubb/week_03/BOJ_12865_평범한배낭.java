package NavyHubb.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 이전 아이템을 탐색할 때의 값을 보존하기 위해 역순으로 탐색
            // 탐색의 범위는 현재 아이템의 무게 이상으로만 시행
            for (int j = K; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j- w] + v);
            }
        }

        System.out.println(dp[K]);
    }
    
}
