package miraekwak.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_NQueen {
    private static int N, count=0;
    private static int[] colToRow;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colToRow = new int[N];
        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int depth) {
        if(depth == N) {
            count++;
            return;
        }
        for(int i=0; i<N; i++) {
            colToRow[depth] = i;
            if(isPossible(depth)) {
                nQueen(depth+1);
            }
        }
    }

    private static boolean isPossible(int col) {
        for(int i=0; i<col; i++) {
            // 같은 행에 존재하는 경우
            if(colToRow[i] == colToRow[col]) return false;

            // 대각선상에 놓여있는 경우
            if(Math.abs(col - i) == Math.abs(colToRow[col] - colToRow[i])) return false;

        }
        return true;
    }
}
