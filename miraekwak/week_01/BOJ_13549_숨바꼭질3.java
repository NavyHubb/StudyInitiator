package miraekwak.week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;


public class BOJ_13549_숨바꼭질3 {

    private static final int MAX_VALUE = 100_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        System.out.println(bfs(N, K));
    }

    private static int bfs(int from, int to) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);

        int[] visited = new int[MAX_VALUE+1];
        visited[from] = 1;

        while(!queue.isEmpty()) {
            int curr = queue.remove();

            if(curr == to) {
                return visited[curr] -1;
            }

            if(curr-1 >= 0 && (visited[curr-1] == 0 || visited[curr-1] >= visited[curr]+1)) {
                visited[curr-1] = visited[curr] +1;
                queue.add(curr-1);
            }
            if(curr+1 <= MAX_VALUE && (visited[curr+1] == 0 || visited[curr+1] >= visited[curr]+1)) {
                visited[curr+1] = visited[curr] +1;
                queue.add(curr+1);
            }
            if(curr*2 <= MAX_VALUE && (visited[curr*2] == 0 || visited[curr*2] >= visited[curr])) {
                visited[curr*2] = visited[curr];
                queue.add(curr*2);
            }
        }
        return -1;

    }
}