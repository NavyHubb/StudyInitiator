package truningkick.week_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/*
 * N kg 배달
 * 봉지는 3kg ,  5kg 존재
 * 최대한 적은 봉지 들기
 */
public class BOJ_2839_설탕배달 {
	
    static int count;
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        reculsive(N);
    }

    
    public static void reculsive (int N) {
    	//기저조건
    	if (N == 0) {
            System.out.println(count);
            return;
        }
        else if (N < 3) {	//만들 수 없을 때
            System.out.println(-1);
            return;
        }

    	
        if(N % 5 == 0) {
            count += N / 5;
            N = 0;
        }
        else {
            ++count;
            N -= 3;
        }

        reculsive(N);
    }
    
    
}