package NavyHubb.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2098_외판원순회 {

    static int N;
    static int[][] wage;
    static int[][] dp;
    static int statusFull;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        wage = new int[N][];
        for (int i = 0; i < N; i++) {
            wage[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        statusFull = (1<<N) - 1;
        dp = new int[N][statusFull];  // 현재 있는 도시, 이미 방문한 도시의 집합
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        // 0번 도시부터 탐색시작. 0번도시 방문처리
        System.out.println(dfs(0, 1));
    }


    /**
     * @param now 현재 위치한 도시의 인덱스
     * @param status 지금까지 방문한 도시 정보
     * @return dp[now][status] 현재 있는 도시에서 출발하여 아직 방문하지 않은 도시들을 모두 방문한 뒤 출발 도시로 돌아오는 데 드는 최소비용
     */
    static int dfs(int now, int status) {
        // 모든 도시를 방문한 경우
        if (status == statusFull) {
            if (wage[now][0] == 0) return INF;  // 출발 도시로 돌아가는 경로가 없으면 INF로 탐색 무효화
            else return wage[now][0];
        }

        // 이미 방문한 도시이면 저장되어 있는 값 반환
        if (dp[now][status] != -1) return dp[now][status];

        // 현재 도시에 방문 처리
        dp[now][status] = INF;

        // 현재 도시에서 다른 도시로 이동
        for (int i = 0; i < N; i++) {
            if ((status & (1<<i)) == 0 && wage[now][i] != 0) {  // 아직 방문하지 않은 도시이면서 이동 가능한 경우
                dp[now][status] = Math.min(dp[now][status], dfs(i, status | (1<<i)) + wage[now][i]);
            }
        }

        return dp[now][status];
    }

}