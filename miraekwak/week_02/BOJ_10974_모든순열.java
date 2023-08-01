package miraekwak.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_모든순열 {
    private static int N;
    private static StringBuilder sb;
    private static boolean[] visited;
    private static int[] order;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        visited = new boolean[N];
        order = new int[N];
        permutation(0);
        System.out.println(sb);
    }

    private static void permutation(int cnt) {
        if(cnt == N) {
            for(int i=0; i<N; i++) {
                sb.append(order[i]+" ");
            }
            sb.append("\n");
        }

        for(int i=0; i<N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            order[cnt] = i+1;
            permutation(cnt+1);
            visited[i] = false;
        }
    }
}
