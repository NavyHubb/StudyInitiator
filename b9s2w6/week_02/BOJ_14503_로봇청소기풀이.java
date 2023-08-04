package b9s2w6.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기풀이 {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] arr;
	static int res;
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n= Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		
		int Rrow = Integer.parseInt(st.nextToken()); // 로봇 row값
		int Rcol = Integer.parseInt(st.nextToken()); // 로봇 col값
		int Rdir = Integer.parseInt(st.nextToken()); // 로봇 방향값
		
		arr = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j =0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(Rrow, Rcol, Rdir);
		System.out.println(res);
		
	}
	
	/**
	 * 
	 * @param row 로봇의 현재 행
	 * @param col 로봇의 현재 열
	 * @param dir 로봇의 현재 방향
	 */
	static void dfs(int row, int col, int dir) { //로보트의 위치를 받고 움직임을 결정
//		int cpCnt = cnt;
		//현재칸이 청소가 되어있지 않을때 청소
		if(arr[row][col] == 0) {
			arr[row][col] = 2;
			res++;
//			cpCnt++;
		}
		 // 빈칸이 있는경우 탐색
		boolean flag = false; // 빈칸이 있으면 true, 없으면 false
		for(int i =0; i<4; i++) {
			int newRow = row+dr[i];
			int newCol = col+dc[i];
			if(newRow>=0 && newRow<n &&newCol>=0 &&newCol<m) {
				if(arr[newRow][newCol] == 0) {
					flag = true;
					break;
				}
			}
		}
		
		if(flag) {
			//반시계 90도 회전
			int newDir  = dir;
			if(dir == 0) newDir = 3;
			else newDir = dir-1;
			
			if(row+dr[newDir]>=0 &&row+dr[newDir]<n && col+dc[newDir]<m && col+dc[newDir]>=0) {
				if(arr[row+dr[newDir]][col+dc[newDir]] == 0) {
					dfs(row+dr[newDir], col+dc[newDir], newDir);
				}else dfs(row, col, newDir
						);
			}
		}
		else {
			if(row-dr[dir]<n&&row-dr[dir]>=0 &&col-dc[dir]<m && col-dc[dir]>=0) {
				if(arr[row-dr[dir]][col-dc[dir]] == 2) {
					dfs(row-dr[dir], col-dc[dir], dir);
				}
				if(arr[row-dr[dir]][col-dc[dir]] == 1) {
					return ;
				}
			}
			
		}
		
		
	}
}
	
