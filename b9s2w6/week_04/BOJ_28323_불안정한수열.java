package b9s2w6.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 값의 인덱스는 1부터 시작
 * 연속한 값의 합이 모두 홀수이면 불안정한 수열, 단 길이가 1인 수열은 모두 불안정한 수열
 * 
 * N개의 자연수 1<= N <= 300_000
 * 
 * Ai는 i번째 자연수이다. 1<=Ai<= 100_000
 * 
 * A는 최초의 수 집합
 * B는 뽑은 수의 집합
 * k는 뽑은 수의 갯수
 * 
 * 신기한 수의 최대 길이
 * 
 * 1) 완전탐색(조합)
 * 
 * 
 * 시간 복잡도 ...
 * @author 백성욱
 *
 */
public class BOJ_28323_불안정한수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//N 입력 받기
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int cnt = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i= 0; i<N;i++) A[i]=Integer.parseInt(st.nextToken());
		boolean startFlag = true;
		//startFlag 짝이면  flase; 홀수면 true;
		for(int i = 0; i<N; i++) {
			if(i == 0) {
				startFlag = A[i] % 2 == 1 ? true : false;
				continue;
			}
			if(startFlag && A[i]%2 == 0) {
				cnt++;
				startFlag = false;
			}
			else if (!startFlag && A[i]%2 == 1) {
				cnt++;
				startFlag = true;
			}
		}
		System.out.println(cnt);
	}	
}
