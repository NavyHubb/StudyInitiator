package b9s2w6.week_01;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_1260_DFS와BFS {
  static int n = 0;//정점의 갯수
	static int m = 0;//간선의 갯수
	static int v = 0;//탐색을 시작할 정점의 번호
	static int[][] arr;//간선 행렬
	static Queue<Integer> q = new LinkedList<>();
	
	public static void dfs(boolean[] visited, int start) {
		visited[start] = true;
		System.out.printf("%d ", start+1);
		for(int i = 0; i< n; i++) {
			if(arr[start][i]==1 && visited[i] ==false) {
				dfs(visited, i);
			}
		}
	}
	
	public static void bfs(boolean[] visited, int start) {
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			start = q.poll();
			System.out.printf("%d ", start+1);
			
			for(int i = 0; i< n; i++) {
				if(arr[start][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		arr = new int[n][n];
		boolean[] visited = new boolean[n]; //방문 배열
		Arrays.fill(visited,false); //방문배열 false로 초기화
		
		int row = 0;
		int column = 0; 
		
		for(int i = 0; i<m; i++) {
			column =sc.nextInt();
			row = sc.nextInt();
			arr[column-1][row-1] = arr[row-1][column-1] = 1;
		}
		
		//dfs 출력
		dfs(visited, v-1);
		
		Arrays.fill(visited,false);
		System.out.println();
		//bfs 출력
		bfs(visited, v-1);
	}
}
