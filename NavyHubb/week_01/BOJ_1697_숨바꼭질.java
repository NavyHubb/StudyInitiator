package NavyHubb.week_01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {
    static int N, K;
    static int[] times = new int[100_001];

    /*
    N : 시작 지점
    K : 목표 지점
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        sc.close();
        
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        times[N] = 1;  // 0으로 초기화할 경우 아직 방문하지 않은 것과 구분이 어려워지므로 1로 초기화

        while (!que.isEmpty()) {
            int now = que.poll();

            if (now == K) {
                return times[now] - 1;  // 시작 위치에서의 값을 0이 아닌 1로 초기화했으므로 다시 1만큼 빼준다
            }

            int next;
            for (int i = 0; i < 3; i++) {
                if (i == 0)         next = now - 1;
                else if (i == 1)    next = now + 1;
                else                next = now * 2;

                if (next < 0 || next > 100_000) {
                    continue;
                }

                // 아직 방문한 적이 없거나
                // 다음 위치까지 걸리는 시간이 (현재 위치까지 걸리는 시간+1) 이상일 때
                // 값을 갱신해줄 가치가 있다
                if (times[next] == 0 || times[next] >= times[now] + 1) {
                    times[next] = times[now] + 1;
                    que.add(next);
                }
            }
        }

        return -1;
    }
}