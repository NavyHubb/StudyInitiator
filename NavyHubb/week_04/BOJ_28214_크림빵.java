package NavyHubb.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
N : 빵 묶음의 수 (1 <= N <= 50)
K : 한 묶음에 포함된 빵의 갯수 (1 <= K <= 50)
P : 한 묶음에 크림이 없는 빵이 P개 미만이어야 팔 수 있다 (1 <= P <= K)

팔 수 있는 빵 묶음의 수를 구하라
 */
public class BOJ_28214_크림빵 {

    static int N, K, P;
    static String[] breads;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        breads = br.readLine().split(" ");

        System.out.println(solution());
    }

    static int solution() {
        int cnt = 0;  // 팔 수 있는 묶음의 수

        Group : for (int i = 0; i < N*K; i+=K) {  // 그룹별 탐색
            int noCream = 0;  // 크림이 없는 빵의 수
            for (int j = i; j < i+K; j++) {  // 그룹 내 탐색
                if (breads[j].equals("0")) noCream++;

                if (noCream >= P) continue Group;  // 팔 수 없는 그룹임이 판별되면 다음 그룹으로 건너뛴다
            }
            cnt++;  // 팔 수 있는 그룹의 경우 카운트
        }

        return cnt;
    }

}