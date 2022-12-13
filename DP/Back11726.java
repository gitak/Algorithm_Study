package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back11726 {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        preprocess();
    }

    private static void preprocess() {
        dp = new int[1001];
        //초기값 구하기
        dp[1] = 1;
        dp[2] = 2;

        //점화식을 토대로 dp 배열 채우기
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[N]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
}
