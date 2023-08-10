package truningkick.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14002_가장긴증가하는부분수열4 {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); //수열 arr의 길이
        int[] arr = new int[n+1];  //수열 배열 초기화
        int[] dp = new int[n+1];  //dp 테이블 초기화
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  //arr에 수열 입력 받기
            dp[i] = 1;  //모든 dp값들은 최소 1
        }
        
        int max = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
            	
                if (arr[i] > arr[j]) {	//이전 원소들보다 현재 비교하고 있는 값이 클 때
                	dp[i] = Math.max(dp[i], dp[j]+1); // 이전 원소들 중 가장 큰 dp값 + 1
                }

            }
            max = Math.max(max, dp[i]);  //LIS 길이 구하기
            
        }
        
        //역추적
        
        int val = max;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=n; i>=1; i--) {
        	if(val == dp[i]) {
        		stack.push(arr[i]);
        		val--;
        	}
        }
        
        while(!stack.isEmpty()) {
        	sb.append(stack.pop()+ " ");
        }
        
        System.out.println(max);
        System.out.print(sb);
    }
}