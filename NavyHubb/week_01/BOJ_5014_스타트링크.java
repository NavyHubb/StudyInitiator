package NavyHubb.week_01;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5014_스타트링크 {

    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();  // 총 층수
        S = sc.nextInt();  // 현재 위치
        G = sc.nextInt();  // 목적지
        U = sc.nextInt();  // 위로 U개층 이동
        D = sc.nextInt();  // 아래로 D개층 이동

        int result = bfs();
        System.out.println(result == -1 ? "use the stairs" : result-1);
    }

    static int bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(S);

        int[] times = new int[F+1];
        times[S] = 1;

        while (!que.isEmpty()) {
            int now = que.poll();

            if (now == G) {
                return times[G];
            }

            int next;
            for (int i = 0; i < 2; i++) {
                if (i == 0)     next = now + U;
                else            next = now - D;

                if (next <= 0 || next > F) {
                    continue;
                }

                if (times[next] == 0) {
                    times[next] = times[now] + 1;
                    que.add(next);
                }
            }
        }

        return -1;
    }

}