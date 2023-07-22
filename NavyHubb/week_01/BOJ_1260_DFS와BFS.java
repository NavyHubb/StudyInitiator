package NavyHubb.week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {

    static int N, M, V;
    static boolean[] visisted;
    static int[][] adjMatrix;
    static StringBuilder sb;

    /**
     * start를 시작으로 탐색을 시작했을 때
     * 첫째줄에는 BFS로 탐색한 경로를
     * 둘째줄에는 DFS로 탐색한 경로를 출력한다.
     * 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문한다.
     *
     * N - 정점의 개수
     * M - 간선의 개수
     * V - 시작 노드
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());  // 정점의 개수
        M = Integer.parseInt(st.nextToken());  // 간선의 개수
        V = Integer.parseInt(st.nextToken());  // 시작 노드

        // 인접행렬 초기화
        adjMatrix = new int[N+1][N+1];  // 노드 번호가 1부터 시작하므로 N+1

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 양방향 등록
            adjMatrix[from][to] = 1;
            adjMatrix[to][from] = 1;
        }

        visisted = new boolean[N+1];  // 방문 확인 배열 초기화
        dfs(V);

        sb.append('\n');

        bfs(V);

        System.out.println(sb);
    }

    // 재귀를 이용한 dfs 탐색
    static void dfs(int start) {
        visisted[start] = true;
        sb.append(start).append(' ');

        for (int i = 1; i <= N; i++) {
            if (adjMatrix[start][i] == 1 && !visisted[i]) {
                dfs(i);
            }
        }
    }

    // Stack을 이용한 dfs 탐색
    static void dfsWithStack(int start) {
        Stack<Integer> stack = new Stack<>();
        visisted = new boolean[N+1];

        stack.push(start);

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (!visisted[cur]) {
                visisted[cur] = true;
                sb.append(cur).append(' ');
            }

            for (int i = N; i >= 1; i--) {
                // 현재 노드 cur과 연결된 노드 중 아직 탐색하지 않은 노드를 stack에 삽입
                // 번호가 큰 노드부터 탐색하여 stack에 삽입되므로 자연스럽게 stack에서 추출되는 것은 작은 번호부터 우선적으로 나온다.
                if (adjMatrix[cur][i] == 1 && !visisted[i]) {
                    stack.add(i);
                }
            }
        }
    }

    // Queue를 이용한 bfs 탐색
    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        visisted = new boolean[N+1];

        que.add(start);
        visisted[start] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            sb.append(cur).append(' ');

            for (int i = 1; i <= N; i++) {
                // 현재 노드 cur과 연결된 노드 중 아직 탐색하지 않은 노드를 que에 삽입
                // 번호가 작은 노드부터 탐색하여 que에 입력되므로 자연스럽게 que에서 추출되는 것 또한 작은 수부터 나온다
                if (adjMatrix[cur][i] == 1 && !visisted[i]) {
                    que.add(i);
                    visisted[i] = true;
                }
            }
        }
    }

}