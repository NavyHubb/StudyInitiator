package b9s2w6.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14002_가장긴증가하는부분수열4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] nums = new int[cnt];
		int[] dp = new int[cnt];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<cnt; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); 
		}
		
		dp[0] = 1;
		int max = 1;
		for(int i = 1; i<cnt; i++) {
			dp[i] = 1;
			for(int j= 0; j<i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i],  dp[j]+1);
					max = Math.max(max,  dp[i]);
				}
			}
		}
		
		int value = max;
        Stack<Integer> stack = new Stack<>();

        for (int i = cnt-1; i >= 0; i--) {
            if (value == dp[i]) {
                stack.push(nums[i]);
                value--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(max);
        System.out.println(sb);
	}

}
