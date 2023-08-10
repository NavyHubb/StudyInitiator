package truningkick.week_03;

import java.io.*;
import java.util.*;

/*
 * 비트마스킹과 DP를 사용
 * 
 * 비트마스킹을 통해 2^n의 상태값을 n bit로 표현
 * 이후 줄어든 O(n!)을 dp 메모제이션 기법을 사용하여 최적화
 *  TSP는 한 정점에서 다른 모든 정점을 순회하여 다시 출발 정점으로 돌아오는 최적의 경로를 찾는 방식으로 풀 수 있다. 
 *  이 순회 경로는 싸이클로  n개의 정점 중 어느 정점에서 탐색을 시작을 해도 결과는 똑같다는 것을 알아야한다.
 *  
 *  1. TSP(외판원순회)는 최단 순환 경로를 탐색해야한다.
 *  2. N! 중복 경로를 제거해주는 DP 메모제이션 기법을 사용(하지만 2^N의 모든 경우의 수를 표현하기 때문에 그만큼의 공간복잡도를 요구함)
 *  3. 따라서 비트마스킹을 사용하여 메모리 사용량 절감, 성능 향상
 *   
 *   비트마스킹: 방문여부를 확인 (boolean배열과 같은 역할)
 *      ㄴ  if(A & (1 << k)) : k를 방문했으면 true(1)
 */

public class BOJ_2098_외판원순회 {

	static int n, statusFullBit, INF = 987654321;
	static int[][] w;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		statusFullBit = (1<<n) -1;
		System.out.println(statusFullBit);
		w = new int[n][n];
		dp = new int[n][statusFullBit];
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(tsp(0,1)); // 0번도시 부터 탐색 시작 (check: 0001)
	}
	
	static int tsp(int x, int check) {
        
		// 모든 도시 방문 완료
		if(check == statusFullBit) {
			if(w[x][0] == 0) return INF; // 경로 없으면 INF로 탐색 무효화 (Math.min)
			else return w[x][0]; // 경로가 존재하면 w[x][0]
		}
        
		// 이미 방문한 도시 
		if(dp[x][check] != -1) return dp[x][check];
        
		// 해당 도시에 출석 표시
		dp[x][check] = INF;
        
		// 방문하지 않은 도시 탐색 
		for(int i=0; i<n; i++) {
			// next : i 도시 방문
			int next = check | (1<<i); 
            
			// 경로가 없거나 i 도시를 이미 방문했을 경우 continue 
			if(w[x][i] ==0 || (check & (1<<i)) != 0) continue;
			
			dp[x][check] = Math.min(dp[x][check], tsp(i, next) + w[x][i]);
		}
		
		return dp[x][check];
	}
}