package miraekwak.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_28324_스케이트연습 {
	
	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] speed = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			speed[i] = Integer.parseInt(st.nextToken());
		}
				
		long sum = 0;
		long prev = 0;
		for(int i=N-1; i>=0; i--) {
			if(prev < speed[i]) prev++;
			else if(prev > speed[i]) prev = speed[i];
			sum += prev;
		}
		System.out.println(sum);
	}
}
