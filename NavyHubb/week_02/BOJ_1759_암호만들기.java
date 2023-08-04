package NavyHubb.week_02;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1759_암호만들기 {

    static int L, C;  // 출력 갯수, 문자 갯수
    static char[] chars;
    static boolean[] visited;
    static char[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        chars = new char[C];
        for (int i = 0; i < C; i++) {
            chars[i] = sc.next().charAt(0);
        }
        Arrays.sort(chars);

        visited = new boolean[C];
        output = new char[L];

        solution(0, 0, 0, 0);

        System.out.println(sb);
    }

    static void solution(int depth, int start, int consCnt, int vowCnt) {
        if (depth == L) {
            if (consCnt >= 2 && vowCnt >= 1) {
                print();
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = chars[i];
                if (chars[i] == 'a' || chars[i] == 'e'|| chars[i] == 'i'|| chars[i] == 'o'|| chars[i] == 'u') {
                    solution(depth+1, i+1, consCnt, vowCnt+1);
                } else {
                    solution(depth+1, i+1, consCnt+1, vowCnt);
                }
                visited[i] = false;
            }
        }
    }

    static void print() {
        for (int i = 0; i < L; i++) {
            sb.append(output[i]);
        }
        sb.append('\n');
    }

}
