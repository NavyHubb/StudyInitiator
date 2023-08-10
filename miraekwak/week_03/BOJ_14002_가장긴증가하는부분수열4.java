package miraekwak.week_03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14002_가장긴증가하는부분수열4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int[] numbers = new int[A+1];
		int[] dp = new int[A+1];
		int[] indexs = new int[A+1];
		
		String[] line = br.readLine().split(" ");
		for(int i=0; i<A; i++) {
			numbers[i+1] = Integer.parseInt(line[i]);
		}
		
		for(int i=0; i<=A; i++) {
			for(int j=i-1; j>=0; j--) {
				if(numbers[i] > numbers[j]) {
					if(dp[j]+1 > dp[i]) {
						dp[i] = dp[j] +1;
						indexs[i] = j;						
					}
				}
			}
		}
		int max_idx = 0;
		for(int i=1; i<=A; i++) {
			if(dp[max_idx] < dp[i]) {
				max_idx = i;
			}
		}
		
		System.out.println(dp[max_idx]);
		StringBuilder sb = new StringBuilder();
		while(max_idx != 0) {
			sb.insert(0, numbers[max_idx]+" ");
			max_idx = indexs[max_idx];
		}
		System.out.println(sb);
	}
}
