package b9s2w6.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_����������ϴºκм��� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//������
		int n = Integer.parseInt(br.readLine());
		
		//���ڹ迭 ����
		int arr[] = new int[n];
		
		//dp �迭 ����
		int d[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//���� �迭 ����
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		d[0] = 1;
		
		for (int i = 1; i < n; i++) {
			//����  ������ 1
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
