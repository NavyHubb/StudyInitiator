package NavyHubb.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971_외판원순회2 {

    public static int N;
    public static int[][] wage;
    public static int[] arr;
    public static boolean[] visit;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        wage = new int[N][N];
        arr = new int[N];
        visit = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                wage[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            visit[i] = true;
            dfs(i, i, 0);
        }

        System.out.println(min);
    }

    /**
     * @param start : 순회를 시작한 도시
     * @param now : 현재 위치한 도시
     * @param cost : 현재까지의 비용 누적합
     */
    public static void dfs(int start, int now, int cost) {
        if (allVisit()) {
            if (wage[now][start] != 0) {
                min = Math.min(min, cost + wage[now][0]);
            }
            return;
        }

        for (int i = 1; i < N; i++) {
            if (!visit[i] && wage[now][i] != 0) {
                visit[i] = true;
                dfs(start, i, cost + wage[now][i]);

                visit[i] = false;
            }
        }
    }

    public static boolean allVisit() {
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                return false;
            }
        }
        return true;
    }

}