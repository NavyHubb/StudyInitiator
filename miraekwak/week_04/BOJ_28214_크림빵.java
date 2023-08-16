package miraekwak.week_04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_28214_크림빵 {

	private static int N, K, P;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		int min_cnt = K-P+1;
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=0; j<K; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			if(sum >= min_cnt) {
				cnt++;
			}
		}		
		System.out.println(cnt);
	}
}
