package truningkick.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N개의 자연수가 좌우 일렬로
 * 
 * 좌측부터 k개의 자연수를 골라
 * 고른 자연수의 순서는 그대로 유지, 하나의 배열을 이룸
 * 
 *  불안정한 수열 : 
 *   - 생성된 배열의 이웃한 두 수의 합이 홀수일 때, 
 *   - k=1 일 때
 * 
 * B가 불안정한 수열이 되면서, 가장 많은 개수의 자연수를 골라야 한다. 
 * 
 * N(자연수 개수) : 1~300_000
 * A_i(N번째 값) : 1~100_000
 * 
 */
public class BOJ_28323_불안정한수열 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		int [] arr = new int [N];
		for(int i =0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		int max = 0;
		StringBuilder sb = new StringBuilder();
		
		loop1: for(int i =1; i<(1<<N); i++) {	//1<<N : 부분집합의 개수
			sb.delete(0,sb.length());
			for(int j=0; j<N; j++) {	//원소 수만큼 비트 비교
				if( (i & (1<<j)) != 0 ) {	//부분수열 생성
					sb.append(arr[j]);
				}
			}
			
			//부분수열의 길이가 1이라면
			if(sb.length()==1) {
				max = 1;
				continue loop1;
			}
//			System.out.println(sb);

			//불안정한 수열 판단
			for(int j=0; j<sb.length()-1; j++) {
				
				int a = sb.charAt(j)-48;
				int b = sb.charAt(j+1)-48;
//				System.out.println("a:"+a+" b:"+b+ " Max:"+max);
				if( ( a + b ) % 2 == 0  ) continue loop1;	//이웃된 수가 짝수라면
			}
			max = Math.max(max, sb.length());
		}
		System.out.println(max);
		
	}
}
	
