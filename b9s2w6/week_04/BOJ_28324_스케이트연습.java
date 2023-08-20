package b9s2w6.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_28324_스케이트연습 {
	public static void main(String[] args) throws NumberFormatException, IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int spotSize = Integer.parseInt(br.readLine());
	    
	    int limitSpeed[] = new int[spotSize+2];
	    int Speed[] = new int[spotSize+2];
	    long ans = 0;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    for(int i = 1; i<=spotSize; i++) {
	        limitSpeed[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    Speed[spotSize] = 1;
	    
	    for(int i = spotSize-1; i>=1; i--) {
	        if(limitSpeed[i] >= Speed[i+1]) {
	            if (limitSpeed[i] > Speed[i+1]) {
	                Speed[i] = Speed[i+1]+1; 
	            }
	            else Speed[i] = Speed[i+1];
	        }else {
	            Speed[i] = limitSpeed[i];
	        }
	        ans += Speed[i];
	    }
	    
	    System.out.println(ans+1);
	}
}
