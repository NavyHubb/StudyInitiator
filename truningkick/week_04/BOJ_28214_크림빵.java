package truningkick.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_28214_크림빵 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		int p = Integer.parseInt(str.nextToken());
		
		str = new StringTokenizer(br.readLine());
		int [] arr = new int [N*K];
		for(int i=0; i<N*K; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		int result =0;
		int noCreamConut = 0;
		int cnt=0;
		for(int j=0; j<N*K; j++) {
			cnt+=1;
			if(arr[j] == 0) {
				noCreamConut+=1;
			}
			
			if(cnt==K) {
				cnt=0;
				if(noCreamConut < p) result +=1;
				noCreamConut = 0;
			}

		}
		System.out.println(result);
		
	}
}
