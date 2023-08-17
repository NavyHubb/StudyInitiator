package truningkick.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N = 2~250_000
 * C_i = 0 ~ 10^12 (1조)
 * 
 * 조건 
 *  1. N개의 방이 loop형태로 각각 하나의 통로로 연결되어 있음,
 *  2. C_i는 i번째 방이 가지는 쪽방의 수
 *  3. 개미는 방 1개당 1마리가 산다. 단, 통로가 연결된 두 방 중 한 방에만 살 수 있다!
 *  
 * 방책
 *  1. 쪽방이 있는 방은 쪽방 사용이 우선 시 되어야 함. 
 *  2. 이후 단일 방을 이웃된 방에 개미가 살지 않는다면 1마리를 입주시킨다.
 */

public class BOJ_28325_호숫가의개미굴 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String [] arr = new String [N];	// index: 방번호, 값: 쪽방의 수 
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = str.nextToken();
		}
		
		long sum;
		long max = 0;
		int before;
		int after;
		boolean [] checkRoom = new boolean [N];	//메인방의 개미 입주여부를 확인하는 배열(true:입주)
		for(int j=0; j<=1; j++) {
			checkRoom = new boolean [N];
			sum = 0;
			for(int i=j; i<N; i++) {
				if(Long.parseLong(arr[i]) >= 1) {
					sum += Long.parseLong(arr[i]);
					continue;
				}
				before	= i-1;
				after	= i+1;
				if(i-1 < 0) before = N-1; 
				if(i+1 >= N) after = 0; 
				if(checkRoom[before]==false && checkRoom[after]==false) {
					checkRoom[i] = true; 
					sum += 1;				
				}
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);	
	} 
}
