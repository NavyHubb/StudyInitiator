package b9s2w6.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * N x K개의 빵을 만든다.
 * 앞 쪽 부터 k개씩 묶어서 한묶음으로 판매한다.(N묶음)
 * 빵 일부는 크림이 없다. 묶음에 P개 이상 있다면 판매불가
 * 팔 수 있는 빵의 묶음 수는?
 * 
 * 1차원 배열 만들고 한 행의 0갯수 count 하여 조건 판단
 *
 */
public class BOJ_28214_크림빵풀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int notSell = 0;
		
		int[][] arr = new int [N][K];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			int zeroCnt = 0; // 0갯수 count
			for(int j= 0; j<K; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) zeroCnt++;
			}
			if(zeroCnt >= P) notSell++;
		}
		
		System.out.println(N-notSell);
	}

}
