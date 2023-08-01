package NavyHubb.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10971_외판원순회2 {

    static int N;
    static int[][] wage;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        wage = new int[N][];
        for (int i = 0; i < N; i++) {
            wage[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, i, 0, 0);
        }

        System.out.println(min);
    }

    /**
     * @param start - 시작 노드
     * @param now - 현재 노드
     * @param cost - 현재 노드까지의 이동에 소비된 누적 비용
     * @param visitCnt - 현재 노드까지 방문한 노드 개수
     */
    static void dfs(int start, int now, int cost, int visitCnt) {
        // 모든 노드를 방문한 경우
        if (visitCnt == N-1) {
            if (wage[now][start] != 0) {
                min = Math.min(min, cost + wage[now][0]);  // 마지막에서 처음 노드로 가는 비용 더하여 최솟값 갱신
            }
        }

        for (int i = 1; i < N; i++) {
            // 아직 방문하지 않은 노드이면서 해당 노드로 이동할 수 있는 경우
            if (!visited[i] && wage[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, cost + wage[now][i], visitCnt+1);
                visited[i] = false;
            }
        }
    }

}