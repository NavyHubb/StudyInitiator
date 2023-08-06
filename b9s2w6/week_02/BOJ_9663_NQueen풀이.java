package b9s2w6.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 2차원 배열에서 
 * 0은 queen이 갈 수 있는곳
 * 1은 queen이 있는 곳
 * 2는 다음 queen이 갈 수 없는곳
 * 
 * row값을 받아서 그자리에서 둘 수 있는지 판단.
 * 둘 수 있다면 본인 자리에서 이동 범위 표시 후, 다음 row값 이동
 * 
 * 둘 곳이 없다면 return
 * 
 * row값이 n이면 프로그램 종료
 * @author b9s2w
 *
 */
public class BOJ_9663_NQueen풀이{
	static int N, ans;
	static int[][] map;
	static int[] dr = {-1, -1, 0, 0, -1}; //북 북동 동 남동 남 남서 서 북서 
	static int[] dc = {0, 1, 1, -1, -1}; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine()); 
		map = new int[N][N];
		
		setQueen(0);
		
		System.out.println(ans);
	}
	/**
	 * 
	 * @param row 탐색할 열
	 * @param map 체스판
	 */
	static void setQueen(int row) {
		
		if (row == N) {
			ans++;
			return;
		}
		
		for(int col = 0; col<N; col++) {
			if(map[row][col] == 0) {
				boolean flag = false;
				
				//8방 탐색
				for(int i = 0; i<5; i++) {
					//최악의 경우 N-1번 움직여야한다.
					// 0이 아니라 1인 이유 : 0이면 안움직이기 때문에 1부터 실행
					for(int j= 1; j<N; j++) {
						int newRow = row+(dr[i]*j);
						int newCol = col+(dc[i]*j);
						if(newRow > N-1 || newRow < 0 || newCol<0 || newCol>N-1) break; //경계 체크
						if(map[newRow][newCol] == 1) {
							flag = true;
							break;
						}
					}
					if(flag) break;// 상하좌우 대각선상에 말이 있으면 멈춘다.
				}
				
				if(flag) continue;
				else {
					map[row][col] = 1;
					setQueen(row+1);
					map[row][col] = 0;
				}
			}
		}
				
	}
}


//if(cpMap[newRow][newCol] == 0) {
//	cpMap[newRow][newCol] = 1;
//	setQueen(row+1, cpMap);
//}
