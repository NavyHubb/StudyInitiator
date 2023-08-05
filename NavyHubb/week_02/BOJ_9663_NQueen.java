package NavyHubb.week_02;

import java.util.Scanner;

public class BOJ_9663_NQueen {

    static int N;
    static int[] board;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N];

        solution(0);

        System.out.println(cnt);
    }

    static void solution(int row) {
        if (row == N) {
            cnt++;
            return;
        }

        // 현재 row의 i번째에 배치
        for (int i = 0; i < N; i++) {
            board[row] = i;

            if (isPromising(row)) {
                solution(row+1);
            }
        }
    }

    static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] || row - i == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }

}