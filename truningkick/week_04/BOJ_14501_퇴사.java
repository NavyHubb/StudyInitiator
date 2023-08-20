package truningkick.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * N : 상담을 할 수 있는 일수
 * T : 각각의 상담을 완료하는 데 걸리는 시간
 * P : 상담을 완료 했을 때 받을 수 있는 금액
 * 
 */
public class BOJ_14501_퇴사 {
	
	static int N;
	static int [][] matrix;
	static int maxCost = 0;
	static int sum=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer str;

		matrix = new int [N][2];
		
		for(int i=0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			matrix[i][0] = Integer.parseInt(str.nextToken());	//시간
			matrix[i][1] = Integer.parseInt(str.nextToken());	//비용
		}
		
		// 모든 경우의 수에 대해
		for(int i=0; i<N; i++) {	
			searchHighCost(i);			
		}
		System.out.println(maxCost);		
	}
	
	private static void searchHighCost(int now) {	
	
		int nextIndex = now + matrix[now][0];
		int nowIndex = now;
		
	    while ( nextIndex <= N) {
	    	if( nowIndex >= N ) break;
	        sum += matrix[nowIndex][1];
	 
	        nowIndex = nextIndex;	
	    	if( nowIndex >= N ) break;
	    	nextIndex = nowIndex +  matrix[nowIndex][0];;

	    }
	    System.out.println(sum);
		maxCost = Math.max(maxCost, sum);
		sum =0;		
	}	
	
}
