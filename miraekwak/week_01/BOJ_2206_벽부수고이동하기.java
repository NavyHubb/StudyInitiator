package miraekwak.week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 문제>
 * (1,1)에서 상하좌우 이동하여 (N,M)까지 이동하기
 * 0은 이동가능 1은 벽으로 이동 불가
 * 딱 한번, 벽을 부수고 지나갈 수 있음
 * 입력>
 * N(1<=N<=1000), M(1<=N<=1000)
 * ((0 or 1) * N) * M
 * 출력>
 * 최단 경로 (시작점, 도착지 포함)
 */
class Location {
    int row;
    int col;
    int isBreak; // 0 or 1

    public Location(int r, int c, int isBreak) {
        this.row = r;
        this.col = c;
        this.isBreak = isBreak;
    }
}

public class BOJ_2206_벽부수고이동하기 {
    private static int N, M;
    private static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            line = br.readLine().split("");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(bfs(0, 0, N-1, M-1));
    }

    private static int bfs(int str_row, int str_col, int end_row, int end_col) {
        Queue<Location> queue = new ArrayDeque<Location>();
        queue.add(new Location(str_row, str_col, 0));

        // 0번째 안뿌숨, 1번째 뿌숨
        int[][][] visited = new int[N][M][2];
        visited[str_row][str_col][0] = 1;
        visited[str_row][str_col][1] = 1;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            Location lo = queue.remove();

            if(lo.row == end_row && lo.col == end_col) {
                if(visited[end_row][end_col][0] == 0) return visited[end_row][end_col][1];
                if(visited[end_row][end_col][1] == 0) return visited[end_row][end_col][0];
                return Math.min(visited[end_row][end_col][0], visited[end_row][end_col][1]);
            }

            for(int d=0; d<4; d++) {
                int r = lo.row + dr[d];
                int c = lo.col + dc[d];

                if(r < 0 || r >=N || c < 0 || c >= M) continue;

                // 방문하지 않았거나 더 짧은 경로 인 경우
                if(visited[r][c][lo.isBreak] == 0 || visited[r][c][lo.isBreak] > visited[lo.row][lo.col][lo.isBreak]+1) {
                    // 이동할 수 있을 경우
                    if(map[r][c] == 0) {
                        visited[r][c][lo.isBreak] = visited[lo.row][lo.col][lo.isBreak] +1;
                        queue.add(new Location(r, c, lo.isBreak));
                        continue;
                    }

                    // 벽일 경우 -> 아직 벽 뿌수기 안했다면
                    if(lo.isBreak == 0) {
                        visited[r][c][1] = visited[lo.row][lo.col][0] +1;
                        queue.add(new Location(r, c, 1));
                    }
                }
            }
        }
        return -1;
    }
}