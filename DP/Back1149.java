package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1149 {

    static int N;
    static int[][] house;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        //초기값 구하기
        dp[1][0] = house[1][0];
        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];

        //점화식 세우기
        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] , dp[i - 1][2]) + house[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + house[i][2];
        }

        int ans = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
        System.out.println(ans);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new int[N + 1][3];
        dp = new int[N + 1][3];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
