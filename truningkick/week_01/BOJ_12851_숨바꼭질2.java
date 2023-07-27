package truningkick.week_01;

import java.util.*;
import java.io.*;

public class BOJ_12851_숨바꼭질2 
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
		
		int[] visited = new int[100_000];
		int[] time_arr = new int[100_000];
		visited[N] = 1;
		time_arr[N] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		int size = q.size();
		int count = 0;
		int target = 100_001;
		int re_cnt =0; //최단시간으로 목표에 도착하는 방법의 수

		Loop1 : while (true)
		{
			count++;
			size = q.size();
			for (int i=0; i<size; i++)
			{
				int x = q.remove(); //Queue 최전방의 수 제거, x 대입
				visited[x] += 1;	//방문위치 true 조정
//				int bd = x*2;
//				if ( bd > 100_000) 
//				{
//		            System.out.println("찾는 방법은 :" + re_cnt + "가지");
//					throw new OutOfBoundsException(bd);
//				}
				//목표 K값에 도달했을 떄 종료
				// 5 - 10 - 9 - 18 - 17
				// 5 - 4 - 8 - 16 -  17

				if (count > target) 
				{
					System.out.println("최단시간 : " + target + " 찾는 방법 : " + re_cnt);
					break Loop1;
				}
				if ( ((x-1==K) || (x+1==K) || (x*2==K)) && target == 100_001 ) //최단시간 최초 식별 전 까지
				{
					target = count;
					re_cnt +=1;


				}
				else if ( ((x-1==K) || (x+1==K) || (x*2==K)) && (count == target) ) //최단시간 식별 후 부5터
				{
					re_cnt +=1;
				}
				
				if ( ( x-1 < 100_000)  &&  (x-1>=0) && (time_arr[x-1] >= visited[x-1]) ) // 0보다 크며 방문하지 않았을 때
				{
					time_arr[x-1] = count;
					visited[x-1] += 1; 
					q.add(x-1);
				}
				if ( (x+1 < 100_000) && (x+1>=0) && (time_arr[x+1] >= visited[x+1]) ) 
				{	
					time_arr[x+1] = count;
					visited[x+1] += 1; 
					q.add(x+1);
				}
				if ( (x*2<100_000) && (x*2>=0) && (time_arr[x*2] >= visited[x*2]) )
				{
					time_arr[x*2] = count;
					visited[x*2] +=1;
					q.add(x*2);
				}
			}
		}
	}
}
