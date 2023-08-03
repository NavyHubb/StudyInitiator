package miraekwak.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123¥ı«œ±‚ {
	
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] count = new int[11];
		count[1] = 1;
		count[2] = 2;
		count[3] = 4;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			for(int i=4; i<=N; i++) {
				if(count[i] != 0) continue;
				count[i] = count[i-1] + count[i-2] + count[i-3];
			}			
			sb.append(count[N]+"\n");
		}
		System.out.println(sb);
	}
}
