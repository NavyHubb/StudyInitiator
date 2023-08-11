package miraekwak.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2098_외판원순회 {
    private static int N;
    static final int INF = 16_000_000;
    private static int[][] weight, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weight = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                weight[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][(1<<N)-1];
        for(int i=0; i<N; i++) Arrays.fill(dp[i], -1);

        System.out.println(dfs(0, 1)+"\n");
    }

    static int dfs(int now, int visit) {
        if(visit == (1<<N)-1) {
            if(weight[now][0] == 0) return INF;
            return weight[now][0];
        }

        if(dp[now][visit] != -1) return dp[now][visit];
        dp[now][visit] = INF;

        for(int i=0; i<N; i++) {
            if((visit& (1<<i)) != 0 || weight[now][i] == 0) continue;
            dp[now][visit] = Math.min(dfs(i, visit | (1 << i)) + weight[now][i], dp[now][visit]);
        }
        return dp[now][visit];
    }

}
