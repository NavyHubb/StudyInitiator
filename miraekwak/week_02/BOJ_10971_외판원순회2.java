package miraekwak.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10971_외판원순회2 {
    private static int N;
    private static int[][] w;
    private static boolean[] visited;
    private static final int MAX_VALUE = 10_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        w = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                w[i][j] = Integer.parseInt(line[j]);
            }
        }
        visited = new boolean[N];
        int min_weight = MAX_VALUE;
        for(int i=0; i<N; i++) {
            visited[i] = true;
            min_weight = Math.min(min_weight, dfs(0, i, i, 0));
            visited[i] = false;
        }
        System.out.println(min_weight);
    }

    private static int dfs(int cnt, int str, int curr, int price) {
        if(cnt == N-1) {
            if(w[curr][str] != 0) {
                return price + w[curr][str];
            }
        }

        int weight = MAX_VALUE;
        for(int i=0; i<N; i++) {
            if(w[curr][i] == 0) continue;
            if(visited[i]) continue;
            visited[i] = true;
            int result = dfs(cnt+1, str, i, price+w[curr][i]);
            weight = Math.min(weight, result);
            visited[i] = false;
        }
        return weight;
    }
}
