package miraekwak.week_04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_28325_호숫가의개미굴 {
	
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] unableToVisit = new boolean[N];
		
		long total = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int curr= Integer.parseInt(st.nextToken());
			if(curr == 0) continue; 
			total += curr;
			unableToVisit[i] = true;
		}

		int[] dp = new int[N+2];
		for(int i=0; i<N; i++) {
			if(unableToVisit[i]) {
				dp[i+2] = dp[i];
				continue;
			}
			// 양 옆이 방문할 수 없다면 현재는 개미가 살아야함
			if(unableToVisit[(i-1+N)%N] && unableToVisit[(i+1)%N]) {
				total++;
				unableToVisit[i] = true;
				dp[i+2] = dp[i];
			}
			else {
				dp[i+2] = dp[i] +1;
			}
		}
		System.out.println(total+Arrays.stream(dp).max().getAsInt());
	}
}
