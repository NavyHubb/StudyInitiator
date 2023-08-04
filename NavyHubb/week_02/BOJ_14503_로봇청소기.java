package NavyHubb.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int[][] map;
    static int N, M, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        cnt = 0;
        dfs(r, c, d);

        System.out.println(cnt);
    }

    static void dfs(int r, int c, int d) {
        if (map[r][c] == 0) {
            map[r][c] = 2;
            cnt++;
        }

        // 주변에 청소되지 않은 빈칸이 있는지
        for (int i = 0; i < 4; i++) {
            d = (d+3) % 4;

            int nr = r + di[d];
            int nc = c + dj[d];

            // 청소가 안된 칸인 경우
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                dfs(nr, nc, d);
                return;
            }
        }

        // 여기까지 코드가 도달하는 경우는
        // 네 방향 모두 청소가 되어 있거나
        // 벽인 경우
        int back = (d+2) % 4;  // 후진
        int br = r + di[back];
        int bc = c + dj[back];

        // 후진할 수 있으면서
        if (br >= 0 && br < N && bc >= 0 && bc < M && map[br][bc] != 1) {
            dfs(br, bc, d);
        }
    }

}