package NavyHubb.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_28215_대피소 {

    static int N, K;
    static int[][] homes;
    static int[] comb;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 집 갯수
        K = Integer.parseInt(st.nextToken());  // 대피소 갯수

        homes = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            homes[i][0] = Integer.parseInt(st.nextToken());
            homes[i][1] = Integer.parseInt(st.nextToken());
        }
        comb = new int[K];

        makeComb(0, 0);

        System.out.println(result);
    }

    // 대피소의 조합 생성
    static void makeComb(int depth, int start) {
        if (depth == K) {
            result = Math.min(result, getMaxDist());
            return;
        }

        for (int i = start; i < N; i++) {
            comb[depth] = i;
            makeComb(depth+1, i+1);
        }
    }

    // 모든 집에 대해 가장 가까운 대피소까지의 거리를 구하고 그 중 최댓값을 반환
    static int getMaxDist() {
        int max = 0;  // 가장 가까운 대피소까지의 거리의 최댓값
        for (int i = 0; i < N; i++) {
            int closestDist = Integer.MAX_VALUE;  // 현재 집에서 가장 가까운 대피소까지의 거리

            for (int c : comb) {
                if (c == i) {  // 현재 집의 위치가 대피소로 선정된 경우
                    closestDist = 0;
                    break;
                }

                // 현재 집과 대피소 사이의 거리를 구하여 가장 가까운 대피소까지의 거리 갱신
                closestDist = Math.min(closestDist, getDist(homes[i][0], homes[i][1], homes[c][0], homes[c][1]));
            }

            max = Math.max(max, closestDist);
        }

        return max;
    }

    // 두 지점 사이의 거리 계산
    static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);  // 맨하탄 거리
    }

}