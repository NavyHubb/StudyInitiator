package truningkick.week_02;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;

public class BOJ_9095_123더하기 {
	
	static int dp[] = new int [11];
	
	public static void main(String[] args) throws NumberFormatException, IOException   {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		dp[1] =1; //초기 값 초기화
		dp[2]=2;
		dp[3]=4;
		
		for(int j=4;j<=10;j++) { // 4부터 반복
			dp[j] = dp[j-3] + dp[j-2] + dp[j-1]; // 점화식
		}
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());	
			System.out.println(dp[n]);
		}
	}	
}
