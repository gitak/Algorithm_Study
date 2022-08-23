package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoodMoney {
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[10001];
        int[] money = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            money[i] = Integer.parseInt(br.readLine());
            dp[money[i]] = 1;
        }
        //입력 종료

        Arrays.sort(money);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - money[j] >=0 && dp[i - money[j]] != 0) {
                    if (dp[i] != 0) {
                        dp[i] = Math.min(dp[i], dp[i - money[j]] + 1);
                    }
                    dp[i] = dp[i - money[j]] + 1;
                }
            }
        }

        if (dp[m] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }

    }
}
