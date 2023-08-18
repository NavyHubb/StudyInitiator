package NavyHubb.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N];
        int[] P = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 각 날짜까지 얻을 수 있는 최대 수익
        // T, P는 길이가 N인 반면, dp는 길이가 N + 1인 이유는 일을 마친 다음날에야 보수를 받기 때문
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {

            // 상담을 마쳤을 때 날짜의 범위를 벗어나지 않는 경우
            // 보다 직관적인 수식은 아래와 같지만 편의상 상수항을 소거한다
            // i + T[i] - 1 <= N - 1
            if (i + T[i] <= N) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }

            // i + 1 번째 날에 일할 수 없다면, 그 전날까지 일한 최대 수당을 입력
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[N]);
    }
}
