package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back11057 {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10];
    }

    private static void logic() {
        //초기값 구하기
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        //점화식을 토대로 dp배열 채우기
        for (int len = 2; len <= N; len++) {
            for (int last = 0; last <= 9; last++) {
                for (int prev = 0; prev <= last; prev++) {
                    dp[len][last] += dp[len - 1][prev];
                    dp[len][last] %= 10007;
                }
            }
        }

        //dp배열로 정답 계산하기
        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[N][i];
            ans %= 10007;
        }

        System.out.println(ans);
    }
}
