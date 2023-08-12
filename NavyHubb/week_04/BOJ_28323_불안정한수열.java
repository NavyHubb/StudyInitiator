package NavyHubb.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주어진 수들 중 k개를 골라 불안정한 수열을 만든다
 * 이떄 k의 최댓값을 구하라
 * 불안정한 수열이란, 이웃한 두 수의 합이 모두 홀수인 수열
 *
 * 불안정한 수열이 되기 위한 조건: 홀수와 짝수가 번갈아 가며 등장해야 함
 */
public class BOJ_28323_불안정한수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        boolean isEven = false;  // 불안정한 수열에 들어간 마지막 수가 짝수이면 false, 홀수이면 true
        if (n % 2 == 0) {
            isEven = true;
        }

        for (int i = 1; i < N; i++) {
            n = Integer.parseInt(st.nextToken());

            // 불안정한 수열에 들어간 마지막 수가 짝수인 경우, 현재 수(n)는 홀수여야 불안정한 수열에 추가될 수 있다
            if (isEven != (n % 2 == 0)) {
                cnt++;
                isEven = !isEven;
            }
        }

        System.out.println(cnt);
    }

}