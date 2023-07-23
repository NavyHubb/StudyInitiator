package truningkick.week_01;

public class BOJ_1260_DFS와BFS 
{
    static int N, M, V;
    static boolean[] visisted;
    static int[][] adjMatrix;
    static StringBuilder sb;
    static boolean[] visited;
	
	
	
	
	public static void main(String[] args) throws IOException //예외 발생 시 해당 클래스를 벗어남
	{
		//입력
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	//정점 수
		M = sc.nextInt();	//간선 수
		V = sc.nextInt();	//정점 시작
		
        sb = new StringBuilder(); //문자열을 더할 때, 새로운 객체를 생성하는 것이 아닌 기존 데이터에 더하는 방식을 사용(빠른속도,적은 부하)

        // 인접행렬 초기화
        adjMatrix = new int[N+1][N+1];  // 노드 번호가 1부터 시작하므로 N+1
        

		//int[] ans_dfs = new int[N];
		
		int f_val = 0;
		int t_val = 0;
		visited = new boolean[N + 1];
		visited[0]=true;
		for (int i = 0; i < M; i++) 
		{
			int from = sc.nextInt();
			int to = sc.nextInt();
			for (int j = 0; j< adjMatrix[from].length; j++) 
			{
			    if (adjMatrix[from][j] == 0) 
			    {
			        f_val = j;
			        break;
			    }
			}
			
			for (int j = 0; j< adjMatrix[to].length; j++) 
			{
			    if (adjMatrix[to][j] == 0) 
			    {
			        t_val = j;
			        break;
			    }
			}
			
			adjMatrix[from][f_val] = to;
			adjMatrix[to][t_val] = from;
		}
		
		for (int i = 0; i < M; i++) 
		{
			Arrays.sort(adjMatrix[i]);
		}
        for (int[] row : adjMatrix) {
            System.out.println(Arrays.toString(row));
        }
        
		int before = 0;
        DFS(V,before);

	}
	
	
	static void DFS(int start, int before)
	{
		int ind = 0;
		sb.append(start);
		visited[start] = true;

		
		if(sb.length() == N)
		{
			System.out.print("sb: " + sb);
		}
		else
		{				
			Loof1 : for (int i= 0; i< adjMatrix[start].length; i++) 
			{
				int aa = adjMatrix[start][i];
				if ( (aa > 0) && (visited[aa] == false) ) 
			    {
					ind = i;
					break Loof1;
			    		
			    }
			    else continue;
			}
			before = start;
			DFS(adjMatrix[start][ind],before);
		}
	}

}
