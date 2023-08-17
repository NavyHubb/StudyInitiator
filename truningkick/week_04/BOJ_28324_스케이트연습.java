package truningkick.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_28324_스케이트연습 {

	static int N;
	static String [] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new String [N+2];	//시작과 끝의 속도제한을 0으로
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] =str.nextToken();
		}
		
		
		long sum=0;	//각 구간별 속도를 더할 변수
		long vNow=0;	//현 구간에서의 속도
		long vPrev =0;	//이전 구간에서 정해진 속도
		
		for(int i=N; i>=1; i--) {
			vNow = vPrev +1;	//이전 구간의 속도+1
			if(vNow > Long.parseLong(arr[i]) ) vNow = Long.parseLong(arr[i]);	//이전 구간의 속도+1 값이 현 속도제한 값보다 클 때, 현 속도제한 값으로 변
			
			sum += vNow;
			vPrev = vNow;
		}
		
		System.out.println(sum);
		
	}
}
