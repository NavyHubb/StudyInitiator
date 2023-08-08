package miraekwak.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12865_평범한배낭 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);
		int[] weight = new int[N];
		int[] value = new int[N];
		
		for(int i=0; i<N; i++) {
			line= br.readLine().split(" ");
			weight[i] = Integer.parseInt(line[0]);
			value[i] = Integer.parseInt(line[1]);
		}
		
		int[] dp = new int[K+1];
		for(int i=0; i<N; i++) {
			for(int j=K; j>=weight[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
			}
		}
		System.out.println(dp[K]);
	}

}
