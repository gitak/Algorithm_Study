package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back9465 {
    static BufferedReader br;
    static int N;
    static int[][] sticker;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            logic();
        }

    }

    static void input() throws IOException{
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        sticker = new int[2][N + 1];
        dp = new int[2][N + 1];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                sticker[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void logic() {
        //초기값 구하기
        dp[0][1] = sticker[0][1];
        dp[1][1] = sticker[1][1];

        //점화식 세우기
        for (int i = 2; i <= N; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
        }

        System.out.println(Math.max(dp[0][N], dp[1][N]));
    }
}
