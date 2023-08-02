package NavyHubb.week_02;

import java.util.Scanner;

public class BOJ_9095_123더하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        int max = 0;

        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }

}