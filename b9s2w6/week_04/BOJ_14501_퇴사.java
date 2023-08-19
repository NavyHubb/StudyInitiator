package b9s2w6.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제해석
 * N일동안 많은 상담하기
 * N+1일째 되는 날 퇴사
 * Ti : 상담을 완료하는데 걸리는 기간 
 * Pi : 상담을 했을 때 받을 수 있는 금액 
 * 
 * 기간은 1일보다 클 수 있고, 상담기간 동안은 다른상담 진행이 불가하다.
 * 상담기간은 당일을 포함하여 계산한다.
 * 
 * 
 * 문제해결에 대한 고민
 * 부분집합을 짜면서 부분집합이 완성 되었을때 최대값을 갱신.
 * 
 * 
 * 문제해결 프로세스
 * 1. 부분집합만들기 메서드(setConsult(start, 누적금액))
 * 유도파트
 * for문 돌면서
 * n+Ti은 N보다 크면 continue
 * n일의 상담을 선택했을경우  
 * 인덱스는 n+Ti일로 이동하고 누적금액에 추가한다.
 * 
 * n일을 선택하지 않을경우
 * 인덱스 값만 +1하고 누적금액은 변동없이 이동
 * 
 *  기저조건 
 *  start > N일때 return
 */

public class BOJ_14501_퇴사 {
	static int maxMoney = Integer.MIN_VALUE;
	static int N;
	static consult[] consultings;
	static class consult{
		int T;//걸리는 시간
		int P;//상담비용
		
		public consult(int T, int P) {
			this.T = T;
			this.P = P;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		consultings = new consult[N]; //시간 집합
		
		for(int i= 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			consultings[i] = new consult(P, T);
		}
		
		setConsult(0, 0);
		System.out.println(maxMoney);
	}
	
	private static void setConsult(int start, int money) {
		maxMoney = Math.max(maxMoney, money);
		for(int i = start; i<N; i++) {
			if(i+consultings[i].T >N) continue;
			setConsult(i+consultings[i].T, money+consultings[i].P);
		}
	}
}
