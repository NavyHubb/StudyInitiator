package truningkick.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N : 물품의 수 (1 ≤ N ≤ 100)
 * K : 무게 (1 ≤ K ≤ 100,000)
 * W : 물건의 무게 (1 ≤ W ≤ 100,000) / 
 * V : 해당 물건의 가치 (0 ≤ V ≤ 1,000)
 * 
 * N K
 * W V
 * W V
 * ... 
 */

public class BOJ_12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());

		int [] W = new int[N+1];
		int [] V = new int[N+1];
		for(int i=1; i<=N; i++) {
			str = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(str.nextToken());
			V[i] = Integer.parseInt(str.nextToken());
		}
		
		//dp 배열은 행(물건 index) 열(가용무게) 해당 행열에 위치한 값(가치)로 이뤄짐
		int [][] dp = new int [N+1][K+1];
		
		
		for (int i = 1; i <= N; i++) {			// i: 물건의 index
			for (int j = 1; j <= K; j++) {		// j: 가용 무게
				
				// i번째 무게를 더 담을 수 없는 경우 
				if(W[i] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				// i번째 무게를 더 담을 수 있는 경우 
				else {
					// dp[이전 물건 index][동일한 열(무게)] = 값(가치) 와 
					// dp[이전 물건 index][열(무게)-현물건의 무게 == 남는무게에 담을 수 있는 물건의 무게 ] >> 즉, 남는 무게에 담을 수 있는 물건이 가지는 가치  + 현 index 물건의 가치 
					dp[i][j] = Math.max( dp[i - 1][j],  dp[i - 1][j - W[i]] + V[i] );
				}
				
			}
		}
		System.out.println(dp[N][K]);
	
		
	}
}
