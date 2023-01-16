package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2156 {
    static int N;
    static int[] wine;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        wine = new int[N + 1];
        dp = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void logic() {
        //초기값 구하기
        dp[1][0] = 0;
        dp[1][1] = wine[1];
        dp[1][2] = wine[1];

        //점화식 만들기
        //dp[i][0]: i 번째 일때, 포도주를 0잔 마시는 경우
        //dp[i][1]: i 번째 일때, 포도주를 1잔 마시는 경우
        //dp[i][2]: i 번째 일때, 포도주를 2잔 마시는 경우
        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + wine[i];
            dp[i][2] = dp[i - 1][1] + wine[i];
        }

        int ans = Math.max(Math.max(dp[N][0], dp[N][1]), dp[N][2]);
        System.out.println(ans);

    }
}
