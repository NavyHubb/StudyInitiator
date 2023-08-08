package miraekwak.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		int[] dp = new int[N];
		String[] line = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(line[i]);
			dp[i] = 1;
			for(int j=i-1; j>=0; j--) {
				if(numbers[i] > numbers[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}

}
