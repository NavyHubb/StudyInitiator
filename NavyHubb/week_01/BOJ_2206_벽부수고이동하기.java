package NavyHubb.week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2206_벽부수고이동하기 {

    static int N, M;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> que = new LinkedList<>();
        int[][][] visited = new int[N][M][2];

        que.add(new int[]{0, 0, 1});  // 행, 열, 벽을 부술 수 있는 횟수
        visited[0][0][1] = 1;

        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int i = now[0], j = now[1], k = now[2];

            if (i == N-1 && j == M-1) {
                return visited[i][j][k];
            }

            for (int l = 0; l < 4; l++) {
                int newI = i + di[l];
                int newJ = j + dj[l];

                if (newI < 0 || newJ < 0 || newI > N-1 || newJ > M-1) {
                    continue;
                }

                if (visited[newI][newJ][k] > 0) {
                    continue;
                }

                if (map[newI][newJ] == '0') {
                    visited[newI][newJ][k] = visited[i][j][k] + 1;
                    que.add(new int[]{newI, newJ, k});
                }
                // 벽이지만 벽을 부술 수 있는 기회가 남아있는 경우
                // 기회를 사용하여 이동
                else if (map[newI][newJ] == '1' && k == 1) {
                    visited[newI][newJ][0] = visited[i][j][1] + 1;
                    que.add(new int[]{newI, newJ, 0});
                }
            }
        }

        return -1;
    }
}