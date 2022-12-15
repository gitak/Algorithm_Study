package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back11052_New {

    static int N;
    static int[] P, dp;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void logic() {
        dp = new int[N + 1];
        //초기값 구하기
        dp[0] = 0;

        //점화식을 토대로 dp 배열 채우기
        for (int i = 1; i <= N; i++) {
            for (int count = 1; count <= i; count++) {
                dp[i] = Math.max(dp[i], dp[i - count] + P[count]);
            }
        }

        System.out.println(dp[N]);
    }
}
