package miraekwak.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1759_암호만들기 {
	private static int L, C;
	private static String[] alpha;
	private static String[] selected;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		L = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		
		sb = new StringBuilder();
		alpha = br.readLine().split(" ");
		Arrays.sort(alpha);
		selected = new String[L];
		choose(0, 0, 0, 0);
		System.out.println(sb);
	}
	
	private static void choose(int cnt, int str, int mo, int za) {
		if(cnt == L) {
			if(mo >= 1 && za >= 2) {
				for(int i=0; i<selected.length; i++) {
					sb.append(selected[i]);				
				}
				sb.append("\n");				
			}
			return;
		}
		
		for(int i=str; i<alpha.length; i++) {
			selected[cnt] = alpha[i];
			if("aeiou".contains(alpha[i])) {
				choose(cnt+1, i+1, mo+1, za);				
			}
			else {
				choose(cnt+1, i+1, mo, za+1);				
			}
		}
	}
}
