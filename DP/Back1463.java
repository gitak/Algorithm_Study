package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1463 {
    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();//입력 종료

        int[] dp = new int[n+1];

        // 경우의 수가 많은 연산 순서대로 반복문 실행
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[n]);
    }
}
