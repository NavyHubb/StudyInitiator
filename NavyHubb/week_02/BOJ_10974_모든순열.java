package NavyHubb.week_02;

import java.util.Scanner;

public class BOJ_10974_모든순열 {

    static int N;
    static boolean[] visited;
    static int[] output;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N+1];
        output = new int[N+1];
        sb = new StringBuilder();

        dfs(1);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == N+1) {
            print();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    static void print() {
        for (int i = 1; i <= N; i++) {
            sb.append(output[i]).append(' ');
        }
        sb.append('\n');
    }

}