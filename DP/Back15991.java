package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back15991 {

    static int N, T;
    static long[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        preprocess();
        logic();
    }

    private static void logic() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append('\n');
        }

        System.out.println(sb);
    }

    private static void preprocess() {
        dp = new long[100001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;

        //점화식 세우기
        //(# 은 대칭인 수를 의미)
        //case 1. 1 + # + 1 인 경우
        //case 2. 2 + # + 2 인 경우
        //case 3. 3 + # + 3 인 경우
        for (int i = 7; i <= 100000; i++) {
            dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % 1000000009;
        }
    }
}
