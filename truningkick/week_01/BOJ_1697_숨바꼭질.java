package turningkick.week_01;

import java.util.*;
import java.io.*;

public class BOJ_1697_숨바꼭질 
{
	public static void main(String[] args) throws IOException
	{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// N,K 일치 시 소요시간 0
		if (N == K)
		{
			System.out.println(0);
			return;
		}
		
		boolean[] visited = new boolean[100000];
		visited[N] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		int size = q.size();
		int count = 0;
		
		while (true)
		{
			count++;
			size = q.size();
			for (int i=0; i<size; i++)
			{
				int x = q.remove(); //Queue 최전방의 수 제거, x 대입
				visited[x] = true;	//방문위치 true 조정
				//목표 K값에 도달했을 떄 종료
				if ( (x-1==K) || (x+1==K) || (x*2==K) ) 
				{
					System.out.println(count);
					return;
				}
				if ( (x-1>=0) && (!visited[x-1]) ) // 0보다 크며 방문하지 않았을 때
				{
					visited[x-1] = true; 
					q.add(x-1);
				}
				if ( (x+1>=0) && (!visited[x+1]) ) 
				{	
					visited[x+1] = true; 
					q.add(x+1);
				}
				if ( (x*2>=0) && (!visited[x*2]))
				{
					visited[x*2] = true;
					q.add(x*2);
				}
			}
		}
	}
}
