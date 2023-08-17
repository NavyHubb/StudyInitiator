package truningkick.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N: 1~300_000
 * A_i : 1~100_000 (i: 1~N개)
 * 
 * 불안정한 수열: 이웃한 두 자연수의 합을 구했을 때, 항상 홀수라면 (ex. 첫번째,두번째 / 세번째,네번쨰...)
 *  - 요소가 단 하나라면 그것도 인정~
 *  
 */

public class BOJ_28323_불안정한수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean isSniffling = false;	//true:짝 false: 홀
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		if( Integer.parseInt(str.nextToken())%2 == 0) isSniffling = true;
				
		int temp, cnt=1;
		for(int i=1; i<N; i++) {
			temp = Integer.parseInt(str.nextToken());
			
			if(isSniffling != (temp%2==0)) {
				cnt+=1;
				isSniffling = !isSniffling;
			}
			
		}
		System.out.println(cnt);
	}
}
