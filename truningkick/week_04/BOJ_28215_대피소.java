package truningkick.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 대피소를 K개 집에 설치한다
 * 이 때, 대피소로 이동하는 가장 긴 거리가 최소가 되도록 설치할 K개의 집을 선택,
 * 가장 멀리 떨어진 집과의 거리를 구한다
 * 
 */
public class BOJ_28215_대피소 {

	static int N, K;
	static int [][] home;
	static int result = 0;
	static int [] selecH;
	static int moreMinDistance=Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());	//집의 수
		K = Integer.parseInt(str.nextToken());	//대피소 수
		
		home = new int[N][2];
		selecH = new int [K];

		for(int i=0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			home[i][0] = Integer.parseInt(str.nextToken()); //X
			home[i][1] = Integer.parseInt(str.nextToken()); //Y
		}
		
		//N_ C _K 조합
		
		selectHome(0, 0);
		System.out.println(moreMinDistance);
		
	}
	
	//모든 집과, 대피소와의 거리를 구하는 메서드
	/*
	 * @param int H : 선정된 대피소의 위치(집의 index값)
	 */
	private static void calculate(int H) {
		int x = home[H][0];
		int y = home[H][1];
		
		//1개의 대피소에 대해 집과의 거리가 가장 긴 거리 구하기
		for(int i=0; i<N; i++) result = Math.max( result, Math.abs( x-home[i][0] ) + Math.abs( y-home[i][1]) );
	}
	
	private static void selectHome(int start, int cnt) {
		if(cnt == K) {
//			System.out.println(Arrays.toString(selecH));
			//선정한 대피소 위치와 집 사이간 최장 거리를 구한다.
			for(int i=0; i<K; i++) {
				calculate(selecH[i]);
			}	
			//현재까지 계산한 최장거리 중 가장 작은 거리를 저장한다.
			moreMinDistance = Math.min(moreMinDistance, result);
			result = 0;
			return;
		}
		
		for(int i=start; i<N; i++) {
			selecH[cnt] = i;
			selectHome(i+1, cnt+1);
		}
		
	}
}
