package b9s2w6.week_01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13549_숨바꼭질3 {
  static int bfs(int start, int end) {
		//queue, visited 배열 생성
		int[] visited = new int[100000];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = 1;
		
		while(!(queue.isEmpty())) {
			int c = queue.poll();
			if(c == end)
				return visited[end]-1;
			
			int[] spot = {c-1, c+1, 2*c};
			
			for(int i = 0; i<3; i++) {
				if(spot[i]<200000 &&spot[i]>=0 && visited[spot[i]] == 0) {
					queue.add(spot[i]);
					if(i == 2) visited[spot[i]] = visited[c];
					else visited[spot[i]] = visited[c]+1;
						
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int n = 0;// 수빈 위치 변수
		int m = 0;// 동생 위치 변수
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		
		System.out.println(bfs(n,m));
	}
}
