package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2688 {
    // 타입 주의!
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        logic();
        input();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long sum = 0;
            for (int i = 0; i <= 9; i++) {
                sum += dp[N][i];
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }

    static void logic() {
        dp = new long[65][10];
        //초기값 구하기
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        //점화식을 토대로 dp배열 채우기
        for (int i = 2; i <= 64; i++) {
            dp[i][0] = 1;
            for (int last = 1; last <= 9; last++) {
                for (int j = 0; j <= last; j++) {
                    dp[i][last] += dp[i - 1][j];
                }
            }
        }

    }
}
