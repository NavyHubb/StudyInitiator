package truningkick.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {

	static int N, M;    //방의 크기 
	static int r, c;    //로봇의 현위치 좌표
	static int d;        //d: 0_북  1_동  2_남  3_서
	static int [][] arr;
	
	//델타 상 / 우 / 하 / 좌  
	// 0북 1동  2남  3서
	static int [] dx = {1,  0, -1, 0};
	static int [] dy = {0, -1,  0, 1};
	static int c_Cnt=0;

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer str = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(str.nextToken());
	    M = Integer.parseInt(str.nextToken());
	    arr = new int[N][M];
	    
	    StringTokenizer str1 = new StringTokenizer(br.readLine());
	    for(int i=0; i<N+1; i++) {
	        if (i==0) {
	            r = Integer.parseInt(str1.nextToken());
	            c = Integer.parseInt(str1.nextToken());
	            d = Integer.parseInt(str1.nextToken());
	            continue;
	        }
	        StringTokenizer str2 = new StringTokenizer(br.readLine());
	        for(int j=0; j<M; j++) {
	            arr[i-1][j] = Integer.parseInt(str2.nextToken());
	        }
	    }

    //System.out.println(Arrays.deepToString(arr));
    
    cleaning(r, c, d);
	System.out.println(c_Cnt);

	}

	/*
	 * 방 청소 메소드   
	 * @param x : 현재 행 좌표의 index
	 * @param y : 현재 열 좌표의 index
	 * @param way : 현재 로봇청소기의 방향 
	 */
	private static void cleaning(int x, int y, int way) {

	    if( arr[x][y] == 1) return;	
	    
	    // 1. 수행
	    if( arr[x][y] == 0) {
	        c_Cnt+=1;
	        arr[x][y] = 2;   //청소 완료 시 2 표기  
	    }
    
        
	    //4방탐색
	    for(int i=0; i<4; i++) { 	
	    	
	    	// 미청소 위치 찾음
	        if( arr[ x+dx[i] ][ y+dy[i] ] == 0  ) { 
	            
	            //반시계  90도 방향전환
	            way += 1;
	            if (way ==4 ) way =0;

	            // 방향 전환 후 청소를 안 한 위치면 : 전진
	            if( arr[ x+dx[way] ][ y+dy[way] ] == 0) {    
	                cleaning(x+dx[way], y+dy[way], way );      
	            }
	            else {
	            	cleaning(x, y, way );
	            }
	        }
	        
	        // 모두 청소가 되었을 때 2.가,나
	        else {
	        	
	            int move = way + 2;    // move : 후진 위치 index
	            if (move >= 4) move -= 4;
	                
	            //2.가 (후진)
	            cleaning(x+dx[move],y+dy[move], way);
	        }
	    }
	}
}