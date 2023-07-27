package NavyHubb.week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질2 {

    static int N;
    static int K;
    static int[] times = new int[100_001];
    static int minTime;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N-K);
            System.out.println(1);
            return;
        }

        bfs();
        System.out.println(minTime-1);
        System.out.println(cnt);
    }

    static void bfs() {
        minTime = 0;

        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        times[N] = 1;

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (cur == K) {
                minTime = times[cur];
                cnt++;
                continue;
            }

            int next;
            for (int i = 0; i < 3; i++) {
                if (i == 0)         next = cur - 1;
                else if (i == 1)    next = cur + 1;
                else                next = cur * 2;

                if (next < 0 || next > 100_000) {
                    continue;
                }

                if (times[next] == 0 || times[next] >= times[cur] + 1) {
                    times[next] = times[cur] + 1;
                    que.add(next);
                }
            }
        }
    }
}
