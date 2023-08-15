package NavyHubb.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N : 방의 갯수 (2 <= N <= 250_000)
 * C[] : 각 방이 가진 쪽방 갯수 (0 <= C <= 10^12)
 *
 * 각 방과 쪽방에는 최대 한마리의 개미가 살 수 있다
 * 통로로 직접 연결되어 있는 두 방 모두에 개미가 살지는 않는다
 *
 * 현재 구조에서 살 수 있는 개미의 최댓값을 구하라
 */
public class BOJ_28325_호숫가의개미굴 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }

        long max = 0;
        int prev, next;
        boolean[] status;  // 각 방에 개미가 살고 있는지 여부

        for (int i = 0; i <= 1; i++) {
            status = new boolean[N];
            long sum = 0;

            for (int j = i; j < N; j++) {
                long tmp = Long.parseLong(arr[j]);
                if (tmp != 0) {  // 현재 방이 쪽방을 가지고 있는 경우, 현재 노드는 선택되지 않으며 쪽방의 수만큼 개미가 살 수 있다
                    sum += tmp;
                    continue;
                }

                prev = (j-1 < 0) ? N-1 : j-1;
                next = (j+1 >= N) ? 0 : j+1;

                if (!status[prev] && !status[next]) {  // 이전 방과 다음 방이 모두 비어 있는 경우
                    status[j] = true;
                    sum += 1;
                }
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

}