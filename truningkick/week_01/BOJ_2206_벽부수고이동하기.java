package turningkick.week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2206_벽부수고이동하기 
{
	static int N, M;
	static char [][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		
		// map 초기화
		for (int i=0; i < N; i++) {
			String str = br.readLine();
			for(int j=0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		System.out.println(bfs());
	}

	static int bfs() {
		int [][][] visited = new int[N][M][2]; //방문여부(N,M) 및 벽부수기회(0:가능, 1:불가능)
		Queue<int[]> que = new LinkedList<>();		
		visited[0][0][1] = 1;
		que.add(new int[] {0,0,1});
		
		int[] dh = {-1,1,0,0};
		int[] dw = {0,0,-1,1};
		
		while (!que.isEmpty()) {
			int[] now = que.poll();
			int i = now[0], j=now[1], k=now[2];


			if(i == N-1 && j == M-1){
				return visited[i][j][k];	// 종료조건, 도착지점 도착
			}
			
			for(int l=0; l<4; l++) {
				int x = i+dh[l];
				int y = j+dw[l];
				
				
				if( x<0 || y<0 || x>N-1 || y>M-1 ) {
					continue; 	// 4방탐색 map 범위 밖
				}
				if( visited[x][y][k] > 0) {
					continue; // 방문경험 있음
				}
				
				if( map[x][y] == '0') {				// 벽이 없음
					visited[x][y][k] = visited[i][j][k]+1;
					que.add( new int[] {x,y,k} );
				}
			
				else if( (map[x][y] == '1') && (k == 1) ) { //벽이지만, 부술 수 있을 때
					visited[x][y][0] = visited[i][j][1]+1;
					que.add(new int[] {x,y,0});
				}
			}			
		}
		return -1;
	}
}


