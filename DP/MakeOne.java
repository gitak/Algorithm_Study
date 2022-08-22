package DP;

import java.io.*;

public class MakeOne {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int[] dp = new int[30000 + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i],dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i],dp[i / 3] + 1);
            }
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i],dp[i / 5] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
