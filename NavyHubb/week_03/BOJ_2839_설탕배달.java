package NavyHubb.week_03;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2839_설탕배달 {

    static int N;
    static int[] weights = {3, 5};
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        System.out.println(solution());
    }

    static int solution() {
        int[] dp = new int[N+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int w : weights) {
                if (i >= w && dp[i-w] != INF) {  // 현재 무게 i가 봉지 무게
                    dp[i] = Math.min(dp[i], dp[i-w] + 1);
                }
            }
        }

        return (dp[N] == INF) ? -1 : dp[N];
    }

}