package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2579 {

    static int N;
    static int[] stairs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        dp = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }


    }

    private static void logic() {
        //초기값 구하기
        dp[1][0] = 0;
        dp[1][1] = stairs[1];

        if (N >= 2) {
            dp[2][0] = stairs[2];
            dp[2][1] = stairs[1] + stairs[2];
        }

        //dp[i][0]: i-1 번째 계단은 밟지 않고, i 번째 계단에 도착하여 얻는 최대 점수
        //dp[i][1]: i-1 번째 계단을 밟고서, i 번째 계단에 도착하여 얻는 최대 점수

        for (int i = 3; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 2][0] + stairs[i], dp[i - 2][1] + stairs[i]);
            dp[i][1] = dp[i - 1][0] + stairs[i];
        }

        int ans = Math.max(dp[N][0], dp[N][1]);
        System.out.println(ans);
    }

}
