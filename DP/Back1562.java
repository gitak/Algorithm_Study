package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1562 {

    static int N;
    static int MOD = 1000_000_000;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    public static void logic() {
        /**
         **
         * dp[i][j][k]
         * i: i자리 숫자 , j: j로 끝나는 숫자, k: 마킹된 숫자(어떤 숫자가 사용됐는지)
         * *
         *
         */
        dp = new int[N + 1][10][1 << 10];
        //초기값 구하기
        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i]= 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    //k에서 j를 추가 (j 번째 비트 켜기)
                    //if. k = 4(100), j = 2(010) -> bit = 6(110)
                    int bit = k | (1 << j);
                    if (j == 0) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % MOD;
                    } else if (j == 9) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % MOD;
                    } else {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k] + dp[i - 1][j - 1][k]) % MOD;
                    }
                }
            }
        }

        int ans = 0;
        // 0 ~ 9까지 숫자가 모두 등장하는 경우
        for (int i = 0; i < 10; i++) {
            ans = (ans + dp[N][i][(1 << 10) - 1]) % MOD;
        }

        System.out.println(ans);
    }
}
