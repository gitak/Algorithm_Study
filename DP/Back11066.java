package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back11066 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int K;
    static int[] file;
    static int[][] dp, sum;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            input();
            logic();
        }

    }

    private static void input() throws IOException {
        K = Integer.parseInt(br.readLine());
        file = new int[K + 1];
        sum = new int[K + 1][K + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            file[i] = Integer.parseInt(st.nextToken());
        }
    }

    // i ~ j 까지의 총합 구하기
    static void preprocess() {
        for (int i = 1; i <= K; i++) {
            for (int j = i; j <= K; j++) {
                sum[i][j] = sum[i][j - 1] + file[j];
            }
        }
    }

    private static void logic() {
        preprocess();
        dp = new int[K + 1][K + 1];
        for (int len = 2; len <= K; len++) {
            //시작점 i부터 길이가 len까지 반복
            for (int from = 1; from <= K - len + 1; from++) {
                int to = from + len - 1;
                dp[from][to] = Integer.MAX_VALUE;
                for (int k = from; k < to; k++) {
                    dp[from][to] = Math.min(dp[from][to], dp[from][k] + dp[k + 1][to] + sum[from][to]);
                }
            }
        }

        System.out.println(dp[1][K]);
    }
}
