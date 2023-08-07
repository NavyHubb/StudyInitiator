package truningkick.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_10974_모든순열 {
	static int n;
	static boolean[] visited;
	
	public static void main (String[] args) throws NumberFormatException, IOException{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		String sNum;	//순열변수
		
		for(int i=1; i<=n; i++) {
			visited[i] = true;
			sNum = Integer.toString(i);
			
			dfs(sNum,i,1);
			visited[i] = false;
		}
	}
	
	static void dfs(String sNum, int start, int depth) {
		if(depth >= n) {	//순열 출력 조건
			System.out.println(sNum);
		}
		else {
			for(int i=1; i<=n; i++) {
				if(!visited[i]) {		//방문하지 않았을 때
					visited[i]=true;	//방문표시
					sNum += " "+i;		//순열 추가
					dfs(sNum, start, depth+1);	
					
					//백트래킹_저장된 순열의 마지막 방문 위치 삭제 (결국 첫 순열 완성 후, 시작인자를 제외한 나머지 삭제 -> true false false)
					//이어서 for문 i의 다음 값으로 또다른 순열을 찾아 떠남~
					sNum = sNum.substring(0, sNum.length()-2);
					visited[i] = false;	//미방문 처리
				}
			}
		}
	}
}

