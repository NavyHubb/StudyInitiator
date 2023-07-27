package NavyHubb.week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13549_숨바꼭질3 {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(N);

        int[] visited = new int[100_001];
        visited[N] = 1;

        while (!que.isEmpty()) {
            int now = que.poll();

            if (now == K) {
                return visited[now] - 1;
            }

            int next;
            for (int i = 0; i < 2; i++) {
                if (i == 0)     next = now-1;
                else            next = now+1;

                if (next < 0 || next > 100_000) {
                    continue;
                }

                if (visited[next] == 0 || visited[next] > visited[now] + 1) {
                    visited[next] = visited[now] + 1;
                    que.add(next);
                }
            }

            next = now*2;
            if (next > 100_000) {
                continue;
            }

            if (visited[next] == 0 || visited[next] > visited[now]) {
                visited[next] = visited[now];
                que.add(next);
            }
        }

        return -1;
    }
}