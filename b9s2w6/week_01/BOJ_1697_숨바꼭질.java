package b9s2w6.week_01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {
	static int bfs(int start, int end) {
		//queue, visited 배열 생성
		int[] visited = new int[200000];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = 1;
		while(!(queue.isEmpty())) {
			int c = queue.poll();
			if(c == end)
				return visited[end]-1;
			int[] spot = {c-1, c+1, 2*c};
			
			for(int i : spot) {
				if(i<200000 &&i>=0 && visited[i] == 0) {
					queue.add(i);
					visited[i] = visited[c]+1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int n = 0;// 수빈 위치 변수
		int m = 0;// 동생 위치 변수
		int sec = 0;//시간 변수
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		
		System.out.println(bfs(n,m));
	}

}
