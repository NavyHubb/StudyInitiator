package NavyHubb.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_28324_스케이트연습 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] limits = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        long sum = 0;  // 각 지점에서의 최대 속력의 속력의 합. int형으로 선언 시 overflow가 우려되므로 long형으로 선언
        int v = 0;  // 도착 지점에서의 속력인 0으로 초기화
        for (int i = N-1; i >= 0; i--) {  // 마지막 지점부터 역순으로 탐색
            v++;  // 이전 지점의 속력에서 1증가. 이 값은 곧 현재 지점에서 속력제한을 고려하지 않았을 때 가질 수 있는 최댓값
            v = Math.min(v, limits[i]);  // 현재 지점에서의 속력 제한을 고려하여 v 값 갱신

            sum += v;
        }

        System.out.println(sum);
    }

}