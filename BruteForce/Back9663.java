package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back9663 {

    static int n, ans;
    static int[] col;

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1);
        System.out.println(ans);
    }

    static void rec_func(int row) {

        //1 ~ n행까지 성공적으로 놓은 경우
        if (row == n + 1) {
                ans++;

        } else {
            for (int c = 1; c <= n; c++) {
                boolean isPossible = true;

                //valid check (row, c)
                for (int i = 1; i <= row - 1; i++) {
                    //(i, col[i])
                    if (attackable(row, c, i, col[i])) {
                        isPossible = false;
                        break;
                    }
                }

                if (isPossible) {
                    col[row] = c;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        //같은 열인 경우
        if(c1 == c2) return true;

        //같은 완쪽 대각선인 경우 (행 - 열)의 값이 같다.
        if(r1 - c1 == r2 - c2) return true;

        //같은 오른쪽 대각선인 경우 (행 + 열)의 값이 같다.
        if(r1 + c1 == r2 + c2) return true;

        return false;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        col = new int[n + 1];

    }

    //    private static boolean validity_check() {
//        for (int i = 1; i <= n; i++) {
//            //(i, col[i]
//            for (int j = 1; j <= i; j++) {
//                //(j,col[j])
//                if (attackable(i, col[i], j, col[j])) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
