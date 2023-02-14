package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back15990 {

    static long[][] dp;
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        logic();
        input();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long ans = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

    private static void logic() {
        dp = new long[100_001][4];

        //초기값 구하기 -> 끝자리가 1로 끝나는 경우, 2로 끝나는 경우, 3으로 끝나는 경우
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 100_000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }
    }
}
