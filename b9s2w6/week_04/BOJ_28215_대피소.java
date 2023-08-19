package b9s2w6.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N : 집 위치
 * K : 대피소 갯수
 * 
 * 집에서 2개를 뽑아서 모든거리를 구한다.
 * 최대값을 구하고 거기서 최소값을 구한다.
 *
 */
public class BOJ_28215_대피소 {
	static int N;
	static int K;
	static home[] shelter;
	static int[][] distances;
	static int[] min;
	static home[] homes;
	static int ans = Integer.MAX_VALUE;
	
	static class home{
		int row; 
		int col;
		public home(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 집의 갯수
		K = Integer.parseInt(st.nextToken()); // 대피소 갯수
		homes = new home[N];
		shelter = new home[K]; // 대피소 선택
		distances = new int[N][K+1]; //대피소까지의 거리
		min = new int[N];
		Arrays.fill(min, Integer.MAX_VALUE);
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			homes[i] = new home(row, col);
		}
		
		permutation(0, 0);
		System.out.println(ans);
	}
	
	private static void permutation(int idx, int start) {
		if(idx == K) {
			calcDistance();
			return;
		}
		
		for(int i = start; i<N; i++) {
			shelter[idx] = homes[i];
			permutation(idx+1, i+1);
		}
	}
	
	private static void calcDistance() {
		for(int col = 0; col < K; col++) {
			for(int  row = 0; row < N; row++) {
				distances[row][col] =  calc(homes[row], shelter[col]);
			}
		}
		
		for(int  row = 0; row < N; row++) {
			int min = Integer.MAX_VALUE;
			for(int col = 0; col < K; col++) {
				min = Math.min(min, distances[row][col]);
			}
			distances[row][K] = min;
		}
		int max = Integer.MIN_VALUE;
		
		for(int i= 0; i<N;i++) {
			max = Math.max(max, distances[i][K]);
		}
		
		ans = Math.min(ans, max);
	}
	
	private static int calc(home h1, home h2) {
		return Math.abs(h1.row-h2.row)+Math.abs(h1.col - h2.col);
	}
}
