package miraekwak.week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 입력 >
 * N, M, V (정점의 개수, 간선의 개수, 탐색 시작 정점)
 * (간선을 연결하는 두 정점의 번호) * M 개
 * 출력 >
 * dfs 탐색 시 정점 순서
 * bfs 탐색 시 정점 순서
 * 풀이 >
 * 재귀를 활용한 dfs 구현
 * queue를 활용한 bfs 구현
 */
public class BOJ_1260_DFS와BFS {
    private static int N, M, V; // 정점의 개수, 간선의 개수, 탐색 시작 번호
    private static boolean[][] edgeMap; // 간선 연결 여부 맵
    private static boolean[] visited; // 방문 표시 맵
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] order = br.readLine().split(" ");
        N = Integer.parseInt(order[0]);
        M = Integer.parseInt(order[1]);
        V = Integer.parseInt(order[2]);
        edgeMap = new boolean[N+1][N+1];

        for(int i=0; i<M; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]), b = Integer.parseInt(line[1]);
            // 양방향 연결
            edgeMap[a][b] = true;
            edgeMap[b][a] = true;
        }

        sb = new StringBuilder();

        // dfs 시작
        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");

        // bfs 시작
        visited = new boolean[N+1];
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int std) {
        visited[std] = true;
        sb.append(std+" ");
        for(int i=1; i<=N ; i++) {
            if(edgeMap[std][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int std) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(std);
        visited[std] = true;
        while(!queue.isEmpty()) {
            int vertex = queue.remove();
            sb.append(vertex + " ");
            for (int i = 1; i <= N; i++) {
                if (edgeMap[vertex][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
