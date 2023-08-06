package miraekwak.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕배달 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(true) {
            if(N % 5 == 0) {
                System.out.println(N/5 + cnt);
                break;
            }
            else if(N < 0) {
                System.out.println(-1);
                break;
            }
            N = N-3;
            cnt++;
        }
    }
}
