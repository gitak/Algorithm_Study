package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AntWarrior {
    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] food = new int[1001];
        int[] dp = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            food[i] = Integer.parseInt(st.nextToken());
        }
        //입력종료
        dp[1] = food[1];
        dp[2] = food[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + food[i]);
        }

        System.out.println(dp[n]);

    }
}
