package NavyHubb.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Item> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

//        // 2차원 dp 배열 사용 풀이
//        int[][] dp = new int[N+1][K+1];
//        for (int i = 0; i < N; i++) {
//            for (int j = 1; j <= K; j++) {
//                Item item = list.get(i);
//
//                if (item.w <= j) {  // 현재 탐색하는 무게(j)의 범위 안에 현재 아이템의 무게가 있는 경우
//                    dp[i+1][j] = Math.max(dp[i][j], dp[i][j- item.w] + item.v);
//                } else {
//                    dp[i+1][j] = dp[i][j];
//                }
//            }
//        }
//
//        System.out.println(dp[N][K]);

        // 1차원 dp 배열 사용 풀이
        int[] dp = new int[K+1];
        for (int i = 0; i < N; i++) {
            for (int j = K; j >= 1; j--) {  // 이전 아이템을 탐색할 때의 값을 보존하기 위해 역순으로 탐색
                Item item = list.get(i);

                if (item.w <= j) {  // 현재 탐색하는 무게(j)의 범위 안에 현재 아이템의 무게가 있는 경우
                    dp[j] = Math.max(dp[j], dp[j- item.w] + item.v);
                }
            }
        }

        System.out.println(dp[K]);
    }

    static class Item implements Comparable<Item> {
        int w;  // 무게
        int v;  // 가치

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Item o) {
            return w - o.w;
        }
    }

}
