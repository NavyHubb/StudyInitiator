package truningkick.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * DFS를 통해 모든 도시를 방문하는 최소 비용 구하기
 * 한번 방문한 도시는 재방문 불가
 * 도시 간 비용이 0일 경우 해당 루트로는 이동 불가
 * 
 */
public class BOJ_10971_외판원순회2 {
    static int n;
    static boolean[] visited;
    static int[][] map;
    static long result_min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
    	//입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        //map 초기화
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //i는 시작(출발 도시)
        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, i, 0);
        }
        System.out.println(result_min);
    }

    public static void dfs(int start, int now, long cost){
        if (allVisited()) {	//도시를 모두 방문했을 때 발생하는 총비용을 이전 최솟값(비용)과 비요하여 최신화
            if(map[now][start]!=0){
                result_min = Math.min(result_min, cost+map[now][0]);
            }
            return;
        }

        for(int i=1; i<n; i++){
            if (!visited[i] && map[now][i] != 0) {	//방문하지 않았고, 갈 수 있는 루트일 때
                visited[i] = true;					//방문처리
                dfs(start, i, cost + map[now][i]);	//재귀를 통해 경우의 수 탐색
                visited[i] = false;					//백트래킹, 최초 시작 위치 외 모두 false
            }
        }
    }

    //visited 배열이 모두 true인지 아닌지에 대한 결과 리턴
    public static boolean allVisited() {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}