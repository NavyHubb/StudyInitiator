package miraekwak.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_28323_불안정한수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cur = Integer.parseInt(st.nextToken());
        boolean isOdd = false;
        if(cur %2 != 0) isOdd = true;
        for(int i=1; i<N; i++) {
            cur = Integer.parseInt(st.nextToken());
            if(isOdd != (cur % 2 != 0)) {
                cnt++;
                isOdd = !isOdd;
            }
        }
        System.out.println(cnt);
    }
}
