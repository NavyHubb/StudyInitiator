package NavyHubb.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_14002_가장긴증가하는부분수열4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // dp 배열의 최댓값을 시작으로 수열 역추적
        StringBuilder sb = new StringBuilder();
        int max = Arrays.stream(dp).max().getAsInt();
        sb.append(max).append('\n');

        Stack<Integer> stack = new Stack<>();
        int n = max;
        for (int i = N-1; i >= 0; i--) {
            if (dp[i] == n) {
                stack.push(arr[i]);
                n--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

}
