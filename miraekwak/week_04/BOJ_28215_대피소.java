package miraekwak.week_04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_28215_대피소 {

	static class Home {
		int row; // y
		int col; // x
		public Home(int c, int r) { //x , y
			this.col = c;
			this.row = r;
		}
	}
	
	private static int N, K, DISTANCE;
	private static Home[] homes;
	private static int[] selected;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		selected = new int[K];
		homes = new Home[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			homes[i] = new Home(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		DISTANCE = Integer.MAX_VALUE;
		permu(0, 0);
		System.out.println(DISTANCE);
	}

	private static void permu(int cnt, int str) {
		if(cnt == K) {
			int distance = 0;
			Home : for(int j=0; j<N; j++) {
				int temp = Integer.MAX_VALUE;
				for(int i=0; i<K; i++) {
					if(selected[i] == j) continue Home;
					temp = Math.min(temp, distance(homes[selected[i]], homes[j]));					
				}
				distance = Math.max(distance, temp);
			}
			DISTANCE = Math.min(distance, DISTANCE);
			return;
		}
		
		for(int i=str; i<N; i++) {
			selected[cnt] = i;
			permu(cnt+1, i+1);
		}
	}
	
	private static int distance(Home h1, Home h2) {
		return Math.abs(h1.row - h2.row) + Math.abs(h1.col - h2.col);
	}
}
