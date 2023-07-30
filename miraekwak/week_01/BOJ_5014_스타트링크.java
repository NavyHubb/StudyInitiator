package miraekwak.week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_5014_스타트링크 {
    private static int F, S, G, U, D;
    private static final int MAX_VALUE = 1000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        F = Integer.parseInt(line[0]);
        S = Integer.parseInt(line[1]);
        G = Integer.parseInt(line[2]);
        U = Integer.parseInt(line[3]);
        D = Integer.parseInt(line[4]);

        System.out.println(bfs());
    }

    private static String bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(S);

        int[] visited = new int[F+1];
        visited[S] = 1;

        while(!queue.isEmpty()) {
            int curr = queue.remove();

            if(curr == G) {
                return String.valueOf(visited[G]-1);
            }

            if(curr + U <= F ) {
                if(visited[curr+U] == 0) {
                    visited[curr+U] = visited[curr]+1;
                    queue.add(curr+U);
                }
            }
            if(curr - D > 0) {
                if(visited[curr-D] == 0) {
                    visited[curr-D] = visited[curr] + 1;
                    queue.add(curr-D);
                }
            }
        }
        return "use the stairs";
    }
}
