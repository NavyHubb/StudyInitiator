package miraekwak.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9251_LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        int[] dp = new int[B.length()];

        for(int i=0; i<A.length(); i++) {
            int cnt = 0;
            for(int j=0; j<B.length(); j++) {
                if(cnt < dp[j]) cnt = dp[j];
                else if(A.charAt(i) == B.charAt(j)) dp[j] = cnt+1;
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
