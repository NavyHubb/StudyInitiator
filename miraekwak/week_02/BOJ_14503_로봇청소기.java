package miraekwak.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14503_로봇청소기 {

	private static int N, M, CNT=0;
	private static int[][] room;
	private static int[] dr = {-1, 0, 1, 0}; // �ݽð����(��, ��, ��, ��)
	private static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		
		line = br.readLine().split(" ");
		int str_r = Integer.parseInt(line[0]);
		int str_c = Integer.parseInt(line[1]);
		int d = Integer.parseInt(line[2]);
		
		room = new int[N][M];
		for(int i=0; i<N; i++) {
			line = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				room[i][j] = Integer.parseInt(line[j]);
			}
		}
		if(d == 1) d = 3;
		else if(d == 3) d = 1;
		cleaning(str_r, str_c, d);
		System.out.println(CNT);
		
	}
	
	private static void cleaning(int r, int c, int direc) {
		if(room[r][c] == 0) {
			room[r][c] = 2;	
			CNT++;
		}
		
		boolean isPossibleCleaning = false;
		// �������� ĭ Ž��
		for(int d=0; d<4; d++) {
			if(room[r+dr[d]][c+dc[d]] == 0) {
				isPossibleCleaning = true;
				break;
			}
		}
		
		// û�ҵ��� ���� ĭ�� �ִ� ���
		if(isPossibleCleaning) {
			int newDirec = (direc+1) %4; // �ݽð���� 90�� ȸ��
			if(room[r+dr[newDirec]][c+dc[newDirec]] == 0) {
				cleaning(r+dr[newDirec], c+dc[newDirec], newDirec);				
			}
			else {
				cleaning(r, c, newDirec);
			}
		}
		// û�ҵ��� ���� ĭ�� ���� ���
		else { 
			// ��ĭ ������ �� �ִٸ�
			if(room[r+dr[(direc+2)%4]][c+dc[(direc+2)%4]] != 1) {
				cleaning(r+dr[(direc+2)%4], c+dc[(direc+2)%4], direc);
			}
		}
	}

}
