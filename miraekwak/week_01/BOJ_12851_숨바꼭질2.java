package miraekwak.week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제 >
 * 최소 시간과 최소 시간을 구하는 방법 개수 구하기
 * 입력 >
 * N(0<=N<=100,000), K(0<=K<=100,000)
 * 출발 점, 도착 점
 * 출력>
 * 최소시간
 * 최소 시간을 구하는 방법 가지수
 */
public class BOJ_12851_숨바꼭질2 {

    private static final int MAX_VALUE = 100_000;
    private static int min_time = -1; // 최소시간
    private static int cnt = 0; // 방법 개수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        bfs(N, K);
        System.out.println(min_time);
        System.out.println(cnt);

    }

    private static void bfs(int from, int to) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);

        int[] visited = new int[MAX_VALUE+1];
        visited[from] = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            // 트리 구조에서 같은 레벨끼리 처리
            while(size-- > 0) {
                int curr = queue.remove();
                if(curr == to) {
                    min_time = visited[curr]-1;
                    cnt++;
                    continue;
                }
                // 방문하지 않았거나 최소 시간이 같은 점을 상대로 탐색
                if(curr-1 >=0) {
                    if(visited[curr-1] == 0 || visited[curr-1] == visited[curr]+1) {
                        visited[curr-1] = visited[curr] +1;
                        queue.add(curr-1);
                    }
                }
                if(curr+1 <= MAX_VALUE) {
                    if(visited[curr+1] == 0 || visited[curr+1] == visited[curr]+1) {
                        visited[curr+1] = visited[curr] +1;
                        queue.add(curr+1);
                    }
                }
                if(curr*2 <= MAX_VALUE) {
                    if(visited[curr*2] == 0 || visited[curr*2] == visited[curr]+1) {
                        visited[curr*2] = visited[curr] +1;
                        queue.add(curr*2);
                    }
                }
            }
            // 해당 레벨에서 값이 구해졌다면 종료
            if(cnt > 0) {
                return;
            }
        }
    }
}
