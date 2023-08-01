package test;

import java.util.Scanner;

public class test1 {
	
	static int size;
	static int[][] price;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	
	public static void dfs(int start, int now, int cnt, int cost) {

		if (now == start && cost > 0) {
			min = Math.min(min, cost);
			return;
		}

		for (int n = 0; n < size; n++) {

			if (price[now][n] > 0) {

				if (n == start && cnt == size-1) {
					cost += price[now][n];
					dfs(start, n, cnt + 1, cost);
				}

				else if (!visited[n]) {
					visited[n] = true;
					cost += price[now][n];

					dfs(start, n, cnt + 1, cost);

					cost -= price[now][n];
					visited[n] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		size = sc.nextInt();
		
		price = new int[size][size];
		visited = new boolean[size];
		
		for(int i = 0; i<size; i++) {
			for(int j= 0; j<size; j++) {
				price[i][j] = sc.nextInt();
			}
		}
		
		visited[0] = true;
		dfs(0, 0, 0, 0);
		
		System.out.println(min);
	}

}
