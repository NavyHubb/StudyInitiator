package b9s2w6.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//사이즈
		int n = Integer.parseInt(br.readLine());
		
		//숫자배열 변수
		int arr[] = new int[n];
		
		//dp 배열 변수
		int d[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//수자 배열 생성
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		d[0] = 1;
		
		for (int i = 1; i < n; i++) {
			//값이  작으면 1
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && d[i] <= d[j]) {
					d[i] = d[j] + 1;
				}
			}
		}

		int max = 0;
		
		for (int i : d) {
			max = Math.max(max, i);
		}

		System.out.println(max);
	}
}
