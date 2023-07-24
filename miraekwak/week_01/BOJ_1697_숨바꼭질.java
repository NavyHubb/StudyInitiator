package miraekwak.week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제 >
 * x-1, x+1, x*2 로 이동할 수 있을 때 최소 시간
 * 입력 >
 * N(0<=N<=100,000), K(0<=K<=100,000)
 * 출발 점, 도착 점
 * 출력 >
 * 최소 시간
 */
public class BOJ_1697_숨바꼭질 {
    private static final int MAX_VALUE = 100000; // N, K 최대 값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        System.out.println(bfs(N, K));
    }
    private static int bfs(int from, int to) {
        // bfs 탐색으로 최단 시간 찾기
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        // 최단 시간 저장 배열
        // 방문 안함 : 0, 방문함 : 1~100,000
        int[] visited = new int[MAX_VALUE + 1];
        visited[from] = 1;
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            if (curr == to) {
                return visited[curr] - 1;
            }
            if (curr - 1 >= 0 && visited[curr - 1] == 0) {
                visited[curr - 1] = visited[curr] + 1;
                queue.add(curr - 1);
            }
            if (curr + 1 <= MAX_VALUE && visited[curr + 1] == 0) {
                visited[curr + 1] = visited[curr] + 1;
                queue.add(curr + 1);
            }
            if (curr * 2 <= MAX_VALUE && visited[curr * 2] == 0) {
                visited[curr * 2] = visited[curr] + 1;
                queue.add(curr * 2);
            }
        }
        return -1;
    }
}
